package com.april.groupware.chat.service;

import com.april.groupware.cmn.DTO;

public class UserVO extends DTO {
	
	private String id;
	/**이름*/
	private String name;
	/**부서명*/
	private String dept_Nm;
	/**직책*/
	private String position;
	
	
	public UserVO() {}
 

	public UserVO(String id, String name, String dept_Nm, String position) {
		super();
		this.id = id;
		this.dept_Nm = dept_Nm;
		this.name = name;
		this.position = position;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDept_Nm() {
		return dept_Nm;
	}


	public void setDept_Nm(String dept_Nm) {
		this.dept_Nm = dept_Nm;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", dept_Nm=" + dept_Nm + ", position=" + position + "]";
	}


	

	
	
}