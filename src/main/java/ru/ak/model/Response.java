package ru.ak.model;

import javax.xml.bind.annotation.XmlElement;

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

	@XmlElement
	public String getMessageId() {
		return messageId;
	}

	@XmlElement
	public boolean isError() {
		return error;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	@XmlElement
	public String getTextMessage() {
		return textMessage;
	}
}