package org.core.design.creational.factory;

public class NotificationFactory {
	public Notification createNotification(String channel) {
		if(null == channel || channel.isEmpty()) {
			return null;
		}else if("SMS".equalsIgnoreCase(channel)) {
			return new SmsNotification();
		}else if("EMAIL".equalsIgnoreCase(channel)) {
			return new EmailNotification();
		}
		return null;
	}
}
