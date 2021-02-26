package shehrbano.empiric.flightportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shehrbano.empiric.flightportal.entities.Flights;

@Repository
public interface FlightRepository extends JpaRepository <Flights,String>{}
