MMT Booking Application

Spring Boot App that shows REST API development using Spring MVC, Spring Data JPA using Java 8 features.

Problem Statement

A microservice that would recommend cheapest routes for a customer to go from a source to a destination for a given date.
The recommended routes will be shown for both modes of transport - flights and buses. All the possible routes from the 
source to the destination will be displayed in the increasing order of the price of the ticket for both flights and buses.

Assumption:

1)There won't be more than 1 stop between a source and a destination.

2)Booking with both Flight and bus together from one source to one destination with stops won't be populated in the cheapest route possible list.

Features

This application has 2 rest end points:- 

1) GET /findBookings - Provides a list of all the cheapest routes between source and destination via flights and buses separately.
2) POST /addBookings - Books a flight and bus for a passenger who provides his/her details with the source,destination,departure date and mode of transport details.

How to Start and Use

1) git clone https://github.com/ayushgovil21/mmt-booking.git
2) Run Application.java inside src/main/java

Tech Stack

->Java8
->Spring Boot
->H2 Database
->Junit
->Maven

Database

The application uses H2(in-memory) database. Data and Schema are provided in data.sql and schema.sql files.
After running the application, the H2 console can be accessed using http://localhost:8080/console and putting "jdbc:h2:mem:testdb" in JDBC URL 
to connect with default username as sa and password as "".

Testing

A Spring Boot Test is also provided which confirms the validity of the find booking API.
