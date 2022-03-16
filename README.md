# Menu Microservice
This is a Java based Menu Service which consists an API set for Getting, Syncing and Updating Menu and ProductStock in Restaurants.


#### Used Frameworks and Technologies:
Spring Boot - Spring Web - Spring Data - SpringBootTest, Hibernate - Gradle - Log4J2 , Mockito and junit


#### Database:
mySql


#### Layers:
API (Rest Controllers), Service (Business), Repository (Data Persistence), Domain (Model) and ExceptionHandler

## Build and Run Project
In order to start the project please follow the Instructions below :\
1- install mySql Service and create database with name: menudb then set the connection settings in application.properties file in Resource directory. (I have used mySql Version 8.0.27.1)\
2- Open the Project in IntelliJ Idea (Or any other IDE) this project is developed in IntelliJIdea\
3- Build the source code via Gradle\
4- Run the project By creating a Spring Boot-Run configuration\ Or you can terigger it by clicking on bootRun in Gradle
5- Use Provided PostMan Collection to testing the functionality of MicroService
6- All the required specification are done completely int this Microservice

## Outstanding Features and Interesting Specifications in Implementation:
there are many good Ideas that have made this project extensible, scalable like:
#### 1- Domain Driven Design 
#### 2- Solid and Clean Code
#### 3- Multi Layers Structure working around a Core Domain
#### 4- Comprehensive Backend: Restfull Api set for Managing Shared Menus, Updating ProductStock and Getting and Syncing The previous Menus
#### 5- Having Integration test for Service Layer (because It is a risky layer)
#### 6- Having Customised Exception Handlers For Api set
#### 7- Comprehensive Logging into Console and LogFile for All layers. 

* note: To get an overview of the structure and architecture please have a look at the Design folder content inside Zip file.

### Hope it will be satisfying :)
#### Feel free to ask any question regarding running the project.
#### Arman.heydarian@gmail.com

Best Regards.
