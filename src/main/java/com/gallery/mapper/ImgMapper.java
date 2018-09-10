package com.gallery.mapper;


import com.gallery.entity.ImgEntity;

import java.util.List;

public interface ImgMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ImgEntity record);

    int insertImgBatch(List<ImgEntity> imgEntities);

    ImgEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImgEntity record);

    int updateBatchByAlbumId(int albumId);

    List<ImgEntity> selectByAlbumId(int albumId);
}