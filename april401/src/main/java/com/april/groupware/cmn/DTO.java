/**
 * 공통 VO
 */
package com.april.groupware.cmn;

/**
 * @author sist
 *
 */
public class DTO {
	//글번호
	private int num;
	
	//총글수 
	private int totalCnt;
	
	public DTO() {}

	public DTO(int num, int totalCnt) {
		this.num = num;
		this.totalCnt = totalCnt;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return the totalCnt
	 */
	public int getTotalCnt() {
		return totalCnt;
	}

	/**
	 * @param totalCnt the totalCnt to set
	 */
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	@Override
	public String toString() {
		return "DTO [num=" + num + ", totalCnt=" + totalCnt + "]";
	}
	
	
	
	
}
