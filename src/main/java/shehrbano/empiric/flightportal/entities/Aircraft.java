package shehrbano.empiric.flightportal.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Data
@Table(name = "Aircraft")
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor

public class Aircraft {

    @Id
//@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String aircraftid;

    @Column(name = "AIRCRAFT_NAME")
    public String aircraftName;
    public String aircraftModel;
    public String built;
    public String serviced;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="aircraftCategoryId")
    public AircraftCategory aircraftCategory;

}

