package com.ss;

import java.util.Random;
import java.util.Scanner;

public class RandomGuess {

    int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }

    int getUserInput(Scanner scanner) {
        System.out.print("Enter a number: ");
        int guess;
        try {
            guess = Integer.parseInt(scanner.nextLine());
        } catch(NumberFormatException e) {
            System.err.println(e);
            System.out.println("Must enter valid integer"); //number of tries remaining does not decrement for invalid entry
            guess = getUserInput(scanner);
        }
        if(guess < 1 || guess > 100) {
            System.out.println("Invalid Entry number must be between 1 and 100 inclusive of 1 and 100");
            guess = getUserInput(scanner);
        }
        return guess;
    }

    void gameController() {
        final int CORRECT_ANS = getRandomNumber();
        int guess;
        int numOfGuesses = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess a number that is >= 1 && <= 100");
        do {
            guess = getUserInput(scanner);
            if(guess <= CORRECT_ANS + 10 && guess >= CORRECT_ANS - 10) {
                System.out.println("You guessed within 10 numbers of the answer!");
                break;
            } else if(numOfGuesses < 4) {
                System.out.println("Number entered is not correct try again");
            } else {
                System.out.println("Sorry");
            }
            ++numOfGuesses;
        } while(numOfGuesses < 5);
        System.out.println("Random # generated is " + CORRECT_ANS);
    }

    public static void main(String[] args) {
        new RandomGuess().gameController();
    }
}
