package com.keldorn.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoachImpl implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
}
