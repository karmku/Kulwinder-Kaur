/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.dvdlibrary;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Toshiba
 */
    public class UserIOConsoleImpl implements UserIO{

    Scanner consoleInput = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String promptString(String message) {
        print(message);
        return consoleInput.nextLine();
    }

    @Override
    // guarantee user input to be an integer between min and max (inclusive),
    // handles input mismatch and out-of-range issues
    public int promptValidInt(String message, int min, int max) {
        boolean isBadInput = true;
        int userInt = 0;
        while (isBadInput) {
            try {
                print(message);
                userInt = consoleInput.nextInt();
                while (userInt < min || userInt > max) {
                    print("");
                    print("ENTER A VALID CHOICE");
                    print("");
                    userInt = consoleInput.nextInt();
                }
                consoleInput.nextLine();
                isBadInput = false;
            } catch (InputMismatchException e) {
                consoleInput.nextLine();
                print("");
                print("ENTER A VALID CHOICE");
                print("");
            }
        }
        return userInt;
    }


}
