package com.jt.subscription.model;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Event Type tracking
 * @author JThomp
 *
 */
public class Event {
	private RequestMethod requestType;
	private int accessCount;
	public Event()
	{
		
	}
	public Event(RequestMethod requestType, int accessCount)
	{
		this.requestType = requestType;
		this.accessCount = accessCount;
	}
	
	public RequestMethod getRequestType() {
		return requestType;
	}
	public void setRequestType(RequestMethod requestType) {
		this.requestType = requestType;
	}
	public int getAccessCount() {
		return accessCount;
	}
	public void setAccessCount(int accessCount) {
		this.accessCount = accessCount;
	}
	
}
