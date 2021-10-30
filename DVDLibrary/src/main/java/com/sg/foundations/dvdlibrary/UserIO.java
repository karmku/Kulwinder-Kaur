/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.dvdlibrary;

/**
 *
 * @author Toshiba
 */
public interface UserIO {
   void print(String message);

    String promptString(String message);

    int promptValidInt(String message, int min, int max);

 
}
