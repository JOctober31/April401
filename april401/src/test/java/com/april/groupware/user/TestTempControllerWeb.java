package com.april.groupware.user;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
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

import com.april.groupware.member.service.UserService;
import com.april.groupware.member.service.UserVO;
import com.google.gson.Gson;




@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
                                   })
public class TestTempControllerWeb {

	private final Logger  LOG = LoggerFactory.getLogger(TestTempControllerWeb.class);
	
	@Autowired
	WebApplicationContext  webApplicationContext;
	
	private List<UserVO> users;
	
	@Autowired
	UserService  userService;
	
	//브라우저 대신 Mock
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp() {
		LOG.debug("*********************");
		
		LOG.debug("=setUp()=");
		LOG.debug("*********************");
		users = Arrays.asList(
					 new UserVO("kimjh21","1234","부서명","1","1",
							    "1","이름","직급","012-345-6789","email",
							    "주소","20200202","20200202","1","1",
							    "1","학력","원본파일명","수정파일명",
							    "ext","0",
							    "test","1234","test","1234")
					
				);
				
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		LOG.debug("=====================");
		LOG.debug("=webApplicationContext="+webApplicationContext);
		LOG.debug("=mockMvc="+mockMvc);
		LOG.debug("=userService="+userService);
		LOG.debug("=====================");		

	}
	
	//삭제,등록,단건조회
	@Test
	public void addAndGet()throws Exception{
		

		
		LOG.debug("=====================");		
		LOG.debug("=3.단건조회=");		
		LOG.debug("=====================");			
		
		for(UserVO user :users) {
			  UserVO vsVO = doSelectOne(user);
			  checkSameUser(vsVO, user);
		}
		
	}
	
	public void checkSameUser(UserVO orgVO, UserVO vsVO) {
		assertTrue(orgVO.equals(vsVO));
	}
	
	
	//단건조회
	private UserVO doSelectOne(UserVO user) throws Exception {
		//url+param
		MockHttpServletRequestBuilder  createMesage 
		           = MockMvcRequestBuilders.post("/member/do_select_one.do")
		             .param("id", user.getId());		
		
		//MediaType.APPLICATION_JSON_UTF8 ==application/json;charset=UTF-8
		ResultActions  resultActions = mockMvc.perform(createMesage)
			.andExpect(status().is2xxSuccessful())	
			.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
		    .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(user.getId())))
		    ;
				
		String result = resultActions.andDo(print())
				.andReturn()
				.getResponse().getContentAsString();
		LOG.debug("=====================");
		LOG.debug("=result="+result);
		LOG.debug("=====================");  		
		
		//Json String to UserVO
		Gson gson=new Gson();
		UserVO outVO =gson.fromJson(result, UserVO.class);
		
		LOG.debug("=====================");
		LOG.debug("=outVO="+outVO);
		LOG.debug("=====================");	
		
		return outVO;
	}
	

	

	
	
	@Test
	public void test() {
		LOG.debug("=====================");
		LOG.debug("=test()=");
		LOG.debug("=====================");
		
		
		LOG.debug("=====================");
		LOG.debug("=userService="+userService);
		LOG.debug("=====================");		
		
		assertThat(1, is(1));
		
	}
	

}
