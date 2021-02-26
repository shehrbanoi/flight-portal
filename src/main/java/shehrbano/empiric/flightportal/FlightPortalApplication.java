package shehrbano.empiric.flightportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FlightPortalApplication {

	public static void main(String[] args) {
		for(int i = 1;i <= 100; i++){
			if(i%3 ==0 && !(i%5 ==0)){
				System.out.println("bano");
			}
			if(i%5==0 && !(i%3 ==0)){
				System.out.println("shehr");
			}
			if(i%3==0 && i%5==0){
				System.out.println("shehrbano");
			}
			if(i%3!=0 && i%5!=0){
				System.out.println(i);
			}

		}


		SpringApplication.run(FlightPortalApplication.class, args);
	}

}
