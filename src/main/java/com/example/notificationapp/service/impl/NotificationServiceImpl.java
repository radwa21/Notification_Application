package com.example.notificationapp.service.impl;

import com.example.notificationapp.model.Notification;
import com.example.notificationapp.repository.NotificationRepository;
import com.example.notificationapp.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification sendNotification(Long userId, String message) {
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setMessage(message);
        notification.setSeen(false);
        notification.setCreatedAt(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> listUserNotifications(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    @Override
    public Notification markNotificationAsSeen(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setSeen(true);
        return notificationRepository.save(notification);
    }
}
