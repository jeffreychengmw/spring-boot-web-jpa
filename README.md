# **spring-boot-web-jpa-rest**
###### DEMO Restful Spring Boot Application employs MVC and JPA

| Development Environment | Version |
| :------------- | :------------- |
| Java | 8 |
| Spring Boot | 2.0.0.M7 |
| STS | 3.9.2 |
| JPA | Spring Boot Managed Version |
| Web | Spring Boot Managed Version |
| MySQL connector | Spring Boot Managed Version |

### &#x1f4d8; Table of Contents
+ [Summary](#summary)
+ [JIRA Epics](#jiraEpics)
+ [Version](#version)
+ [Application Details](#applicationDetails)
+ [Application Specification Mapping](#applicationSpecificMapping)
+ [Global Exception Handler](#globalExceptionHandler)
+ [Program Installation And Execution](#programInstallationAndExecution)

<a name="summary"></a>
### Summary
Demo Restful Spring Boot Application employs Spring Boot starter auto-configuration with web, jpa, thymeleaf and mysql-connector.

This demo will demonstrate various jpa functions, such as findAll(), findById(), findBy[Bean Variable Name](), save() etc.

+ API Type: Restful API
+ Base URI: /
+ Key Authors: Jeffrey M W Cheng
+ Author's Email: 2653399478@qq.com

<a name="jiraEpics"></a>
### JIRA Epics
+ [MYITLearning - Spring Boot 2 Tutorials](http://www.hivesplace.com:8081/browse/MYIT-1)

<a name="version"></a>
### Version
**0.0.1**
+ Initial Development based on **Beginning Spring Boot 2: Applications and Microservices with the Spring Framework** *K. Siva Prasad Reddy* **APRESS @ 2017** *ISBN-13 (pbk): 978-1-4842-2930-9*

<a name="applicationDetails"></a>
### Application Details
API Methods

| Method Type | Path | Description  |
| :------------- | :------------- | :------------- |
| Get | / | list all users |
| Get | /id/{id} | retrieve a single user by id |
| Get | /username/{username:.+} | retrieve a single user by username accepting dot(.) in the url path |
| Post | /createUser | create a user |

<a name="applicationSpecificMapping"></a>
### Application Specific Mapping

| API Path | HTTP Status Code | Backend HTTP Response Code | Backend Response Code | Backend Response Message |
| :------------- | :------------- | :------------- | :------------- | :------------- |
| / | 200 | 200 | NA | [{"id":8,"username":"jeffrey@qq.com","password":"zdsaew756o87@!","status":1},{"id":14,"username":"jeffreycheng123@gmail.com","password":"rjfgrh9483n9fw84@31","status":1},{"id":13,"username":"jeffreycheng5@gmail.com","password":"rjfgrh9483n9fw84@31","status":1},{"id":4,"username":"jeffreycheng65@gmail.com","password":"rjfgrh9483n9fw84@31","status":1}] |
| / | 404 | 404 | 404 | Error message handled by Global Exception Handler |
| /id/{id} | 200 | 200 | 200 | {"id":1,"username":"jeffreycheng@gmail.com","password":"uy76tfyft5c75e@hg*","status":1} |
| /id/{id} | 404 | 404 | 404 | No user found with the id: ${id}) |
| /username/{username:.+} | 200 | 200 | 200 | {"id":8,"username":"jeffrey@qq.com","password":"zdsaew756o87@!","status":1} |
| /username/{username:.+} | 404 | 404 | 404 | No user found with user name: ${username}) |
| /createUser | 200 | 201 | 201 | {"id":23,"username":"hivesplace@gmail.com","password":"89uhu1ntu567","status":1} |
| /createUser | 400 | 400 | 400 | Error message handled by Global Exception Handler |
| /createUser | 409 | 409 | 409 | Error message handled by Global Exception Handler |

<a name="globalExceptionHandler"></a>
### Global Exception Handler

| API Path | Backend Response Error Code | Error Description | Backend Response Error Message |
| :------------- | :------------- | :------------- |
| / | 400 | Bad Request | ServletRequestBindingException message |
| /id/{id} | 404 | Resources Not Found | RuntimeException message |
| /username/{username:.+} | 404 | Resources Not Found | RuntimeException message |
| /createUser | 409 | Request Conflict with Existing Resources | RuntimeException message |
| [ALL API PATH] | 500 | Internal Server Error | Exception message |

<a name="programInstallationAndExecution"></a>
### Program Installation and Execution
+ setup a local MySQL server with database name "spring_boot_2_tutorial"
+ uncomment "Initialize database by executing /resources/data.sql" and "spring.datasource.initialization-mode=always" in application.properties in src/main/resources folder
+ Standard Spring Boot application installation and execution process
    + mvn clean package
    + fire command "java -jar [jar file name]" to execute the application
+ open browser/postman @ http://localhost:8080 to test all API Methods
