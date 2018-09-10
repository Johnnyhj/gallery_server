package com.gallery.service;

import com.gallery.entity.ImgEntity;

import java.util.List;

/**
 * @Description
 * @ClassName com.album.service
 * @Date 2018年09月04日 17时16分
 * @Author johnnyhj@qq.com
 * @Copyright (c) All Rights Reserved, 2018.
 */
public interface ImgService {
    int insertImgBatch(List<ImgEntity> imgEntities);

    int deleteImgBatchByAlbumId(int albumId);

    List<ImgEntity> getImgsByAlbumId(int albumId);
}
