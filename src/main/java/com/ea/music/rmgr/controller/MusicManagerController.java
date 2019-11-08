package com.ea.music.rmgr.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ea.music.rmgr.exception.TechnicalException;
import com.ea.music.rmgr.model.MusicMgrHeader;
import com.ea.music.rmgr.model.MusicMgrResponse;
import com.ea.music.rmgr.service.ManagerService;

import io.swagger.annotations.ApiOperation;

@RestController
public class MusicManagerController {
	Logger logger =LoggerFactory.getLogger(MusicManagerController.class);
	
	@Autowired
	ManagerService service;
	
	@ApiOperation(value = "Loads all the music festivals in a location")
	@GetMapping("/loadAllMusicFestivals/{location}")
    public MusicMgrResponse loadAllMusicFestivals(@PathVariable String location) {
		MusicMgrResponse response = null;
		try {
			logger.info("Request music manger: load all festivls data for location: "+location);
			response=  service.loadAllFestivals(location.toLowerCase());
		}catch(TechnicalException ex) {
			logger.error("Technical Error returning the data",ex);
			MusicMgrHeader header = new MusicMgrHeader();
			header.setStatus("FAIL");
			header.setRequestId(ex.getRequestid());
			response = new MusicMgrResponse();
			response.setHeader(header);
		}catch(Exception ex){
			logger.error("Error processing the data",ex);
			MusicMgrHeader header = new MusicMgrHeader();
			header.setStatus("FAIL");
			response = new MusicMgrResponse();
			response.setHeader(header);
		}
			return response;
    }
	
	@ApiOperation(value = "Returns an appropriate error message")
	@GetMapping("/error")
    public String error() {
		logger.info("Error Request");
		return "We our updating our website to provide more information. Please come back again later for your queries!";
    }

}
