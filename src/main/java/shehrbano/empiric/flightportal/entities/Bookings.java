package shehrbano.empiric.flightportal.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bookings {

    @Id
//@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String bookingId;
    @OneToOne
    @JoinColumn(name="flightId")
    public Flights flightId;
//    private String flightName;
    public String datim;
    @OneToOne
    @NotNull
    @JoinColumn(name="passengerId")
    public Passengers passengers;

   // private String rowNo;
   // private String seat;
    @OneToOne
    @JoinColumn(name="seatId")
    public Seats seats;


    //@ManyToOne
    //private Flights flights;

   // public Flights getFlights() {
       // return flights;
    //}

    //public void setFlights(Flights flights) {
      //  this.flights = flights;
   // }





    /*@ManyToOne
    private Flights manyToOne;

    public void setManyToOne(Seats manyToOne) {
        this.manyToOne = manyToOne;
    }

    public Flights getManyToOne() {
        return manyToOne;
    }

    public void setManyToOne(Flights manyToOne) {
        this.manyToOne = manyToOne;
    }*/

}
