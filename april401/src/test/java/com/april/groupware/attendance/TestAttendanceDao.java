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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;

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

import com.april.groupware.attendance.service.AttendanceDao;
import com.april.groupware.attendance.service.AttendanceVO;

/**
 * @author JIEUN 
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestAttendanceDao {
	private final Logger LOG = LoggerFactory.getLogger(TestAttendanceDao.class);
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	AttendanceDao dao;
	
	AttendanceVO user01;
	
	/**
	 * Method Name:setUp
	 * 작성일: 2020. 5. 10.
	 * 작성자: JIEUN
	 * 설명:
	 * @throws java.lang.Exception
	 */
	@Before
	
	
	public void setUp() throws Exception {
		LOG.debug("======================");
		LOG.debug("WebApplicationContext : "+webApplicationContext);
		LOG.debug("======================");
		
		user01 = new AttendanceVO("test", "1", "", "", "1", "0", "0", "0", "test", "test", "", "");
	}

	@Test
//	@Ignore
	public void addAndGet() throws ParseException {
		//삭제
		int flag = dao.doDelete(user01);
//		assertThat(flag, is(1));
		
		//등록
		flag = dao.doInsert(user01);
		assertThat(flag, is(1));
		
		//수정
//		user01.setLeaveYN("1");;	
//		flag = dao.doUpdate(user01);
		flag = dao.doLeaveUpdate(user01);
		assertThat(flag, is(1));
		
		AttendanceVO userVO = (AttendanceVO) dao.doSelectOne(user01);
		
		//assertThat(list.size(), is(1));
	}
	
	@Test
	@Ignore
	public void doInsert() throws ParseException {
		//1.삭제
		//2.단건 입력
		//3.단건 입력 user01 수정
		//3.1.update 호출
		//3.2.단건 조회 user01
		//4.비교 : 단건 입력 user01 수정 == 단건조회 user01
		
		int flag = 0;
		
		flag = dao.doInsert(user01);
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
		
		int flag = 0;
		
		user01.setLeaveYN("1");
		flag = dao.doUpdate(user01);
	}
	
	@Test
	@Ignore
	public void doDelete() {
		//1.삭제
		//2.단건 입력
		//3.단건 입력 user01 수정
		//3.1.update 호출
		//3.2.단건 조회 user01
		//4.비교 : 단건 입력 user01 수정 == 단건조회 user01
		
		int flag = 0;
		
		flag = dao.doDelete(user01);
	}
	
	@Test
	@Ignore
	public void doSelectOne() {
		//1.삭제
		//2.입력
		//3.단건 조회
		//4.입력 data, 조회 data 비교
		
		//3.단건 조회
		AttendanceVO userVO = (AttendanceVO) dao.doSelectOne(user01);
	}
	
	/**
	 * Method Name:tearDown
	 * 작성일: 2020. 5. 10.
	 * 작성자: JIEUN
	 * 설명:
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

}
