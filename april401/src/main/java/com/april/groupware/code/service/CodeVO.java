package com.april.groupware.code.service;

import com.april.groupware.cmn.DTO;

public class CodeVO extends DTO {

	private String codeTypeId	;//	코드유형ID
	private String codeId		;//	코드ID
	private String codeNm		;//	코드명
	private String useYn		;//	사용여부
	private String seq			;//	순서
	private String regId		;//	등록자ID
	private String regDt		;//	등록일 
	
	public CodeVO() {}

	public CodeVO(String codeTypeId, String codeId, String codeNm, String useYn, String seq, String regId,
			String regDt) {
		super();
		this.codeTypeId = codeTypeId;
		this.codeId = codeId;
		this.codeNm = codeNm;
		this.useYn = useYn;
		this.seq = seq;
		this.regId = regId;
		this.regDt = regDt;
	}

	/**
	 * @return the codeTypeId
	 */
	public String getCodeTypeId() {
		return codeTypeId;
	}

	/**
	 * @param codeTypeId the codeTypeId to set
	 */
	public void setCodeTypeId(String codeTypeId) {
		this.codeTypeId = codeTypeId;
	}

	/**
	 * @return the codeId
	 */
	public String getCodeId() {
		return codeId;
	}

	/**
	 * @param codeId the codeId to set
	 */
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	/**
	 * @return the codeNm
	 */
	public String getCodeNm() {
		return codeNm;
	}

	/**
	 * @param codeNm the codeNm to set
	 */
	public void setCodeNm(String codeNm) {
		this.codeNm = codeNm;
	}

	/**
	 * @return the useYn
	 */
	public String getUseYn() {
		return useYn;
	}

	/**
	 * @param useYn the useYn to set
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	/**
	 * @return the seq
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * @param seq the seq to set
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * @return the regId
	 */
	public String getRegId() {
		return regId;
	}

	/**
	 * @param regId the regId to set
	 */
	public void setRegId(String regId) {
		this.regId = regId;
	}

	/**
	 * @return the regDt
	 */
	public String getRegDt() {
		return regDt;
	}

	/**
	 * @param regDt the regDt to set
	 */
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "CodeVO [codeTypeId=" + codeTypeId + ", codeId=" + codeId + ", codeNm=" + codeNm + ", useYn=" + useYn
				+ ", seq=" + seq + ", regId=" + regId + ", regDt=" + regDt + ", toString()=" + super.toString() + "]";
	}
	
	
}
