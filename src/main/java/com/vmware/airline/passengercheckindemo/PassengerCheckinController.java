package com.vmware.airline.passengercheckindemo;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassengerCheckinController {

    private PassengerCheckinService passengerCheckinService;

    public PassengerCheckinController(PassengerCheckinService passengerCheckinService) {

        this.passengerCheckinService = passengerCheckinService;
    }

    @GetMapping( value = "/welcome", consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<String> welcome(@RequestBody String passenger) {
        String greeting = passengerCheckinService.getGreeting(passenger);
        ResponseEntity<String> response = ResponseEntity.ok(greeting);
        return response;
    }
}
