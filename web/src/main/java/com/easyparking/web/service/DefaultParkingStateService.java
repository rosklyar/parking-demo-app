package com.easyparking.web.service;

import com.easyparking.web.domain.ParkingPlace;
import com.easyparking.web.domain.ParkingState;
import com.easyparking.web.domain.State;

import java.util.Random;

import static java.util.Arrays.asList;

public class DefaultParkingStateService implements ParkingStateService {

    @Override
    public ParkingState get() {
        return new ParkingState(asList(
                ParkingPlace.builder().row(1).column(1).state(generate()).build(),
                ParkingPlace.builder().row(1).column(2).state(generate()).build(),
                ParkingPlace.builder().row(2).column(1).state(generate()).build(),
                ParkingPlace.builder().row(2).column(2).state(generate()).build()
        ));
    }

    private State generate() {
        State[] states = State.values();
        return states[new Random().nextInt(states.length)];
    }
}
