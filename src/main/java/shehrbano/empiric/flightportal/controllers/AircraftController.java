package shehrbano.empiric.flightportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shehrbano.empiric.flightportal.dto.AddAircraftDTO;
import shehrbano.empiric.flightportal.dto.GetAircraftDTO;
import shehrbano.empiric.flightportal.entities.Aircraft;
import shehrbano.empiric.flightportal.services.AircraftService;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@RestController
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @RequestMapping("/aircrafts")
    public List<Aircraft> getAllAircrafts(){
        return aircraftService.getAllAircrafts();
    }

    @RequestMapping(method=RequestMethod.POST, value="/aircrafts/getAircraftById")
    public Optional<Aircraft> getAircraft(@RequestBody GetAircraftDTO getAircraftDTO){
        return aircraftService.getAircraft(getAircraftDTO.id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/aircrafts/addAircraft")
    public Aircraft addAircraft(@RequestBody Aircraft aircraft){
       return aircraftService.addAircraft(aircraft);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/aircrafts/updateAircraft")
    public Aircraft updateAircraft(@RequestBody Aircraft aircraft){
        return aircraftService.updateAircraft(aircraft);
    }
    @RequestMapping(method=RequestMethod.DELETE, value="/aircrafts/deleteAircraftById")
    public void deleteAircraft(@RequestBody Aircraft aircraft){
        aircraftService.deleteAircraft(aircraft.aircraftid);
    }

    @RequestMapping(method = RequestMethod.POST, value="/aircrafts/add4aircraft")
    public Aircraft add44Aircraft(@RequestBody Aircraft aircraft){
       return aircraftService.add44Aircraft(aircraft);
    }

}
