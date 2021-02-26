package shehrbano.empiric.flightportal.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }




}
