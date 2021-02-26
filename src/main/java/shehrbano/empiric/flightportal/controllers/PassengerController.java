package shehrbano.empiric.flightportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shehrbano.empiric.flightportal.dto.AddBookingDTO;
import shehrbano.empiric.flightportal.dto.GetFlightDTO;
import shehrbano.empiric.flightportal.entities.Aircraft;
import shehrbano.empiric.flightportal.entities.Bookings;
import shehrbano.empiric.flightportal.services.PassengerService;
import shehrbano.empiric.flightportal.entities.Passengers;

import java.util.List;
import java.util.Optional;

@RestController
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @RequestMapping("/passengers")
    public List<Passengers> getAllPassengers(){
        return passengerService.getAllPassengers();
    }

    @RequestMapping(method=RequestMethod.POST, value="/passengers/getPassengersByFlightId")
    public Optional<Passengers> getAllPassengers(@RequestBody GetFlightDTO getFlightDTO){
        return passengerService.getPassenger(getFlightDTO.id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/passengers/addPassenger")
    public void addPassenger(@RequestBody Passengers passenger){
        passengerService.addPassenger(passenger);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/passengers/addPassengerToBooking")
    public void addPassToBooking(@RequestBody AddBookingDTO addBookingDTO){
        passengerService.addPassToBooking(addBookingDTO);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/passengers/updatePassenger")
    public void updatePassenger(@RequestBody Passengers passenger){
        passengerService.updatePassenger(passenger);
    }



    @RequestMapping(method=RequestMethod.DELETE, value="/passengers/deletePassengerbyId")
    public void deletePassenger(@RequestBody Passengers passenger){
        passengerService.deletePassenger(passenger.passId);
    }



}
