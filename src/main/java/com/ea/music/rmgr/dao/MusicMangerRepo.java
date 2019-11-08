package com.ea.music.rmgr.dao;

import org.springframework.data.repository.CrudRepository;

import com.ea.music.rmgr.entity.MusicFestival;

//To be used after
//configuration of Db
public interface MusicMangerRepo extends CrudRepository<MusicFestival, Long> {

}
