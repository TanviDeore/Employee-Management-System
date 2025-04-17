# Employee Management System

A Java-based desktop application for managing employee records using CRUD operations with a Swing GUI and Hibernate ORM.

## Features

- Add new employees
- View existing employees
- Update employee information
- Delete employee records
- Intuitive GUI using Java Swing
- Database integration via Hibernate

## Technologies Used

- Java
- Java Swing (GUI)
- Hibernate (ORM)
- MySQL (or other JDBC-compatible DB)

## Project Structure

- `MainFrame.java`: Entry point with navigation buttons.
- `AddFrame.java`, `UpdateFrame.java`, `DeleteFrame.java`, `ViewFrame.java`: Individual windows for each operation.
- `Employee.java`: Model class for employee entity.
- `hibernate.cfg.xml`: Hibernate configuration (expected).
- `hibernatejar/`: Directory containing Hibernate and JDBC JARs.

## Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/TanviDeore/Employee-Management-System.git
2. Open in IDE Open the project in IntelliJ or Eclipse.

3. Add JARs
    Include all .jar files from hibernatejar/ in your classpath.

4. Configure Database
    Set your database credentials in hibernate.cfg.xml.
    Ensure the Employee table exists or let Hibernate auto-create it.

5. Run the application
    Execute MainFrame.java to start the GUI.
