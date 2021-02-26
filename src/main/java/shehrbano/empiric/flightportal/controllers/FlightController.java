package shehrbano.empiric.flightportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shehrbano.empiric.flightportal.dto.GetFlightDTO;
import shehrbano.empiric.flightportal.entities.Flights;
import shehrbano.empiric.flightportal.services.FlightService;

import java.util.List;
import java.util.Optional;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @RequestMapping("/flights")
    public List<Flights> getAllFlights(){
        return flightService.getAllFlights(); }

    @RequestMapping(method=RequestMethod.POST, value="/flights/getFlightById")
    public Optional<Flights> getFlight(@RequestBody GetFlightDTO getFlightDTO){
        return flightService.getFlight(getFlightDTO.id); }

    @RequestMapping(method = RequestMethod.POST, value = "/flights/addFlight")
    public Flights addFlight (@RequestBody Flights flight){

        return flightService.addFlight(flight);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/flights/updateFlight")
    public Flights updateFlight(@RequestBody Flights flight){
        return flightService.updateFlight(flight);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/flights/deleteFlight")
    public void deleteFlight(@RequestBody Flights flight){
        flightService.deleteFlight(flight.flightId);
    }

}




/**   String filePath = "C:\\Users\\ShehrbanoIbrahim\\Downloads\\flight-portal\\flight-portal\\src\\main\\resources\\data.txt";


 StringBuilder contentBuilder = new StringBuilder();

 try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
 {
 stream.forEach(s -> {
 contentBuilder.append(s);
 contentBuilder.append("\n");
 });
 }
 catch (IOException e)
 {
 e.printStackTrace();
 }

 String read = contentBuilder.toString();
 new JdbcTemplate().execute(read);
 */
