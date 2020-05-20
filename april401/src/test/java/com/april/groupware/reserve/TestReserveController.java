package com.april.groupware.reserve;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.april.groupware.reserve.service.ReservationVO;
import com.april.groupware.reserve.service.ReserveDao;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestReserveController {
	private final Logger LOG = LoggerFactory.getLogger(TestReserveController.class);
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	ReserveDao dao;
	
	private List<ReservationVO> reserveList;
	
	//브라우저 대신 Mock 사용
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		LOG.debug("======================");
		LOG.debug("=setUp()=");
		LOG.debug("======================");
		
		//BASIC TEST
		reserveList = Arrays.asList(
				new ReservationVO("1", "20200428", "09", "11", "1", "이지은", "회의실 예약입니다", "0", "test", "", "test", ""),
				new ReservationVO("2", "20200428", "09", "11", "1", "이지은", "회의실 예약입니다", "0", "test", "", "test", ""),
				new ReservationVO("3", "20200428", "09", "11", "1", "이지은", "회의실 예약입니다", "0", "test", "", "test", "")
				);
				
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		LOG.debug("======================");
		LOG.debug("=mockMvc= : "+mockMvc);
		LOG.debug("=webApplicationContext= : "+webApplicationContext);
		LOG.debug("======================");
	}
	
	@Test
//	@Ignore
	public void test() {
		LOG.debug("======================");
		LOG.debug("=test()=");
		LOG.debug("======================");
		
		LOG.debug("======================");
		LOG.debug("=dao= "+dao);
		LOG.debug("======================");
		
		assertNotNull(dao);
		assertThat(1, is(1));
	}
	
	@Test
	@Ignore
	public void add() throws Exception {
		LOG.debug("======================");
		LOG.debug("=add()=");
		LOG.debug("======================");
		
		//URL+Param
		//		#{rsvNo},                  
		//	    #{rsvDay},                  
		//	    #{rsvStartTime},           
		//	    #{rsvEndTime},           
		//	    #{meetRoomNo},           
		//	    #{rsvName},           
		//	    #{rsvCn},           
		//	    #{rsvYN},           
		//	    #{regId},
		//	    sysdate,
		//	    #{modId},
		//	    sysdate
		
		//MockMvcRequestBuilders.post, get
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/reserve/do_insert.do")
				.param("rsvNo", reserveList.get(0).getRsvNo())
				.param("rsvDay", reserveList.get(0).getRsvDay())
				.param("rsvStartTime", reserveList.get(0).getRsvStartTime())
				.param("rsvEndTime", reserveList.get(0).getRsvEndTime())
				.param("meetRoomNo", reserveList.get(0).getMeetRoomNo())
				.param("rsvName", reserveList.get(0).getRsvName())
				.param("rsvCn", reserveList.get(0).getRsvCn())
				.param("rsvYN", reserveList.get(0).getRsvYN())
				.param("regId", reserveList.get(0).getRegId())
				.param("modId", reserveList.get(0).getModId())
				;
		
		ResultActions resultActions = mockMvc.perform(createMessage)
				.andExpect(MockMvcResultMatchers.content().contentType("application/json; charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.msgId", is("1")));
		
		String result = resultActions.andDo(print()).
				andReturn().
				getResponse().getContentAsString();
		
		LOG.debug("======================");
		LOG.debug("=add() result= : "+result);
		LOG.debug("======================");
	}
	
	@Test
	@Ignore
	public void doDelete() throws Exception {
		LOG.debug("======================");
		LOG.debug("=doDelete()=");
		LOG.debug("======================");
		
		//조회
		ReservationVO ReserveVO = (ReservationVO) dao.doSelectOne(reserveList.get(0));
		LOG.debug("======================");
		LOG.debug("=doDelete() ReservationVO= : "+ReserveVO);
		LOG.debug("======================");
		
		//URL+Param
		//		WHERE reg_id = 		#{regId}
		//		AND	rsv_no = 		#{rsvNo}
		
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/reserve/do_delete.do")
				.param("regId", ReserveVO.getRegId())
				.param("rsvNo", ReserveVO.getRsvNo())
				;
		
		ResultActions resultActions = mockMvc.perform(createMessage)
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$.msgId", is("1")));
		
		String result = resultActions.andDo(print()).
				andReturn().
				getResponse().getContentAsString();
		
		LOG.debug("======================");
		LOG.debug("=doDelete() result= : "+result);
		LOG.debug("======================");
	}
	
	@Test
	@Ignore
	public void doUpdate() throws Exception {
		//조회
		ReservationVO ReserveVO = (ReservationVO) dao.doSelectOne(reserveList.get(0));
		LOG.debug("======================");
		LOG.debug("=doUpdate() ReservationVO= : "+ReserveVO);
		LOG.debug("======================");
		
		ReserveVO.setRsvName(ReserveVO.getRsvName()+"_U");
		//URL+Param
		//		rsv_day = 		#{rsvDay},      
		//	    rsv_st_time = 	#{rsvStartTime},  
		//	    rsv_end_time = 	#{rsvEndTime}, 
		//	    mt_rm_no = 		#{meetRoomNo},     
		//	    rsv_name = 		#{rsvName},     
		//	    rsv_cn = 		#{rsvCn},       
		//	    rsv_yn = 		#{rsvYN},       
		//	    mod_id = 		#{modId},       
		//	    mod_date = 		sysdate
		//		WHERE reg_id = 	#{regId}
		//		AND	rsv_no = 	#{rsvNo}
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/reserve/do_update.do")
				.param("rsvDay", ReserveVO.getRsvDay())
				.param("rsvStartTime", ReserveVO.getRsvStartTime())
				.param("rsvEndTime", ReserveVO.getRsvEndTime())
				.param("meetRoomNo", ReserveVO.getMeetRoomNo())
				.param("rsvName", ReserveVO.getRsvName())
				.param("rsvCn", ReserveVO.getRsvCn())
				.param("rsvYN", ReserveVO.getRsvYN())
				.param("modId", ReserveVO.getModId())
				.param("regId", ReserveVO.getRegId())
				.param("rsvNo", ReserveVO.getRsvNo())
				;
		
		ResultActions resultActions = mockMvc.perform(createMessage)
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$.msgId", is("1")));
		
		String result = resultActions.andDo(print()).
				andReturn().
				getResponse().getContentAsString();
		
		LOG.debug("======================");
		LOG.debug("=result= : "+result);
		LOG.debug("======================");

		//수정된 데이터 조회
		ReservationVO vsVO = (ReservationVO) dao.doSelectOne(ReserveVO);
		
		//비교
		checkSameUser(vsVO, ReserveVO);
	}
	
	public void checkSameUser(ReservationVO ReserveVO, ReservationVO vsVO) {
		//assertThat(ReserveVO.getId(), is(vsVO.getId()));
		//assertThat(ReserveVO.getSeq(), is(vsVO.getSeq()));
	}
	
	@Test
	@Ignore
	public void doSelectOne() throws Exception {

		ReservationVO ReserveVO = (ReservationVO) dao.doSelectOne(reserveList.get(0));
		LOG.debug("======================");
		LOG.debug("=ReserveVO= : "+ReserveVO);
		LOG.debug("======================");
		
		//URL+Param
		//		WHERE reg_id = #{regId}
		
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/reserve/do_select_one.do")
				.param("regId", ReserveVO.getRegId())
				;
		
		ResultActions resultActions = this.mockMvc.perform(createMessage)
				.andExpect(status().is2xxSuccessful())
				;
		
		String result = resultActions.andDo(print()).andReturn().getResponse().getContentAsString();
		LOG.debug("======================");
		LOG.debug("=result= : "+result);
		LOG.debug("======================");
	}
	
	@Test
