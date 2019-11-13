package com.ea.music.rmgr.helper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ea.music.rmgr.entity.Band;
import com.ea.music.rmgr.entity.BandMember;
import com.ea.music.rmgr.entity.MusicFestival;
import com.ea.music.rmgr.entity.RecordLabel;

@Component
public class MusicManagerHelper {

	Logger logger =LoggerFactory.getLogger(MusicManagerHelper.class);
	/**
	 * @return list of music 
	 * labels of Sony
	 */
	public List<RecordLabel> loadLabelsSony() {
		logger.info("Loading Labels for Sony");
		List<MusicFestival> festivals = new ArrayList<MusicFestival>();
		MusicFestival festival1 = new MusicFestival();

		festival1.setFestivalId(Long.valueOf("234234234234"));
		festival1.setFestivalLocation("INDIA");
		festival1.setFestivalName("Alpha Festival");
		festival1.setNoOfAudience("10000");
		
		festival1.setFestivalId(Long.valueOf("234234234234"));
		festival1.setFestivalLocation("INDIA");
		festival1.setFestivalName("GAMMA Festival");
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
		bandMembers.add(member2);
		
		band1.setBandMembers(bandMembers);
		bands.add(band1);
		festivals.add(festival1);
		band1.setFestivals(festivals);
		
		label1.setBands(bands);
		
		ArrayList<RecordLabel> labels = new ArrayList<RecordLabel>();
		labels.add(label1);
		
		return labels;

	}

	/**
	 * @return list of music 
	 * festivals in melbourne/dummy data
	 */
	public List<RecordLabel> loadLabelsCasablanca() {
		logger.info("Loading music festivals in Melbourne");
		List<MusicFestival> festivals = new ArrayList<MusicFestival>();
		MusicFestival festival1 = new MusicFestival();
		festival1.setFestivalId(Long.valueOf("534234234234"));
		
		festival1.setFestivalLocation("Melbourne");
		festival1.setFestivalName("BetaGamma festival");
		festival1.setNoOfAudience("2000");
		
		
		MusicFestival festival2 = new MusicFestival();
		festival2.setFestivalId(Long.valueOf("9234234234"));
		
		festival2.setFestivalLocation("Melbourne");
		festival2.setFestivalName("AlphaBetaGamma festival");
		festival2.setNoOfAudience("21000");

		List<Band> bands = new ArrayList<Band>();
		Band band1 = new Band();
		band1.setBandLocation("London");
		band1.setBandName("Backstreet Girls");
		band1.setBandManager("Ms.Catherine Summer");
		band1.setBandPrimaryContact("+12805467896");
		
		RecordLabel label1 = new RecordLabel();
		label1.setLabelOwner("Disney");
		label1.setLabelContact("+315687822554");
		
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
		bandMembers.add(member2);
		
		band1.setBandMembers(bandMembers);
		
		Band band2 = new Band();
		band2.setBandLocation("Paris");
		band2.setBandName("Backstreet Boys");
		band2.setBandManager("Mr.John Snow");
		band2.setBandPrimaryContact("+12805467896");
		
		
		bands.add(band1);
		bands.add(band2);
		
		festivals.add(festival1);
		festivals.add(festival2);
		band1.setFestivals(festivals);
		band2.setFestivals(festivals);
		
		label1.setBands(bands);
		
		ArrayList<RecordLabel> labels = new ArrayList<RecordLabel>();
		labels.add(label1);
		
		return labels;

	
	}

	/**
	 * @return empty Message back
	 */
	public List<RecordLabel> invalidName() {
		logger.info("Loading no music lables /Invalid name");
		return new ArrayList<RecordLabel>();
	}
}
