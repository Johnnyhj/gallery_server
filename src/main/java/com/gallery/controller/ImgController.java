package com.gallery.controller;

import com.gallery.entity.ImgEntity;
import com.gallery.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @ClassName com.album.controller
 * @Date 2018年09月04日 17时15分
 * @Author johnnyhj@qq.com
 * @Copyright (c) All Rights Reserved, 2018.
 */
@RestController
@RequestMapping("/img")
public class ImgController {
    @Autowired
    private ImgService imgService;

    /**
     * upload image batch
     * @return
     */
    @PostMapping("/insertImgs")
    public int insertImgs(@RequestBody List<ImgEntity> imgEntities){
        return imgService.insertImgBatch(imgEntities);
    }

    /**
     * check out the specific images of one album
     * @param albumId
     * @return
     */
    @GetMapping("/getImgs/{albumId}")
    public List<ImgEntity> getImgsByAlbumId(@PathVariable int albumId) {
        return imgService.getImgsByAlbumId(albumId);
    }

}
