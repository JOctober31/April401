/**
 * <pre>
 * com.april.groupware.attendance.service
 * Class Name : attendanceVO.java
 * Description : 
 * Modification Information
 * 
 * 수정일         수정자        수정내용
 * ------------ ----------- -------------------------------
 * 2020-05-06           최초생성
 *
 * @author 쌍용교육센터 E반 April
 * @since 2020-05-06 
 * @version 1.0
 * 
 *  Copyright (C) by April All right reserved.
 * </pre>
 */
package com.april.groupware.attendance.service;

import com.april.groupware.cmn.DTO;

/**
 * @author SIST
 *
 */
public class AttendanceVO extends DTO {
	/**아이디*/
	private String id;
	/**순서*/
	private String seq;
	/**출근 시간*/
	private String attendTime;
	/**퇴근 시간*/
	private String leaveTime;
	/**출근 여부*/
	private String attendYN;
	/**퇴근 여부*/
	private String leaveYN;
	/**출결 상태*/
	private String state;
	/**근무시간*/
	private String workTime;
	/**작성자*/
	private String regId;
	/**작성일*/
	private String regDate;
	/**수정자*/
	private String modId;
	/**수정일*/
	private String modDate;
	
	public AttendanceVO() {
		
	}

	public AttendanceVO(String id, String seq, String attendTime, String leaveTime, String attendYN, String leaveYN,
			String state, String workTime, String regId, String modId, String regDate, String modDate) {
		super();
		this.id = id;
		this.seq = seq;
		this.attendTime = attendTime;
		this.leaveTime = leaveTime;
		this.attendYN = attendYN;
		this.leaveYN = leaveYN;
		this.state = state;
		this.workTime = workTime;
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

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getAttendTime() {
		return attendTime;
	}

	public void setAttendTime(String attendTime) {
		this.attendTime = attendTime;
	}

	public String getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}

	public String getAttendYN() {
		return attendYN;
	}

	public void setAttendYN(String attendYN) {
		this.attendYN = attendYN;
	}

	public String getLeaveYN() {
		return leaveYN;
	}

	public void setLeaveYN(String leaveYN) {
		this.leaveYN = leaveYN;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
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
		return "AttendanceVO [id=" + id + ", seq=" + seq + ", attendTime=" + attendTime + ", leaveTime=" + leaveTime
				+ ", attendYN=" + attendYN + ", leaveYN=" + leaveYN + ", state=" + state + ", workTime=" + workTime
				+ ", regId=" + regId + ", regDate=" + regDate + ", modId=" + modId + ", modDate=" + modDate
				+ ", toString()=" + super.toString() + "]";
	}
	
}