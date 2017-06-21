package com.jt.subscription.model;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jt.subscription.controller.SubscriptionController;

@XmlRootElement
public class Subscription extends ResourceSupport {
	private long identifier;
	private List<Event> eventsCount;
	private List<Message> messageTypes;

	public Subscription()
	{
		messageTypes = new ArrayList<>();
		eventsCount = new ArrayList<>();

		createEvents();
	}
	/**
	 * Creates the default events for a subscription
	 */
	private void createEvents()
	{
		eventsCount.add(new Event(RequestMethod.PUT, 0));
		eventsCount.add(new Event(RequestMethod.GET, 0));
		eventsCount.add(new Event(RequestMethod.POST, 0));
	}
	
	public void createLinks()
	{
		removeLinks();
		add(linkTo(SubscriptionController.class).slash(identifier).withSelfRel());
		add(linkTo(SubscriptionController.class).slash(identifier).withRel(RequestMethod.PUT.toString()));
		add(linkTo(SubscriptionController.class).slash(identifier).slash("message").withRel(RequestMethod.POST.toString()));
	}
	/**
	 * Adds a put event
	 */
	public void addPutEvent()
	{
		for(Event recordedEvent : eventsCount)
		{
			if(recordedEvent.getRequestType().equals(RequestMethod.PUT))
			{
				recordedEvent.setAccessCount(recordedEvent.getAccessCount() + 1);
				break;
			}
		}
	}
	/**
	 * Adds a get event
	 */
	public void addGETEvent()
	{
		for(Event recordedEvent : eventsCount)
		{
			if(recordedEvent.getRequestType().equals(RequestMethod.GET))
			{
				recordedEvent.setAccessCount(recordedEvent.getAccessCount() + 1);
				break;
			}
		}
	}
	/**
	 * Adds a post event
	 */
	public void addPostEvent()
	{
		for(Event recordedEvent : eventsCount)
		{
			if(recordedEvent.getRequestType().equals(RequestMethod.POST))
			{
				recordedEvent.setAccessCount(recordedEvent.getAccessCount() + 1);
				break;
			}
		}
	}
	
	
	public long getIdentifier() {
		return identifier;
	}
	public void setIdentifier(long identifier) {
		this.identifier = identifier;
	}
	public List<Message> getMessageTypes() {
		return messageTypes;
	}
	public void setMessageTypes(List<Message> messageTypes) {
		this.messageTypes = messageTypes;
	}

	public void setEventsCount(List<Event> eventsCount) {
		this.eventsCount = eventsCount;
	}
	public List<Event> getEventsCount() {
		return eventsCount;
	}
}
