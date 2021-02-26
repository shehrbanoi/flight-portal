package shehrbano.empiric.flightportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shehrbano.empiric.flightportal.dto.AddAircraftDTO;
import shehrbano.empiric.flightportal.entities.Aircraft;
import shehrbano.empiric.flightportal.entities.CabinClass;
import shehrbano.empiric.flightportal.entities.Seats;
import shehrbano.empiric.flightportal.repositories.AircraftCategoryRepository;
import shehrbano.empiric.flightportal.repositories.SeatRepository;

import java.util.*;

@Service
@Component
public class SeatService {

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    AircraftCategoryRepository aircraftCategoryRepository;

    public List<Seats> getAllSeats(){
        List<Seats> seats = new ArrayList<>();
        seats= (List<Seats>) seatRepository.findAll();
        return seats;
    }


    public Optional<Seats> getSeat(int id){
        return seatRepository.findById(Integer.toString(id));
    }

    public Seats addSeat(Seats seat){
        seatRepository.save(seat);
        return seat;
    }


    public Seats updateSeat(Seats seat) {
        seatRepository.save(seat);
        return seat; }

    public void deleteSeat(String id) {
        seatRepository.deleteById(id);
    }

    public void createSeatsForAircraft(Aircraft aircraft){
        int num_rows =  Integer.valueOf(aircraft.aircraftCategory.getNumOfRows());
        int num_seats_per_row =Integer.valueOf(aircraft.aircraftCategory.getNumOfColumns());
        int totalSeats = num_seats_per_row * num_rows;
      //  Seats seat = new Seats();

        Dictionary cabinClass = new Hashtable();
        cabinClass.put(1,new CabinClass("First",10));
        cabinClass.put(2,new CabinClass("Business",30));
        cabinClass.put(3,new CabinClass("Economy",60));



        int classId=1;

        for (int i = 1;i <= num_rows; i++) {

            for(int j = 1;j <= num_seats_per_row; j++){
                CabinClass cabinClasses = (CabinClass) cabinClass.get(classId);
                if(((i*j > cabinClasses.getNumSeatsinCabin()))&&(classId<cabinClass.size())){
                    classId+=1;
                    cabinClasses = (CabinClass) cabinClass.get(classId);

                }
                Seats seat = new Seats();
                seat.setCabinClass(cabinClasses.getCabinType());
                seat.setSeatNum(i + "_" + j);
                seat.setAircraft(aircraft);
                seatRepository.save(seat);
            }
        }
    }


    public List<Seats> getAircraftSeats(int aircraftid){
        return seatRepository.findByAircraftAircraftid(aircraftid);
    }



}

//create looop with 3 iterations
//each iteration adds cabin class to dictionary
//create new cabin class in each iteration


//create dictoronary
//class name key, value: num seats
//if ij > classes * current class
//return value numseats
//if numseats > curent change to next class
//create cabin class pojo -name,num seats, key 1,2,3

//dictionary
//with 3 values: window, middle, aisle
//variable seattype id; int
//nested look add if (
//parent loop define current seat type=window from dictionary .get(1)
//internal loop define seattype id=current column num--- check if j==seattypid
//get seat ttype by seatype id then assign seattype
//elseif seat type id===3 then the next id should also be 3
//1 window 2 middle 3 aisle 4 aisle 5 middle 6 aisle
//in row first and last column are window all mddel seats:
//current seatt type
//prev seat typu STRING
//check if , else if else
//if current seat type=aisle, prev !aisle dont change current
//else if current = aisle and prev = aisle then middel
///min 1 max=column if== then seatype=windo
//if current =aisle and rprev aisle then current=aisle
//else seatyp=middle
    //seatype=aisle