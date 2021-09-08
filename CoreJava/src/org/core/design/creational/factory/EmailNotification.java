package org.core.design.creational.factory;

public class EmailNotification implements Notification {

	@Override
	public void notifyUser() {
		System.out.println("Email sent");
	}

}
