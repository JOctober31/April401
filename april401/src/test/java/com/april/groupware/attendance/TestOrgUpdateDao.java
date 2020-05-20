/**
 * <pre>
 * com.april.groupware
 * Class Name : TestUserUpdateDao.java
 * Description : 
 * Modification Information
 * 
 * 수정일         수정자        수정내용
 * ------------ ----------- -------------------------------
 * 2020-05-02           최초생성
 *
 * @author 쌍용교육센터 E반 April
 * @since 2020-05-02 
 * @version 1.0
 * 
 *  Copyright (C) by April All right reserved.
 * </pre>
 */
package com.april.groupware.attendance;

import org.junit.After;
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

import com.april.groupware.attendance.service.OrgUpdateVO;
import com.april.groupware.attendance.service.OrgUpdateDao;

/**
 * @author JIEUN 
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestOrgUpdateDao {
	private final Logger LOG = LoggerFactory.getLogger(TestOrgUpdateDao.class);
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	OrgUpdateDao dao;
	
	OrgUpdateVO user01;
	
	/**
	 * Method Name:setUp
	 * 작성일: 2020. 5. 2.
	 * 작성자: JIEUN
	 * 설명:
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		LOG.debug("======================");
		LOG.debug("WebApplicationContext : "+webApplicationContext);
		LOG.debug("======================");
		
//		user01 = new UserUpdateVO("kimjh","1234","이름","20200202","부서명","직급","1","1","1","학력",
//				"원본파일명","수정파일명","이미지경로","ext","0","email","20200202","012-345-6789","주소",
//				"test","1234","test","1234");
		
		user01 = new OrgUpdateVO(
				"kimjh1","1234","부서명","1","1",
				"1","이름","직급","012-345-6789","email",
				"주소","20200202","20200202","1","1",
				"1","학력","원본파일명","수정파일명",
				"ext",0,
				"test","1234","test","1234");
	}

	@Test
	@Ignore
	public void updateAndGet() {
		user01.setPassword("123");
		user01.setAddress("할수있는거");
		
		int flag = dao.doUpdate(user01);
		
		LOG.debug("======================");
		LOG.debug("flag : "+flag);
		LOG.debug("======================");
		
		OrgUpdateVO userVO = (OrgUpdateVO) dao.doSelectOne(user01);
		
		LOG.debug("======================");
		LOG.debug("userVO : "+userVO);
		LOG.debug("======================");
	}
	
	@Test
	@Ignore
	public void doUpdate() {
		//1.삭제
		//2.단건 입력
		//3.단건 입력 user01 수정
		//3.1.update 호출
		//3.2.단건 조회 user01
		//4.비교 : 단건 입력 user01 수정 == 단건조회 user01
		
		user01.setPassword("123456");
		LOG.debug("======================");
		LOG.debug("inVO : "+user01);
		LOG.debug("======================");
		
		int flag = dao.doUpdate(user01);
		LOG.debug("======================");
		LOG.debug("flag : "+flag);
		LOG.debug("======================");
	}
	
	@Test
//	@Ignore
	public void doSelectOne() {
		//1.삭제
		//2.입력
		//3.단건 조회
		//4.입력 data, 조회 data 비교
		
		//3.단건 조회
		OrgUpdateVO userVO = (OrgUpdateVO) dao.doSelectOne(user01);
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
