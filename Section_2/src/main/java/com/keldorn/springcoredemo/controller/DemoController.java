package com.keldorn.springcoredemo.controller;

import com.keldorn.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Coach myCoach;

    @Autowired
    DemoController(@Qualifier("cricketCoachImpl") Coach coach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = coach;
    }

//    @Autowired
//    public void setCoach(Coach coach) { // This method could be named anything.
//        myCoach = coach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
