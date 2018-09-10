package com.gallery.service.impl;

import com.gallery.constant.RedisKeyConstants;
import com.gallery.entity.ImgEntity;
import com.gallery.mapper.ImgMapper;
import com.gallery.service.ImgService;
import com.gallery.service.RedisService;
import com.gallery.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @ClassName com.album.service.impl
 * @Date 2018年09月04日 17时16分
 * @Author johnnyhj@qq.com
 * @Copyright (c) All Rights Reserved, 2018.
 */
@Service
public class ImgServiceImpl implements ImgService {

    private Logger logger = LoggerFactory.getLogger(ImgServiceImpl.class);

    @Autowired
    private ImgMapper imgMapper;

    @Autowired
    private RedisService redisService ;

    @Transactional
    @Override
    public int insertImgBatch(List<ImgEntity> imgEntities) {
        logger.info("开始批量插入图片");
        String redisKey = RedisKeyConstants.IMG_ALBUM_ID + imgEntities.get(0).getAlbumId() ;
        Date date = DateUtil.getToday();
        for (ImgEntity imgEntity : imgEntities) {
            imgEntity.setIfCover(false);
            imgEntity.setCreateTime(date);
            imgEntity.setIfDelete(false);
        }
        imgEntities.get(0).setIfCover(true);// set the first as cover
        int flag = imgMapper.insertImgBatch(imgEntities);
        if (flag > 0) {
            logger.info("批量插入图片成功");
            logger.info("移除redis缓存");
            redisService.remove(redisKey);
            logger.info("插入redis缓存");
            redisService.set(redisKey, imgEntities);
        }

        return flag;
    }

    @Transactional
    @Override
    public int deleteImgBatchByAlbumId(int albumId) {
        String redisKey = RedisKeyConstants.IMG_ALBUM_ID + albumId ;
        int flag = imgMapper.updateBatchByAlbumId(albumId);// set ifDelete of img true
        if (flag > 0) {
            redisService.remove(redisKey);
        }
        return flag;
    }

    @Override
    public List<ImgEntity> getImgsByAlbumId(int albumId) {
        logger.info("查询相册id为 " + albumId + " 的所有图片");
        String redisKey =  RedisKeyConstants.IMG_ALBUM_ID + albumId ;
        if (redisService.exists(redisKey)) {
            return (List<ImgEntity>)(List)redisService.get(redisKey);
        }
        List<ImgEntity> imgEntities = imgMapper.selectByAlbumId(albumId);
        redisService.set(redisKey, imgEntities);
        return imgEntities;
    }
}
