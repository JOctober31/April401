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

import com.april.groupware.nboard.service.NBoardService;
import com.april.groupware.nboard.service.NBoardVO;
import com.april.groupware.nboard.service.imple.NBoardDaoImple;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
                                   })
public class TestNBoardController {

private final Logger  LOG = LoggerFactory.getLogger(TestNBoardController.class);
	
	@Autowired
	WebApplicationContext  webApplicationContext;
	
	private List<NBoardVO> boardList;
	
	@Autowired
	NBoardService boardService;
	
	@Autowired
	NBoardDaoImple dao;
	
	//브라우저 대신 Mock
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		LOG.debug("*********************");
		LOG.debug("=setUp()=");
		LOG.debug("*********************");
		
		boardList = Arrays.asList(
				new NBoardVO(1,"게시글말머리01","게시글제목01","J01_내요오오오옹","","","",0,"작성자01","","20200510","")
				,new NBoardVO(2,"게시글말머리02","게시글제목02","J02_내요오오오옹","","","",0,"작성자02","","20200510","")					
				,new NBoardVO(3,"게시글말머리03","게시글제목03","J03_내요오오오옹","","","",0,"작성자03","","20200510","")
				);
				
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		LOG.debug("=====================");
		LOG.debug("=webApplicationContext="+webApplicationContext);
		LOG.debug("=mockMvc="+mockMvc);
		
		LOG.debug("=====================");		

	}
	
	//목록조회
	@Test
	@Ignore
	public void doRetrieve()  throws Exception {
		//1.전체삭제
		//2.3건입력
		//3.조회
		dao.doDeleteAll();
		int flag = dao.doInsert(boardList.get(0));
		flag += dao.doInsert(boardList.get(1));
		flag += dao.doInsert(boardList.get(2));

		assertThat(flag, is(3));

		//url+param
		MockHttpServletRequestBuilder  createMesage 
					= MockMvcRequestBuilders.get("/nboard/do_retrieve.do")
					.param("pageNum", "1")
					.param("pageSize", "10")
					.param("searchDiv", "")
					.param("searchWord", " ");
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
	
	//수정
	@Test
	@Ignore
	public void doUpdate() throws Exception {
		//1.전체 삭제
		//2.단건입력
		//3.단건조회:board_id조회
		//3.1.단건수정
		//4.수정
		//5.수정데이터 조회
		//6.비교 
		dao.doDeleteAll();

		int flag = dao.doInsert(boardList.get(0));
		assertThat(flag, is(1));

		NBoardVO boardId = (NBoardVO) dao.doSelectOneTitle(boardList.get(0));
		LOG.debug("======doUpdate()===============");
		LOG.debug("=NBoardVO="+boardId);
		LOG.debug("=====================");  

		boardId.setNbCategory("update");
		boardId.setNbTitle(boardId.getNbTitle()+"_U");
		boardId.setNbContents(boardId.getNbContents()+"_U");
		boardId.setRegId("admin_U");
		

		//url+param
		MockHttpServletRequestBuilder  createMesage 
		           = MockMvcRequestBuilders.post ("/nboard/do_update.do")
		           	 .param("nbNo", boardId.getNbNo()+"")
		           	 .param("nbCategory", boardId.getNbCategory()+"")
		             .param("nbTitle", boardId.getNbTitle()+"")
					 .param("nbContents", boardId.getNbContents())
					 .param("regId", boardId.getRegId())
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
		NBoardVO vsVO = (NBoardVO) dao.doSelectOne(boardId);
		//6.비교 
//		checkSameUser(vsVO,boardId);
	}
	
	//단건삭제
	@Test
	@Ignore
	public void doDelete() throws Exception {
		//1.전체 삭제
		//2.단건입력
		//3.단건조회:board_id조회
		//4.삭제
		dao.doDeleteAll();

		int flag = dao.doInsert(boardList.get(0));
		assertThat(flag, is(1));
		
		NBoardVO boardId = (NBoardVO) dao.doSelectOneTitle(boardList.get(0));
		LOG.debug("======doDelete()===============");
		LOG.debug("=BoardVO="+boardId);
		LOG.debug("=====================");
		
		//url+param
		MockHttpServletRequestBuilder  createMesage 
				= MockMvcRequestBuilders.post ("/nboard/do_delete.do")
				.param("nbNo", boardId.getNbNo()+"");		

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
//	@Ignore
	public void doSelectOne() throws Exception {
		dao.doDeleteAll();
		
		int flag = dao.doInsert(boardList.get(0));
		assertThat(flag, is(1));
		
		NBoardVO boardId = (NBoardVO) dao.doSelectOneTitle(boardList.get(0));
		LOG.debug("======doSelectOne()===============");
		LOG.debug("=NBoardVO="+boardId);
		LOG.debug("=====================");
		
		//url+param
		MockHttpServletRequestBuilder  createMesage 
				= MockMvcRequestBuilders.get("/nboard/do_selectone.do")
					.param("nbNo", boardId.getNbNo()+"");		
		LOG.debug("=======nbNo==="+boardId.getNbNo());

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
	
	//등록
	@Test
	@Ignore
	public void add() throws Exception {
		dao.doDeleteAll();
		
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.post("/nboard/do_insert.do")
				.param("nbCategory", boardList.get(0).getNbCategory())
				.param("nbTitle", boardList.get(0).getNbTitle())
				.param("nbContents", boardList.get(0).getNbContents())
				.param("regId", boardList.get(0).getRegId())
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
		
		NBoardVO titleVO = (NBoardVO) dao.doSelectOneTitle(boardList.get(0));
		NBoardVO vsVO = (NBoardVO) dao.doSelectOne(titleVO);
		checkSameUser(vsVO,boardList.get(0));
	}
	
	public void checkSameUser(NBoardVO orgVO, NBoardVO vsVO) {
		//assertTrue(orgVO.equals(vsVO));
		assertThat(orgVO.getNbCategory(), is(vsVO.getNbCategory()));
		assertThat(orgVO.getNbTitle(), is(vsVO.getNbTitle()));
		assertThat(orgVO.getNbContents(), is(vsVO.getNbContents()));
		assertThat(orgVO.getRegId(), is(vsVO.getRegId()));
	}
	
	@Test
	public void test() {
		LOG.debug("=====================");
		LOG.debug("=test()=");
		LOG.debug("=====================");
		
		LOG.debug("=====================");
		LOG.debug("=boardService="+boardService);
		LOG.debug("=dao="+dao);
		LOG.debug("=====================");		
		assertNotNull(boardService);
		assertNotNull(dao);
		assertThat(1, is(1));
	
	}
	

	

}
