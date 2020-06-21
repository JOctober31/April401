package com.april.groupware.nboard;

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

import com.april.groupware.nboard.service.NBAnswerService;
import com.april.groupware.nboard.service.NBAnswerVO;
import com.april.groupware.nboard.service.NBoardVO;
import com.april.groupware.nboard.service.imple.NBAnswerDaoImple;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
                                   })
public class TestNBAnswerController {

private final Logger  LOG = LoggerFactory.getLogger(TestNBAnswerController.class);
	
	@Autowired
	WebApplicationContext  webApplicationContext;
	
	private List<NBAnswerVO> answerList;
	
	@Autowired
	NBAnswerService nbAnswerService;
	
	@Autowired
	NBAnswerDaoImple dao;
	
	//브라우저 대신 Mock
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		LOG.debug("*********************");
		LOG.debug("=setUp()=");
		LOG.debug("*********************");
		
		answerList = Arrays.asList(
				new NBAnswerVO(50,1041,"댓글 내용 ControllerTest01","등록자01","","20200501","")
				,new NBAnswerVO(2,1041,"댓글 내용 ControllerTest02","등록자02","","20200501","")				
				,new NBAnswerVO(3,1041,"댓글 내용 ControllerTest03","등록자03","","20200501","")
				);
				
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		LOG.debug("=====================");
		LOG.debug("=webApplicationContext="+webApplicationContext);
		LOG.debug("=mockMvc="+mockMvc);
		
		LOG.debug("=====================");		

	}
	
	//목록조회 - 성공
	@Test
	@Ignore
	public void doRetrieve()  throws Exception {

		//url+param
		MockHttpServletRequestBuilder  createMesage 
					= MockMvcRequestBuilders.get("/nbAnswer/do_retrieve.do")
					.param("pageNum", "1")
					.param("pageSize", "10")
		;

		ResultActions  resultActions = mockMvc.perform(createMesage)
				.andExpect(status().is2xxSuccessful())	
				.andExpect(model().attributeExists("list"))
				.andExpect(model().attributeExists("vo"))
				.andExpect(model().attributeExists("totalCnt"))
				;

		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString();
		LOG.debug("=====================");
		LOG.debug("=result="+result);
		LOG.debug("=====================");  				
	}
	
	
	//단건삭제 -성공 (Test 실행시 answerList의 awNo값 변경필요)
	@Test
	@Ignore
	public void doDelete() throws Exception {
		
		int flag = dao.doInsert(answerList.get(0));
		
		NBAnswerVO answerId = answerList.get(0);
//		NBAnswerVO boardId = (NBAnswerVO) dao.doSelectOneTitle(boardList.get(0));
		LOG.debug("====== Controller doDelete()===============");
		LOG.debug("=NBAnswerVO="+answerId);
		LOG.debug("=====================");
		
		//url+param
		MockHttpServletRequestBuilder  createMesage 
				= MockMvcRequestBuilders.post ("/nbAnswer/do_delete.do")
				.param("awNo", answerId.getAwNo()+"")		
				.param("nbNo", answerId.getNbNo()+"");		

		ResultActions  resultActions = mockMvc.perform(createMesage)
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$.msgId", is("1")));
		;

		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString();
		LOG.debug("=====================");
		LOG.debug("=result="+result);
		LOG.debug("=====================");		
	}
	
	
	//등록 -성공
	@Test
	@Ignore
	public void add() throws Exception {
		int flag = dao.doInsert(answerList.get(0));
		flag += dao.doInsert(answerList.get(1));
		flag += dao.doInsert(answerList.get(2));
		
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.post("/nbAnswer/do_insert.do")
				.param("awContents", answerList.get(0).getAwContents())
				.param("regId", answerList.get(0).getRegId())
				;
		ResultActions  resultActions =mockMvc.perform(createMessage)
			       .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
			       .andExpect(MockMvcResultMatchers.jsonPath("$.msgId", is("1")))
			;
		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString();
		LOG.debug("========add()=============");
		
		LOG.debug("=result="+result);
		LOG.debug("=====================");
		
	}
	
	public void checkSameUser(NBoardVO orgVO, NBoardVO vsVO) {
		//assertTrue(orgVO.equals(vsVO));
		assertThat(orgVO.getNbCategory(), is(vsVO.getNbCategory()));
		assertThat(orgVO.getNbTitle(), is(vsVO.getNbTitle()));
		assertThat(orgVO.getNbContents(), is(vsVO.getNbContents()));
		assertThat(orgVO.getRegId(), is(vsVO.getRegId()));
	}
	
	@Test
	@Ignore
	public void test() {
		LOG.debug("=====================");
		LOG.debug("=test()=");
		LOG.debug("=====================");
		
		LOG.debug("=====================");
		LOG.debug("=nbAnswerService="+nbAnswerService);
		LOG.debug("=dao="+dao);
		LOG.debug("=====================");		
		assertNotNull(nbAnswerService);
		assertNotNull(dao);
//		assertThat(1, is(1));
	
	}
	

	

}
