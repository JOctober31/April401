package com.april.groupware.attendance;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

import com.april.groupware.attendance.service.AttendanceDao;
import com.april.groupware.attendance.service.AttendanceVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestAttendanceController {
	private final Logger LOG = LoggerFactory.getLogger(TestAttendanceController.class);
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	AttendanceDao dao;
	
	private List<AttendanceVO> attendList;
	
	//브라우저 대신 Mock 사용
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		LOG.debug("======================");
		LOG.debug("=setUp()=");
		LOG.debug("======================");
		
		//BASIC TEST
		attendList = Arrays.asList(
				new AttendanceVO("test11", "1", "attendTime", "leaveTime", "1", "0", "0", "0", "test", "test", "", ""),
				new AttendanceVO("test22", "1", "attendTime", "leaveTime", "1", "1", "1", "0", "test", "test", "", ""),
				new AttendanceVO("test33", "1", "attendTime", "leaveTime", "1", "1", "2", "0", "test", "test", "", "")
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
//	@Ignore
	public void add() throws Exception {
		LOG.debug("======================");
		LOG.debug("=add()=");
		LOG.debug("======================");
		
		//URL+Param
		//		#{seq},                  
		//	    #{id},                  
		//	    sysdate,                  
		//	    #{attendYN},                  
		//	    #{leaveYN},                  
		//	    #{workTime},                  
		//	    #{regId},                  
		//	    #{modId},                  
		//	    sysdate,
		//	    sysdate
		
		//MockMvcRequestBuilders.post, get
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/attend/do_insert.do")
				.param("seq", attendList.get(0).getSeq())
				.param("id", attendList.get(0).getId())
				.param("attendYN", attendList.get(0).getAttendYN())
				.param("leaveYN", attendList.get(0).getLeaveYN())
				.param("workTime", attendList.get(0).getWorkTime())
				.param("regId", attendList.get(0).getRegId())
				.param("modId", attendList.get(0).getModId())
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
		AttendanceVO attendVO = (AttendanceVO) dao.doSelectOne(attendList.get(0));
		LOG.debug("======================");
		LOG.debug("=doDelete() AttendanceVO= : "+attendVO);
		LOG.debug("======================");
		
		//URL+Param
		//		WHERE seq = #{seq}
		//		AND id = #{id}
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/attend/do_delete.do")
//				.param("seq", "1")
//				.param("id", "test11")
				.param("seq", attendVO.getSeq())
				.param("id", attendVO.getId())
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
//	@Ignore
	public void doUpdate() throws Exception {
		//조회
		AttendanceVO attendVO = (AttendanceVO) dao.doSelectOne(attendList.get(0));
		LOG.debug("======================");
		LOG.debug("=doUpdate() AttendanceVO= : "+attendVO);
		LOG.debug("======================");
		
		//URL+Param
		//		attend_time = 	sysdate,
		//	    lv_ffc_time = 	sysdate,
		//	    attend_yn = 	#{attendYN},  
		//	    lv_ffc_yn = 	#{leaveYN},  
		//	    state = 		#{state},   	
		//	    work_time = 	#{workTime},  
		//	    mod_id = 		#{modId},     
		//	    mod_date = 		sysdate    
		//	    WHERE id = 		#{id}
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/attend/do_update.do")
				.param("attendYN", "1")
				.param("leaveYN", "0")
				.param("state", "0")
				.param("workTime", attendVO.getWorkTime())
				.param("modId", attendVO.getId())
				.param("id", attendVO.getId())
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
		AttendanceVO vsVO = (AttendanceVO) dao.doSelectOne(attendVO);
		
		//비교
		checkSameUser(vsVO, attendVO);
	}
	
	@Test
//	@Ignore
	public void doLeaveUpdate() throws Exception {
		//조회
		AttendanceVO attendVO = (AttendanceVO) dao.doSelectOne(attendList.get(0));
		LOG.debug("======================");
		LOG.debug("=doLeaveUpdate() AttendanceVO= : "+attendVO);
		LOG.debug("======================");
		
		//URL+Param
		//		lv_ffc_time = 	sysdate, 
		//	    lv_ffc_yn = 	#{leaveYN},   
		//	    state = 		#{state},   	
		//	    work_time = 	#{workTime},   //TODO : work_time 시간 계산해서 insert 하기
		//	    mod_id = 		#{modId},      
		//	    mod_date = 		sysdate     
		//	    WHERE id = 		#{id}
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/attend/leave_update.do")
				.param("leaveYN", "1")
				.param("state", "0")
				.param("workTime", attendVO.getWorkTime())
				.param("modId", attendVO.getId())
				.param("id", attendVO.getId())
				;
		
		ResultActions resultActions = mockMvc.perform(createMessage)
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$.msgId", is("1")));
		
		String result = resultActions.andDo(print()).
				andReturn().
				getResponse().getContentAsString();
		
		LOG.debug("======================");
		LOG.debug("=doLeaveUpdate() result= : "+result);
		LOG.debug("======================");

		//수정된 데이터 조회
		AttendanceVO vsVO = (AttendanceVO) dao.doSelectOne(attendVO);
		
		//비교
		checkSameUser(vsVO, attendVO);
	}
	
	public void checkSameUser(AttendanceVO attendVO, AttendanceVO vsVO) {
		assertThat(attendVO.getId(), is(vsVO.getId()));
		assertThat(attendVO.getSeq(), is(vsVO.getSeq()));
	}
	
	@Test
//	@Ignore
	public void doSelectOne() throws Exception {

		AttendanceVO attendVO = (AttendanceVO) dao.doSelectOne(attendList.get(0));
		LOG.debug("======================");
		LOG.debug("=attendVO= : "+attendVO);
		LOG.debug("======================");
		
		//URL+Param
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/attend/do_select_one.do")
				.param("id", attendVO.getId());
		
		ResultActions resultActions = this.mockMvc.perform(createMessage)
				.andExpect(status().is2xxSuccessful())
				;
		
		String result = resultActions.andDo(print()).andReturn().getResponse().getContentAsString();
		LOG.debug("======================");
		LOG.debug("=result= : "+result);
		LOG.debug("======================");
	}
	
}