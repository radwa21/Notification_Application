package com.example.notificationapp.service;

import com.example.notificationapp.model.Notification;
import java.util.List;

public interface NotificationService {
    Notification sendNotification(Long userId, String message);
    List<Notification> listUserNotifications(Long userId);
    Notification markNotificationAsSeen(Long notificationId);
}
