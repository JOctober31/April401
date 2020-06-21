package com.april.groupware.member.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.april.groupware.attendance.service.AttendanceDao;
import com.april.groupware.attendance.service.AttendanceVO;
import com.april.groupware.cmn.MessageVO;
import com.april.groupware.cmn.SearchVO;
import com.april.groupware.mail.service.MailService;
import com.april.groupware.mail.service.MailVO;
import com.april.groupware.member.service.UserService;
import com.april.groupware.member.service.UserVO;
import com.google.gson.Gson;

@Controller
public class MemberController {

	private final Logger  LOG = LoggerFactory.getLogger(MemberController.class);

	//@Qualifier("dummyMailSender") : root-context.xml bean id
	@Autowired
	UserService userService;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	AttendanceDao attendanceDao;

	/**
	 * Login
	 * @param user
	 * @param session
	 * @return json
	 */
	@RequestMapping(value = "login/logout.do",method = RequestMethod.GET)
	public String doLogout(HttpSession session) {
		session.removeAttribute("user");
        return "login/login";
	}
	/**
	 * Login
	 * @param user
	 * @param session
	 * @return json
	 * @throws ParseException 
	 */
	@RequestMapping(value = "login/login.do", method = RequestMethod.POST,produces ="application/json; charset=UTF-8")
	@ResponseBody
	public String doLogin(UserVO user, AttendanceVO attendVO, HttpSession session, HttpServletRequest req, HttpServletResponse res) throws ParseException {
		//1.idPassCheck() call
		//1.1. return 10 -> "아이디를 확인하세요."
		//1.2. return 20 -> "비밀번호를 확인하세요."
		//1.3. return 30 -> "로그인 성공"
		//1.3.1. 단건조회 -> Session Read
		LOG.debug("1===================");
		LOG.debug("1=user="+user);
		LOG.debug("1===================");
		
		//아이디가 널이면
		String message = "";
		if(null == user.getId() || "".equals(user.getId().trim())) {
			message = "아이디를 입력하세요.";
			throw new IllegalArgumentException(message);
		}

		//비밀번호가 널이면
		if(null == user.getPassword() || "".equals(user.getPassword().trim())) {
			message = "비밀번호를 확인하세요.";
			throw new IllegalArgumentException(message);
		}
		
		//아이디와 비밀번호가 맞는지 체크
		int flag = this.userService.idPassCheck(user);
		MessageVO messageVO = new MessageVO();
		messageVO.setMsgId(String.valueOf(flag));

		//아이디가 맞지 않음
		if(10 == flag) {
			messageVO.setMsgMsg("아이디를 확인하세요.");
		//비밀번호가 맞지 않음
		} else if(20 == flag) {
			messageVO.setMsgMsg("비밀번호를 확인하세요.");
		//로그인에 성공
		} else if(30 == flag) {
			messageVO.setMsgMsg("로그인을 성공했습니다.");
			//사용자 정보 조회
			UserVO userInfo = (UserVO) this.userService.doSelectOne(user);
			LOG.debug("2===================");
			LOG.debug("2=userInfo="+userInfo);
			LOG.debug("2===================");
			
			session.setAttribute("user", userInfo);
			
			/**지은 출근 기록*/
			//DB에 출근한 기록이 있는지 확인
			attendVO.setId(userInfo.getId());
			int cnt = attendanceDao.doAttendCheck(attendVO);
			LOG.debug("====================");
			LOG.debug("=Attendance DB cnt= : "+cnt);
			LOG.debug("====================");
			
			int attendFlag = 0;
			//출근 기록이 없으면(0이면) insert 
			if(cnt == 0) {
				attendFlag = attendanceDao.doInsert(attendVO);
				LOG.debug("====================");
				LOG.debug("=doInsert attendFlag= : "+attendFlag);
				LOG.debug("====================");
				
				messageVO.setMsgId(String.valueOf(flag));
				
				Date date = new Date();
				DateFormat format = DateFormat.getDateInstance(DateFormat.FULL);
				String today = format.format(date);
				
				//출근 성공
				if(flag == 1) {
					messageVO.setMsgMsg(attendVO.getId()+"님 \n"+today+" 출근이 완료되었습니다.");
				//출근 실패
				} else if(flag == 0) {
					messageVO.setMsgMsg("정상적인 출근 시간이 아닙니다. \n관리자에게 문의해주세요.");
				}
				/**--지은 출근 기록*/
				
			}
			/**민지 메일 알림*/
			//---------------민지 alarm part Start
			LOG.debug("3=====민지 alarm part Start=====");
			SearchVO search = new SearchVO();
			search.setSearchWord(userInfo.getId());
			//알림용 list
			List<MailVO> alarmList = (List<MailVO>) this.mailService.getAll(search);
			
			//알림용 image
			String img = "";
			
			//안읽은 건수
			int totalCntNotRead = 0;
			
			for(MailVO vo:alarmList) {
				LOG.debug("** alarmList : "+vo);
				if(vo.getRead().equals("0")) {
					totalCntNotRead++;
					
					MailVO imgVO = (MailVO)this.mailService.doSelectImage(vo);
					img = "/groupware/"+ imgVO.getSaveFileName();
					vo.setSaveFileName(img);
					LOG.debug("** alarmList(SaveFileName) : "+vo);
				}
			}
			
			session.setAttribute("alarmList", alarmList);
			
			LOG.debug("** totalCntNotRead : "+totalCntNotRead);
			
			//조회결과 화면 전달
			session.setAttribute("totalCntNotRead", totalCntNotRead);
			LOG.debug("3=====민지 alarm part End=====");
			//---------------민지 alarm part End
			
			LOG.debug("4=====민지 Count Start=====");
			//Count Start
			int count = this.mailService.getAllCount(search);
			LOG.debug("** count : "+ count);
			session.setAttribute("count", count);
			//Count End
			LOG.debug("4=====민지 Count End=====");
			/**--민지 메일 알림*/
			
		}
			
		Gson gson = new Gson();
		String json = gson.toJson(messageVO);
		LOG.debug("2===================");
		LOG.debug("2=json="+json);
		LOG.debug("2===================");

		return json;
	}

	@RequestMapping(value = "member/do_select_one.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doSelectOne(UserVO user) {
		LOG.debug("1===================");
		LOG.debug("1=user=" + user);
		LOG.debug("1===================");

		UserVO outVO = (UserVO) userService.doSelectOne(user);
		// outVO.setLevel(outVO.getLevel().intValue());

		LOG.debug("1.2===================");
		LOG.debug("1.2=outVO=" + outVO);
		LOG.debug("1.2===================");

		Gson gson = new Gson();
		String json = gson.toJson(outVO);

		LOG.debug("1.3===================");
		LOG.debug("1.3=json=" + json);
		LOG.debug("1.3===================");

		return json;
	}
}
