package com.jt.subscription.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jt.subscription.model.ErrorMessage;
import com.jt.subscription.model.Message;
import com.jt.subscription.model.Subscription;
import com.jt.subscription.service.SubscriptionService;


@RestController
@RequestMapping(value = "subscription", produces = { "application/json", "text/xml" })
public class SubscriptionController {
	
	@Autowired
	private SubscriptionService subscriptions;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createSubscription(@RequestBody Subscription subscription, HttpServletRequest request)
	{
		if(!checkValidRequest(subscription)) return new ResponseEntity<>(new ErrorMessage("Invalid Request"), HttpStatus.BAD_REQUEST);
		subscription.setIdentifier(subscriptions.getSubscriptions().size() + 1);
		subscription.createLinks();
		subscription.addPostEvent();
		for(Message message : subscription.getMessageTypes())
		{
			message.setIdentifier(subscription.getMessageTypes().indexOf(message) + 1);
		}
		subscriptions.getSubscriptions().put(subscription.getIdentifier(), subscription);
		return new ResponseEntity<>(subscription, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "{subscriptionID}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateSubscription(@RequestBody Subscription subscription, @PathVariable long subscriptionID)
	{
		Subscription recordedSubscription = subscriptions.getSubscriptions().get(subscriptionID);
		if(recordedSubscription == null) return new ResponseEntity<>(new ErrorMessage("Subscription Does Not Exist"), HttpStatus.NOT_FOUND);
		else if(!checkValidRequest(subscription)) return new ResponseEntity<>(new ErrorMessage("Invalid Request"), HttpStatus.BAD_REQUEST);
		subscription.setIdentifier(recordedSubscription.getIdentifier());
		subscription.setEventsCount(recordedSubscription.getEventsCount());
		subscription.createLinks();
		subscription.addPutEvent();
		subscriptions.getSubscriptions().put(subscriptionID, subscription);
		return new ResponseEntity<>(subscriptions.getSubscriptions().get(subscriptionID), HttpStatus.OK);
	}
	
	@RequestMapping(value = "{subscriptionID}", method = RequestMethod.GET)
	public ResponseEntity<Object> readSubscription(@PathVariable long subscriptionID)
	{
		Subscription subscription = subscriptions.getSubscriptions().get(subscriptionID);
		if(subscription == null) return new ResponseEntity<>(new ErrorMessage("Subscription Does Not Exist"), HttpStatus.NOT_FOUND);
		subscription.createLinks();
		subscription.addGETEvent();
		return new ResponseEntity<>(subscription, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{subscriptionID}/message", method = RequestMethod.POST)
	public ResponseEntity<Object> postMessage(@RequestBody Message message, @PathVariable long subscriptionID)
	{
		if(subscriptions.getSubscriptions().get(subscriptionID) == null) return new ResponseEntity<>(new ErrorMessage("Subscription Does Not Exist"), HttpStatus.NOT_FOUND);
		else if(message == null || message.getMessageType() == null || message.getMessageType().isEmpty())  return new ResponseEntity<>(new ErrorMessage("Invalid Request"), HttpStatus.BAD_REQUEST);
		Subscription subscription = subscriptions.getSubscriptions().get(subscriptionID);
		subscription.createLinks();
		subscription.addPostEvent();
		message.setIdentifier(subscription.getMessageTypes().size() + 1);
		subscription.getMessageTypes().add(message);
		return new ResponseEntity<>(subscriptions.getSubscriptions().get(subscriptionID), HttpStatus.CREATED);
	}
	
	private boolean checkValidRequest(Subscription subscription)
	{
		return subscription != null && subscription.getMessageTypes() != null && !subscription.getMessageTypes().isEmpty();
	}
	
}
