package org.core.design.creational.factory;

public class MainClass {

	public static void main(String[] args) {
		NotificationFactory factory = new NotificationFactory();
		Notification notification = factory.createNotification("sms");
		if(null != notification) {
			notification.notifyUser();
		}
	}

}
