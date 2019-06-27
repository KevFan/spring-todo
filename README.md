# Spring Todo 
This is a spring app that provides basic CRUD APIs for Todos with user creation and authentication APIs.
Routes for the todo APIs are secured via JWT and must be supplied in the Authentication request header.

### Features
* User 
  * Create API - unsecured
  * Authentication API - unsecured
* Todo CRUD Secured API for current logged in user
* Secured APIs routes via JWT
* H2 Database persistent to file

### How to run application
```yaml
# Ensure docker has been installed
docker run -p 8080:8080 --name spring-todo-docker -t kevfan11/spring-todo-docker 
```
or 
```yaml
git clone {repo}
cd spring-todo
./gradlew bootRun
```
Application would be then served on `http://localhost:8080`

### How to run tests
```yaml
 ./gradlew test jacocoTestReport
```
This would run the tests and generate a test code coverage report to `build/reports/jacoco/test/html/index.html`

### How to build docker image
```yaml
 ./gradlew build docker
```
This would build a local docker image with the repository name `kevfan11/spring-todo-docker`

### API 
[API.md](API.md) for available APIs.

### Improvements
* Should use external database such MySql instead of H2 file
* Todo APIs can be expanded for showing history of Todo
* Allow sharing of Todo between users

### Reference Documentation
* [Spring Security for a REST API](https://www.baeldung.com/securing-a-restful-web-service-with-spring-security)
* [Retrieve User Information in Spring Security](https://www.baeldung.com/get-user-in-spring-security)
* [Encrypt User Password with Spring Security](http://appsdeveloperblog.com/encrypt-user-password-with-spring-security/)
* [Spring Boot with Docker](https://spring.io/guides/gs/spring-boot-docker/)

### Authors:
Kevin Fan ([KevFan](https://github.com/KevFan))

### Version/Date:
16th June 2019

