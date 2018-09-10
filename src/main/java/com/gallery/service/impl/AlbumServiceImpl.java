package com.gallery.service.impl;

import com.gallery.constant.RedisKeyConstants;
import com.gallery.dto.CoverDTO;
import com.gallery.entity.AlbumEntity;
import com.gallery.mapper.AlbumMapper;
import com.gallery.service.AlbumService;
import com.gallery.service.ImgService;
import com.gallery.service.RedisService;
import com.gallery.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @ClassName album
 * @Date 2018年09月03日 16时35分
 * @Author johnny_huang@asus.com
 * @Copyright (c) All Rights Reserved, 2018.
 */
@Service
public class AlbumServiceImpl implements AlbumService {

    private Logger logger = LoggerFactory.getLogger(AlbumServiceImpl.class);

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private ImgService imgService;

    @Autowired
    private RedisService redisService ;

    @Override
    public AlbumEntity selectByPrimaryKey(int userId) {
        return albumMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<CoverDTO> getAllCoversByUserId(int userId) {
        logger.info("查询用户id为 \"" + userId + "\" 的所有相册封面");
        String redisKey = RedisKeyConstants.ALBUM_COVERS_USER_ID + userId;
        List<CoverDTO> coverDTOS;
        if (redisService.exists(redisKey)) {
            coverDTOS =  (List<CoverDTO>)(List)redisService.get(redisKey);
        } else {
            coverDTOS = albumMapper.selectCoversByUserId(userId);
            redisService.set(redisKey, coverDTOS);
        }
        return coverDTOS;
    }

    @Transactional
    @Override
    public int insertAlbum(AlbumEntity albumEntity) {
        int userId = albumEntity.getUserId();
        String redisKey = RedisKeyConstants.ALBUM_COVERS_USER_ID + userId;
        albumEntity.setCreateTime(DateUtil.getToday());
        albumEntity.setIfDelete(false);
        int flag = albumMapper.insert(albumEntity);
        if (flag > 0) {
            redisService.remove(redisKey);
            redisService.set(redisKey, albumMapper.selectCoversByUserId(userId));
            return albumEntity.getId();
        }
        return 0;
    }

    @Transactional
    @Override
    public int deleteAlbumById(int id) {
        AlbumEntity albumEntity = albumMapper.selectByPrimaryKey(id);
        if (albumEntity == null) {
            return 0;
        }
        int userId = albumEntity.getUserId();
        String redisKey = RedisKeyConstants.ALBUM_COVERS_USER_ID + userId;
        albumEntity.setIfDelete(true);
        int flag =  albumMapper.updateByPrimaryKeySelective(albumEntity);
        if (flag > 0) {
            redisService.remove(redisKey);
            redisService.set(redisKey, albumMapper.selectCoversByUserId(userId));
            imgService.deleteImgBatchByAlbumId(id);// delete images below the albumEntity
        }
        return flag;
    }

}
