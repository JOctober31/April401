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

import java.util.List;

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

import com.april.groupware.attendance.service.AttendanceVO;
import com.april.groupware.attendance.service.UserDao;
import com.april.groupware.cmn.SearchVO;
import com.april.groupware.reserve.service.ReservationVO;

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
	UserDao dao;
	
	AttendanceVO user01;
	
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
		
		user01 = new AttendanceVO("1","20200428","09","11","1",
				"이지은","회의실 예약입니다","0","test", "",
				"test", "");
	}

	@Test
	@Ignore
	public void doInsert() {
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
		
		user01.setLeaveYN("1");;
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
		ReservationVO userVO = (ReservationVO) dao.doSelectOne(user01);
	}
	
	@Test
//	@Ignore
	public void doRetrieve() {
		//삭제
		dao.doDelete(user01);
		
		//등록
		int flag = dao.doInsert(user01);
		
		SearchVO inVO = new SearchVO("10", "test", 10, 1, "20200427", "20200429"); //날짜 검색, 검색 조건이 모두 있는 경우
//		SearchVO inVO = new SearchVO("10", "test", 10, 1, "", ""); //검색 조건만 있는 경우
//		SearchVO inVO = new SearchVO("", "", 10, 1, "", ""); //날짜 검색, 검색 조건이 모두 없는 경우
		List<ReservationVO> list = (List<ReservationVO>) dao.doRetrieve(inVO);
		
		for(ReservationVO outVO : list) {
			LOG.debug(outVO.toString());
		}
		
		assertThat(list.size(), is(1));
	}
	
	/**
	 * Method Name:tearDown
	 * 작성일: 2020. 5. 2.
	 * 작성자: JIEUN
	 * 설명:
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

}
