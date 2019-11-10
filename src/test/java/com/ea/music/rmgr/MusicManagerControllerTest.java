package com.ea.music.rmgr;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ea.music.rmgr.controller.MusicManagerController;
import com.ea.music.rmgr.entity.Band;
import com.ea.music.rmgr.entity.BandMember;
import com.ea.music.rmgr.entity.MusicFestival;
import com.ea.music.rmgr.entity.RecordLabel;
import com.ea.music.rmgr.model.MusicMgrResponse;
import com.ea.music.rmgr.service.ManagerService;

import junit.framework.TestCase;

/**
 * Unit test for music Manager
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MusicManagerController.class)
public class MusicManagerControllerTest extends TestCase {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ManagerService service;

	@Test
    public void greetingShouldReturnMessageFromService() throws Exception {
    	MusicMgrResponse response = new MusicMgrResponse();
    	response.setFestivals(loadFestivalsInIndia() );
        when(service.loadAllFestivals("india")).thenReturn(response);
        this.mockMvc.perform(get("/loadAllFestivals/india")).andDo(print()).andExpect(status().isOk());
    }

	/**
	 * @return list of music festivals in india/dummy data
	 */
	private List<MusicFestival> loadFestivalsInIndia() {
		List<MusicFestival> festivals = new ArrayList<MusicFestival>();
		MusicFestival festival1 = new MusicFestival();

		festival1.setFestivalId(Long.valueOf("234234234234"));
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
		member1.setActiveMember("Y");
		bandMembers.add(member1);

		BandMember member2 = new BandMember();
		member2.setAge("32");
		member2.setContact("+9148799998");
		member2.setGender("male");
		member2.setAddress("NA");
		member2.setName("Sunidhi Chauhan");
		member2.setActiveMember("Y");
		bandMembers.add(member2);

		band1.setBandMembers(bandMembers);
		bands.add(band1);
		festival1.setBands(bands);
		festivals.add(festival1);
		return festivals;

	}
}
