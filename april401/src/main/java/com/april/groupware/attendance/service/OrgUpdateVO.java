/**
 * <pre>
 * com.april.groupware.attendance
 * Class Name : UserUpdateVO.java
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
package com.april.groupware.attendance.service;

import com.april.groupware.cmn.DTO;

/**
 * @author JIEUN 
 *
 */
public class OrgUpdateVO extends DTO {
	/**아이디*/
	private String id;
	/**비밀번호*/
	private String password;
	/**부서명*/
	private String deptNm;
	/**부서코드*/
	private String deptCd;
	/**상위 부서코드*/
	private String parentDeptCd;
	/**권한*/
	private String auth;
	/**이름*/
	private String name;
	/**직급*/
	private String position;
	/**휴대폰 번호*/
	private String mobile;
	/**이메일 주소*/
	private String email;
	/**주소*/
	private String address;
	/**입사일*/
	private String hiredate;
	/**생년월일*/
	private String birth;
	/**휴가일수*/
	private String vacationCnt;
	/**병역*/
	private String militaryYN;
	/**장애*/
	private String dspsnYN;
	/**학력*/
	private String grade;
	/**원본 사진 경로*/
	private String orgFileName;
	/**수정 사진 경로*/
	private String saveFileName;
	/**사진 확장자*/
	private String ext;
	/**사진 크기*/
	private long fileSize;
	/**작성자*/
	private String regId;
	/**작성일*/
	private String regDate;
	/**수정자*/
	private String modId;
	/**수정일*/
	private String modDate;
	
	public OrgUpdateVO() {
		
	}

	public OrgUpdateVO(String id, String password, String deptNm, String deptCd, String parentDeptCd, String auth,
			String name, String position, String mobile, String email, String address, String hiredate, String birth,
			String vacationCnt, String militaryYN, String dspsnYN, String grade, String orgFileName,
			String saveFileName, String ext, long fileSize, String regId, String regDate, String modId,
			String modDate) {
		super();
		this.id = id;
		this.password = password;
		this.deptNm = deptNm;
		this.deptCd = deptCd;
		this.parentDeptCd = parentDeptCd;
		this.auth = auth;
		this.name = name;
		this.position = position;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.hiredate = hiredate;
		this.birth = birth;
		this.vacationCnt = vacationCnt;
		this.militaryYN = militaryYN;
		this.dspsnYN = dspsnYN;
		this.grade = grade;
		this.orgFileName = orgFileName;
		this.saveFileName = saveFileName;
		this.ext = ext;
		this.fileSize = fileSize;
		this.regId = regId;
		this.regDate = regDate;
		this.modId = modId;
		this.modDate = modDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	public String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}

	public String getParentDeptCd() {
		return parentDeptCd;
	}

	public void setParentDeptCd(String parentDeptCd) {
		this.parentDeptCd = parentDeptCd;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getVacationCnt() {
		return vacationCnt;
	}

	public void setVacationCnt(String vacationCnt) {
		this.vacationCnt = vacationCnt;
	}

	public String getMilitaryYN() {
		return militaryYN;
	}

	public void setMilitaryYN(String militaryYN) {
		this.militaryYN = militaryYN;
	}

	public String getDspsnYN() {
		return dspsnYN;
	}

	public void setDspsnYN(String dspsnYN) {
		this.dspsnYN = dspsnYN;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getOrgFileName() {
		return orgFileName;
	}

	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getModId() {
		return modId;
	}

	public void setModId(String modId) {
		this.modId = modId;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	@Override
	public String toString() {
		return "OrgUpdateVO [id=" + id + ", password=" + password + ", deptNm=" + deptNm + ", deptCd=" + deptCd
				+ ", parentDeptCd=" + parentDeptCd + ", auth=" + auth + ", name=" + name + ", position=" + position
				+ ", mobile=" + mobile + ", email=" + email + ", address=" + address + ", hiredate=" + hiredate
				+ ", birth=" + birth + ", vacationCnt=" + vacationCnt + ", militaryYN=" + militaryYN + ", dspsnYN="
				+ dspsnYN + ", grade=" + grade + ", orgFileName=" + orgFileName + ", saveFileName=" + saveFileName
				+ ", ext=" + ext + ", fileSize=" + fileSize + ", regId=" + regId + ", regDate=" + regDate + ", modId="
				+ modId + ", modDate=" + modDate + ", toString()=" + super.toString() + "]";
	}

}
