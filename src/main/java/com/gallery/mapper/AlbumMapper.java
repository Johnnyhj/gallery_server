package com.gallery.mapper;


import com.gallery.dto.CoverDTO;
import com.gallery.entity.AlbumEntity;

import java.util.List;

public interface AlbumMapper {

    int insert(AlbumEntity record);

    List<CoverDTO> selectCoversByUserId(Integer userId);

    AlbumEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AlbumEntity record);

}