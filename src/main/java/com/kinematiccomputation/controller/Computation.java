package com.kinematiccomputation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kinematiccomputation.service.KinematicUAM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Computation {
//https://www.google.com/url?sa=i&url=http%3A%2F%2Fgradeelevenphysics.weebly.com%2F5-kinematics-equations.html&psig=AOvVaw1Szmg10TTSnS78x7eOgIqT&ust=1636427599834000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMjvl9Luh_QCFQAAAAAdAAAAABAD
    @Autowired
    KinematicUAM kinematicUAM;

    ObjectMapper objectMapper = new ObjectMapper();

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping(value = "/computeKinematicEquation", consumes = "application/json", produces = "application/json")
    public double computeKinematicEquation(@RequestParam(value = "displacement") double displacement, @RequestParam(value = "time") double time,
                                           @RequestParam(value = "initialVelocity") double initialVelocity, @RequestParam(value = "finalVelocity") double finalVelocity,
                                           @RequestParam(value = "acceleration") double acceleration, @RequestParam(value = "excludedIndex") int excludedIndex,
                                           @RequestParam(value = "targetIndex") int targetIndex) throws JsonProcessingException {
        //variables should be of size 5
//        InputData inputData = objectMapper.readValue(data, InputData.class);
        double[] inputVector = {displacement, time, initialVelocity, finalVelocity, acceleration};
        return kinematicUAM.driver(excludedIndex, inputVector, targetIndex);
    }
}