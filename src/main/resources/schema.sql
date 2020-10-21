DROP TABLE IF EXISTS Flight;

CREATE TABLE Flight (
  flightId INT AUTO_INCREMENT  PRIMARY KEY,
  fromSource VARCHAR(250) NOT NULL,
  toDestination VARCHAR(250) NOT NULL,
  travelDate DATE NOT NULL,
  duration INT NOT NULL,
  fare DOUBLE NOT NULL,
  startTime TIMESTAMP NOT NULL
);

DROP TABLE IF EXISTS Bus;

CREATE TABLE Bus (
  busId INT AUTO_INCREMENT  PRIMARY KEY,
  fromSource VARCHAR(250) NOT NULL,
  toDestination VARCHAR(250) NOT NULL,
  travelDate DATE,
  duration INT NOT NULL,
  fare DOUBLE NOT NULL,
  startTime TIMESTAMP NOT NULL
);

DROP TABLE IF EXISTS Passenger;

CREATE TABLE Passenger (
    passengerId INT AUTO_INCREMENT PRIMARY KEY,
    emailId VARCHAR(250) NOT NULL,
    firstName VARCHAR(250) NOT NULL,
    lastName VARCHAR(250) NOT NULL
);

CREATE TABLE Booking (
    bookingId INT AUTO_INCREMENT PRIMARY KEY,
    passengerId INT NOT NULL,
    fromSource VARCHAR(250) NOT NULL,
    toDestination VARCHAR(250) NOT NULL,
    flightId INT NOT NULL,
    busId INT NOT NULL,
    flightStatus VARCHAR(250) NOT NULL,
    busStatus VARCHAR(250) NOT NULL,
    FOREIGN KEY (passengerId) REFERENCES Passenger(passengerId)
)