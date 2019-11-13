package com.ea.music.rmgr.model;

import java.util.List;

import com.ea.music.rmgr.entity.RecordLabel;

/**
 * response thats 
 * sent back to UI
 *
 */
public class MusicManagerRes {

	MusicMgrHeader header;

	public MusicMgrHeader getHeader() {
		return header;
	}

	public void setHeader(MusicMgrHeader header) {
		this.header = header;
	}

	public List<RecordLabel> getLabels() {
		return labels;
	}

	public void setLabels(List<RecordLabel> labels) {
		this.labels = labels;
	}

	List<RecordLabel> labels;

	@Override
	public String toString() {
		return "MusicManagerRes [header=" + header + ", labels=" + labels + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
