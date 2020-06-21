package com.april.groupware.nboard;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

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

import com.april.groupware.nboard.service.NBAnswerService;
import com.april.groupware.nboard.service.NBAnswerVO;
import com.april.groupware.nboard.service.imple.NBoardDaoImple;




@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
                                   })
public class TestNBAnswerServiceWeb {

	private final Logger  LOG = LoggerFactory.getLogger(TestNBAnswerServiceWeb.class);
	
	@Autowired
	WebApplicationContext  webApplicationContext;
	
	NBAnswerVO answer01;
	
	@Autowired
	NBAnswerService  nbAnswerService;
	
	@Autowired
	NBoardDaoImple  dao;

	
	@Before
	public void setUp() {
		LOG.debug("*********************");
		LOG.debug("=setUp()="); 
		LOG.debug("*********************");
		answer01=new NBAnswerVO(1,1041,"댓글 내용 ServiceTest01","등록자01","","20200501","");
	}
	
	@Test
	public void doInsert() {
		
		nbAnswerService.doInsert(answer01);
		
	}
	

	@Test
	public void test() {
		LOG.debug("=====================");
		LOG.debug("=test()=");
		LOG.debug("=====================");
		
		
		LOG.debug("=====================");
		LOG.debug("=nboardService="+nbAnswerService);
		
		LOG.debug("=====================");		
		
		assertNotNull(nbAnswerService);
		assertThat(1, is(1));
		
	}
	

}
