/**
 * 
 */
package com.april.groupware.mail.service;

import com.april.groupware.cmn.DTO;

public class MailVO extends DTO {
	// Mail 테이블
	/** 메일 아이디 */
	private String mailId; // M날짜_순번
	/** 카테고리 */
	private String category; // 메일, 휴가
	/** 보낸 사람 */
	private String sender;
	/** 보낸 사람 아이디 */
	private String senderId;
	/** 보낸 날짜 */
	private String senDate;
	/** 제목 */
	private String title;
	/** 파일 아이디 */
	private String fileId;
	/** 내용 */
	private String contents;
	/** 받는 사람 */
	private String recipient;
	/** 받는 사람 아이디 */
	private String recipientId;
	/** 받는 날짜 */
	private String recDate;
	/** 메일 삭제 유무 */
	private String disableYn; // Y: 삭제, N: 삭제 안함
	/** 읽음 여부 */
	private String read; // 읽지않음-0, 읽음-9
	/**수정 사진 경로*/
	private String saveFileName;

	public MailVO() {}

	public MailVO(String mailId, String category, String sender, String senderId, String senDate, String title,
			String fileId, String contents, String recipient, String recipientId, String recDate, String disableYn,
			String read, String saveFileName) {
		super();
		this.mailId = mailId;
		this.category = category;
		this.sender = sender;
		this.senderId = senderId;
		this.senDate = senDate;
		this.title = title;
		this.fileId = fileId;
		this.contents = contents;
		this.recipient = recipient;
		this.recipientId = recipientId;
		this.recDate = recDate;
		this.disableYn = disableYn;
		this.read = read;
		this.saveFileName = saveFileName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getSenDate() {
		return senDate;
	}

	public void setSenDate(String senDate) {
		this.senDate = senDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public String getRecDate() {
		return recDate;
	}

	public void setRecDate(String recDate) {
		this.recDate = recDate;
	}

	public String getDisableYn() {
		return disableYn;
	}

	public void setDisableYn(String disableYn) {
		this.disableYn = disableYn;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	@Override
	public String toString() {
		return "MailVO [mailId=" + mailId + ", category=" + category + ", sender=" + sender + ", senderId=" + senderId
				+ ", senDate=" + senDate + ", title=" + title + ", fileId=" + fileId + ", contents=" + contents
				+ ", recipient=" + recipient + ", recipientId=" + recipientId + ", recDate=" + recDate + ", disableYn="
				+ disableYn + ", read=" + read + ", saveFileName=" + saveFileName + ", toString()=" + super.toString()
				+ "]";
	}



	
}
