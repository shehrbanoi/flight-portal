package shehrbano.empiric.flightportal.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shehrbano.empiric.flightportal.entities.Aircraft;


import java.util.List;


@Repository
public interface AircraftRepository extends CrudRepository<Aircraft,String>{

    List<Aircraft> findByAircraftCategoryAircraftCategoryId(String aircraftCategoryId);

}
