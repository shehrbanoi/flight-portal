package shehrbano.empiric.flightportal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shehrbano.empiric.flightportal.entities.AircraftCategory;

@Repository
public interface AircraftCategoryRepository extends CrudRepository<AircraftCategory,String> {

    AircraftCategory findByAircraftCategoryId(String aircraftCategoryId);

}