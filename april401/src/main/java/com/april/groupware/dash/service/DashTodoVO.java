/**
 * 
 */
package com.april.groupware.dash.service;

import com.april.groupware.cmn.DTO;

/**
 * @author sist
 *
 */
public class DashTodoVO extends DTO {
	/** 아이디 */
	private String id;
	/** 부서명 */
	private String deptNm;
	/** 프로젝트명 */
	private String pTitle       ;
	/** 프로젝트 타입 */
	private String pType        ;
	/** 고객사 */
	private String customer      ;
	/** 업무내용 */
	private String taskContents ;
	/** 지역 */
	private String area          ;
	/** 근무형태 */
	private String workingForm  ;
	/** 작성자 */
	private String regId        ;
	/** 수정자 */
	private String modId        ;
	/** 작성일 */
	private String regDate      ;
	/** 수정일 */
	private String modDate      ;


	public DashTodoVO() {}


	public DashTodoVO(String id, String deptNm, String pTitle, String pType, String customer, String taskContents,
			String area, String workingForm, String regId, String modId, String regDate, String modDate) {
		super();
		this.id = id;
		this.deptNm = deptNm;
		this.pTitle = pTitle;
		this.pType = pType;
		this.customer = customer;
		this.taskContents = taskContents;
		this.area = area;
		this.workingForm = workingForm;
		this.regId = regId;
		this.modId = modId;
		this.regDate = regDate;
		this.modDate = modDate;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDeptNm() {
		return deptNm;
	}


	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}


	public String getpTitle() {
		return pTitle;
	}


	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}


	public String getpType() {
		return pType;
	}


	public void setpType(String pType) {
		this.pType = pType;
	}


	public String getCustomer() {
		return customer;
	}


	public void setCustomer(String customer) {
		this.customer = customer;
	}


	public String getTaskContents() {
		return taskContents;
	}


	public void setTaskContents(String taskContents) {
		this.taskContents = taskContents;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getWorkingForm() {
		return workingForm;
	}


	public void setWorkingForm(String workingForm) {
		this.workingForm = workingForm;
	}


	public String getRegId() {
		return regId;
	}


	public void setRegId(String regId) {
		this.regId = regId;
	}


	public String getModId() {
		return modId;
	}


	public void setModId(String modId) {
		this.modId = modId;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getModDate() {
		return modDate;
	}


	public void setModDate(String modDate) {
		this.modDate = modDate;
	}


	@Override
	public String toString() {
		return "TodoVO [id=" + id + ", deptNm=" + deptNm + ", pTitle=" + pTitle + ", pType=" + pType + ", customer="
				+ customer + ", taskContents=" + taskContents + ", area=" + area + ", workingForm=" + workingForm
				+ ", regId=" + regId + ", modId=" + modId + ", regDate=" + regDate + ", modDate=" + modDate
				+ ", toString()=" + super.toString() + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((deptNm == null) ? 0 : deptNm.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modDate == null) ? 0 : modDate.hashCode());
		result = prime * result + ((modId == null) ? 0 : modId.hashCode());
		result = prime * result + ((pTitle == null) ? 0 : pTitle.hashCode());
		result = prime * result + ((pType == null) ? 0 : pType.hashCode());
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		result = prime * result + ((regId == null) ? 0 : regId.hashCode());
		result = prime * result + ((taskContents == null) ? 0 : taskContents.hashCode());
		result = prime * result + ((workingForm == null) ? 0 : workingForm.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DashTodoVO other = (DashTodoVO) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (deptNm == null) {
			if (other.deptNm != null)
				return false;
		} else if (!deptNm.equals(other.deptNm))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modDate == null) {
			if (other.modDate != null)
				return false;
		} else if (!modDate.equals(other.modDate))
			return false;
		if (modId == null) {
			if (other.modId != null)
				return false;
		} else if (!modId.equals(other.modId))
			return false;
		if (pTitle == null) {
			if (other.pTitle != null)
				return false;
		} else if (!pTitle.equals(other.pTitle))
			return false;
		if (pType == null) {
			if (other.pType != null)
				return false;
		} else if (!pType.equals(other.pType))
			return false;
		if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		if (regId == null) {
			if (other.regId != null)
				return false;
		} else if (!regId.equals(other.regId))
			return false;
		if (taskContents == null) {
			if (other.taskContents != null)
				return false;
		} else if (!taskContents.equals(other.taskContents))
			return false;
		if (workingForm == null) {
			if (other.workingForm != null)
				return false;
		} else if (!workingForm.equals(other.workingForm))
			return false;
		return true;
	}



}
	
