INSERT INTO Flight (from_source,to_destination,travel_date,duration,fare,start_time) VALUES
  ('HYDERABAD', 'BENGALURU','2020-10-18',80,1550,'2020-10-18 06:00:00'),
  ('BENGALURU', 'LUCKNOW','2020-10-17',120,9200,'2020-10-17 12:00:00'),
  ('BENGALURU', 'KOLKATA','2020-10-19',100,6000,'2020-10-19 18:00:00'),
  ('BENGALURU', 'PUNJAB','2020-10-19',150,2000,'2020-10-19 11:00:00'),
  ('HYDERABAD', 'INDORE','2020-10-15',40,1500,'2020-10-15 13:00:00'),
  ('INDORE', 'DELHI','2020-10-16',30,1000,'2020-10-16 17:00:00'),
  ('MUMBAI', 'BENGALURU','2020-10-12',60,1500,'2020-10-12 19:00:00'),
  ('MUMABI', 'DELHI','2020-10-21',50,2000,'2020-10-21 20:00:00'),
  ('INDORE', 'MUMBAI','2020-10-22',70,7400,'2020-10-22 21:00:00'),
  ('LUCKNOW', 'BENGALURU','2020-10-16',100,8000,'2020-10-16 03:00:00'),
  ('PUNJAB', 'KOLKATA','2020-10-19',150,3000,'2020-10-19 04:00:00');

INSERT INTO Bus (from_source,to_destination,travel_date,duration,fare,start_time) VALUES
    ('HYDERABAD', 'BENGALURU','2020-10-18',300,1550,'2020-10-18 06:00:00'),
    ('BENGALURU', 'LUCKNOW','2020-10-17',800,9200,'2020-10-17 12:00:00'),
    ('DELHI', 'KOLKATA','2020-10-19',400,6000,'2020-10-19 18:00:00'),
    ('BENGALURU', 'PUNJAB','2020-10-20',450,9000,'2020-10-20 11:00:00'),
    ('HYDERABAD', 'INDORE','2020-10-15',600,1500,'2020-10-15 13:00:00'),
    ('INDORE', 'DELHI','2020-10-16',500,1000,'2020-10-16 17:00:00'),
    ('MUMBAI', 'BENGALURU','2020-10-12',400,1500,'2020-10-12 19:00:00'),
    ('MUMABI', 'DELHI','2020-10-21',300,2000,'2020-10-21 20:00:00'),
    ('INDORE', 'MUMBAI','2020-10-22',600,7400,'2020-10-22 21:00:00'),
    ('LUCKNOW', 'BENGALURU','2020-10-16',1000,8000,'2020-10-16 03:00:00'),
    ('PATNA', 'BENGALURU','2020-10-14',900,10000,'2020-10-14 04:00:00');

INSERT INTO Passenger(first_name,last_name,email,phone,flight_id,bus_id,is_flight_booked,is_bus_booked) VALUES
      ('Ayush', 'Govil', 'ayush.govil@gmail.com',8375039709,1,1,true,true),
      ('Ankit', 'Kumar', 'ankit.kumar@email.com',8008000801,2,2,false,false),
      ('Rohan', 'Gupta', 'rohan.gupta@gmail.com',4567812345,3,3,true,false),
      ('Shruti','Pandey', 'shruti.pandey@yahoo.com',1234578965,4,4,false,true),
      ('Samidha','Singh','samidha.singh@yahoo.com',9874651232,5,5,true,true);