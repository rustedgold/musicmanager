package com.ea.music.rmgr.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RecordLabel {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long labelId;
	private ArrayList<Band> bands;
	private String labelOwner;
	private String labelContact;

	public String getLabelOwner() {
		return labelOwner;
	}

	public void setLabelOwner(String labelOwner) {
		this.labelOwner = labelOwner;
	}

	public String getLabelContact() {
		return labelContact;
	}

	public void setLabelContact(String labelContact) {
		this.labelContact = labelContact;
	}

	public ArrayList<Band> getBands() {
		return bands;
	}

	public void setBands(ArrayList<Band> bands) {
		this.bands = bands;
	}

}
