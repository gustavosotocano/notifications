# Notification System



## Architecture

The application's architecture is structured to cleanly separate concerns,
making it maintainable and scalable. The core business logic is isolated
from external details through well-defined interfaces, following the
Hexagonal architecture principles. This design pattern enhances
testability and adherence to SOLID principles. 

## Technology Stack 

- Backend
  - SpringBoot 3.2.6
  - java 21
- Frontend
  - Angular 17

## to add more notification channels.

To add another channel, you must create a class that implements the class implements 
NotificationChannel. The name of the class must be the same as that configured in the channels 
table and with that we already have another channel configured.


