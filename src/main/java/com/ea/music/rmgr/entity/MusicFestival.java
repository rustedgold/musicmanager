package com.ea.music.rmgr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MusicFestival {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long festivalId;
	private String festivalName;
	private String festivalLocation;

	public Long getFestivalId() {
		return festivalId;
	}

	public void setFestivalId(Long festivalId) {
		this.festivalId = festivalId;
	}


	private String noOfAudience;

	public String getFestivalName() {
		return festivalName;
	}

	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
	}

	public String getFestivalLocation() {
		return festivalLocation;
	}

	public void setFestivalLocation(String festivalLocation) {
		this.festivalLocation = festivalLocation;
	}

	public String getNoOfAudience() {
		return noOfAudience;
	}

	public void setNoOfAudience(String noOfAudience) {
		this.noOfAudience = noOfAudience;
	}

	@Override
	public String toString() {
		return "MusicFestival [festivalId=" + festivalId + ", festivalName=" + festivalName + ", festivalLocation="
				+ festivalLocation + ", noOfAudience=" + noOfAudience + "]";
	}

}
