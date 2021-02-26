package shehrbano.empiric.flightportal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shehrbano.empiric.flightportal.entities.Seats;

import java.util.List;

@Repository
public interface SeatRepository extends CrudRepository<Seats, String> {

    List<Seats> findByAircraftAircraftid(int aircraftid);
}
