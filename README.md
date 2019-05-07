BK CAR API Assignment

*** SPRING BOOT ***

DESCRIPTION: this project is an API handling all basic CRUD operations (RIDERS,DRIVERS,TRIPS) for a taxiAPP,
done using spring boot. 
From the root Directory shared is a reference, a postam collection containing all request needed for all basic methods (POST,GET,PUT,DELETE) 

*** TEST ****

Test implemented in this project are UNIT TESTS, testing all the basic method of my application (create,delete,update,view).

-Used JUnit library to run tests
-Used DBSetup to initialize the database @BEFORE and cleaning @AFTER while tests are being executed.


**** INSTALLATION ****

What things you need to install the software and how to install them

-run the pom.xml file as maven install to install all dependencies 

-Setup a local database called BK_Car_Api the tables creation will be handled by hibernate

-Remember to change database credential in the application properties


**** RUN APPLICATION ****

To run the application once everything is setup head in the com.example.api package and run a class called BkCarApiApplication which basically 
run a springBoot project


