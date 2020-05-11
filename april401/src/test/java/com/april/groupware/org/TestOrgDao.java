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

package com.april.groupware.org;

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

import com.april.groupware.cmn.SearchVO;
import com.april.groupware.org.service.OrgService;
import com.april.groupware.org.service.OrgVO;

/**
 * @author JUHEE
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml", 
								    "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestOrgDao {
	private final Logger LOG = LoggerFactory.getLogger(TestOrgDao.class);
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired 
	OrgService dao;
	
	OrgVO insertUser;
	OrgVO updateUser;
	
	
	@Test
	public void doRetrieve() {
		//1.전체 삭제
		//2.추가:3건
		//3.목록조회:3건
		SearchVO  searchVO=new SearchVO(10,1,"10","kimjh");
		List<OrgVO> list =   (List<OrgVO>) dao.doRetrieve(searchVO);
		assertThat(list.size(), is(4));
		for(OrgVO vo: list) {
			LOG.debug("doRetrieve:"+vo.toString());
		}
				
	}
	
	/**
	 * Method Name:setUp
	 * 작성일: 2020. 5. 2.
	 * 
	 * 작성자: JUHEE
	 * 설명:
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		LOG.debug("======================");
		LOG.debug("WebApplicationContext : "+webApplicationContext);
		LOG.debug("======================");
		
//		user01 = new OrgVO("kimjh","1234","이름","20200202","부서명","직급","1","1","1","학력",
//				"원본파일명","수정파일명","이미지경로","ext","0","email","20200202","012-345-6789","주소",
//				"test","1234","test","1234");
		insertUser = new OrgVO(
				"kimjh3","1234","부서명","1","1",
				"1","이름","직급","012-345-6789","email",
				"주소","20200202","20200202","1","1",
				"1","학력","원본파일명","수정파일명","이미지경로",
				"ext","0",
				"test","1234","test","1234");
		
		updateUser = new OrgVO(
				"kimjh3",
				"1234",
				"연구소_U",
				"000001_U",
				"000000_U",
				"1",
				"김주희_U",
				"대리_U",
				"20200112",
				"15",
				"test_U",
				"1234_U"
				);
	}

	@Test
	@Ignore
	public void doUpdate() {
		
		int flag = dao.doUpdate(updateUser);
		assertThat(flag, is(1));

	}
	
	@Test
	@Ignore
	public void doInsert() {
		//1.삭제
		//2.입력
		//3.단건 조회
		//4.입력 data, 조회 data 비교
		
		//3.단건 조회
		int flag = dao.doInsert(insertUser);
		assertThat(flag, is(1));

	
	}
	
	@Test
	@Ignore
	public void doSelectOne() {
		//1.삭제
		//2.입력
		//3.단건 조회
		//4.입력 data, 조회 data 비교
		
		//3.단건 조회
		OrgVO OrgVO = (OrgVO) dao.doSelectOne(insertUser);
		LOG.debug("단건:"+OrgVO.toString());
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
