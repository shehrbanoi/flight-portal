package shehrbano.empiric.flightportal.dto;

import lombok.Data;
import shehrbano.empiric.flightportal.entities.Bookings;
import shehrbano.empiric.flightportal.entities.Passengers;


@Data
public class AddBookingDTO {

    public Bookings booking;
    public Passengers passengers;




}
