the notification application uses a Hexagonal (Ports and Adapters) architecture style. This architectural style emphasizes the separation of concerns by organizing the application into distinct layers, promoting flexibility and decoupling.

Here's a summary of each layer and its responsibilities within this architecture:

1. Core Domain

Packages:

com/gila/notification/domain/ports

com/gila/notification/domain/models

Description: The core domain contains the business logic of the application. It includes domain models and interfaces (ports) which represent the operations offered to and required from the external world.

NotificationChannel in NotificationChannel.java: Defines the contract for different notification delivery mechanisms.

2. Application Services

Packages:

com/gila/notification/application/ports/services

Description: Application services contain the orchestration of domain logic, translating and coordinating the higher-level processes. This layer interacts with the core domain layer through defined interfaces (ports).

NotificationServiceImpl.java: Implements the business logic for sending notifications.

3. Infrastructure (Adapters)

Packages:

com/gila/notification/infraestructura/adapters/controllers

com/gila/notification/infraestructura/adapters/repositories

Description: This layer contains the technical details of connecting the application with external systems. Implementations of the ports are included in this layer.

NotificationController.java: Handles HTTP requests for notification operations.

LogRepositoryImpl.java: Implements data persistence operations.

4. Configuration

src/main/java/com/gila/notification/NotificationApplication.java

Sets up the Spring Boot application, enabling auto-configuration and async support.

Interaction Flow

To provide a clearer picture, here are two main interaction flows derived from the sequence diagrams:

1. Sending Notifications (POST /notifications/send)

Entry Point: NotificationController.sendNotification()

Service Call: NotificationServiceImpl.sendNotifications()

Database Operations:

Retrieve categories and notifications.

Fetch user details.

Notifications Dispatch: Utilize NotificationChannel to send notifications.

2. Retrieving Logs (GET /notifications/logs)

Entry Point: NotificationController.logsFindAll()

Database Call: LogRepositoryImpl.findAll()

Return Response: Return the logs as HTTP response