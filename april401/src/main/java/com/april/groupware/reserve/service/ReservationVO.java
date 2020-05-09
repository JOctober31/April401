/**
 * <pre>
 * com.april.groupware.reserve.service
 * Class Name : ReservationVO.java
 * Description : 
 * Modification Information
 * 
 * 수정일         수정자        수정내용
 * ------------ ----------- -------------------------------
 * 2020-05-05           최초생성
 *
 * @author 쌍용교육센터 E반 April
 * @since 2020-05-05 
 * @version 1.0
 * 
 *  Copyright (C) by April All right reserved.
 * </pre>
 */
package com.april.groupware.reserve.service;

import com.april.groupware.cmn.DTO;

/**
 * @author home
 *
 */
public class ReservationVO extends DTO {
	/**예약 번호*/ 
	private String rsvNo;
	/**예약일*/
	private String rsvDay;
	/**예약 시작 시간*/
	private String rsvStartTime;
	/**예약 끝 시간*/
	private String rsvEndTime;
	/**회의실 번호*/
	private String meetRoomNo;
	/**예약자명*/
	private String rsvName;
	/**예약 내용*/
	private String rsvCn;
	/**예약 여부*/
	private String rsvYN;
	/**작성자*/
	private String regId;
	/**작성일*/
	private String regDate;
	/**수정자*/
	private String modId;
	/**수정일*/
	private String modDate;
	
	public ReservationVO() {
		
	}

	public ReservationVO(String rsvNo, String rsvDay, String rsvStartTime, String rsvEndTime, String meetRoomNo,
			String rsvName, String rsvCn, String rsvYN, String regId, String regDate, String modId, String modDate) {
		super();
		this.rsvNo = rsvNo;
		this.rsvDay = rsvDay;
		this.rsvStartTime = rsvStartTime;
		this.rsvEndTime = rsvEndTime;
		this.meetRoomNo = meetRoomNo;
		this.rsvName = rsvName;
		this.rsvCn = rsvCn;
		this.rsvYN = rsvYN;
		this.regId = regId;
		this.regDate = regDate;
		this.modId = modId;
		this.modDate = modDate;
	}

	public String getRsvNo() {
		return rsvNo;
	}

	public void setRsvNo(String rsvNo) {
		this.rsvNo = rsvNo;
	}

	public String getRsvDay() {
		return rsvDay;
	}

	public void setRsvDay(String rsvDay) {
		this.rsvDay = rsvDay;
	}

	public String getRsvStartTime() {
		return rsvStartTime;
	}

	public void setRsvStartTime(String rsvStartTime) {
		this.rsvStartTime = rsvStartTime;
	}

	public String getRsvEndTime() {
		return rsvEndTime;
	}

	public void setRsvEndTime(String rsvEndTime) {
		this.rsvEndTime = rsvEndTime;
	}

	public String getMeetRoomNo() {
		return meetRoomNo;
	}

	public void setMeetRoomNo(String meetRoomNo) {
		this.meetRoomNo = meetRoomNo;
	}

	public String getRsvName() {
		return rsvName;
	}

	public void setRsvName(String rsvName) {
		this.rsvName = rsvName;
	}

	public String getRsvCn() {
		return rsvCn;
	}

	public void setRsvCn(String rsvCn) {
		this.rsvCn = rsvCn;
	}

	public String getRsvYN() {
		return rsvYN;
	}

	public void setRsvYN(String rsvYN) {
		this.rsvYN = rsvYN;
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
		return "ReservationVO [rsvNo=" + rsvNo + ", rsvDay=" + rsvDay + ", rsvStartTime=" + rsvStartTime
				+ ", rsvEndTime=" + rsvEndTime + ", meetRoomNo=" + meetRoomNo + ", rsvName=" + rsvName + ", rsvCn="
				+ rsvCn + ", rsvYN=" + rsvYN + ", regId=" + regId + ", regDate=" + regDate + ", modId=" + modId
				+ ", modDate=" + modDate + ", toString()=" + super.toString() + "]";
	}
	
}