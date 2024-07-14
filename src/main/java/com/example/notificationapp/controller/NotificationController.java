package com.example.notificationapp.controller;

import com.example.notificationapp.model.Notification;
import com.example.notificationapp.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public Notification sendNotification(@RequestBody Notification notificationRequest) {
        return notificationService.sendNotification(notificationRequest.getUserId(), notificationRequest.getMessage());
    }

    @GetMapping("/user/{userId}")
    public List<Notification> listUserNotifications(@PathVariable Long userId) {
        return notificationService.listUserNotifications(userId);
    }

    @PostMapping("/{notificationId}/markSeen")
    public Notification markNotificationAsSeen(@PathVariable Long notificationId) {
        return notificationService.markNotificationAsSeen(notificationId);
    }
}