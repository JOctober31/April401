package com.april.groupware.todo;

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

import com.april.groupware.todo.service.TodoService;
import com.april.groupware.todo.service.TodoVO;
import com.april.groupware.todo.service.imple.TodoDaoImpl;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
                                   })
public class TestTodoControllerWeb {

	private final Logger  LOG = LoggerFactory.getLogger(TestTodoControllerWeb.class);
	
	@Autowired
	WebApplicationContext  webApplicationContext;
	
	private List<TodoVO> todoList;
	
	@Autowired
	TodoService  todoService;
	
	@Autowired
	TodoDaoImpl  dao;
	
	 
	//브라우저 대신 Mock
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		LOG.debug("*********************");
		LOG.debug("=setUp()=");
		LOG.debug("*********************");
		
		todoList = Arrays.asList(
				 new TodoVO("ja_124","운영팀","PM작업","MAIN","무림","잘하고 있습니다","서울","외근","1234_124","1234_124","","")
				,new TodoVO("ja_124","인사팀","PM작업","MAIN","러쉬","잘하고 있습니다","대구","외근","5678_124","5678_124","","")					
				,new TodoVO("ja_124","경영팀","PM작업","MAIN","경영","잘하고 있습니다","부산","외근","9101_124","9101_124","","")
				);
				
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		LOG.debug("=====================");
		LOG.debug("=webApplicationContext="+webApplicationContext);
		LOG.debug("=mockMvc="+mockMvc);
		
		LOG.debug("=====================");		

	}
	
	@Test
	@Ignore
	public void add() throws Exception {
		LOG.debug("1=================");
		LOG.debug("1=add=");
		LOG.debug("1=================");
		
		//dao.doDeleteAll();
		
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.post("/todo/do_insert.do")
				.param("id", todoList.get(0).getId())
				.param("deptNm", todoList.get(0).getDeptNm())
				.param("pTitle", todoList.get(0).getpTitle())
				.param("pType", todoList.get(0).getpType())
				.param("customer", todoList.get(0).getCustomer())
				.param("taskContents", todoList.get(0).getTaskContents())
				.param("area", todoList.get(0).getArea())
				.param("workingForm", todoList.get(0).getWorkingForm())
				.param("regId", todoList.get(0).getRegId())
				.param("modId", todoList.get(0).getModId())
				.param("regDate", todoList.get(0).getRegDate())
				.param("modDate", todoList.get(0).getModDate())
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
		
//		TodoVO titleVO = (TodoVO) dao.doSelectOneTitle(todoList.get(0));
//		TodoVO vsVO = (TodoVO) dao.doSelectOne(titleVO);
//		checkSameUser(vsVO,todoList.get(0));
	}
	
	@Test
	public void doRetrieve()  throws Exception {
		//2.3건입력
		//3.조회
		
		//url+param
		MockHttpServletRequestBuilder  createMesage 
		           = MockMvcRequestBuilders.get("/todo/do_retrieve.do")
		             .param("pageNum", "1")
					 .param("pageSize", "10")
					 .param("searchDiv", "")
					 .param("searchWord", "ja_124");
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
	
	@Test
	@Ignore
	public void doUpdate() throws Exception {
		//3.단건조회:board_id조회
		//3.1.단건수정
		//4.수정
		//5.수정데이터 조회
		//6.비교 
		TodoVO id = (TodoVO) dao.doSelectOne(todoList.get(0));
		LOG.debug("=====================");
		LOG.debug("=TodoVO="+id);
		LOG.debug("=====================");  
		
		id.setId(id.getId()+"");
		id.setDeptNm(id.getDeptNm()+"_U");
		id.setpTitle(id.getpTitle()+"_U");
		id.setpType(id.getpType()+"_U");
		id.setTaskContents(id.getTaskContents()+"_U");
		id.setCustomer(id.getCustomer()+"_U");
		id.setArea(id.getArea()+"_U");
		id.setWorkingForm(id.getWorkingForm()+"_U");
		id.setModId(id.getModId()+"");
		id.setModDate(id.getModDate()+"");
		
		
		//url+param
		MockHttpServletRequestBuilder  createMesage 
		           = MockMvcRequestBuilders.post ("/todo/do_update.do")
		        	.param("id", id.getId())
					 .param("deptNm", id.getDeptNm())
					 .param("pTitle",id.getpTitle())
					 .param("pType",id.getpType())
					 .param("taskContents",id.getTaskContents())
					 .param("customer",id.getCustomer())
					 .param("area",id.getArea())
					 .param("workingForm",id.getWorkingForm())
					 .param("modId",id.getModId())
					 .param("modDate",id.getModDate())
					;
		
		
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
				
		//5.수정데이터 조회
		TodoVO vsVO = (TodoVO) dao.doSelectOne(id);
	}
	
	@Test
	@Ignore
	public void doDelete() throws Exception {
		//1.전체 삭제
		//2.단건입력
		//3.단건조회:board_id조회
		//4.삭제
		//dao.doDeleteAll();
		
		
		TodoVO id = (TodoVO) dao.doSelectOne(todoList.get(0));
		LOG.debug("=====================");
		LOG.debug("=TodoVO="+id);
		LOG.debug("=====================");  
		
		//url+param
		MockHttpServletRequestBuilder  createMesage 
		           = MockMvcRequestBuilders.post ("/todo/do_delete.do")
		             .param("id", id.getId()+"");		
		
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
	
	//단건조회
	@Test
	@Ignore
	public void doSelectOne() throws Exception {
	
		//url+param
		MockHttpServletRequestBuilder  createMesage 
		           = MockMvcRequestBuilders.get("/todo/do_selectone.do")
		             .param("id", todoList.get(0).getId());		
		
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
	
	
//	public void checkSameUser(TodoVO orgVO, TodoVO vsVO) {
//		//assertTrue(orgVO.equals(vsVO));
//		assertThat(orgVO.getTitle(), is(vsVO.getTitle()));
//		assertThat(orgVO.getContents(), is(vsVO.getContents()));
//		assertThat(orgVO.getRegId(), is(vsVO.getRegId()));
//	}
	
	@Test
	public void test() {
		LOG.debug("=====================");
		LOG.debug("=test()=");
		LOG.debug("=====================");
		
		LOG.debug("=====================");
		LOG.debug("=todoService="+todoService);
		LOG.debug("=dao="+dao);
		LOG.debug("=====================");		
		assertNotNull(todoService);
		assertNotNull(dao);
		assertThat(1, is(1));
	
	}
	
	
	

	

}
