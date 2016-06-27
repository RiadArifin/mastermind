/*
 * CSCI 1228 Assignment 4   
 * A program to play Mastermind
 * Md. Riad Arifin (A00395462), Feb 2016
 */

import java.util.Scanner;
import java.util.Arrays;

public class Mastermind {

    public static void main(String[] args) {
        //assigning scanner to take input from keyboard
        Scanner kbd = new Scanner(System.in);

        //creating some variables
        int color = 0;
        int allRight = 0;
        String pick = "";
        int choice = 6;

        char[] newpicked = new char[4];

        //loop to chose four random color and assign it to pick
        for (int i = 0; i < 4; ++i) {

            choice = (int) (Math.random() * 6) + 1;

            switch (choice) {
                case 1:
                    pick = pick.concat("R");
                    break;
                case 2:
                    pick = pick.concat("O");
                    break;
                case 3:
                    pick = pick.concat("Y");
                    break;
                case 4:
                    pick = pick.concat("G");
                    break;
                case 5:
                    pick = pick.concat("B");
                    break;
                case 6:
                    pick = pick.concat("P");
                    break;
            }
        }

        //assign characters of string pick into array picked
        char[] picked = new char[4];

        for (int i = 0; i < 4; ++i) {

            picked[i] = pick.charAt(i);
        }

        //loop to ask user for ten guess and check whether it is correct or not
        for (int k = 1; k <= 10; ++k) {
            allRight = 0;
            color = 0;
            System.out.print("What is your guess? ");
            String guess = kbd.nextLine();

            char[] guessed = new char[4];

            for (int j = 0; j < 4; ++j) {
                guessed[j] = guess.charAt(j);
            }

            for (int j = 0; j < 4; ++j) {

                if (picked[j] == guessed[j]) {
                    ++allRight;

                    newpicked[j] = '╩';
                    guessed[j] = '╦';

                } else {
                    newpicked[j] = picked[j];
                }

            }
            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < 4; ++j) {
                    if (newpicked[i] == guessed[j]) {
                        ++color;
                        guessed[j] = '╦';
                    }
                }
            }

            //to inform the user how many are  correct
            if (allRight < 4) {
                System.out.println("Your score is: " + allRight + "/" + color);
            } else {
                System.out.println("Your score is: " + allRight + "/" + color);
                System.out.println("All 4 are correct -- game is now over");
                System.exit(0);
            }
        }

        System.out.println("Press any key to continue...");
    }

}
