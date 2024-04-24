# Employee-Assessment-REST-Service
<p><strong>Employee Assessment REST Service</strong></p>

<p><strong>Overview:</strong><br />
The &quot;Employee Assessment REST Service&quot; is a Spring Boot project developed to manage employee information through a secure and efficient RESTful API. The project incorporates role-based authentication, allowing users to access different functionalities based on their roles. Admin users have the authority to create and delete employee records, while regular users can view employee information. Authentication is facilitated via JWT tokens to ensure secure communication and request validation.</p>

<p><strong>Key Features:</strong><br />
<strong>Authentication and Authorization:</strong><br />
Users can authenticate using role-based access control (RBAC) via the /authentication endpoint.<br />
Admin and user roles are defined, with distinct privileges for each role.<br />
Authentication tokens (JWT) are provided upon successful authentication for subsequent request validation.</p>

<p><strong>Employee Management:</strong><br />
Admin users can add new employee records using the /admin/add-employee endpoint, providing details such as name, email, and department.<br />
Admins also have the ability to delete employee records using the /admin/delete-employee/{employeeId} endpoint, where {employeeId} represents the unique identifier of the employee to be deleted.<br />
Regular users can retrieve employee information using the /employees endpoint to get a list of all employees or the /employees/{employeeId} endpoint to retrieve details of a specific employee by ID.</p>

<p><strong>RESTful API:</strong><br />
The project follows RESTful principles, providing well-defined endpoints for seamless interaction.<br />
Each endpoint is secured with JWT-based authorization to ensure only authenticated users can access the functionality.</p>

<p><strong>Resilience and Performance:</strong><br />
Resilience4j is implemented for rate limiting to enhance the project&#39;s resilience and performance under varying load conditions.<br />
Rate limiting prevents excessive API requests, while circuit breaking helps maintain system stability by handling failures gracefully.</p>

<p><strong>Technologies Used:</strong></p>

<ul>
	<li>&nbsp;&nbsp; &nbsp;Java Spring Boot: For building the RESTful API and handling business logic.</li>
	<li>&nbsp;&nbsp; &nbsp;Spring Security: For implementing authentication and authorization features.</li>
	<li>&nbsp;&nbsp; &nbsp;JSON Web Tokens (JWT): For secure communication and request validation.</li>
	<li>&nbsp;&nbsp; &nbsp;PostgreSQL Database: For storing employee information persistently.</li>
	<li>&nbsp;&nbsp; &nbsp;Resilience4j: For rate limiting and circuit breaking to improve system resilience.</li>
</ul>

<p><strong>Conclusion:</strong><br />
The &quot;Employee Assessment REST Service&quot; project offers a robust solution for managing employee information securely and efficiently through a RESTful API. With features such as role-based authentication, JWT validation, and resilience mechanisms, the project ensures data integrity, confidentiality, and system stability.</p>


<h2 style="text-align:center"><strong><u>API Endpoints</u></strong></h2>

<h3><strong>Authentication:</strong></h3>

<ul>
	<li><strong>URL:</strong> <a href="http://localhost:8081/eas/api/v1/authentication" target="_new">http://localhost:8081/eas/api/v1/authentication</a></li>
	<li><strong>Method:</strong> POST</li>
	<li><strong>Request Body (Admin Role):</strong><br />
	json -<br />
	{<br />
	&nbsp; &quot;userName&quot;: &quot;user1&quot;,<br />
	&nbsp; &quot;password&quot;: &quot;1234&quot;<br />
	}</li>
	<li><strong>Request Body (User Role):</strong><br />
	json<br />
	{<br />
	&nbsp; &quot;userName&quot;: &quot;user2&quot;,<br />
	&nbsp; &quot;password&quot;: &quot;1234&quot;<br />
	}<br />
	&nbsp;</li>
</ul>

<h3><strong>Add Employee:</strong></h3>

<ul>
	<li><strong>URL:</strong> <a href="http://localhost:8081/eas/api/v1/admin/add-employee" target="_new">http://localhost:8081/eas/api/v1/admin/add-employee</a></li>
	<li><strong>Method:</strong> POST</li>
	<li><strong>Request Body:</strong><br />
	json<br />
	{<br />
	&nbsp; &quot;name&quot;: &quot;Demo Name&quot;,<br />
	&nbsp; &quot;email&quot;: &quot;demo@gmail.com&quot;,<br />
	&nbsp; &quot;department&quot;: &quot;Demo Department&quot;<br />
	}</li>
	<li><strong>Headers:<br />
	Key:</strong> Authorization<br />
	<strong>Value:</strong>&nbsp;<span style="font-size:11px">EzNzgwMTQ2fQ JhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTcxMjk4NjA5NSwiaWF0IjoxNzEyODk5Njk1fQ.Y4vI6mKFbuNOTIWgmWIesqBdDRt2439RO2yZxqfCqpk</span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</li>
</ul>

<h3><strong>Delete Employee:</strong></h3>

<ul>
	<li><strong>URL:</strong> <a href="http://localhost:8081/eas/api/v1/admin/delete-employee/133" target="_new">http://localhost:8081/eas/api/v1/admin/delete-employee/133</a></li>
	<li><strong>Method:</strong> DELETE</li>
	<li><strong>Headers:</strong><br />
	<strong>Key:</strong> Authorization<br />
	<strong>Value:</strong>&nbsp;<span style="font-size:11px">EzNzgwMTQ2fQ JhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTcxMjk4NjA5NSwiaWF0IjoxNzEyODk5Njk1fQ.Y4vI6mKFbuNOTIWgmWIesqBdDRt2439RO2yZxqfCqpk</span>&nbsp;</li>
</ul>

<h3><strong>Get Employee By ID:</strong></h3>

<ul>
	<li><strong>URL:</strong> <a href="http://localhost:8081/eas/api/v1/employees/133" target="_new">http://localhost:8081/eas/api/v1/employee/133</a></li>
	<li><strong>Method:</strong> GET</li>
	<li><strong>Headers:</strong><br />
	<strong>Key:</strong> Authorization<br />
	<strong>Value:</strong>&nbsp;<span style="font-size:11px">EzNzgwMTQ2fQ JhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTcxMjk4NjA5NSwiaWF0IjoxNzEyODk5Njk1fQ.Y4vI6mKFbuNOTIWgmWIesqBdDRt2439RO2yZxqfCqpk</span>&nbsp;</li>
</ul>

<h3><strong>Get All Employees:</strong></h3>

<ul>
	<li><strong>URL:</strong> <a href="http://localhost:8081/eas/api/v1/employees" target="_new">http://localhost:8081/eas/api/v1/employees</a></li>
	<li><strong>Method:</strong> GET</li>
	<li><strong>Headers:<br />
	Key:</strong> Authorization<br />
	<strong>Value:</strong>&nbsp;<span style="font-size:11px">EzNzgwMTQ2fQ JhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTcxMjk4NjA5NSwiaWF0IjoxNzEyODk5Njk1fQ.Y4vI6mKFbuNOTIWgmWIesqBdDRt2439RO2yZxqfCqpk</span>&nbsp;</li>
</ul>
