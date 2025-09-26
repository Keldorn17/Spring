package com.keldorn.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoachImpl implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice you backhand volley.";
    }
}
