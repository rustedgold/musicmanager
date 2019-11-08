package com.ea.music.rmgr.model;

import java.util.List;

import com.ea.music.rmgr.entity.MusicFestival;

/**
 * response thats 
 * sent back to UI
 *
 */
public class MusicMgrResponse {

	MusicMgrHeader header;

	public MusicMgrHeader getHeader() {
		return header;
	}

	public void setHeader(MusicMgrHeader header) {
		this.header = header;
	}

	public List<MusicFestival> getFestivals() {
		return festivals;
	}

	public void setFestivals(List<MusicFestival> festivals) {
		this.festivals = festivals;
	}

	List<MusicFestival> festivals;
}
