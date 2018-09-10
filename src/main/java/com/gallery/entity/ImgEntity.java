package com.gallery.entity;

import java.util.Date;

public class ImgEntity {
    private Integer id;

    private Integer albumId;

    private Boolean ifCover;

    private String imgName;

    private String imgUrl;

    private Date createTime;

    private Boolean ifDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getIfDelete() {
        return ifDelete;
    }

    public void setIfDelete(Boolean ifDelete) {
        this.ifDelete = ifDelete;
    }

    public Boolean getIfCover() {
        return ifCover;
    }

    public void setIfCover(Boolean ifCover) {
        this.ifCover = ifCover;
    }
}