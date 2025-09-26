package com.keldorn.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoachImpl implements Coach {

    public CricketCoachImpl() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }
}
