package com.april.groupware.attendance.web;

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
import com.google.gson.Gson;

@Controller
public class AttendanceController {
	private final Logger LOG = LoggerFactory.getLogger(AttendanceController.class);
	
	@Autowired
	AttendanceDao attendanceDao;
	
	@RequestMapping(value="attend/do_insert.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	@ResponseBody
	public String doInsert(AttendanceVO attendVO) {
		LOG.debug("====================");
		LOG.debug("=doInsert user= : "+attendVO);
		LOG.debug("====================");
		
		int flag = attendanceDao.doInsert(attendVO);
		LOG.debug("====================");
		LOG.debug("=doInsert flag= : "+flag);
		LOG.debug("====================");
		
		MessageVO message = new MessageVO();
		
		message.setMsgId(String.valueOf(flag));
		
		if(flag == 1) {
			message.setMsgMsg(attendVO.getId()+"등록 성공");
		} else {
			message.setMsgMsg(attendVO.getId()+"등록 실패");
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
			message.setMsgMsg(attendVO.getId()+"출근 성공");
		} else {
			message.setMsgMsg(attendVO.getId()+"출근 실패");
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
	
	@RequestMapping(value="attend/do_select_one.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	@ResponseBody
	public String doSelectOne(AttendanceVO attendVO) {
		LOG.debug("====================");
		LOG.debug("=doSelectOne user= : "+attendVO);
		LOG.debug("====================");
		
		AttendanceVO outVO = (AttendanceVO) attendanceDao.doSelectOne(attendVO);
		LOG.debug("====================");
		LOG.debug("=doSelectOne outVO= : "+outVO);
		LOG.debug("====================");
		
		//Json(Gson)
		Gson gson = new Gson();
		String json = gson.toJson(outVO);
		
		LOG.debug("====================");
		LOG.debug("=doSelectOne json= : "+json);
		LOG.debug("====================");
		
		return json;
	}
	
}
