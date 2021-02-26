package shehrbano.empiric.flightportal.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Flights {

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "aircraftid",nullable = true)
    public Aircraft aircraft;

    @Id
//@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String flightId;
    public String flightName;
    public String fro;
    public String too;
    public String dep;
    public String arr;



}