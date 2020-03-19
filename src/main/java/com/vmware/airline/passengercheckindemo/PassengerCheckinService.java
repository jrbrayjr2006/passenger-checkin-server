package com.vmware.airline.passengercheckindemo;

import org.springframework.stereotype.Service;

@Service
public class PassengerCheckinService {

    public String getGreeting(String passenger) {
        return "Welcome, " + passenger;
    }
}
