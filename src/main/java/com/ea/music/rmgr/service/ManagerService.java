package com.ea.music.rmgr.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ea.music.rmgr.constants.MusicManagerConstants;
import com.ea.music.rmgr.exception.TechnicalException;
import com.ea.music.rmgr.helper.MusicManagerHelper;
import com.ea.music.rmgr.model.MusicManagerRes;
import com.ea.music.rmgr.model.MusicMgrHeader;
import com.ea.music.rmgr.model.MusicMgrResponse;

/**
 * Executes the request
 * and sends out the data after 
 * performing business operations
 * and/or db calls
 **/
@Service
public class ManagerService {
	Logger logger =LoggerFactory.getLogger(ManagerService.class);
	
	@Autowired
	MusicManagerHelper helper;
	/**
	 * @param location
	 * @return List of Music festivals based on location
	 */
	public MusicManagerRes loadAllLabels(String name) throws TechnicalException{
		MusicManagerRes response = new MusicManagerRes();
		MusicMgrHeader header = new MusicMgrHeader();
		String requestId = null;
		try {
		requestId = "MM"+UUID.randomUUID().toString()+name.substring(0, 2).toUpperCase()  ;
		logger.info("loadAllFestivals for festival in:"+name+" for request id:"+requestId);
		//to track each request 
		//that comes to the server
		header.setRequestId(requestId);
		
		// initiates a db call;
		// for now loading a pre populated Object
		switch (name) {
			case "sony":
				response.setLabels(helper.loadLabelsSony());
				header.setStatus(MusicManagerConstants.SUCCESS);
				break;
			case "casablanca":
				response.setLabels(helper.loadLabelsCasablanca());
				header.setStatus(MusicManagerConstants.SUCCESS);
				break;
			default:
				response.setLabels(helper.invalidName());
				header.setStatus(MusicManagerConstants.FAIL);
				break;
		}
		
		response.setHeader(header);
		}catch(Exception ex) {
			logger.error("Issue processing the request for "+requestId+"Error Details",ex);
			throw new TechnicalException("Error processing loadAllFestivals",requestId);
		}
		logger.info("Response sent after processing :"+response);
		return response;
	}

	

}
