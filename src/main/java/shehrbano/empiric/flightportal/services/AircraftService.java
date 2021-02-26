package shehrbano.empiric.flightportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shehrbano.empiric.flightportal.dto.AddAircraftDTO;
import shehrbano.empiric.flightportal.entities.Aircraft;
import shehrbano.empiric.flightportal.repositories.AircraftCategoryRepository;
import shehrbano.empiric.flightportal.repositories.AircraftRepository;

import java.util.*;

@Service
@Component
public class AircraftService {

    @Autowired
    AircraftCategoryRepository aircraftCategoryRepository;

    @Autowired
    AircraftRepository aircraftRepository;

    @Autowired
    SeatService seatService;

    public List<Aircraft> getAllAircrafts(){
        List<Aircraft> aircrafts = new ArrayList<>();
        aircrafts= (List<Aircraft>) aircraftRepository.findAll();
        return aircrafts;
    }

    public Optional<Aircraft> getAircraft(int id){
        return aircraftRepository.findById(Integer.toString(id));
    }

    public Aircraft addAircraft(Aircraft aircraft){
       return aircraftRepository.save(aircraft);
    }


    public Aircraft updateAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public void deleteAircraft(String id) {
        aircraftRepository.deleteById(id);
    }

    public Aircraft add44Aircraft(Aircraft aircraft){
        aircraft.setAircraftCategory(aircraftCategoryRepository.findByAircraftCategoryId(aircraft.aircraftCategory.getAircraftCategoryId()));
        Aircraft newAir=aircraftRepository.save(aircraft);
        seatService.createSeatsForAircraft(newAir);
        return newAir;
    }

}

