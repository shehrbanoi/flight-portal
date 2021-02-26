package shehrbano.empiric.flightportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shehrbano.empiric.flightportal.dto.AddBookingDTO;
import shehrbano.empiric.flightportal.entities.Bookings;
import shehrbano.empiric.flightportal.entities.Passengers;
import shehrbano.empiric.flightportal.repositories.BookingRepository;
import shehrbano.empiric.flightportal.repositories.PassengerRepository;

import java.util.*;

@Service
@Component
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public List<Bookings> getAllBookings(){
        List<Bookings> bookings = new ArrayList<>();
        bookings= (List<Bookings>) bookingRepository.findAll();
        return bookings;
    }

    public Optional<Bookings> getBooking(int id){
        return bookingRepository.findById(Integer.toString(id));
    }


    public Bookings addBooking(AddBookingDTO addBookingDTO){
        Passengers newPass = passengerRepository.save(addBookingDTO.passengers);
        Bookings book = addBookingDTO.getBooking();
        book.setPassengers(newPass);
        return bookingRepository.save(book);
    }


    public Bookings updateBooking(Bookings booking) {
       return bookingRepository.save(booking);
    }

    public void deleteBooking(String id) {
        bookingRepository.deleteById(id);
    }
}
