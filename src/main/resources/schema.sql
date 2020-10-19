DROP TABLE IF EXISTS Flight;

CREATE TABLE Flight (
  flight_id INT AUTO_INCREMENT  PRIMARY KEY,
  from_source VARCHAR(250) NOT NULL,
  to_destination VARCHAR(250) NOT NULL,
  travel_date DATE NOT NULL,
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