package org.example;

public class Main {
    public static void main(String[] args) {

        /*Create a Java program that will print a welcome message with dynamic data variables.
        Use String, int and double data variables.*/

        String firstName = "Sergii";
        String productName = "Porsche Cayenne S";
        String city = "Westlake";
        double price = 120550.99;
        int age = 35;

        System.out.println(firstName + ", thank you for your purchase. You have bought '" + productName + "' in the " + city + " car dealership with price of $" + price + ". Buyers older than " + age + " years can get a spa service for free anytime during annual maintenance service. Welcome to Porsche family!");

        //Make 4 different math operations using int data variable. Print your result to console.

        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;

        System.out.println("Addition: " + (a + b + c + d));
        System.out.println("Subtraction: " + (a - b - c - d));
        System.out.println("Multiplication: " + (a * b * c * d));
        System.out.println("Division: " + (d / b));
        System.out.println("Mix: " + (d / a + c - b));
    }
}