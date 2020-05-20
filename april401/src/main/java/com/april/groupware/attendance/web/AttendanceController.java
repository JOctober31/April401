package com.april.groupware.attendance.web;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.april.groupware.attendance.service.AttendanceDao;
import com.april.groupware.attendance.service.AttendanceVO;
import com.april.groupware.cmn.MessageVO;
import com.google.gson.Gson;

@Controller
public class AttendanceController {
	private final Logger LOG = LoggerFactory.getLogger(AttendanceController.class);
	
	@Autowired
	AttendanceDao attendanceDao;
	
	@RequestMapping(value="attend/do_insert.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	@ResponseBody
	public String doInsert(AttendanceVO attendVO) throws ParseException {
		LOG.debug("====================");
		LOG.debug("=doInsert user= : "+attendVO);
		LOG.debug("====================");
		
		int flag  = attendanceDao.doInsert(attendVO);
		LOG.debug("====================");
		LOG.debug("=doInsert flag= : "+flag);
		LOG.debug("====================");
		
		MessageVO message = new MessageVO();
		
		message.setMsgId(String.valueOf(flag));
		
		if(flag == 1) {
			message.setMsgMsg(attendVO.getId()+"출근 성공");
		} else {
			message.setMsgMsg(attendVO.getId()+"출근 실패");
		}
		
		//Json(Gson)
		Gson gson = new Gson();
		String json = gson.toJson(message);
		
		LOG.debug("====================");
		LOG.debug("=doInsert json= : "+json);
		LOG.debug("====================");
		
		return json;
	}
	
	@RequestMapping(value="attend/do_update.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	@ResponseBody
	public String doUpdate(AttendanceVO attendVO) {
		LOG.debug("====================");
		LOG.debug("=doUpdate user= : "+attendVO);
		LOG.debug("====================");
		
		if(attendVO.getId() == null) {
			throw new IllegalArgumentException("ID를 입력하세요");
		}
		
		int flag = attendanceDao.doUpdate(attendVO);
		LOG.debug("====================");
		LOG.debug("=doUpdate flag= : "+flag);
		LOG.debug("====================");
		
		MessageVO message = new MessageVO();
		
		message.setMsgId(String.valueOf(flag));
		
		if(flag == 1) {
			message.setMsgMsg(attendVO.getId()+"성공");
		} else {
			message.setMsgMsg(attendVO.getId()+"실패");
		}
		
		//Json(Gson)
		Gson gson = new Gson();
		String json = gson.toJson(message);
		
		LOG.debug("====================");
		LOG.debug("=doUpdate json= : "+json);
		LOG.debug("====================");
		
		return json;
	}
	
	@RequestMapping(value="attend/leave_update.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	@ResponseBody
	public String doLeaveUpdate(AttendanceVO attendVO) {
		LOG.debug("====================");
		LOG.debug("=doLeaveUpdate user= : "+attendVO);
		LOG.debug("====================");
		
		if(attendVO.getId() == null) {
			throw new IllegalArgumentException("ID를 입력하세요");
		}
		
		//TODO
		attendVO.setWorkTime("8");
		attendVO.setLeaveYN("1");
		
		int flag = attendanceDao.doLeaveUpdate(attendVO);
		LOG.debug("====================");
		LOG.debug("=doLeaveUpdate flag= : "+flag);
		LOG.debug("====================");
		
		MessageVO message = new MessageVO();
		
		message.setMsgId(String.valueOf(flag));
		
		if(flag == 1) {
			message.setMsgMsg(attendVO.getId()+"퇴근 성공");
		} else {
			message.setMsgMsg(attendVO.getId()+"퇴근 실패");
		}
		
		//Json(Gson)
		Gson gson = new Gson();
		String json = gson.toJson(message);
		
		LOG.debug("====================");
		LOG.debug("=doLeaveUpdate json= : "+json);
		LOG.debug("====================");
		
		return json;
	}
	
	@RequestMapping(value="attend/do_delete.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	@ResponseBody
	public String doDelete(AttendanceVO attendVO) {
		LOG.debug("====================");
		LOG.debug("=doDelete user= : "+attendVO);
		LOG.debug("====================");
		
		//TODO 로그인 
		attendVO.setId("kimjh1");
		
		if(attendVO.getId() == null) {
			throw new IllegalArgumentException("ID를 입력하세요");
		}
		
		int flag = attendanceDao.doDelete(attendVO);
		LOG.debug("====================");
		LOG.debug("=doDelete flag= : "+flag);
		LOG.debug("====================");
		
		MessageVO message = new MessageVO();
		
		message.setMsgId(String.valueOf(flag));
		
		if(flag > 0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("삭제 성공");
		} else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("삭제 실패");
		}
		
		//Json(Gson)
		Gson gson = new Gson();
		String json = gson.toJson(message);
		
		LOG.debug("====================");
		LOG.debug("=doDelete json= : "+json);
		LOG.debug("====================");
		
		return json;
	}
	
	@RequestMapping(value="attend/do_select_one.do", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public String doSelectOne(AttendanceVO attendVO, Model model) {
		LOG.debug("====================");
		LOG.debug("=doSelectOne(getAll) user= : "+attendVO);
		LOG.debug("====================");
		
		List<AttendanceVO> outList = (List<AttendanceVO>) attendanceDao.getAll(attendVO);
		LOG.debug("====================");
		LOG.debug("=doSelectOne(getAll) outList= : "+outList);
		LOG.debug("====================");
		
		model.addAttribute("attendanceVO", outList);
		
		//Json(Gson)
//		Gson gson = new Gson();
//		String json = gson.toJson(outVO);
//		
//		LOG.debug("====================");
//		LOG.debug("=doSelectOne json= : "+json);
//		LOG.debug("====================");
		
		return "/views/attendance";
	}
	
}
