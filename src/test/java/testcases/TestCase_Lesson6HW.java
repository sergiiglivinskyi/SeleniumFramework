package testcases;

import org.testng.annotations.Test;

public class TestCase_Lesson6HW {
    @Test
    /*Create if/else conditional statement to print tax % based on the income user enters
    condition 1. if user makes from 0 to 10275, print - "your tax will be 10%"
    condition 2. if user makes from 10276 to 41775" , print - "your tax will be12%"
    condition 3. if user makes from 41776 to 89075" , print - "your tax will be22%"
    condition 3. For everything else, print "please call your CPA"*/
    public void printTax() {
        int income = 89076;

        if(income >= 0 && income <= 10275) {
            System.out.println("Your tax will be 10%");
        } else if (income >= 10276 && income <= 41775) {
            System.out.println("Your tax will be 12%");
        } else if (income >= 41776 && income <= 89075) {
            System.out.println("Your tax will be 22%");
        } else {
            System.out.println("Please call your CPA");
        }
    }

    @Test
    //Create switch statement to print working hours for 6 different departments
    public void printWorkingHours() {
        String department = "management";

        switch (department) {
            case "sales":
                System.out.println("Sales department works from 8am to 12pm.");
                break;
            case "operations":
                System.out.println("Operations department works from 8am to 14pm.");
                break;
            case "it":
                System.out.println("IT department works from 10am to 18pm.");
                break;
            case "delivery":
                System.out.println("Delivery department works from 8am to 15pm.");
                break;
            case "management":
                System.out.println("Management department works from 9am to 16pm.");
                break;
            case "returns":
                System.out.println("Returns department works from 8am to 13pm.");
                break;
            default:
                System.out.println("Please enter the correct department");
                break;
        }
    }

    @Test
    /*Create for loop to print every second hour in a day (total hours 24, you need to print 12 lines).
    Start with 0 hours,  and complete your loop when day is over.*/
    public void getEverySecondHour() {
        int hourNumber = 1;
        for (int i = 0; i < 24; i++) {
            System.out.println("Hour number is " + hourNumber++ + " and it's value: " + i++);
        }
    }
}