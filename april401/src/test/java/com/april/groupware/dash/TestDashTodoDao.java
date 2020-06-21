package com.april.groupware.dash;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.april.groupware.cmn.SearchVO;
import com.april.groupware.dash.service.DashDeptVO;
import com.april.groupware.dash.service.DashNBoardVO;
import com.april.groupware.dash.service.DashTodoService;
import com.april.groupware.dash.service.DashTodoVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class TestDashTodoDao {

	private final Logger LOG = LoggerFactory.getLogger(TestDashTodoDao.class);
	

	@Autowired
	WebApplicationContext webApplicationContext;

	DashTodoVO dashTodoVO01;

	DashDeptVO dashDeptVO01;

	@Autowired
	DashTodoService dao;

	@Before
	public void setUp() throws Exception {
		LOG.debug("^^^^^^^^^^^");
		LOG.debug("^WebApplicationContext^" + webApplicationContext);
		LOG.debug("^^^^^^^^^^^");
		dashTodoVO01 = new DashTodoVO("kimjh", "운영", "기술지원", "main", "그룹웨어구축", "삼성SDS", "부산", "외근", "김주희", "김주희","20/05/19", "20/05/21");
		dashDeptVO01 = new DashDeptVO("운영", "1", "2", "3", "4", "5");
	}

	@Test
	@Before
	public void doSelectOne() {
		DashTodoVO dashTodoVO = (DashTodoVO) dao.doSelectOne(dashTodoVO01);
		LOG.debug("dashTodoVO: " + dashTodoVO);
	}

	@Test
	@Before
	public void doDeptSelectOne() {
		DashDeptVO dashDeptVO = (DashDeptVO) dao.doDeptSelectOne(dashDeptVO01);
		LOG.debug("★dashDeptVO: " + dashDeptVO);
	}

	@After
	public void tearDown() throws Exception {
		LOG.debug("^^^^^^^^^^^");
		LOG.debug("^tearDown^");
		
		LOG.debug("^^^^^^^^^^^");
	}
	
	
	@Test
	public void doRetrieve() {
		//1.전체 삭제
		//2.추가:3건
		//3.목록조회:3건
		SearchVO  searchVO=new SearchVO(10,1,"","");
		List<DashNBoardVO> list =   (List<DashNBoardVO>) dao.doRetrieve(searchVO);
		assertThat(list.size(), is(10));
		for(DashNBoardVO vo: list) {
			LOG.debug("Nboard!doRetrieve@@:"+vo.toString());
		}
				
	}

	@Test
	public void test() {
		LOG.debug("=====================");
		LOG.debug("=test()=");
		LOG.debug("=====================");

		LOG.debug("=====================");
		LOG.debug("=dao()=" + dao);
		LOG.debug("=====================");

		assertNotNull(dao);
		assertThat(1, is(1));

	}
	
	
	

}
