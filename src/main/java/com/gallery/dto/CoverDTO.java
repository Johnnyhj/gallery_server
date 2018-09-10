package com.gallery.dto;

/**
 * @Description
 * @ClassName com.album.dto
 * @Date 2018年09月03日 20时03分
 * @Author johnnyhj@qq.com
 * @Copyright (c) All Rights Reserved, 2018.
 */
public class CoverDTO {
    private Integer albumId;

    private Integer userId;

    private String albumName;

    private String imgName;

    private String imgUrl;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
