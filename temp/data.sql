
INSERT INTO AIRCRAFT(aircraft_,
                         model_,
                         seats_,
                         built_,
                         service_) VALUES('A320', 'Airbus', '180', 2009, '06/01/2019');
INSERT INTO AIRCRAFT(aircraft_,
                         model_,
                         seats_,
                         built_,
                         service_) VALUES ('B747', 'Boeing', 210, 2017, '10/15/2018');
INSERT INTO AIRCRAFT(aircraft_,
                     model_,
                     seats_,
                     built_,
                     service_) VALUES ('A730', 'Boeing', 210, 2017, '10/15/2018');

INSERT INTO FLIGHTS(flights,
                    fro,
                    too,
                    dep,
                    drr,
                    aircraft) VALUES('KHI', 'LHR', '0930', '1130', 'A320', 1);

INSERT INTO SEATS (aircraft_,row_,seat_,type_,class_) VALUES
( 1, 1, 'A', 'Window', 'First');


INSERT INTO BOOKINGS(
    Flight_,
    Datim,
    Passenger_,
    Row_,
    Seat_,
    BookingId_) VALUES(1, '10/01/19', 'Shehrbano', '12', 1, 'CNIC123');

//INSERT INTO BOOKINGS(
                     // Flight_,
                    //    Datim,
                    //    Passenger_,
                      //  Row_,
                     //   Seat_,
                      //  BookingId_) VALUES ('909', '14/01/20', 'Empiric', '5', 'B', 'CNIC234');
//INSERT INTO BOOKINGS(Flight_,Datim,Passenger_, Row_,Seat_,BookingId_,) VALUES ('909', '10/04/21', 'AI', '15', 'C', 'CNIC321');

