package shehrbano.empiric.flightportal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shehrbano.empiric.flightportal.entities.Passengers;

import java.util.Optional;

@Repository
public interface PassengerRepository extends CrudRepository<Passengers,String>{


    public Optional<Passengers> findById(String Id);
    public Passengers findByContactInfo(String contactInfo);
    public Passengers findByIdentification(String identification);



}
