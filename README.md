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

### Improvements
* Should use external database such MySql instead of H2 file
* Todo APIs can be expanded for showing history of Todo
* Allow sharing of Todo between users

### Reference Documentation
* [Spring Security for a REST API](https://www.baeldung.com/securing-a-restful-web-service-with-spring-security)
* [Retrieve User Information in Spring Security](https://www.baeldung.com/get-user-in-spring-security)
* [Encrypt User Password with Spring Security](http://appsdeveloperblog.com/encrypt-user-password-with-spring-security/)

### Authors:
Kevin Fan ([KevFan](https://github.com/KevFan))

### Version/Date:
16th June 2019

