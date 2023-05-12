package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner guessNumber = new Scanner(System.in);
        Random random = new Random();
        int attempts = 0;
        int points = 0;
        int randomNumber = random.nextInt() + 1;

        System.out.println("Choose a difficulty level: ");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");

        int level = guessNumber.nextInt();

        switch (level) {
            case 1 -> randomNumber = random.nextInt(40,50) + 1;
            case 2 -> randomNumber = random.nextInt(90,100) + 1;
            case 3 -> randomNumber = random.nextInt(290,300) + 1;
            default -> {
                System.out.println("invalid choice, defaulting to easy mode");
                randomNumber = 10;
            }
        }
        boolean playAgain = true;

        while (playAgain) {
            try {
                while (true) {
                    System.out.println("Enter a number between 1 and" + " " + randomNumber);
                    int guess = guessNumber.nextInt();
                    attempts++;
                    if (guess > randomNumber) {
                        System.out.println("Too big");
                    } else if (guess < randomNumber) {
                        System.out.println("Too small");
                    } else {
                        points++;
                        System.out.println("Congrats, you guessed the number in" + " " + attempts + " " + "Attempts");
                        System.out.println("You now have" + " " + points + " " + "points");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }


            System.out.println("do you want to play again? (Y/N)");
            String playAgainStr = guessNumber.next();

            if (playAgain = playAgainStr.equalsIgnoreCase("Y")) {
                System.out.println("Loading next game...");
            } else {
                System.out.println("Thank you for playing, you got: " + " " + points + " " + "points");
            }
            //reset the guess count
            attempts = 0;
        }
    }
}

