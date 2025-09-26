package com.keldorn.springcoredemo.controller;

import com.keldorn.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Coach myCoach;

    @Autowired
    DemoController(Coach coach) {
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
