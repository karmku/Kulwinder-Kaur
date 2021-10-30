/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.dvdlibrary;

import java.util.Set;

/**
 *
 * @author Toshiba
 */
public class DVDLibraryView {
     UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public void displayMainMenu() {
        io.print("");
        io.print("******* DVD Library *******");
        io.print("1. Add a DVD");
        io.print("2. Edit a DVD");
        io.print("3. Remove a DVD");
        io.print("4. Search for a DVD by title");
        io.print("5. List DVD information");
        io.print("6. Show all DVDs");
        io.print("7. Exit");
    }

    public void displayEmptyLibrary() {
        io.print("");
        io.print("DVD Library is empty!");
    }

    public void displayAlreadyExists(String userTitle) {
        io.print("");
        io.print("Found DVD titled " + userTitle + "!");
    }

    public void displayNonExistent(String userTitle) {
        io.print("");
        io.print("Sorry, could not find " + userTitle);
    }

    public String getUserSearch() {
        io.print("");
        return io.promptString("Enter title to search: ");
    }

    public String getDVDTitle(String message) {
        String userTitle = io.promptString(message);
        return userTitle;
    }

    public String getDVDTitleToEdit() {
        io.print("");
        String title = getDVDTitle("Enter title of DVD to edit:");
        return title;
    }

    public String getDVDTitleToDelete() {
        io.print("");
        String title = getDVDTitle("Enter title of DVD to delete:");
        return title;
    }

    public String getDVDTitleToDisplay() {
        io.print("");
        String title = getDVDTitle("Enter title of DVD to display:");
        return title;
    }

    // format message prompt to include acceptable range of integer input
    private int getMenuChoiceNumber(String message, int min, int max) {
        message = String.format(message + " (%s - %s):", min, max);
        io.print("");
        return io.promptValidInt(message, min, max);
    }

    public int getMainMenuChoice() {
        io.print("");
        String message = "Select an item number to continue";
        int min = 1;
        int max = 7;
        return getMenuChoiceNumber(message, min, max);
    }

    public void displayExitMessage() {
        io.print("");
        String exitMessage = "Thanks for using DVD Library!";
        io.print(exitMessage);
    }

    public String getNewTitle() {
        io.print("");
        String message = "Enter DVD title:";
        return getDVDTitle(message);
    }

    // create new DVD data transger object from user data
    public DVD getNewData(String title) {
        io.print("");
        String releaseDate = io.promptString("DVD release date:");
        String MPAARating = io.promptString("MPAA rating:");
        String director = io.promptString("Director:");
        String studio = io.promptString("Production Studio:");
        String rating = io.promptString("rating/notes:");
        DVD newDVD = new DVD(title);
        newDVD.setReleaseDate(releaseDate);
        newDVD.setMPAArating(MPAARating);
        newDVD.setDirectorName(director);
        newDVD.setStudio(studio);
        newDVD.setUserRating(rating);
        return newDVD;
    }

    // uses title collection to display numbered but unsorted DVD titles
    public void displayAllDVDTitles(Set<String> titleSet) {
        io.print("");
        io.print(titleSet.size() + " entries found");
        io.print("");
        int count = 0;
        for (String title : titleSet) {
            count++;
            io.print("");
            io.print("#" + count + "  -  " + title);
        }
    }

    // print out individual DVD's data
    public void displayDVD(DVD DVD) {
        io.print("");
        io.print("Title: " + DVD.getTitle());
        io.print("Release Date: " + DVD.getReleaseDate());
        io.print("MPAA Rating: " + DVD.getMPAArating());
        io.print("Director Name: " + DVD.getDirectorName());
        io.print("Production Studio: " + DVD.getStudio());
        io.print("User Rating: " + DVD.getUserRating());
    }

    private void displaySuccessMessage(String message) {
        io.print("");
        io.print("Success! " + message);
    }

    public void displayAddSuccess(String title) {
        String message = title + " added to library";
        displaySuccessMessage(message);
    }

    public void displayEditSuccess(String title) {
        String message = title + " edited in library";
        displaySuccessMessage(message);
    }

    public void displayDeleteSuccess(String title) {
        String message = title + " deleted from library";
    }

    // intended for exception error messages
    public void displayErrorMessage(String errorMessage) {
        io.print("");
        io.print(errorMessage);

    }


}
