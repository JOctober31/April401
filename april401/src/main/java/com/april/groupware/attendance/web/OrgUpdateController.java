package com.april.groupware.attendance.web;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

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
import com.april.groupware.member.service.UserVO;
import com.google.gson.Gson;

@Controller
public class OrgUpdateController {
	private final Logger LOG = LoggerFactory.getLogger(OrgUpdateController.class);
	
	//파일 저장 경로 : JIEUN 부분 -> sist
	//private final String PROFILE_UPLOAD_PATH ="C:\\Users\\jieun\\git\\April\\aprilPrj\\src\\main\\webapp\\resources\\file_upload_img";
	private final String PROFILE_UPLOAD_PATH ="/home/ubuntu/soc/apache-tomcat-9.0.35/webapps/ROOT/src/main/webapp/resources/file_upload_img";
	
	@Autowired
	OrgUpdateDao orgUpdateDao;
	
	@RequestMapping(value="org/do_update.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public String doUpdate(MultipartHttpServletRequest mhsRequest, HttpSession session, ModelAndView model) throws IllegalStateException, IOException {
		OrgUpdateVO orgVO = new OrgUpdateVO();
		
		//로그인 세션
		UserVO userInfo = (UserVO) session.getAttribute("user");
		//orgVO.setId("kimjh1");
		orgVO.setId(userInfo.getId());
		LOG.debug("====================");
		LOG.debug("=doUpdate orgVO ID= : "+orgVO.getId());
		LOG.debug("====================");
		
		OrgUpdateVO orgUpdateVO = (OrgUpdateVO) orgUpdateDao.doSelectOne(orgVO);
		LOG.debug("====================");
		LOG.debug("=doUpdate orgUpdateVO DB= : "+orgUpdateVO);
		LOG.debug("====================");
		//DB에 있는 기존 정보
		String dbPassword = orgUpdateVO.getPassword();
		String dbEmail = orgUpdateVO.getEmail();
		String dbMobile = orgUpdateVO.getMobile();
		String dbAddress = orgUpdateVO.getAddress();
		String dbGrade = orgUpdateVO.getGrade();
		String dbMilitaryYN = orgUpdateVO.getMilitaryYN();
		String dbDspsnYN = orgUpdateVO.getDspsnYN();
		
		//View에서 입력 받은 정보(수정 가능 변수) 
		String inputPassword = mhsRequest.getParameter("password");
		String inputEmail = mhsRequest.getParameter("email");
		String inputMobile = mhsRequest.getParameter("mobile");
		String inputAddress = mhsRequest.getParameter("address");
		String inputGrade = mhsRequest.getParameter("grade")+","+mhsRequest.getParameter("grade_sc_name")+","+mhsRequest.getParameter("grade_dp_name");
		String inputMilitaryYN = mhsRequest.getParameter("militaryYN");
		String inputDspsnYN = mhsRequest.getParameter("dspsnYN");
		
		LOG.debug("inputPassword "+inputPassword);
		LOG.debug("inputEmail "+inputEmail);
		LOG.debug("inputMobile "+inputMobile);
		LOG.debug("inputAddress "+inputAddress);
		LOG.debug("inputGrade "+inputGrade);
		LOG.debug("inputMilitaryYN "+inputMilitaryYN);
		LOG.debug("inputDspsnYN "+inputDspsnYN);
		
		if(inputPassword.equals("") && inputPassword==null) {
			orgUpdateVO.setPassword(dbPassword);
		} else if(!inputPassword.equals("") && inputPassword!=null) {
			orgUpdateVO.setPassword(inputPassword);
		}
		
		if(inputEmail.equals("") && inputEmail==null) {
			orgUpdateVO.setEmail(dbEmail);
		} else if(!inputEmail.equals("") && inputEmail!=null) {
			orgUpdateVO.setEmail(inputEmail);
		}
		
		if(inputMobile.equals("") && inputMobile==null) {
			orgUpdateVO.setMobile(dbMobile);
		} else if(!inputMobile.equals("") && inputMobile!=null) {
			orgUpdateVO.setMobile(inputMobile);
		}
		
		if(inputAddress.equals("") && inputAddress==null) {
			orgUpdateVO.setAddress(dbAddress);
		} else if(!inputAddress.equals("") && inputAddress!=null) {
			orgUpdateVO.setAddress(inputAddress);
		}
		
		if(inputGrade.equals("") && inputGrade==null) {
			orgUpdateVO.setGrade(dbGrade);
		} else if(!inputGrade.equals("") && inputGrade!=null) {
			orgUpdateVO.setGrade(inputGrade);
		}
		
		if(inputMilitaryYN.equals("") && inputMilitaryYN==null) {
			orgUpdateVO.setMilitaryYN(dbMilitaryYN);
		} else if(!inputMilitaryYN.equals("") && inputMilitaryYN!=null) {
			orgUpdateVO.setMilitaryYN(inputMilitaryYN);
		}
		
		if(inputDspsnYN.equals("") && inputDspsnYN==null) {
			orgUpdateVO.setDspsnYN(dbDspsnYN);
		} else if(!inputDspsnYN.equals("") && inputDspsnYN!=null) {
			orgUpdateVO.setDspsnYN(inputDspsnYN);
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
		//ex) C:\\Users\\JIEUN\\git\\April401\\april401\\src\\main\\webapp\\resources\\file_upload_img\\2020\\05
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
			orgUpdateVO.setOrgFileName(orgFileName); //원본 파일명 set
			orgUpdateVO.setFileSize(multiFile.getSize()); //파일 사이즈 set
			LOG.debug("=orgFileName= : " + orgFileName);
			
			//2.4.확장자 : .의 유무로 split
			String ext = "";
			if (orgFileName.indexOf(".") > -1) { 
				ext = orgFileName.substring(orgFileName.indexOf(".")+1);
			}
			LOG.debug("=ext= : "+ext);
			//2.4.1.확장자 set
			orgUpdateVO.setExt(ext);
			
			//2.5.전체 경로 생성
			//2.5.1.프로젝트 경로 내에 저장될 파일명으로 변경(UUID 사용)
			String saveFileName = StringUtil.getDate("yyyyMMddHHmmss")+StringUtil.getUUID();
			
			//2.5.2.파일명+확장자 : ex) file.jpg
			saveFileName += "."+ext;
			LOG.debug("=saveFileName.ext= : "+saveFileName);
			
			//2.5.5.DB에 저장될 파일 전체 경로 set(절대 경로)
			//String projectDir = "resources"+ File.separator +"file_upload_img"+ File.separator + yyyyStr + File.separator + mmStr;
			String projectDir = "resources/file_upload_img/"+ yyyyStr + "/" + mmStr;
			String dbSaveFilePath = projectDir+ "/" +saveFileName;
			orgUpdateVO.setSaveFileName(dbSaveFilePath);
			//원본 파일명, 파일 사이즈, 확장자, 전체 경로

			//2.5.5.전체 경로 = datePath"폴더+연+월" + saveFileName"저장될파일명+확장자"
			File fullPathFileName = new File(datePath, saveFileName);
			LOG.debug("=fullPathFileName= : "+fullPathFileName);
			
			//3.전송하기
			multiFile.transferTo(new File(fullPathFileName.getAbsolutePath()));
		}	
		/**--프로필 이미지 파일 저장*/
		
		int flag = orgUpdateDao.doUpdate(orgUpdateVO);
		LOG.debug("====================");
		LOG.debug("=doUpdate flag= : "+flag);
		LOG.debug("====================");
		
		MessageVO message = new MessageVO();
		
		message.setMsgId(String.valueOf(flag));
		
		if(flag == 1) {
			message.setMsgMsg(orgVO.getId()+"님의 정보가 수정되었습니다");
		} else {
			message.setMsgMsg(orgVO.getId()+"님의 정보 수정을 실패했습니다");
		}
		
		//Json(Gson)
		Gson gson = new Gson();
		String json = gson.toJson(message);
		
		LOG.debug("====================");
		LOG.debug("=doUpdate json= : "+json);
		LOG.debug("====================");
		
//		return "/views/mypage_org";
//		return "redirect:/org/do_select_one.do?id=kimjh1";
		return "redirect:/org/do_select_one.do";
	}

	@RequestMapping(value="org/do_select_one.do", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public String doSelectOne(OrgUpdateVO userOrg, HttpSession session, Model model) {
		LOG.debug("====================");
		LOG.debug("=doSelectOne user= : "+userOrg);
		LOG.debug("====================");
		
		//if(userOrg.getId() == null) {
		//	throw new IllegalArgumentException("ID를 입력하세요");
		//}
		
		//로그인 세션
		UserVO userInfo = (UserVO) session.getAttribute("user");
		//orgVO.setId("kimjh1");
		userOrg.setId(userInfo.getId());
		
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
