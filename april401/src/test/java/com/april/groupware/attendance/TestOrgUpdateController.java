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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.april.groupware.attendance.service.OrgUpdateDao;
import com.april.groupware.attendance.service.OrgUpdateVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestOrgUpdateController {
	private final Logger LOG = LoggerFactory.getLogger(TestOrgUpdateController.class);
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	OrgUpdateDao dao;
	
	private List<OrgUpdateVO> userList;
	
	//브라우저 대신 Mock 사용
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		LOG.debug("======================");
		LOG.debug("=setUp()=");
		LOG.debug("======================");
		
		//BASIC TEST
		userList = Arrays.asList(
				new OrgUpdateVO(
					"kimjh1","1234","부서명","1","1",
					"1","이름","직급","012-345-6789","email",
					"주소","20200202","20200202","1","1",
					"1","학력","원본파일명","수정파일명",
					"ext",0,
					"test1","1234","test1","1234"),
				new OrgUpdateVO(
					"kimjh2","1234","부서명","1","1",
					"1","이름","직급","012-345-6789","email",
					"주소","20200202","20200202","1","1",
					"1","학력","원본파일명","수정파일명",
					"ext",0,
					"test","1234","test","1234"),
				new OrgUpdateVO(
					"kimjh3","1234","부서명","1","1",
					"1","이름","직급","012-345-6789","email",
					"주소","20200202","20200202","1","1",
					"1","학력","원본파일명","수정파일명",
					"ext",0,
					"test","1234","test","1234")
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
	public void doUpdate() throws Exception {
		//조회
		OrgUpdateVO orgVO = (OrgUpdateVO) dao.doSelectOne(userList.get(0));
		LOG.debug("======================");
		LOG.debug("=OrgUpdateVO= : "+orgVO);
		LOG.debug("======================");
		
		//URL+Param
		//		password = 		#{password},     
		//	    mobile = 		#{mobile},       
		//	    email = 		#{email},        
		//	    address = 		#{address},      
		//	    military_yn = 	#{militaryYN},  
		//	    dspsn_yn = 		#{dspsnYN},     
		//	    grade = 		#{grade},        
		//	    org_file_nm = 	#{orgFileName},  
		//	    mod_file_nm = 	#{modFileName},  
		//	    img_path = 		#{imgPath},     
		//	    ext = 			#{ext},          
		//	    file_size = 	#{fileSize},
		//	    mod_id = 		#{modId}
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/org/do_update.do")
				.param("password", orgVO.getPassword())
				.param("mobile", orgVO.getMobile())
				.param("email", orgVO.getEmail())
				.param("address", orgVO.getAddress())
				.param("militaryYN", orgVO.getMilitaryYN())
				.param("dspsnYN", orgVO.getDspsnYN())
				.param("grade", orgVO.getGrade())
				.param("orgFileName", orgVO.getOrgFileName())
				.param("saveFileName", orgVO.getSaveFileName())
				.param("ext", orgVO.getExt())
				.param("fileSize", orgVO.getFileSize()+"")
				.param("modId", orgVO.getModId())
				.param("id", orgVO.getId())
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
		OrgUpdateVO vsVO = (OrgUpdateVO) dao.doSelectOne(orgVO);
		
		//비교
		checkSameUser(vsVO, orgVO);
	}
	
	public void checkSameUser(OrgUpdateVO orgVO, OrgUpdateVO vsVO) {
		assertThat(orgVO.getName(), is(vsVO.getName()));
		assertThat(orgVO.getModId(), is(vsVO.getModId()));
	}
	
	@Test
	@Ignore
	public void doSelectOne() throws Exception {

		OrgUpdateVO orgVO = (OrgUpdateVO) dao.doSelectOne(userList.get(0));
		LOG.debug("======================");
		LOG.debug("=orgVO= : "+orgVO);
		LOG.debug("======================");
		
		//URL+Param
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/org/do_select_one.do")
				.param("id", orgVO.getId());
		
		ResultActions resultActions = this.mockMvc.perform(createMessage)
				.andExpect(status().is2xxSuccessful())
				;
		
		String result = resultActions.andDo(print()).andReturn().getResponse().getContentAsString();
		LOG.debug("======================");
		LOG.debug("=result= : "+result);
		LOG.debug("======================");
	}
	
}