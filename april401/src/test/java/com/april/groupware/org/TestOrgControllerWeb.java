package com.april.groupware.org;

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

import com.april.groupware.org.service.OrgService;
import com.april.groupware.org.service.OrgVO;



@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
                                   })
public class TestOrgControllerWeb {
	
	private final Logger  LOG = LoggerFactory.getLogger(TestOrgControllerWeb.class);
	
	@Autowired
	WebApplicationContext  webApplicationContext;
	
	@Autowired
	OrgService dao;

	 
	//브라우저 대신 Mock
	private MockMvc mockMvc;
	private List<OrgVO> userList;
	
	@Before
	public void setUp() {
		LOG.debug("*********************");
		LOG.debug("=setUp()=");
		LOG.debug("*********************");
		userList = Arrays.asList(
				new OrgVO(
					    "king004","1234","부서명","1","1",
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
		LOG.debug("=====================");	

	}
	   @Test
	   public void doRetrieve() throws Exception { 
	      // 1.전체삭제 //2.3건입력 //3.조회


	      //url+param
	            MockHttpServletRequestBuilder  createMesage = MockMvcRequestBuilders.get("/admin/do_retrieve.do")
	                      .param("pageNum", "1")
	                      .param("pageSize", "10")
	                      .param("searchDiv", "10")
	                      .param("searchWord", "kimjh");
	                     ;
	                     
	            ResultActions  resultActions = mockMvc.perform(createMesage)
	            		.andExpect(status().is2xxSuccessful())	
	    				.andExpect(model().attributeExists("searchList"))
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
	

	
	@Test
	@Ignore
	public void doUpdate() throws Exception {
		//조회
		OrgVO originVO = (OrgVO) dao.doSelectOne(userList.get(0));
		LOG.debug("======================");
		LOG.debug("=OrgVO= : "+originVO);
		LOG.debug("======================");
		
//				SET		    id = #{id},
//			    password = #{password},
//			    dept_nm = #{deptNm},
//			    dept_cd = #{deptCd},
//			    parent_dept_cd = #{parentDeptCd},
//			    auth = #{auth},
//			    name = #{name},
//			    position = #{position},
//			    hire_date = #{hiredate},
//			    vacation_cnt = #{vacationCnt},
//			    mod_id = #{modId},
//			    mod_date = sysdate
		
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.post("/admin/do_update.do")
				.param("id", userList.get(0).getId())
				.param("password", userList.get(0).getPassword()+"_u")
				.param("deptNm", userList.get(0).getDeptNm()+"_u")
				.param("deptCd", userList.get(0).getDeptCd()+"_u")
				.param("parentDeptCd", userList.get(0).getDeptCd()+"_u")
				.param("auth", "9")
				.param("name", userList.get(0).getName()+"_u")
				.param("position", userList.get(0).getPosition())
				.param("hiredate", "19901012")
				.param("vacationCnt", "15")
				.param("modId", userList.get(0).getModId()+"_u")
				.param("modDate", userList.get(0).getModDate())
			
				;
		
		ResultActions  resultActions =mockMvc.perform(createMessage)
				       .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				       .andExpect(MockMvcResultMatchers.jsonPath("$.msgId", is("1")))
				;
		String result = resultActions.andDo(print())
						.andReturn()
						.getResponse().getContentAsString();
		LOG.debug("=====================");
		LOG.debug("=result="+result);
		LOG.debug("====================="); 

		// 수정된 데이터 조회
		OrgVO vsVO = (OrgVO) dao.doSelectOne(originVO);
		
		// 비교
		checkSameUser(vsVO, originVO);
	}
	
	public void checkSameUser(OrgVO originVO, OrgVO vsVO) {
		assertThat(originVO.getModId(), is(vsVO.getModId()));
	}
	
	@Test
	@Ignore
	public void add() throws Exception {
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.post("/admin/do_insert.do")
				.param("id", userList.get(0).getId())
				.param("password", userList.get(0).getPassword())
				.param("deptNm", userList.get(0).getDeptNm())
				.param("deptCd", userList.get(0).getDeptCd())
				.param("parentDeptCd", userList.get(0).getDeptCd())
				.param("auth", userList.get(0).getAuth())
				.param("name", userList.get(0).getName())
				.param("position", userList.get(0).getPosition())
				.param("mobile", userList.get(0).getMobile())
				.param("email", userList.get(0).getEmail())
				.param("address", userList.get(0).getAddress())
				.param("hiredate", userList.get(0).getHiredate())
				.param("birth", userList.get(0).getBirth())
				.param("vacationCnt", userList.get(0).getVacationCnt())
				.param("militaryYN", userList.get(0).getMilitaryYN())
				.param("dspsnYN", userList.get(0).getDspsnYN())
				.param("grade", userList.get(0).getGrade())
				.param("orgFileName", userList.get(0).getOrgFileName())
				.param("saveFileName", userList.get(0).getSaveFileName())
				.param("ext", userList.get(0).getExt())
				.param("fileSize", userList.get(0).getFileSize())
				.param("regId", userList.get(0).getRegId())
				.param("regDate", userList.get(0).getRegDate())
				.param("modId", userList.get(0).getModId())
				.param("modDate", userList.get(0).getModDate())
				;
		
		ResultActions  resultActions =mockMvc.perform(createMessage)
				       .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				       .andExpect(MockMvcResultMatchers.jsonPath("$.msgId", is("1")))
				;
		String result = resultActions.andDo(print())
						.andReturn()
						.getResponse().getContentAsString();
		LOG.debug("=====================");
		LOG.debug("=result="+result);
		LOG.debug("====================="); 
	}
	

	
	@Test
	@Ignore
	public void doSelectOne() throws Exception {
		OrgVO orgVO = (OrgVO) dao.doSelectOne(userList.get(0));
		LOG.debug("======================");
		LOG.debug("=orgVO= : "+orgVO);
		LOG.debug("======================");
		
		//URL+Param
		MockHttpServletRequestBuilder createMessage = MockMvcRequestBuilders.post("/admin/do_select_one.do")
				.param("id", orgVO.getId());
		
		ResultActions resultActions = this.mockMvc.perform(createMessage)
				.andExpect(status().is2xxSuccessful())
				;
		
		String result = resultActions.andDo(print()).andReturn().getResponse().getContentAsString();
		LOG.debug("======================");
		LOG.debug("=result= : "+result);
		LOG.debug("======================");
	}
	
	@Test
	
	public void test() {
		LOG.debug("=====================");
		LOG.debug("=test()=");
		LOG.debug("=====================");
		LOG.debug("=====================");
		LOG.debug("=OrgService="+dao);
		LOG.debug("=====================");		
	
		assertNotNull(dao);
		assertThat(1, is(1));
	
	}
	
	
	

	

}
