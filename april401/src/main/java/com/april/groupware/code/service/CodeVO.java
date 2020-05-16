package com.april.groupware.code.service;

import com.april.groupware.cmn.DTO;

public class CodeVO extends DTO {
	/**코드유형ID*/
	private String codeTypeId;
	/**코드유형명*/
	private String codeTypeNm;
	/**코드ID*/
	private String codeId;
	/**코드명*/
	private String codeNm;
	/**사용여부*/
	private String useYn;
	/**순서*/
	private String seq;
	/**등록자ID*/
	private String regId;
	/**등록일*/
	private String regDt;
	
	public CodeVO() {
		
	}

	public CodeVO(String codeTypeId, String codeTypeNm, String codeId, String codeNm, String useYn, String seq,
			String regId, String regDt) {
		super();
		this.codeTypeId = codeTypeId;
		this.codeTypeNm = codeTypeNm;
		this.codeId = codeId;
		this.codeNm = codeNm;
		this.useYn = useYn;
		this.seq = seq;
		this.regId = regId;
		this.regDt = regDt;
	}

	public String getCodeTypeId() {
		return codeTypeId;
	}

	public void setCodeTypeId(String codeTypeId) {
		this.codeTypeId = codeTypeId;
	}

	public String getCodeTypeNm() {
		return codeTypeNm;
	}

	public void setCodeTypeNm(String codeTypeNm) {
		this.codeTypeNm = codeTypeNm;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getCodeNm() {
		return codeNm;
	}

	public void setCodeNm(String codeNm) {
		this.codeNm = codeNm;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "CodeVO [codeTypeId=" + codeTypeId + ", codeTypeNm=" + codeTypeNm + ", codeId=" + codeId + ", codeNm="
				+ codeNm + ", useYn=" + useYn + ", seq=" + seq + ", regId=" + regId + ", regDt=" + regDt
				+ ", toString()=" + super.toString() + "]";
	}
	
}
