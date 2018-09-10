package com.gallery.controller;


import com.gallery.dto.CoverDTO;
import com.gallery.entity.AlbumEntity;
import com.gallery.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @ClassName album
 * @Date 2018年09月03日 16时37分
 * @Author johnny_huang@asus.com
 * @Copyright (c) All Rights Reserved, 2018.
 */
@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    /**
     * insert albumEntity for current user; user's id is in albumEntity
     * @param albumEntity
     * @return
     */
    @PostMapping("/insertAlbum")
    public int insertAlbum(@RequestBody AlbumEntity albumEntity) {
        return albumService.insertAlbum(albumEntity);
    }

    /**
     * get all covers by user's id for home page
     * @param userId
     * @return
     */
    @ResponseBody
    @GetMapping("/getCovers/{userId}")
    public List<CoverDTO> getCovers(@PathVariable int userId){
        return albumService.getAllCoversByUserId(userId);
    }

    /**
     * delete album and images included by userID
     * @param id
     * @return
     */
    @DeleteMapping("/deleteAlbum/{id}")
    public int deleteAlbum(@PathVariable int id) {
        return albumService.deleteAlbumById(id);
    }






}
