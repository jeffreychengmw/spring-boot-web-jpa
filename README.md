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

Program Install and Execution
+ go to the project root
+ mvn clean package
+ find the jar in /target folder
+ fire command "java -jar [jar file name]" to execute the application

API Entry

| Method Mapping | Path | Description  |
| :------------- | :------------- | :------------- |
| GetMapping       | / | list all users |
| GetMapping       | /id/{id} | retrieve a single user by id |
| GetMapping       | /username/{username:.+} | retrieve a single user by username empowered by regular expression |





Global Exception Handler

| Http Status Code | Backend Response Code |
| :------------- | :------------- |
| Item One       | Item Two       |
