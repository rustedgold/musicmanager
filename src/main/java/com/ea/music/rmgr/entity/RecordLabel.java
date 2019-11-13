package com.ea.music.rmgr.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RecordLabel {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long labelId;
	private String labelOwner;
	private String labelContact;
	List<Band> bands;
 
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


	@Override
	public String toString() {
		return "RecordLabel [labelId=" + labelId + ", labelOwner=" + labelOwner + ", labelContact=" + labelContact
				+ ", bands=" + bands + "]";
	}

	/**
	 * @return the bands
	 */
	public List<Band> getBands() {
		return bands;
	}

	/**
	 * @param bands the bands to set
	 */
	public void setBands(List<Band> bands) {
		this.bands = bands;
	}

}
