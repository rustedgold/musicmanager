package com.ea.music.rmgr.entity;

import java.util.List;

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
	private List<Band> bands;
	public Long getFestivalId() {
		return festivalId;
	}

	public void setFestivalId(Long festivalId) {
		this.festivalId = festivalId;
	}

	public List<Band> getBands() {
		return bands;
	}

	public void setBands(List<Band> bands) {
		this.bands = bands;
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

}
