package com.kinematiccomputation.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class KinematicUAM {

//    static int checkedDisplacement = 0;
//    static int checkedTime = 0;
//    static int checkedInitialVelocity = 0;
//    static int checkedFinalVelocity = 0;
//    static int checkedAcceleration = 0;
//
//    static String[] inputVector;
//    static String selectedValues;
//    protected static String excludedVariable = "";
//    static String calculateValue;
//    static int excludedValue = 0;
//
//    static boolean hasDisplacementExcluded = false;
//    static boolean hasTimeExcluded = false;
//    static boolean hasInitialVelocityExcluded = false;
//    static boolean hasFinalVelocityExcluded = false;
//    static boolean hasAccelerationExcluded = false;

    static double displacementValue = 0;
    static double timeValue = 0;
    static double initialVelocityValue = 0;
    static double finalVelocityValue = 0;
    static double accelerationValue = 0;

//    static Scanner input = new Scanner(System.in);

    public double driver(int excludedIndex, double[] inputVector, int targetIndex) { //

        try {

            ComputationEngine computationEngine = new ComputationEngine();

            //call displayUserChoices
//            displayUserChoices();

            //call determineExcludedValue
//            determineExcludedValue();

            //separate all values by comma
//            KinematicUAM.inputVector = selectedValues.split(",");

            // call determineUserSelection
//            this.inputVector = inputVector;
//            determineUserSelection();

            //call assignExcludedValue
//            assignExcludedValue();

            //call determineCalculatingVariable
//            determineCalculatingVariable();

            //call getUserValues
//            getUserValues();

            if(excludedIndex != 0 && targetIndex != 0) {
                displacementValue = inputVector[0];
            }
            if(excludedIndex != 1 && targetIndex != 1) {
                timeValue = inputVector[1];
            }
            if(excludedIndex != 2 && targetIndex != 2) {
                initialVelocityValue = inputVector[2];
            }
            if(excludedIndex != 3 && targetIndex != 3) {
                finalVelocityValue = inputVector[3];
            }
            if(excludedIndex != 4 && targetIndex != 4) {
                accelerationValue = inputVector[4];
            }

            double result = 0;
            if (targetIndex == 0) {
                // calculateDisplacement();
                return computationEngine.calculateDisplacement(excludedIndex, accelerationValue, finalVelocityValue,
                        initialVelocityValue, timeValue, displacementValue);

            } else if (targetIndex == 1) {
                // calculateTime();
                return computationEngine.calculateTime(excludedIndex, accelerationValue, finalVelocityValue,
                        initialVelocityValue, timeValue, displacementValue);
            } else if (targetIndex == 2) {
                // calculateInitialVelocity();
                return computationEngine.calculateInitialVelocity(excludedIndex, accelerationValue, finalVelocityValue,
                        initialVelocityValue, timeValue, displacementValue);
            } else if (targetIndex == 3) {
                // calculateFinalVelocity();
                return computationEngine.calculateFinalVelocity(excludedIndex, accelerationValue, finalVelocityValue,
                        initialVelocityValue, timeValue, displacementValue);
            } else if (targetIndex == 4) {
                // calculateAcceleration();
                return computationEngine.calculateAcceleration(excludedIndex, accelerationValue, finalVelocityValue,
                        initialVelocityValue, timeValue, displacementValue);
            }
        } catch (Exception ex) {
            System.out.println("Exception occured: " + ex.getMessage());
        }
        return -1;
    }

//    private static void determineExcludedValue() {
//        if (excludedValue == 1) {
//            excludedVariable = "displacement";
//        } else if (excludedValue == 2) {
//            excludedVariable = "time";
//        } else if (excludedValue == 3) {
//            excludedVariable = "initialVelocity";
//        } else if (excludedValue == 4) {
//            excludedVariable = "finalVelocity";
//        } else if (excludedValue == 5) {
//            excludedVariable = "acceleration";
//        }
//    }
//
//    private static void determineUserSelection() {
//        System.out.println();
//        System.out.println("The selected values: ");
//        for (int index = 0; index <= inputVector.length - 1; index++) {
//            //parsing the values to Integer
//            if (Integer.parseInt(inputVector[index]) == 1) {
//                checkedDisplacement = Integer.parseInt(inputVector[index]);
//                System.out.println("Displacement: " + checkedDisplacement);
//                hasDisplacementExcluded = true;
//            } else if (Integer.parseInt(inputVector[index]) == 2) {
//                checkedTime = Integer.parseInt(inputVector[index]);
//                System.out.println("Time: " + checkedTime);
//                hasTimeExcluded = true;
//            } else if (Integer.parseInt(inputVector[index]) == 3) {
//                checkedInitialVelocity = Integer.parseInt(inputVector[index]);
//                System.out.println("Initial Velocity: " + checkedInitialVelocity);
//                hasInitialVelocityExcluded = true;
//            } else if (Integer.parseInt(inputVector[index]) == 4) {
//                checkedFinalVelocity = Integer.parseInt(inputVector[index]);
//                System.out.println("Final Velocity:" + checkedFinalVelocity);
//                hasFinalVelocityExcluded = true;
//            } else if (Integer.parseInt(inputVector[index]) == 5) {
//                checkedAcceleration = Integer.parseInt(inputVector[index]);
//                System.out.println("Acceleration:" + checkedAcceleration);
//                hasAccelerationExcluded = true;
//            }
//        }
//    }
//
//    private static void assignExcludedValue() {
//        //Figures out the excluded value
//        //parsing the values to Integer
//        if (excludedValue == 1) {
//            System.out.println("Excluded variable is Displacement");
//            hasDisplacementExcluded = true;
//        } else if (excludedValue == 2) {
//            System.out.println("Excluded variable is Time");
//            hasTimeExcluded = true;
//        } else if (excludedValue == 3) {
//            System.out.println("Excluded variable is Initial Velocity");
//            hasInitialVelocityExcluded = true;
//        } else if (excludedValue == 4) {
//            System.out.println("Excluded variable is Final Velocity");
//            hasFinalVelocityExcluded = true;
//        } else if (excludedValue == 5) {
//            System.out.println("Excluded variable is Acceleration");
//            hasAccelerationExcluded = true;
//        }
//
//    }
//
//    private static void determineCalculatingVariable() {
//        //Finds the calculating variable
//
//        if (hasDisplacementExcluded == false) {
//            System.out.println("Calculating Displacement");
//        } else if (hasTimeExcluded == false) {
//            System.out.println("Calculating Time");
//        } else if (hasInitialVelocityExcluded == false) {
//            System.out.println("Calculating Initial Velocity");
//        } else if (hasFinalVelocityExcluded == false) {
//            System.out.println("Calculating Final Velocity");
//        } else if (hasAccelerationExcluded == false) {
//            System.out.println("Calculating Acceleration");
//        }
//    }
//
//    private static void getUserValues() {
//        if (hasDisplacementExcluded == true && excludedVariable != "displacement") {
//            System.out.println("Please enter displacement value:");
//            displacementValue = input.nextDouble();
//        }
//        if (hasTimeExcluded == true && excludedVariable != "time") {
//            System.out.println("Please enter time value:");
//            timeValue = input.nextDouble();
//        }
//        if (hasInitialVelocityExcluded == true && excludedVariable != "initialVelocity") {
//            System.out.println("Please enter initial velocity value:");
//            initialVelocityValue = input.nextDouble();
//        }
//        if (hasFinalVelocityExcluded == true && excludedVariable != "finalVelocity") {
//            System.out.println("Please enter final velocity value:");
//            finalVelocityValue = input.nextDouble();
//        }
//        if (hasAccelerationExcluded == true && excludedVariable != "acceleration") {
//            System.out.println("Please enter acceleration value:");
//            accelerationValue = input.nextDouble();
//        }
//    }

//    private static void displayUserChoices() {
//
//        System.out.println("The purpose of this program is to investigate kinematic equations the variety of means \n" +
//                "by which the motion of objects can be described.");
//
//        System.out.println("1) \tDisplacement");
//        System.out.println("2) \tTime");
//        System.out.println("3) \tInitial Velocity");
//        System.out.println("4) \tFinal Velocity");
//        System.out.println("5) \tAcceleration");
//
//        System.out.println("Please select your choice (no spaces between commas): ");
//        selectedValues = input.next();
//        System.out.println("You have entered the choices as follows: " + selectedValues);
//
//        System.out.println("Please enter the excluded value: ");
//        excludedValue = input.nextInt();
//        System.out.println("Excluded variable: " + excludedValue);
//
//    }
}