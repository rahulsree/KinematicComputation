package com.kinematiccomputation.service;

import org.springframework.stereotype.Service;


@Service
public class ComputationEngine {

    public ComputationEngine() { }

    public double calculateAcceleration(int excludedValue, double accelerationValue, double finalVelocityValue,
                                             double initialVelocityValue, double timeValue, double displacementValue) {

        excludedValue = excludedValue + 1; //indexing differences

        //Using equation 2, finding acceleration, excluding displacement
        if(excludedValue == 1) {
            accelerationValue = (finalVelocityValue - initialVelocityValue)/timeValue;
        }
        //Using equation 4, finding acceleration, excluding time
        else if(excludedValue == 2) {
            accelerationValue = getAccDispValue(displacementValue, finalVelocityValue, initialVelocityValue);
        }
        //Using equation 5, finding acceleration, excluding initial velocity
        else if(excludedValue == 3) {
            //call reusable logic - getAccValue
            accelerationValue = getAccValue("Negative", displacementValue ,finalVelocityValue, timeValue);
        }
        //Using equation 3, finding acceleration, excluding final velocity
        else if(excludedValue == 4) {
            //call reusable logic - getAccValue
            accelerationValue = getAccValue("Positive", displacementValue , initialVelocityValue, timeValue);
        }
        System.out.println("Acceleration value is " + accelerationValue);
//        Output output = new Output("Acceleration", accelerationValue);
        return accelerationValue;
    }

    public double calculateDisplacement(int excludedValue, double accelerationValue, double finalVelocityValue,
                                             double initialVelocityValue, double timeValue, double displacementValue) {

        excludedValue = excludedValue + 1; //indexing differences

        //Using equation 4, finding displacement, excluding time
        if(excludedValue == 2) {
            displacementValue = getAccDispValue(accelerationValue, finalVelocityValue, initialVelocityValue);
        }
        //Using equation 5, finding displacement, excluding initial velocity
        else if(excludedValue == 3) {
            displacementValue = (finalVelocityValue * timeValue) - (1/2*(accelerationValue * Math.pow(timeValue, 2)));
        }
        //Using equation 3, finding displacement, excluding final velocity
        else if(excludedValue == 4) {
            displacementValue = (initialVelocityValue * timeValue) + (1/2*(accelerationValue * Math.pow(timeValue, 2)));
        }
        //Using equation 1, finding displacement, excluding acceleration
        else if(excludedValue == 5) {
            displacementValue = ((finalVelocityValue + initialVelocityValue)/2)*(timeValue);
        }

        System.out.println("Displacement value is " + displacementValue);

//        Output output = new Output("Displacement", displacementValue);
        return displacementValue;
    }
    public double calculateTime(int excludedValue, double accelerationValue, double finalVelocityValue,
                                     double initialVelocityValue, double timeValue, double displacementValue) {

        excludedValue = excludedValue + 1; //indexing differences

        //Using equation 2, finding time, excluding displacement
        if(excludedValue == 1) {
            timeValue = (finalVelocityValue - initialVelocityValue)/accelerationValue;
        }
        //Using equation 5, finding time, excluding initial velocity
        else if(excludedValue == 3) {
            timeValue = Math.sqrt((-2 * (displacementValue - (finalVelocityValue*timeValue)))/accelerationValue);
        }
        //Using equation 3, finding time, excluding final velocity
        else if(excludedValue == 4) {
            timeValue = Math.sqrt((2 * (displacementValue - (finalVelocityValue*timeValue)))/accelerationValue);
        }
        //Using equation 1, finding time, excluding acceleration
        else if(excludedValue == 5) {
            timeValue = (2 * displacementValue)/(finalVelocityValue + initialVelocityValue);
        }

        System.out.println("Time value is " + timeValue);
//        Output output = new Output("Time", timeValue);
        return timeValue;
    }

    public double calculateInitialVelocity(int excludedValue, double accelerationValue, double finalVelocityValue,
                                                double initialVelocityValue, double timeValue, double displacementValue) {

        excludedValue = excludedValue + 1; //indexing differences

        //Using equation 2, finding initial velocity, excluding displacement
        if(excludedValue == 1) {
            initialVelocityValue = finalVelocityValue - (accelerationValue * timeValue);
        }
        //Using equation 4, finding initial velocity, excluding time
        else if(excludedValue == 2) {
            initialVelocityValue = Math.sqrt(Math.pow(finalVelocityValue, 2) - (2 * (accelerationValue * displacementValue)));
        }
        //Using equation 3, finding initial velocity, excluding final velocity
        else if(excludedValue == 4) {
            initialVelocityValue = displacementValue - (1/2*(accelerationValue * Math.pow(timeValue, 2)));
        }
        //Using equation 1, finding initial velocity, excluding acceleration
        else if(excludedValue == 5) {
            initialVelocityValue = ((2 * displacementValue) - finalVelocityValue)/timeValue;
        }

//        System.out.println("Initial velocity value is " + initialVelocityValue);
//        Output output = new Output("Initial velocity", initialVelocityValue);
        return initialVelocityValue;
    }

    public double calculateFinalVelocity(int excludedValue, double accelerationValue, double finalVelocityValue,
                                              double initialVelocityValue, double timeValue, double displacementValue) {

        excludedValue = excludedValue + 1; //indexing differences

        //Using equation 2, finding final velocity, excluding displacement
        if(excludedValue == 1) {
            finalVelocityValue = initialVelocityValue + (accelerationValue * timeValue);
        }
        //Using equation 4, finding final velocity, excluding time
        else if(excludedValue == 2) {
            finalVelocityValue = Math.sqrt(Math.pow(initialVelocityValue, 2) + (2 * (accelerationValue * displacementValue)));
        }
        //Using equation 5, finding final velocity, excluding initial velocity
        else if(excludedValue == 3) {
            finalVelocityValue = displacementValue + (1/2 * (accelerationValue * Math.pow(timeValue, 2)));
        }
        //Using equation 1, finding final velocity, excluding acceleration
        else if(excludedValue == 5) {
            finalVelocityValue = (2 * (displacementValue/timeValue)) - initialVelocityValue;
        }

        System.out.println("Final velocity value is " + finalVelocityValue);
//        Output output = new Output("Final velocity", finalVelocityValue);
        return finalVelocityValue;

    }

    private double getAccDispValue(double variation, double finalVelocityValue,
                                          double initialVelocityValue) {
        double accDispValue = (Math.pow(finalVelocityValue, 2) - Math.pow(initialVelocityValue, 2))/(2 * variation);

        return accDispValue;
    }

    //Determines acceleration value excluding initial/final velocity
    private double getAccValue(String calcType, double displacementValue, double variation, double timeValue) {

        double accValue = 0;
        if (calcType == "Positive") {
            //Using equation 3, finding acceleration, excluding final velocity
            accValue = (2 * (displacementValue - (variation * timeValue))) / Math.pow(timeValue, 2);
        } else if (calcType == "Negative") {
            //Using equation 5, finding acceleration, excluding initial velocity
            accValue = (-2 * (displacementValue - (variation * timeValue))) / Math.pow(timeValue, 2);
        }
        return accValue;
    }
}