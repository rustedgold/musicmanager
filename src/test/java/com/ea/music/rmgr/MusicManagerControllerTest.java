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
import com.ea.music.rmgr.helper.MusicManagerHelper;
import com.ea.music.rmgr.model.MusicManagerRes;
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
	
	@Autowired
	MusicManagerHelper helper;

	@Test
    public void greetingShouldReturnMessageFromService() throws Exception {
    	MusicManagerRes response = new MusicManagerRes();
    	response.setLabels(helper.loadLabelsSony() );
        when(service.loadAllLabels("Sony")).thenReturn(response);
        this.mockMvc.perform(get("/loadAllLabels/Sony")).andDo(print()).andExpect(status().isOk());
    }

}
