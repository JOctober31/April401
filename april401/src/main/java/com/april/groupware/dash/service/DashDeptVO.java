package com.april.groupware.dash.service;

import com.april.groupware.cmn.DTO;

public class DashDeptVO extends DTO{
	
	private String deptNm;
	private String jan;
	private String feb;
	private String mar;
	private String apr;
	private String may;
	
	public DashDeptVO() {
		
		
	}
	
	
	public DashDeptVO(String deptNm, String jan, String feb, String mar, String apr, String may) {
		super();
		this.deptNm = deptNm;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
		this.apr = apr;
		this.may = may;
	}
	/**
	 * @return the deptNm
	 */
	public String getDeptNm() {
		return deptNm;
	}
	/**
	 * @param deptNm the deptNm to set
	 */
	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}
	/**
	 * @return the jan
	 */
	public String getJan() {
		return jan;
	}
	/**
	 * @param jan the jan to set
	 */
	public void setJan(String jan) {
		this.jan = jan;
	}
	/**
	 * @return the feb
	 */
	public String getFeb() {
		return feb;
	}
	/**
	 * @param feb the feb to set
	 */
	public void setFeb(String feb) {
		this.feb = feb;
	}
	/**
	 * @return the mar
	 */
	public String getMar() {
		return mar;
	}
	/**
	 * @param mar the mar to set
	 */
	public void setMar(String mar) {
		this.mar = mar;
	}
	/**
	 * @return the apr
	 */
	public String getApr() {
		return apr;
	}
	/**
	 * @param apr the apr to set
	 */
	public void setApr(String apr) {
		this.apr = apr;
	}
	/**
	 * @return the may
	 */
	public String getMay() {
		return may;
	}
	/**
	 * @param may the may to set
	 */
	public void setMay(String may) {
		this.may = may;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apr == null) ? 0 : apr.hashCode());
		result = prime * result + ((deptNm == null) ? 0 : deptNm.hashCode());
		result = prime * result + ((feb == null) ? 0 : feb.hashCode());
		result = prime * result + ((jan == null) ? 0 : jan.hashCode());
		result = prime * result + ((mar == null) ? 0 : mar.hashCode());
		result = prime * result + ((may == null) ? 0 : may.hashCode());
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
		DashDeptVO other = (DashDeptVO) obj;
		if (apr == null) {
			if (other.apr != null)
				return false;
		} else if (!apr.equals(other.apr))
			return false;
		if (deptNm == null) {
			if (other.deptNm != null)
				return false;
		} else if (!deptNm.equals(other.deptNm))
			return false;
		if (feb == null) {
			if (other.feb != null)
				return false;
		} else if (!feb.equals(other.feb))
			return false;
		if (jan == null) {
			if (other.jan != null)
				return false;
		} else if (!jan.equals(other.jan))
			return false;
		if (mar == null) {
			if (other.mar != null)
				return false;
		} else if (!mar.equals(other.mar))
			return false;
		if (may == null) {
			if (other.may != null)
				return false;
		} else if (!may.equals(other.may))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
	   return "DashDeptVO [deptNm=" + deptNm + ", jan=" + jan + ", feb=" + feb + ", mar=" + mar + ", apr=" + apr + ", may="
	         + may + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
