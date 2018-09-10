package com.gallery.service;

import com.gallery.dto.CoverDTO;
import com.gallery.entity.AlbumEntity;

import java.util.List;

/**
 * @Description
 * @ClassName album
 * @Date 2018年09月03日 16时34分
 * @Author johnny_huang@asus.com
 * @Copyright (c) All Rights Reserved, 2018.
 */
public interface AlbumService {
    AlbumEntity selectByPrimaryKey(int userId);

    List<CoverDTO> getAllCoversByUserId(int userId);

    int insertAlbum(AlbumEntity albumEntity);

    int deleteAlbumById(int id);
}
