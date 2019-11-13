package com.ea.music.rmgr.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ea.music.rmgr.exception.TechnicalException;
import com.ea.music.rmgr.model.MusicManagerRes;
import com.ea.music.rmgr.model.MusicMgrHeader;
import com.ea.music.rmgr.model.MusicMgrResponse;
import com.ea.music.rmgr.service.ManagerService;

import io.swagger.annotations.ApiOperation;

@RestController
public class MusicManagerController {
	Logger logger =LoggerFactory.getLogger(MusicManagerController.class);
	
	@Autowired
	ManagerService service;
	
	@CrossOrigin
	@ApiOperation(value = "Loads all the music festivals in a location")
	@GetMapping("/loadAllLabels/{name}")
    public MusicManagerRes loadAllLabels(@PathVariable String name) {
		MusicManagerRes response = null;
		try {
			logger.info("Request music manger: Load all festivals data for location: "+name);
			response=  service.loadAllLabels(name.toLowerCase());
		}catch(TechnicalException ex) {
			logger.error("Technical Error returning the data",ex);
			MusicMgrHeader header = new MusicMgrHeader();
			header.setStatus("FAIL");
			header.setRequestId(ex.getRequestid());
			response = new MusicManagerRes();
			response.setHeader(header);
		}catch(Exception ex){
			logger.error("Error processing the data",ex);
			MusicMgrHeader header = new MusicMgrHeader();
			header.setStatus("FAIL");
			response = new MusicManagerRes();
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
