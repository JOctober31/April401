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

import com.april.groupware.nboard.service.NBoardService;
import com.april.groupware.nboard.service.NBoardVO;
import com.april.groupware.nboard.service.imple.NBoardDaoImple;




@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
                                   })
public class TestNBoardServiceWeb {

	private final Logger  LOG = LoggerFactory.getLogger(TestNBoardServiceWeb.class);
	
	@Autowired
	WebApplicationContext  webApplicationContext;
	
	NBoardVO nboard01;
	
	@Autowired
	NBoardService  nboardService;
	
	@Autowired
	NBoardDaoImple  dao;

	
	@Before
	public void setUp() {
		LOG.debug("*********************");
		LOG.debug("=setUp()="); 
		LOG.debug("*********************");
		nboard01=new NBoardVO(1,"게시글말머리01","게시글제목01","J01_내요오오오옹","","","",0,"작성자01","","20200510","");
	}
	
	@Test
	public void doSelectOne() {
		//1.전체삭제
		//2.등록
		//2.1.등록데이터 조회
		//3.
		/*dao.doDeleteAll();
		
		int flag = nboardService.doInsert(nboard01);
		assertThat(flag, is(1));*/
		
		NBoardVO oneVO =(NBoardVO) dao.doSelectOneTitle(nboard01);
		nboardService.doSelectOne(oneVO);
		
		
		
	}
	

	@Test
	public void test() {
		LOG.debug("=====================");
		LOG.debug("=test()=");
		LOG.debug("=====================");
		
		
		LOG.debug("=====================");
		LOG.debug("=nboardService="+nboardService);
		
		LOG.debug("=====================");		
		
		assertNotNull(nboardService);
		assertThat(1, is(1));
		
	}
	

}
