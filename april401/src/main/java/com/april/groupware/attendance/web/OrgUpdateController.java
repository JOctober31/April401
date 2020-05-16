package com.april.groupware.attendance.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.april.groupware.attendance.service.OrgUpdateDao;
import com.april.groupware.attendance.service.OrgUpdateVO;
import com.april.groupware.cmn.MessageVO;
import com.google.gson.Gson;

@Controller
public class OrgUpdateController {
	private final Logger LOG = LoggerFactory.getLogger(OrgUpdateController.class);
	
	@Autowired
	OrgUpdateDao orgUpdateDao;
	
	@RequestMapping(value="org/do_update.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	@ResponseBody
	public String doUpdate(OrgUpdateVO userOrg) {
		LOG.debug("====================");
		LOG.debug("=doUpdate user= : "+userOrg);
		LOG.debug("====================");
		
		if(userOrg.getId() == null) {
			throw new IllegalArgumentException("ID를 입력하세요");
		}
		
		int flag = orgUpdateDao.doUpdate(userOrg);
		LOG.debug("====================");
		LOG.debug("=doUpdate flag= : "+flag);
		LOG.debug("====================");
		
		MessageVO message = new MessageVO();
		
		message.setMsgId(String.valueOf(flag));
		
		if(flag == 1) {
			message.setMsgMsg(userOrg.getId()+"님의 정보가 수정되었습니다");
		} else {
			message.setMsgMsg(userOrg.getId()+"님의 정보 수정을 실패했습니다");
		}
		
		//Json(Gson)
		Gson gson = new Gson();
		String json = gson.toJson(message);
		
		LOG.debug("====================");
		LOG.debug("=doUpdate json= : "+json);
		LOG.debug("====================");
		
		return json;
	}

	@RequestMapping(value="org/do_select_one.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	@ResponseBody
	public String doSelectOne(OrgUpdateVO userOrg) {
		LOG.debug("====================");
		LOG.debug("=doSelectOne user= : "+userOrg);
		LOG.debug("====================");
		
		if(userOrg.getId() == null) {
			throw new IllegalArgumentException("ID를 입력하세요");
		}
		
		OrgUpdateVO outVO = (OrgUpdateVO) orgUpdateDao.doSelectOne(userOrg);
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
