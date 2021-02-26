package shehrbano.empiric.flightportal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shehrbano.empiric.flightportal.entities.Bookings;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Bookings, String> {


    List<Bookings> findByFlightId(int flightId);
    List<Bookings> findByPassengers(int passId);
}
