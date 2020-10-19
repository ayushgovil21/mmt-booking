MMT Booking Application

Spring Boot App that shows REST API development using Spring MVC, Spring Data JPA using Java 8 features.

Problem Statement

Module1: Cheapest Route
 Develop a service to recommend cheapest routes for a customer looking to go
from a source to a destination for a given date.
 Following pointers to be considered:
• Reachability has to be considered. If route is not possible between source and
the destination, then you can choose to show routes not found or any
suggestion is welcome. We are open for ideas.
• Recommended routes could be a combination of different flights and buses.

Features

This application has a rest end point that provides cheapest routes between source and destination via flights and buses.

GET /findBookings

Assumptions

There can be at max 1 stop between a source and destination.

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
After running the application, the H2 console can be accessed using http://localhost:8080/console and putting "jdbc:h2:mem:testdb" in JDBC URL to connect with default username as sa and password as "".

Testing

A Spring Boot Test is also provided which confirms the validity of the API.



