package org.core.design.creational.factory;

public class SmsNotification implements Notification {

	@Override
	public void notifyUser() {
		System.out.println("SMS sent");
	}

}
