package com.ea.music.rmgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ea.music.rmgr.model.MusicMgrResponse;
import com.ea.music.rmgr.service.ManagerService;

@RestController
public class MusicManagerController {
	
	@Autowired
	ManagerService service;
	
	@RequestMapping("/loadAllMusicFestivals")
    public MusicMgrResponse greeting(@RequestParam String location) {
        return service.loadAllFestivals(location);
    }
	
	

}
