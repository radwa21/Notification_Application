# NotificationApp
NotificationApp is a Spring Boot application designed to manage user notifications. It provides RESTful APIs for sending notifications, listing user notifications, and marking notifications as seen. The application uses PostgreSQL for data persistence and follows a layered architecture with controllers, services, and repositories.

## Features
### Send Notification: 
  Allows sending notifications to users.
### List Notifications:  
  Retrieves notifications for a specific user.
### Mark Notification as Seen:  
  Marks a notification as seen by the user.

## Technologies Used
Java
Spring Boot
Spring Data JPA
PostgreSQL
Maven 

## Getting Started
Prerequisites
Java 17
Maven
PostgreSQL
Installation 


### Update the application.properties file with your PostgreSQL database details:

#### spring.datasource.url=jdbc:postgresql://localhost:5432/notificationdb
#### spring.datasource.username=your_username
#### spring.datasource.password=your_password
#### spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
#### spring.jpa.hibernate.ddl-auto=update

## Build the Project:
Use Maven to build the project:

mvn clean install
Run the Application:

## Start the Spring Boot application:

mvn spring-boot:run

## Usage
 ### Sending a Notification
Endpoint: POST /notifications/send
Request Body: 
{
  "userId": 1,
  "message": "This is a test notification",
  "seen": false,
  "createdAt": "2024-07-01T12:00:00"
}

## Listing Notifications for a User
Endpoint: GET /notifications/list/{userId}
  
## Marking a Notification as Seen
Endpoint: POST /notifications/mark-seen/{id}

## Acknowledgments
Spring Boot Documentation
PostgreSQL Documentation
