package shehrbano.empiric.flightportal.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
public class CabinClass {

    public String cabinType;
    public long numSeatsinCabin;


}