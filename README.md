# Employee-Assessment-REST-Service

Overview:<br>
The "Employee Assessment REST Service" is a Spring Boot project developed to manage employee information through a secure and efficient RESTful API. The project incorporates role-based authentication, allowing users to access different functionalities based on their roles. Admin users have the authority to create and delete employee records, while regular users can view employee information. Authentication is facilitated via JWT tokens to ensure secure communication and request validation.
<br>
Key Features:
<br>
Authentication and Authorization:<br>
Users can authenticate using role-based access control (RBAC) via the /authentication endpoint.
Admin and user roles are defined, with distinct privileges for each role.
Authentication tokens (JWT) are provided upon successful authentication for subsequent request validation.<br>
Employee Management:<br>
Admin users can add new employee records using the /admin/add-employee endpoint, providing details such as name, email, and department.<br>
Admins also have the ability to delete employee records using the /admin/delete-employee/{employeeId} endpoint, where {employeeId} represents the unique identifier of the employee to be deleted.<br>
Regular users can retrieve employee information using the /employees endpoint to get a list of all employees or the /employees/{employeeId} endpoint to retrieve details of a specific employee by ID.<br>
RESTful API:<br>
The project follows RESTful principles, providing well-defined endpoints for seamless interaction.
Each endpoint is secured with JWT-based authorization to ensure only authenticated users can access the functionality.<br>
Resilience and Performance:<br>
Resilience4j is implemented for rate limiting and circuit breaking to enhance the project's resilience and performance under varying load conditions.<br>
Rate limiting prevents excessive API requests, while circuit breaking helps maintain system stability by handling failures gracefully.<br>
Technologies Used:
<br>
Java Spring Boot: For building the RESTful API and handling business logic.<br>
Spring Security: For implementing authentication and authorization features.<br>
JSON Web Tokens (JWT): For secure communication and request validation.<br>
PostgreSQL Database: For storing employee information persistently.<br>
Resilience4j: For rate limiting and circuit breaking to improve system resilience.<br>
Future Enhancements:
<br>
Integration with additional authentication providers for enhanced flexibility and security.<br>
Implementation of more granular access control and permission management for finer role-based authorization.<br>
Continuous monitoring and optimization of performance to ensure scalability and reliability.<br>
Conclusion:<br>
The "Employee Assessment REST Service" project offers a robust solution for managing employee information securely and efficiently through a RESTful API. With features such as role-based authentication, JWT validation, and resilience mechanisms, the project ensures data integrity, confidentiality, and system stability.
