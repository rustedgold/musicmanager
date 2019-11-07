package com.ea.music.rmgr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.ea.music.rmgr.constants.MusicManagerConstants;
import com.ea.music.rmgr.entity.Band;
import com.ea.music.rmgr.entity.BandMember;
import com.ea.music.rmgr.entity.MusicFestival;
import com.ea.music.rmgr.entity.RecordLabel;
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

	/**
	 * @param location
	 * @return List of Music festivals based on location
	 */
	public MusicMgrResponse loadAllFestivals(String location) {
		MusicMgrResponse response = new MusicMgrResponse();
		MusicMgrHeader header = new MusicMgrHeader();
		
		Random random = new Random();
		String requestId = String.valueOf(random.nextInt());
		
		//to track each request 
		//that comes to the server
		header.setRequestId(requestId);
		
		// initiates a db call;
		// for now loading a pre populated Object
		switch (location) {
		case "india":
			response.setFestivals(loadFestivalsInIndia());
			header.setStatus(MusicManagerConstants.SUCCESS);
		case "melbourne":
			response.setFestivals(loadFestivalsInMelbourne());
			header.setStatus(MusicManagerConstants.SUCCESS);
		default:
			response.setFestivals(invalidLocation());
			header.setStatus(MusicManagerConstants.FAIL);
		}
		
		response.setHeader(header);
		return response;
	}

	/**
	 * @return list of music 
	 * festivals in india/dummy data
	 */
	private List<MusicFestival> loadFestivalsInIndia() {
		List<MusicFestival> festivals = new ArrayList<MusicFestival>();
		MusicFestival festival1 = new MusicFestival();

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
		bandMembers.add(member1);
		
		BandMember member2= new BandMember();
		member2.setAge("32");
		member2.setContact("+9148799998");
		member2.setGender("male");
		member2.setAddress("NA");
		member2.setName("Sunidhi Chauhan");
		bandMembers.add(member1);
		
		band1.setBandMembers(bandMembers);
		festival1.setBands(bands);
		
		return festivals;

	}

	/**
	 * @return list of music 
	 * festivals in melbourne/dummy data
	 */
	private List<MusicFestival> loadFestivalsInMelbourne() {

		List<MusicFestival> festivals = new ArrayList<MusicFestival>();
		MusicFestival festival1 = new MusicFestival();

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
		bandMembers.add(member1);
		
		BandMember member2= new BandMember();
		member2.setAge("24");
		member2.setContact("+3148799998");
		member2.setGender("female");
		member2.setAddress("NA");
		member2.setName("Sail Drumm");
		bandMembers.add(member1);
		
		band1.setBandMembers(bandMembers);
		festival1.setBands(bands);
		
		festivals.add(festival1);
		return festivals;

	
	}

	/**
	 * @return empty Message back
	 */
	private List<MusicFestival> invalidLocation() {
		return new ArrayList<MusicFestival>();
	}

}
