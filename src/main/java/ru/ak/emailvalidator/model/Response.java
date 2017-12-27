package ru.ak.emailvalidator.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Response {
	
	private String messageId;
	private String textMessage;
	private boolean error;
	private String description;
	
	public Response() {
	}
	
	public Response(String messageId, String textMessage, boolean error, String descrption) {
		this();
		this.messageId = messageId;
		this.textMessage = textMessage;
		this.error = error;
		this.description = descrption;
	}
	
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}
	
	
	
}
