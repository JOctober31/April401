package com.april.groupware.dash.service;
import com.april.groupware.cmn.DTO;

/**
 * 
 */

/**
 * @author 양은영
 *
 */
public class DashNBoardVO extends DTO {

	/** 게시글 번호 */
	private int nbNo		   ;
	/** 말머리 */
	private String nbCategory  ;
	/** 제목 */
	private String nbTitle     ;
	/** 내용 */
	private String nbContents  ;
	/** 상단공지여부 */
	private String noticeYn    ;
	/** 팝업여부 */
	private String popupYn     ;
	/** 파일아이디 */
	private String fileId      ;
	/** 조회수 */
	private int readCnt        ;
	/** 등록자 아이디 */
	private String regId       ;
	/** 수정자 아이디 */
	private String modId       ;
	/** 등록일 */
	private String regDate     ;
	/** 수정일 */
	private String modDate     ;
	
	public DashNBoardVO() {}

	public DashNBoardVO(int nbNo, String nbCategory, String nbTitle, String nbContents, String noticeYn, String popupYn,
			String fileId, int readCnt, String regId, String modId, String regDate, String modDate) {
		super();
		this.nbNo = nbNo;
		this.nbCategory = nbCategory;
		this.nbTitle = nbTitle;
		this.nbContents = nbContents;
		this.noticeYn = noticeYn;
		this.popupYn = popupYn;
		this.fileId = fileId;
		this.readCnt = readCnt;
		this.regId = regId;
		this.modId = modId;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	public int getNbNo() {
		return nbNo;
	}

	public void setNbNo(int nbNo) {
		this.nbNo = nbNo;
	}

	public String getNbCategory() {
		return nbCategory;
	}

	public void setNbCategory(String nbCategory) {
		this.nbCategory = nbCategory;
	}

	public String getNbTitle() {
		return nbTitle;
	}

	public void setNbTitle(String nbTitle) {
		this.nbTitle = nbTitle;
	}

	public String getNbContents() {
		return nbContents;
	}

	public void setNbContents(String nbContents) {
		this.nbContents = nbContents;
	}

	public String getNoticeYn() {
		return noticeYn;
	}

	public void setNoticeYn(String noticeYn) {
		this.noticeYn = noticeYn;
	}

	public String getPopupYn() {
		return popupYn;
	}

	public void setPopupYn(String popupYn) {
		this.popupYn = popupYn;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
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
		return "DashNBoardVO [nbNo=" + nbNo + ", nbCategory=" + nbCategory + ", nbTitle=" + nbTitle + ", nbContents="
				+ nbContents + ", noticeYn=" + noticeYn + ", popupYn=" + popupYn + ", fileId=" + fileId + ", readCnt="
				+ readCnt + ", regId=" + regId + ", modId=" + modId + ", regDate=" + regDate + ", modDate=" + modDate
				+ "]";
	}


	
	
	
	
	
}
