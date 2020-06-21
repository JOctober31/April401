package com.april.groupware.chat;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.april.groupware.chat.service.ChatService;
import com.april.groupware.chat.service.ChatVO;
import com.april.groupware.chat.service.imple.ChatDaoImple;
import com.april.groupware.org.service.OrgVO;



@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
                                   })
public class TestChatControllerWeb {

	private final Logger  LOG = LoggerFactory.getLogger(TestChatControllerWeb.class);
	
	@Autowired
	WebApplicationContext  webApplicationContext;
	
	private List<ChatVO> chatList;
	private List<OrgVO> orgList;
	
	@Autowired
	ChatService chatService;
	
	@Autowired
	ChatDaoImple dao;
	
	//브라우저 대신 Mock
	private MockMvc mockMvc;
	   
	@Before   //03 초기값 세팅
	public void setUp() {
      LOG.debug("*********************");
      LOG.debug("=setUp()=");
      LOG.debug("*********************");
//      orgList = Arrays.asList(
//            new OrgVO(
//                  "kim56","1234","부서명","1","1","1","김사원","직급",
//      			"012-345-6789","email","주소","20200202")
//            );

      chatList = Arrays.asList(
              new ChatVO("kimjh1","부서명","이름","직급")
            );
				
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		LOG.debug("=====================");
		LOG.debug("=webApplicationContext="+webApplicationContext);
		LOG.debug("=mockMvc="+mockMvc);
		
		LOG.debug("=====================");		

	}
	
   
	@Test
	public void doRetrieve()  throws Exception {

		//url+param
		MockHttpServletRequestBuilder  createMesage 
		           = MockMvcRequestBuilders.get("/chat/do_retrieve.do")
		             .param("pageNum", "1")
					 .param("pageSize", "10")
					 .param("searchDiv", "")
					 .param("searchWord", "");
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
	
	
	@Ignore
	@Test
	public void doSelectOne() throws Exception {

		ChatVO chatId = (ChatVO) dao.doSelectOne(chatList.get(0));
		LOG.debug("=====================");
		LOG.debug("=ChatVO="+chatId);
		LOG.debug("=====================");  
		
		//url+param
		MockHttpServletRequestBuilder  createMesage 
		           = MockMvcRequestBuilders.get("/chat/do_selectone.do")
		             .param("id", chatId.getId()+"");		
		
		ResultActions  resultActions = mockMvc.perform(createMesage)
			.andExpect(status().is2xxSuccessful())	
			;
				
		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString();
		LOG.debug("=====================");
		LOG.debug("=result="+result);
		LOG.debug("=====================");  		

	}
	
	
//	public void checkSameUser(BoardVO orgVO, BoardVO vsVO) {
//		//assertTrue(orgVO.equals(vsVO));
//		assertThat(orgVO.getTitle(), is(vsVO.getTitle()));
//		assertThat(orgVO.getContents(), is(vsVO.getContents()));
//		assertThat(orgVO.getRegId(), is(vsVO.getRegId()));
//	}
	
	
	@Ignore
	@Test
	public void test() {
		LOG.debug("=====================");
		LOG.debug("=test()=");
		LOG.debug("=====================");
		
		LOG.debug("=====================");
		LOG.debug("=chatService="+chatService);
		LOG.debug("=dao="+dao);
		LOG.debug("=====================");		
//		assertNotNull(userService);
//		assertNotNull(dao);
//		assertThat(1, is(1));
//	
	}
	
	
	
}
