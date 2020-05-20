package com.april.groupware.attendance.web;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.april.groupware.attendance.service.OrgUpdateDao;
import com.april.groupware.attendance.service.OrgUpdateVO;
import com.april.groupware.cmn.MessageVO;
import com.april.groupware.cmn.StringUtil;
import com.google.gson.Gson;

@Controller
public class OrgUpdateController {
	private final Logger LOG = LoggerFactory.getLogger(OrgUpdateController.class);
	
	//파일 저장 경로 : JIEUN 부분 -> sist
	private final String PROFILE_UPLOAD_PATH ="C:\\Users\\SIST\\git\\April401\\april401\\src\\main\\webapp\\WEB-INF\\file_upload_img";
	
	@Autowired
	OrgUpdateDao orgUpdateDao;
	
	@RequestMapping(value="org/do_update.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public String doUpdate(OrgUpdateVO userOrg, MultipartHttpServletRequest mhsRequest, ModelAndView model) throws IllegalStateException, IOException {
		LOG.debug("====================");
		LOG.debug("=doUpdate user= : "+userOrg);
		LOG.debug("====================");
		
		if(userOrg.getId() == null) {
			throw new IllegalArgumentException("ID를 입력하세요");
		}
		
		/**프로필 이미지 파일 저장*/
		//1.저장 폴더 생성
		File fileRootDir = new File(this.PROFILE_UPLOAD_PATH);
		
		//1.1.Root 폴더가 없다면(false) 생성
		//mkdirs()
		if (fileRootDir.isDirectory() == false) {
			boolean flag = fileRootDir.mkdirs();
			LOG.debug("======flag====== : "+flag+", file_upload_img 폴더 생성 완료");
		}
		
		//1.2.연도(yyyy) 폴더
		String yyyyStr = StringUtil.getDate("yyyy"); //date format : yyyy
		
		//1.3.월(MM) 폴더
		String mmStr = StringUtil.getDate("MM"); //date format : MM
		LOG.debug("=yyyyMM= : "+yyyyStr+mmStr);
		
		//1.4.폴더 경로 : Root폴더+연도(yyyy)폴더+월(MM)폴더
		//ex) C:\\Users\\JIEUN\\git\\April401\\april401\\src\\main\\webapp\\WEB-INF\\file_upload_img\\2020\\05
		String datePath = this.PROFILE_UPLOAD_PATH + File.separator + yyyyStr + File.separator + mmStr;
		
		//1.5.연도+월 폴더 생성
		File fileYearMMDir = new File(datePath);
		if (fileYearMMDir.isDirectory() == false) {
			boolean flag = fileYearMMDir.mkdirs();
			LOG.debug("======flag====== : "+flag+", fileYearMMDir 폴더 생성 완료");
		}
		
		//2. View에서 파일 변수명 읽기
		Iterator<String> profilefiles = mhsRequest.getFileNames();
		//읽어올 파일 변수명이 없을 때까지 반복
		while (profilefiles.hasNext()) {
			//2.1.업로드할 파일명
			String uploadFileName = profilefiles.next();
			LOG.debug("=uploadFileName= : " + uploadFileName);
			
			//2.2.MultipartFile로 업로드할 파일명으로 파일 가져오기
			MultipartFile multiFile = mhsRequest.getFile(uploadFileName);
			String orgFileName = multiFile.getOriginalFilename(); //원본 파일명 가져오기
			
			//2.3.1.입력된 파일(원본 파일명)이 없으면 continue;
			if (orgFileName == null || orgFileName.equals("")) continue;
			//2.3.2.입력된 파일이 있으면 VO에 set
			userOrg.setOrgFileName(orgFileName); //원본 파일명 set
			userOrg.setFileSize(multiFile.getSize()); //파일 사이즈 set
			LOG.debug("=orgFileName= : " + orgFileName);
			
			//2.4.확장자 : .의 유무로 split
			String ext = "";
			if (orgFileName.indexOf(".") > -1) { 
				ext = orgFileName.substring(orgFileName.indexOf(".")+1);
			}
			LOG.debug("=ext= : "+ext);
			//2.4.1.확장자 set
			userOrg.setExt(ext);
			
			//2.5.전체 경로 생성
			//2.5.1.프로젝트 경로 내에 저장될 파일명으로 변경(UUID 사용)
			String saveFileName = StringUtil.getDate("yyyyMMddHHmmss")+StringUtil.getUUID();
			
			//2.5.2.파일명+확장자 : ex) file.jpg
			saveFileName += "."+ext;
			LOG.debug("=saveFileName.ext= : "+saveFileName);
			
			//2.5.5.DB에 저장될 파일 전체 경로 set(절대 경로)
			String projectDir = File.separator + "WEB-INF"+ File.separator +"file_upload_img"+ File.separator + yyyyStr + File.separator + mmStr;
			String dbSaveFilePath = projectDir+ File.separator+saveFileName;
			userOrg.setSaveFileName(dbSaveFilePath);
			//원본 파일명, 파일 사이즈, 확장자, 전체 경로

			//2.5.5.전체 경로 = datePath"폴더+연+월" + saveFileName"저장될파일명+확장자"
			File fullPathFileName = new File(datePath, saveFileName);
			LOG.debug("=fullPathFileName= : "+fullPathFileName);
			
			//3.전송하기
			multiFile.transferTo(new File(fullPathFileName.getAbsolutePath()));
		}	
		/**--프로필 이미지 파일 저장*/
		
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
		
		return "/views/mypage_org";
	}

	@RequestMapping(value="org/do_select_one.do", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public String doSelectOne(OrgUpdateVO userOrg, Model model) {
		LOG.debug("====================");
		LOG.debug("=doSelectOne user= : "+userOrg);
		LOG.debug("====================");
		
		//if(userOrg.getId() == null) {
		//	throw new IllegalArgumentException("ID를 입력하세요");
		//}
		
		userOrg.setId("kimjh1");
		
		OrgUpdateVO outVO = (OrgUpdateVO) orgUpdateDao.doSelectOne(userOrg);
		LOG.debug("====================");
		LOG.debug("=doSelectOne outVO= : "+outVO);
		LOG.debug("====================");
		
		model.addAttribute("orgUpdateVO", outVO);
		
		//Json(Gson)
//		Gson gson = new Gson();
//		String json = gson.toJson(outVO);
//		
//		LOG.debug("====================");
//		LOG.debug("=doSelectOne json= : "+json);
//		LOG.debug("====================");
		
		return "/views/mypage_org";
	}
	
}
