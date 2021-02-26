package shehrbano.empiric.flightportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import shehrbano.empiric.flightportal.dto.GetAircraftDTO;
import shehrbano.empiric.flightportal.dto.GetSeatDTO;
import shehrbano.empiric.flightportal.entities.Aircraft;
import shehrbano.empiric.flightportal.entities.Flights;
import shehrbano.empiric.flightportal.entities.Seats;
import shehrbano.empiric.flightportal.services.PassengerService;
import shehrbano.empiric.flightportal.entities.Passengers;
import shehrbano.empiric.flightportal.services.SeatService;

import java.util.List;
import java.util.Optional;

@RestController
public class SeatController {

    @Autowired
    private SeatService seatService;

    @RequestMapping("/seats")
    public List<Seats> getAllSeats(){
        return seatService.getAllSeats();
    }


    @RequestMapping(method=RequestMethod.POST, value="/seats/getSeatById")
    public Optional<Seats> getSeat(@RequestBody GetSeatDTO getSeatDTO){
        return seatService.getSeat(getSeatDTO.id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/seats/addSeat")
    public Seats addSeat(@RequestBody Seats seat){
        return seatService.addSeat(seat);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/seats/updateSeat")
    public Seats updateSeat(@RequestBody Seats seat){
        return seatService.updateSeat(seat);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/seats/deleteSeatById")
    public void deleteSeat(@RequestBody Seats seat){
        seatService.deleteSeat(seat.seatId);
    }

    @RequestMapping(method= RequestMethod.POST, value="/seats/getAircraftSeatsById")
    public List<Seats> getAircraftSeats(@RequestBody GetAircraftDTO getAircraftDTO){
        return seatService.getAircraftSeats(getAircraftDTO.id);
    }
}