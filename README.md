# Employee Management Application

This is a basic Spring Boot application to manage employees. You can add, view, update, and delete employee records.

## How It Works

1. **Main Application**: The main file that runs the app is `EmpdemoApplication.java`.
2. **Employee**: The `Employee.java` file represents the employee data (like a table in a database).
3. **Repository**: The `EmployeeRepository.java` file contains methods to interact with the database.
   - Includes methods for CRUD operations.
   - Uses JPQL (Java Persistence Query Language) for custom queries.
4. **Tests**: The `EmpdemoApplicationTests.java` file has tests to check if everything is working properly.

## Setting It Up

1. **Database Configuration**: 
   - Make sure you have MySQL installed.
   - Create a database named `empdb`.
   - Update the `application.properties` file with your MySQL details:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/empdb
     spring.datasource.username=root
     spring.datasource.password=test
     ```

2. **Running the Application**:
   - Open your terminal.
   - Navigate to the project directory.
   - Run the following command:

     ```bash
     ./mvnw spring-boot:run
     ```

## What You Can Do

- **Add Employee**: Save new employee records.
- **View Employees**: Retrieve existing employee records.
- **Update Employee**: Modify existing employee records.
- **Delete Employee**: Remove employee records.

## JPQL and Hibernate

### JPQL (Java Persistence Query Language)
- JPQL is used in `EmployeeRepository.java` to define custom queries.
- It allows querying the database using Java objects instead of SQL tables.
- Examples include finding employees by email, mobile number, or both.

### Hibernate
- Hibernate is the ORM (Object-Relational Mapping) framework used to interact with the MySQL database.
- It automatically handles the mapping between Java objects and database tables, making database operations more seamless.

## Testing the Application

The `EmpdemoApplicationTests.java` file contains tests to ensure everything works as expected.
