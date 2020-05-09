package com.april.groupware.cmn;

public class MessageVO extends DTO {
	/**
	 * 메시지 ID
	 */
	private String msgId;
	
	/**
	 * 메시지 
	 */
	private String msgMsg;
	
	public MessageVO() {
		
	}
	
	public MessageVO(String msgId, String msgMsg) {
		super();
		this.msgId = msgId;
		this.msgMsg = msgMsg;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgMsg() {
		return msgMsg;
	}

	public void setMsgMsg(String msgMsg) {
		this.msgMsg = msgMsg;
	}

	@Override
	public String toString() {
		return "MessageVO [msgId=" + msgId + ", msgMsg=" + msgMsg + ", toString()=" + super.toString() + "]";
	}

}