//	@Ignore
	public void doRetrieve() throws Exception {
		//조회 + 검색 조건
		//URL+Param
//		SearchVO inVO = new SearchVO("10", "test", 10, 1, "20200427", "20200429"); //날짜 검색, 검색 조건이 모두 있는 경우
//		SearchVO inVO = new SearchVO("10", "test", 10, 1, "", ""); //검색 조건만 있는 경우
//		SearchVO inVO = new SearchVO("", "", 10, 1, "", ""); //날짜 검색, 검색 조건이 모두 없는 경우
		
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.get("/reserve/do_retrieve.do")
				.param("pageNum", "1")
				.param("pageSize", "10")
//				.param("searchDiv", "")
//				.param("searchWord", " ")
				.param("searchDiv", "10")
				.param("searchWord", "test")
				.param("searchStartDate", "20200427")
				.param("searchEndDate", "20200427")
				;
		
		ResultActions resultActions = mockMvc.perform(createMessage)
				.andExpect(status().is2xxSuccessful())
				.andExpect(model().attributeExists("searchList"))
				.andExpect(model().attributeExists("list"))
				.andExpect(model().attributeExists("totalCnt"))
				;
		
		String result = resultActions.andDo(print()).
				andReturn().
				getResponse().getContentAsString();
		
		LOG.debug("======================");
		LOG.debug("=result= : "+result);
		LOG.debug("======================");
	}
	
}