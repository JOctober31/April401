package com.april.groupware.org;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

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
import org.springframework.web.context.WebApplicationContext;

import com.april.groupware.org.service.OrgService;
import com.april.groupware.org.service.OrgVO;
import com.april.groupware.org.service.imple.OrgDaoImple;




@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
                                   })
public class TestOrgService {

	private final Logger  LOG = LoggerFactory.getLogger(TestOrgService.class);
	
	@Autowired
	WebApplicationContext  webApplicationContext;
	
	OrgVO org01;
	
	@Autowired
	OrgService  OrgService;
	
	@Autowired
	OrgDaoImple  dao;

	
	@Before
	public void setUp() {
		LOG.debug("*********************");
		LOG.debug("=setUp()="); 
		LOG.debug("*********************");
		org01=new OrgVO(
				"kimjh","1234","부서명","1","1",
				"1","이름","직급","012-345-6789","email",
				"주소","20200202","20200202","1","1",
				"1","학력","원본파일명","수정파일명","이미지경로",
				"ext","0",
				"test","1234","test","1234");
	}
	
	@Test
	public void doSelectOne() {
		//1.전체삭제
		//2.등록
		//2.1.등록데이터 조회
		
		//dao.doDeleteAll();
		
		/* int flag = OrgService.doInsert(board01); */
		/* assertThat(flag, is(1)); */
		
		OrgVO oneVO =(OrgVO) dao.doSelectOne(org01);
		OrgService.doSelectOne(oneVO);
	}
	
	@Test
	public void test() {
		LOG.debug("=====================");
		LOG.debug("=test()=");
		LOG.debug("=====================");
		
		
		LOG.debug("=====================");
		LOG.debug("=OrgService="+OrgService);
		
		LOG.debug("=====================");		
		
		assertNotNull(OrgService);
		assertThat(1, is(1));
	}
	

}
