package shehrbano.empiric.flightportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shehrbano.empiric.flightportal.entities.*;
import shehrbano.empiric.flightportal.repositories.AircraftCategoryRepository;
import shehrbano.empiric.flightportal.repositories.AircraftRepository;
import shehrbano.empiric.flightportal.repositories.SeatRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class AircraftCategoryService {

    @Autowired
    AircraftCategoryRepository aircraftCategoryRepository;
    @Autowired
    SeatService seatService;
    @Autowired
    AircraftRepository aircraftRepository;
    @Autowired
    SeatRepository seatRepository;

    public List<AircraftCategory> getAllAircraftCategoryTypes(){
        List<AircraftCategory> aircraftCats = new ArrayList<>();
        aircraftCats= (List<AircraftCategory>) aircraftCategoryRepository.findAll();
        return aircraftCats;
    }
    public Optional<AircraftCategory> getAircraftCatById(int id) {
        return aircraftCategoryRepository.findById(Integer.toString(id));
    }

    public AircraftCategory updateAircraftCategory(AircraftCategory aircraftCategory) {
        return aircraftCategoryRepository.save(aircraftCategory);
    }

    public void deleteAircraftCategory(String id) {
      aircraftCategoryRepository.deleteById(id);
    }


    public AircraftCategory addAircraftCategory(AircraftCategory aircraftCategory) {
        return aircraftCategoryRepository.save(aircraftCategory);
    }
    }


   /* public Optional<Aircraft> getAircraftSeats(int id){
        aircraftCategoryRepository.findById(id);
        noOfColumns = aircraftCategory.getNoOfColumns();
        noOfRows = aircraftCategory.getNoOfRows();
        return noOfColums*noOfRows;
    }*/

     /*
public Optional<AircraftCategory> getAircraftCategory(int id){

        return aircraftRepository.findById(Integer.toString(id));
    }*/