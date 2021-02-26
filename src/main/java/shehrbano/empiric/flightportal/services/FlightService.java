package shehrbano.empiric.flightportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shehrbano.empiric.flightportal.entities.Flights;
import shehrbano.empiric.flightportal.repositories.FlightRepository;

import java.util.*;

@Service
@Component
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<Flights> getAllFlights(){
        List<Flights> flights = new ArrayList<>();
        flights= (List<Flights>) flightRepository.findAll();
        return flights;
    }

    public Optional<Flights> getFlight(int id){

        return flightRepository.findById(Integer.toString(id));
    }

    public Flights addFlight(Flights flight){

        return flightRepository.save(flight);
    }


    public Flights updateFlight(Flights flight) {
       return  flightRepository.save(flight);

    }

    public void deleteFlight(String id) {
        flightRepository.deleteById(id);
    }
}
