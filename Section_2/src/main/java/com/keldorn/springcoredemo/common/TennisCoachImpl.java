package com.keldorn.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoachImpl implements Coach {

    public TennisCoachImpl() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice you backhand volley.";
    }
}
