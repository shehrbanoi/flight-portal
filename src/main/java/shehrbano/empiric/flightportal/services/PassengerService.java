package shehrbano.empiric.flightportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shehrbano.empiric.flightportal.dto.AddBookingDTO;
import shehrbano.empiric.flightportal.entities.Bookings;
import shehrbano.empiric.flightportal.entities.Flights;
import shehrbano.empiric.flightportal.entities.Passengers;
import shehrbano.empiric.flightportal.repositories.BookingRepository;
import shehrbano.empiric.flightportal.repositories.PassengerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingService bookingService;

    public List<Passengers> getAllPassengers(int flightId){
        List<Bookings> bookings= new ArrayList<>();
        bookings = bookingRepository.findByFlightId(flightId);
        List<Passengers>passengers= new ArrayList<>();
        for (Bookings booking: bookings) {
            String id = booking.getPassengers().getPassId();
            Optional<Passengers> passenger;
            passenger=passengerRepository.findById(id);
            passengers.add(passenger.get());
        }
        return passengers;
    }



    public Optional<Passengers> getPassenger(int id){
        return passengerRepository.findById(Integer.toString(id)); }


    public void addPassenger(Passengers passenger){
        passengerRepository.save(passenger); }


    public void updatePassenger( Passengers passenger) {

        passengerRepository.save(passenger);
    }

    public void deletePassenger(String id) {

        passengerRepository.deleteById(id);
    }

   public Passengers addPassToBooking( AddBookingDTO addBookingDTO) {
        Passengers passenger = passengerRepository.findByIdentification(addBookingDTO.getPassengers().getIdentification());
        if (passenger == null) {
            return passengerRepository.save(addBookingDTO.passengers);
        }
        return passenger;


        }

    public List<Passengers> getAllPassengers(){
        List<Passengers> passengers = new ArrayList<>();
        passengers= (List<Passengers>)passengerRepository.findAll();
        return passengers;
    }
}
