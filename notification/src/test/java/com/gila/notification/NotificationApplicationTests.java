package com.gila.notification;

import com.gila.notification.application.ports.NotificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NotificationSystemApplicationTests {

	@Autowired
	private NotificationService notificationService;

	@Test
	void contextLoads() {
	}

	@Test
	void testSendNotifications() {
		notificationService.sendNotifications("Sports", "Sports event tonight!");
		// Add assertions based on your log repository or mock implementation
	}

	@Test
	void testInvalidCategory() {
		try {
			notificationService.sendNotifications("Invalid", "Invalid message");
		} catch (IllegalArgumentException e) {
			assert e.getMessage().equals("Invalid category");
		}
	}

	@Test
	void testEmptyMessage() {
		try {
			notificationService.sendNotifications("Sports", "");
		} catch (IllegalArgumentException e) {
			assert e.getMessage().equals("Message cannot be empty");
		}
	}
}