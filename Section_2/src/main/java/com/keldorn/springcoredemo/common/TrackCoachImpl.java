package com.keldorn.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoachImpl implements Coach {

    public TrackCoachImpl() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
}
