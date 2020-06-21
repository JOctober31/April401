package com.april.groupware.dash;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.april.groupware.dash.service.DashTodoService;
import com.april.groupware.dash.service.DashTodoVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class TestDashTodoControllerWeb {

	private final Logger LOG = LoggerFactory.getLogger(TestDashTodoControllerWeb.class);

	@Autowired
	WebApplicationContext webApplicationContext;

	private List<DashTodoVO> dashTodoList;

	@Autowired
	DashTodoService dashTodoService;

	// 브라우저 대신 Mock
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		LOG.debug("*********************");
		LOG.debug("=setUp()=");
		LOG.debug("*********************");

		dashTodoList = Arrays.asList(new DashTodoVO("kimjh", "운영", "기술지원", "main", "그룹웨어구축", "삼성SDS", "부산", "외근", "김주희",
				"김주희", "20/05/19", "20/05/21"));

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		LOG.debug("=====================");
		LOG.debug("=webApplicationContext=" + webApplicationContext);
		LOG.debug("=mockMvc=" + mockMvc);

		LOG.debug("=====================");

	}

	// 단건조회
	@Test
	public void doSelectOne() throws Exception {

		// url+param
		MockHttpServletRequestBuilder createMesage = MockMvcRequestBuilders.get("/dash/do_selectone.do")
				.param("deptNm", dashTodoList.get(0).getDeptNm());

		ResultActions resultActions = mockMvc.perform(createMesage).andExpect(status().is2xxSuccessful());

		String result = resultActions.andDo(print()).andReturn().getResponse().getContentAsString();
		LOG.debug("=====================");
		LOG.debug("=result=" + result);
		LOG.debug("=====================");

	}

//	public void checkSameUser(DashTodoVO orgVO, DashTodoVO vsVO) {
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
		LOG.debug("=★todoService=" + dashTodoService);
		LOG.debug("=★dao=" + dashTodoService);
		LOG.debug("=====================");
		assertNotNull(dashTodoService);
		assertNotNull(dashTodoService);
		assertThat(1, is(1));

	}

}
