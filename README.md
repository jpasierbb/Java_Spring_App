# Mobile Network Operator Database Application

This project implements a relational database system for managing a mobile network operator's data. It was developed as part of the **Databases and Big Data** course at my studies.

## Features

The application provides two main perspectives based on the user's role:
- **Operator Perspective** (broad view): Full control over employee and customer records, including adding, editing, and deleting entries.
- **Manager Perspective** (narrow view): Read-only access to employee data, without the ability to modify or add records.

## Technologies Used

- **Java (v17)**: The core backend language for handling application logic.
- **Spring Boot**: A framework used for quick web application setup, leveraging several important modules:
  - **Spring Security**: Handles user authentication and authorization.
  - **Spring Web MVC**: Implements the MVC (Model-View-Controller) design pattern.
  - **Thymeleaf**: Templating engine for dynamic HTML generation.
  - **Spring JDBC**: Facilitates communication with the relational database.
- **JDBC (Oracle Thin Driver)**: Used to manage database interactions.

## Functionalities

### User Login
The homepage features a login button that redirects users to the login panel. After logging in, the user gains access to the system based on their assigned role (Operator or Manager).

### Operator Perspective
- **Employee Management**: Operators can view, add, edit, and delete employee records. Data validation ensures only correct entries are processed.
- **Customer Management**: Operators can also manage customer records, including the ability to create and manage service agreements for individual customers.
- **Pagination**: Employee and customer records are displayed with pagination, allowing for easy navigation through large datasets.

### Manager Perspective
- **Read-Only Access**: Managers have a restricted view, allowing them to browse employee data without the ability to modify any records.

## How to Run

1. Clone this repository.
2. Ensure you have Java 17 and Maven installed.
3. Run the following command to start the application:

   ```bash
   mvn spring-boot:run
   ```
4. Access the application in your browser at http://localhost:8080.
