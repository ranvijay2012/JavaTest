package neeraj.design.structural;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {
        // Leaf nodes
        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();
        Notification push = new PushNotification();

        // Composite group
        NotificationGroup allNotifications = new NotificationGroup();
        allNotifications.addNotification(email);
        allNotifications.addNotification(sms);
        allNotifications.addNotification(push);

        // Another group (nested composite)
        NotificationGroup priorityNotifications = new NotificationGroup();
        priorityNotifications.addNotification(email);
        priorityNotifications.addNotification(push);

        // Using composite structure
        System.out.println("Sending to all:");
        allNotifications.send("System maintenance at 10 PM");

        System.out.println("\nSending priority only:");
        priorityNotifications.send("High priority alert!");
    }
}

interface Notification {
    void send(String message);
}

class SMSNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Notified user over mobile");
    }
}

class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Notified user over email");
    }
}

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}


class NotificationGroup implements Notification {
    private List<Notification> notifications = new ArrayList<>();

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void removeNotification(Notification notification) {
        notifications.remove(notification);
    }

    @Override
    public void send(String message) {
        for (Notification notification : notifications) {
            notification.send(message);
        }
    }
}


/*

📦 Real-World Analogy:
Imagine a notification system where you might want to send messages via SMS, Email, Push Notification, or a
combination of all. The composite pattern lets you treat a group of notifications the same way you treat a single one.

🔧 Key Components:
Component (interface or abstract class): Declares common operations for both leaf and composite objects.
Leaf: Represents individual objects (e.g., EmailNotification, SMSNotification).
Composite: Represents groups of components that can include both leaves and other composites (e.g., NotificationGroup).

✅ When to Use:
You want to represent part-whole hierarchies.
You want clients to treat individual objects and composites uniformly.

🔄 Benefits:
Makes it easier to add new kinds of components.
Simplifies client code (uniform interface).
Supports recursive structures like trees and menus.

 */

