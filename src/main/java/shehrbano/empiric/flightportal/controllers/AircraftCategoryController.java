package shehrbano.empiric.flightportal.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shehrbano.empiric.flightportal.dto.GetAircraftCatDTO;
import shehrbano.empiric.flightportal.dto.GetAircraftDTO;
import shehrbano.empiric.flightportal.entities.Aircraft;
import shehrbano.empiric.flightportal.entities.AircraftCategory;
import shehrbano.empiric.flightportal.entities.Seats;
import shehrbano.empiric.flightportal.repositories.AircraftCategoryRepository;
import shehrbano.empiric.flightportal.services.AircraftCategoryService;

import java.util.List;
import java.util.Optional;

@RestController
public class AircraftCategoryController {

    @Autowired
    private AircraftCategoryService aircraftCategoryService;
    @Autowired
    private AircraftCategoryRepository aircraftCategoryRepository;

    @RequestMapping("/aircraftCategory")
    public List<AircraftCategory> getAllAircraftCategories(){
        return aircraftCategoryService.getAllAircraftCategoryTypes();
    }

    @RequestMapping(method=RequestMethod.POST, value="/aircraftCategory/getAircraftCatsById")
    public Optional<AircraftCategory> getAircraftCategoryById(@RequestBody GetAircraftCatDTO getAircraftCatDTO){
        return aircraftCategoryService.getAircraftCatById(getAircraftCatDTO.id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/aircraftCategory/addAircraftType")
    public AircraftCategory addAircraftCategory(@RequestBody AircraftCategory aircraftCategory){
        return aircraftCategoryService.addAircraftCategory(aircraftCategory);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/aircraftCategory/updateAircraftType")
    public AircraftCategory updateAircraftCategory(@RequestBody AircraftCategory aircraftCategory){
        return aircraftCategoryService.updateAircraftCategory(aircraftCategory);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/aircraftCategory/deleteAircraftCatById")
    public void deleteAircraftCategory(@RequestBody AircraftCategory aircraftCategory){
        aircraftCategoryService.deleteAircraftCategory(aircraftCategory.aircraftCategoryId);
    }


}

    /*@RequestMapping(method= RequestMethod.POST, value="/aircraftCategory/getAircraftSeatsById")
    public List<Seats> getAircraftSeats(@RequestBody GetAircraftDTO getAircraftDTO){
        return aircraftCategoryService.getAircraftSeats(getAircraftDTO.id);
    }*/
