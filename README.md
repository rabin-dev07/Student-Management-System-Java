# Student Management System (Java + MySQL)

A console-based Student Management System built using Java and JDBC with MySQL database integration.

## Features
- Add Student
- View All Students
- Update Student
- Delete Student

## Technologies Used
- Java (JDK 21)
- JDBC
- MySQL
- IntelliJ IDEA
- Git & GitHub

## Database Schema

```sql
CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100)
);
