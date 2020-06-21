
/**
 *
 */
package com.april.groupware.member.service.imple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.april.groupware.cmn.DTO;
import com.april.groupware.member.service.UserDao;
import com.april.groupware.member.service.UserService;
import com.april.groupware.member.service.UserVO;



/**
 * @author sist
 *
 */
@Service
public class UserServiceImpl implements UserService {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	/*
	 * case BASIC: return user.getLogin()>=50; case SILVER:return
	 * user.getRecommend()>=30;
	 */

	public static final int MIN_LOGINCOUNT_FOR_SILVER = 50;
	public static final int MIN_RECCOMENDCOUNT_FOR_GOLD = 30;

	@Autowired
	private UserDao userDao;
	
	public UserServiceImpl() {

	}


	@Override
	public int doInsert(DTO dto) {
		return userDao.doInsert(dto);
	}

	@Override
	public int doUpdate(DTO dto) {
		return userDao.doUpdate(dto);
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		return userDao.doSelectOne(dto);
	}

	@Override
	public int doDelete(DTO dto) {
		return userDao.doDelete(dto);
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		return userDao.doRetrieve(dto);
	}

	@Override
	public int idPassCheck(DTO dto) {
		//1. idCheck   실패: 10
		//2. passCheck 실패: 20
		//3. 성공: 30
		int flag  =0;
		//1.
		flag = userDao.idCheck(dto);
		if(flag<1) {
			return 10;//id not found
		}

        //2.
		flag = userDao.passCheck(dto);
		if(flag<1) {
			return 20;//비번확인
		}
		
		if(flag != 30) {
			
			LOG.debug("★★★★★★로그인 30이 아님");
		}


		return 30;
	}


	@Override
	public int add(UserVO user) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void upgradeLevels(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		
	}











}









