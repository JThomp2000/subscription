package com.jt.subscription.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private long identifier;
	private String messageType;
	private String message;
	
	public Message()
	{
	}
	
	public long getIdentifier() {
		return identifier;
	}
	public void setIdentifier(long id) {
		this.identifier = id;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
