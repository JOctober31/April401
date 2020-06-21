package com.april.groupware.nboard.service;
import com.april.groupware.cmn.DTO;

/**
 * 
 */

/**
 * @author 양은영
 *
 */
public class NBoardVO extends DTO {

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
	
	public NBoardVO() {}

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
		return "NBoardVO [nbNo=" + nbNo + ", nbCategory=" + nbCategory + ", nbTitle=" + nbTitle + ", nbContents="
				+ nbContents + ", noticeYn=" + noticeYn + ", popupYn=" + popupYn + ", fileId=" + fileId + ", readCnt="
				+ readCnt + ", regId=" + regId + ", modId=" + modId + ", regDate=" + regDate + ", modDate=" + modDate
				+ ", toString()=" + super.toString() + "]";
	}
	
	public NBoardVO(String nbCategory, String nbTitle, String nbContents, String noticeYn, String popupYn,
			String fileId, int readCnt, String regId, String modId, String regDate, String modDate) {
		super();
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

	public NBoardVO(int nbNo, String nbCategory, String nbTitle, String nbContents, String noticeYn, String popupYn,
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileId == null) ? 0 : fileId.hashCode());
		result = prime * result + ((modDate == null) ? 0 : modDate.hashCode());
		result = prime * result + ((modId == null) ? 0 : modId.hashCode());
		result = prime * result + ((nbCategory == null) ? 0 : nbCategory.hashCode());
		result = prime * result + ((nbContents == null) ? 0 : nbContents.hashCode());
		result = prime * result + nbNo;
		result = prime * result + ((nbTitle == null) ? 0 : nbTitle.hashCode());
		result = prime * result + ((noticeYn == null) ? 0 : noticeYn.hashCode());
		result = prime * result + ((popupYn == null) ? 0 : popupYn.hashCode());
		result = prime * result + readCnt;
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		result = prime * result + ((regId == null) ? 0 : regId.hashCode());
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
		NBoardVO other = (NBoardVO) obj;
		if (fileId == null) {
			if (other.fileId != null)
				return false;
		} else if (!fileId.equals(other.fileId))
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
		if (nbCategory == null) {
			if (other.nbCategory != null)
				return false;
		} else if (!nbCategory.equals(other.nbCategory))
			return false;
		if (nbContents == null) {
			if (other.nbContents != null)
				return false;
		} else if (!nbContents.equals(other.nbContents))
			return false;
		if (nbNo != other.nbNo)
			return false;
		if (nbTitle == null) {
			if (other.nbTitle != null)
				return false;
		} else if (!nbTitle.equals(other.nbTitle))
			return false;
		if (noticeYn == null) {
			if (other.noticeYn != null)
				return false;
		} else if (!noticeYn.equals(other.noticeYn))
			return false;
		if (popupYn == null) {
			if (other.popupYn != null)
				return false;
		} else if (!popupYn.equals(other.popupYn))
			return false;
		if (readCnt != other.readCnt)
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
		return true;
	}
	
	
	
	
}
