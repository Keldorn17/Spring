package com.keldorn.springcoredemo.common;

public class SwimCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Swim a 1000 meters as a warm up";
    }
}
