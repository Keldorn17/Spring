package com.keldorn.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoachImpl implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice.";
    }
}
