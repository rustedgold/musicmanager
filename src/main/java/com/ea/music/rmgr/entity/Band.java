package com.ea.music.rmgr.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Band {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long bandId;
	private String bandName ;
	private List<BandMember> bandMembers ;
	
	public Long getBandId() {
		return bandId;
	}
	public void setBandId(Long bandId) {
		this.bandId = bandId;
	}
	public List<BandMember> getBandMembers() {
		return bandMembers;
	}
	public void setBandMembers(List<BandMember> bandMembers) {
		this.bandMembers = bandMembers;
	}
	private String bandPrimaryContact ;
	private String bandManager ;
	private String bandLocation ;
	private RecordLabel label;
	
	public String getBandPrimaryContact() {
		return bandPrimaryContact;
	}
	public void setBandPrimaryContact(String bandPrimaryContact) {
		this.bandPrimaryContact = bandPrimaryContact;
	}
	public String getBandManager() {
		return bandManager;
	}
	public void setBandManager(String bandManager) {
		this.bandManager = bandManager;
	}
	public String getBandLocation() {
		return bandLocation;
	}
	public void setBandLocation(String bandLocation) {
		this.bandLocation = bandLocation;
	}
	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	public RecordLabel getLabel() {
		return label;
	}
	public void setLabel(RecordLabel label) {
		this.label = label;
	}
	
}
