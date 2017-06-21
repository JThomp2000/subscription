package com.jt.subscription.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.jt.subscription.model.Subscription;

@Service
public class SubscriptionService {
	private Map<Long, Subscription> subscriptions = new ConcurrentHashMap<>();

	public Map<Long, Subscription> getSubscriptions() {
		return subscriptions;
	}
}
