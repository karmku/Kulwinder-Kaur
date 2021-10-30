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
public class App {
     public static void main (String[] args) {
        DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
        UserIO io = new UserIOConsoleImpl();
        DVDLibraryView view = new DVDLibraryView(io);
        DVDLibraryController controller = new DVDLibraryController(dao, view);
        controller.run();
    }
}
