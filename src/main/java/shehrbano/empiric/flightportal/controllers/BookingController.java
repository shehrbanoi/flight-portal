package shehrbano.empiric.flightportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shehrbano.empiric.flightportal.dto.AddBookingDTO;
import shehrbano.empiric.flightportal.dto.GetAircraftDTO;
import shehrbano.empiric.flightportal.dto.GetBookingDTO;
import shehrbano.empiric.flightportal.entities.Aircraft;
import shehrbano.empiric.flightportal.entities.Bookings;
import shehrbano.empiric.flightportal.entities.Flights;
import shehrbano.empiric.flightportal.services.AircraftService;
import shehrbano.empiric.flightportal.services.BookingService;
import shehrbano.empiric.flightportal.services.PassengerService;
import shehrbano.empiric.flightportal.entities.Passengers;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private PassengerService passengerService;

    @RequestMapping("/bookings")
    public List<Bookings> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @RequestMapping(method=RequestMethod.POST, value="/bookings/getABookingsById")
    public Optional<Bookings> getBooking(@RequestBody GetBookingDTO getBookingDTO){
        return bookingService.getBooking(getBookingDTO.id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/bookings/addBooking")
    public Bookings addBooking(@RequestBody AddBookingDTO addBookingDTO){
        return bookingService.addBooking(addBookingDTO);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/bookings/updateBooking")
    public Bookings updateBooking(@RequestBody Bookings booking){

        return bookingService.updateBooking(booking);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/bookings/deleteBookingById")
    public void deleteBooking(@RequestBody Bookings booking){
        bookingService.deleteBooking(booking.bookingId);
    }


}
