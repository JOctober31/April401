package com.april.groupware.nboard.service;
import com.april.groupware.cmn.DTO;

/**
 * 
 */

/**
 * @author 양은영
 *
 */
public class NBAnswerVO extends DTO {
	
	private int	awNo			; /*	댓글번호	*/
	private int	nbNo			; /*	게시글순번	*/
	private String	awContents	; /*	내용	*/
	private String	regId		; /*	작성자	*/
	private String	modId		; /*	수정자	*/
	private String	regDate		; /*	작성일	*/
	private String	modDate		; /*	수정일	*/
	private String	id			; /*	작성자 아이디	*/
	private String	name		; /*	작성자 이름	*/
	private String	deptNm		; /*	작성자 부서	*/
	private String	position	; /*	작성자 직급	*/
	
	private int pageSize 		; /*	페이지 사이즈	*/
	private int pageNum 		; /*	페이지 	*/
	
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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

	public String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public NBAnswerVO() {}

	public int getAwNo() {
		return awNo;
	}

	public void setAwNo(int awNo) {
		this.awNo = awNo;
	}

	public int getNbNo() {
		return nbNo;
	}

	public void setNbNo(int nbNo) {
		this.nbNo = nbNo;
	}

	public String getAwContents() {
		return awContents;
	}

	public void setAwContents(String awContents) {
		this.awContents = awContents;
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
		return "NBAnswerVO [awNo=" + awNo + ", nbNo=" + nbNo + ", awContents=" + awContents + ", regId=" + regId
				+ ", modId=" + modId + ", regDate=" + regDate + ", modDate=" + modDate + ", id=" + id + ", name=" + name
				+ ", deptNm=" + deptNm + ", position=" + position + ", toString()=" + super.toString() + "]";
	}
	
//	@Override
//	public String toString() {
//		return "NBAnswerVO [awNo=" + awNo + ", nbNo=" + nbNo + ", awContents=" + awContents + ", regId=" + regId
//				+ ", modId=" + modId + ", regDate=" + regDate + ", modDate=" + modDate + ", toString()="
//				+ super.toString() + "]";
//	}

	public NBAnswerVO(int awNo, int nbNo, String awContents, String regId, String modId, String regDate,
			String modDate) {
		super();
		this.awNo = awNo;
		this.nbNo = nbNo;
		this.awContents = awContents;
		this.regId = regId;
		this.modId = modId;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	//조직 테이블 데이터 포함
	public NBAnswerVO(int awNo, int nbNo, String awContents, String regId, String modId, String regDate, String modDate,
			String id, String name, String deptNm, String position) {
		super();
		this.awNo = awNo;
		this.nbNo = nbNo;
		this.awContents = awContents;
		this.regId = regId;
		this.modId = modId;
		this.regDate = regDate;
		this.modDate = modDate;
		this.id = id;
		this.name = name;
		this.deptNm = deptNm;
		this.position = position;
	}
	
	
	
	
	

	
}
