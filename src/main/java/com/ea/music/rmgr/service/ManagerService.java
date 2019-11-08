package com.ea.music.rmgr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ea.music.rmgr.constants.MusicManagerConstants;
import com.ea.music.rmgr.entity.Band;
import com.ea.music.rmgr.entity.BandMember;
import com.ea.music.rmgr.entity.MusicFestival;
import com.ea.music.rmgr.entity.RecordLabel;
import com.ea.music.rmgr.exception.TechnicalException;
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
	/**
	 * @param location
	 * @return List of Music festivals based on location
	 */
	public MusicMgrResponse loadAllFestivals(String location) throws TechnicalException{
		MusicMgrResponse response = new MusicMgrResponse();
		MusicMgrHeader header = new MusicMgrHeader();
		String requestId = null;
		try {
		requestId = "MM"+UUID.randomUUID().toString()+location.substring(0, 2).toUpperCase()  ;
		logger.info("loadAllFestivals for festival in:"+location+" for request id:"+requestId);
		//to track each request 
		//that comes to the server
		header.setRequestId(requestId);
		
		// initiates a db call;
		// for now loading a pre populated Object
		switch (location) {
			case "india":
				response.setFestivals(loadFestivalsInIndia());
				header.setStatus(MusicManagerConstants.SUCCESS);
				break;
			case "melbourne":
				response.setFestivals(loadFestivalsInMelbourne());
				header.setStatus(MusicManagerConstants.SUCCESS);
				break;
			default:
				response.setFestivals(invalidLocation());
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

	/**
	 * @return list of music 
	 * festivals in india/dummy data
	 */
	private List<MusicFestival> loadFestivalsInIndia() {
		logger.info("Loading music festivals in India");
		List<MusicFestival> festivals = new ArrayList<MusicFestival>();
		MusicFestival festival1 = new MusicFestival();

		festival1.setFestivalId(Long.valueOf("234234234234"));
		festival1.setFestivalLocation("INDIA");
		festival1.setFestivalName("Diwali Dhamaka");
		festival1.setNoOfAudience("10000");

		List<Band> bands = new ArrayList<Band>();
		Band band1 = new Band();
		band1.setBandLocation("India");
		band1.setBandName("Desi Fusion");
		band1.setBandManager("Mr.Anil Desai");
		band1.setBandPrimaryContact("+91805467896");
		
		RecordLabel label1 = new RecordLabel();
		label1.setLabelOwner("Sony");
		label1.setLabelContact("+915687822554");
		band1.setLabel(label1);
		
		List<BandMember> bandMembers = new ArrayList<BandMember>();
		BandMember member1 = new BandMember();
		member1.setAge("41");
		member1.setContact("+9148799998");
		member1.setGender("male");
		member1.setAddress("NA");
		member1.setName("Sonu Nigam");
		member1.setActiveMember("Y");
		bandMembers.add(member1);
		
		BandMember member2= new BandMember();
		member2.setAge("32");
		member2.setContact("+9148799998");
		member2.setGender("male");
		member2.setAddress("NA");
		member2.setName("Sunidhi Chauhan");
		member2.setActiveMember("Y");
		bandMembers.add(member1);
		
		band1.setBandMembers(bandMembers);
		bands.add(band1);
		festival1.setBands(bands);
		festivals.add(festival1);
		return festivals;

	}

	/**
	 * @return list of music 
	 * festivals in melbourne/dummy data
	 */
	private List<MusicFestival> loadFestivalsInMelbourne() {
		logger.info("Loading music festivals in Melbourne");
		List<MusicFestival> festivals = new ArrayList<MusicFestival>();
		MusicFestival festival1 = new MusicFestival();
		festival1.setFestivalId(Long.valueOf("534234234234"));
		
		festival1.setFestivalLocation("Melbourne");
		festival1.setFestivalName("Halloween Celebration");
		festival1.setNoOfAudience("2000");

		List<Band> bands = new ArrayList<Band>();
		Band band1 = new Band();
		band1.setBandLocation("London");
		band1.setBandName("Backstreet Girls");
		band1.setBandManager("Ms.Catherine Summer");
		band1.setBandPrimaryContact("+12805467896");
		
		RecordLabel label1 = new RecordLabel();
		label1.setLabelOwner("Disney");
		label1.setLabelContact("+315687822554");
		band1.setLabel(label1);
		
		List<BandMember> bandMembers = new ArrayList<BandMember>();
		BandMember member1 = new BandMember();
		member1.setAge("21");
		member1.setContact("+3148799998");
		member1.setGender("female");
		member1.setAddress("NA");
		member1.setName("Shane Twain");
		member1.setActiveMember("Y");
		bandMembers.add(member1);
		
		BandMember member2= new BandMember();
		member2.setAge("24");
		member2.setContact("+3148799998");
		member2.setGender("female");
		member2.setAddress("NA");
		member2.setName("Sail Drumm");
		member2.setActiveMember("Y");
		bandMembers.add(member1);
		
		band1.setBandMembers(bandMembers);
		bands.add(band1);
		festival1.setBands(bands);
		
		festivals.add(festival1);
		return festivals;

	
	}

	/**
	 * @return empty Message back
	 */
	private List<MusicFestival> invalidLocation() {
		logger.info("Loading no music festivals /Invalid Location");
		return new ArrayList<MusicFestival>();
	}

}
