DROP TABLE IF EXISTS Flight;

CREATE TABLE Flight (
  flight_id INT AUTO_INCREMENT  PRIMARY KEY,
  from_source VARCHAR(250) NOT NULL,
  to_destination VARCHAR(250) NOT NULL,
  travel_date DATE,
  duration INT NOT NULL,
  fare DOUBLE NOT NULL,
  start_time TIMESTAMP NOT NULL
);

DROP TABLE IF EXISTS Bus;

CREATE TABLE Bus (
  bus_id INT AUTO_INCREMENT  PRIMARY KEY,
  from_source VARCHAR(250) NOT NULL,
  to_destination VARCHAR(250) NOT NULL,
  travel_date DATE,
  duration INT NOT NULL,
  fare DOUBLE NOT NULL,
  start_time TIMESTAMP NOT NULL
);

DROP TABLE IF EXISTS Passenger;

CREATE TABLE Passenger (
  passenger_id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  phone VARCHAR(250) NOT NULL,
  flight_id INT NOT NULL,
  bus_id INT NOT NULL,
--  flight_id INT FOREIGN KEY REFERENCES Flight(flight_id),
--  bus_id INT FOREIGN KEY REFERENCES Bus(bus_id),
  is_flight_booked Boolean,
  is_bus_booked Boolean,
--  foreign key (flight_id) references Flight(flight_id),
--  foreign key (bus_id) references Bus(bus_id)
);