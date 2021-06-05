/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

import java.util.Scanner;
import java.util.Date;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        String currentAgeString = myApp.readAge("What is your current age? ");
        String retireAgeString = myApp.readAge("At what age would you like to retire? ");
        int currentAge = myApp.convertAgeString(currentAgeString);
        int retireAge = myApp.convertAgeString(retireAgeString);
        int yearsLeft = myApp.computeYearsTillRetire(currentAge, retireAge);
        int currentYear = myApp.getCurrentYear();
        int retirementYear = myApp.getRetirementYear(currentYear, yearsLeft);
        String outputString = myApp.generateOutputString(yearsLeft, currentYear, retirementYear);
        myApp.printOutput(outputString);
    }

    private String readAge(String str) {
        System.out.print(str);
        String age = in.nextLine();
        return age;
    }

    private Integer convertAgeString(String ageString) {
        int age = Integer.parseInt(ageString);
        return age;
    }

    private int computeYearsTillRetire(int currentAge, int retireAge) {
        int yearsLeft = retireAge - currentAge;
        return yearsLeft;
    }

    private int getCurrentYear () {
        Date d = new Date();
        int year = d.getYear();
        int currentYear = year + 1900;
        return currentYear;
    }

    private int getRetirementYear(int currentYear, int yearsLeft) {
        int retirementYear = currentYear + yearsLeft;
        return retirementYear;
    }

    private String generateOutputString(int yearsLeft, int currentYear, int retirementYear) {
        return String.format("You have %d years left until you can retire.\nIt's %d, so you can retire in %d.", yearsLeft, currentYear, retirementYear);
    }

    private void printOutput(String outputString) { System.out.println(outputString); }
}
