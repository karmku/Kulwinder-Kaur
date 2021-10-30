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
public class DVDLibraryController {

    private DVDLibraryView view;
    private DVDLibraryDao dao;

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        // handle IO exceptions
        try {
            boolean keepUsing = true;
            while (keepUsing) {
                view.displayMainMenu();
                // get a number (1 - 7) corresponding to user's menu choice
                int userChoice = view.getMainMenuChoice();
                switch (userChoice) {

                    case 1:
                        addDVD();
                        break;

                    case 2:
                        editDVD();
                        break;

                    case 3:
                        deleteDVD();
                        break;

                    case 4:
                        searchForDVD();
                        break;

                    case 5:
                        displayDVDInfo();
                        break;

                    case 6:
                        displayAllTitles();
                        break;
                    case 7:
                        keepUsing = false;

                }
            }
            view.displayExitMessage();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    // append user's DVD to DVD collection if it doesn't already exist
    private void addDVD() throws DVDLibraryDaoException {

        String titleToAdd = view.getNewTitle();
        if (dao.libraryHas(titleToAdd)) {
            view.displayAlreadyExists(titleToAdd);
        } else {
            DVD userDVD = view.getNewData(titleToAdd);
            dao.addDVD(userDVD.getTitle(), userDVD);
            view.displayAddSuccess(titleToAdd);
        }
    }

    // edit all DVD data, except for the title, of an existing DVD 
    private void editDVD() throws DVDLibraryDaoException {
        if (dao.emptyLibrary()) {
            view.displayEmptyLibrary();
        } else {
            String titleToEdit = view.getDVDTitleToEdit();

            if (dao.libraryHas(titleToEdit)) {
                DVD oldDVD = dao.getDVD(titleToEdit);
                view.displayDVD(oldDVD);
                DVD editedDVD = view.getNewData(titleToEdit);
                dao.editDVD(titleToEdit, editedDVD);
                view.displayEditSuccess(titleToEdit);
            } else {
                view.displayNonExistent(titleToEdit);
            }
        }
    }

    // remove a DVD from DAO if it exists
    private void deleteDVD() throws DVDLibraryDaoException {
        if (dao.emptyLibrary()) {
            view.displayEmptyLibrary();
        } else {
            String titleToDelete = view.getDVDTitleToDelete();

            if (dao.libraryHas(titleToDelete)) {
                dao.removeDVD(titleToDelete);
                view.displayDeleteSuccess(titleToDelete);
            } else {
                view.displayNonExistent(titleToDelete);
            }
        }
    }

    // check if a certain DVD title exists in the DAO
    private void searchForDVD() throws DVDLibraryDaoException {
        if (dao.emptyLibrary()) {
            view.displayEmptyLibrary();
        } else {
            String query = view.getUserSearch();
            if (dao.libraryHas(query)) {
                view.displayAlreadyExists(query);
            } else {
                view.displayNonExistent(query);
            }
        }
    }

    // display field values of a certain DVD in the DAO
    private void displayDVDInfo() throws DVDLibraryDaoException {
        if (dao.emptyLibrary()) {
            view.displayEmptyLibrary();
        } else {
            String titleToDisplay = view.getDVDTitleToDisplay();
            if (dao.libraryHas(titleToDisplay)) {
                DVD dvdToDisplay = dao.getDVD(titleToDisplay);
                view.displayDVD(dvdToDisplay);
            } else {
                view.displayNonExistent(titleToDisplay);
            }
        }
    }

    // display the titles of all DVDs in the DAO
    private void displayAllTitles() throws DVDLibraryDaoException {
        if (dao.emptyLibrary()) {
            view.displayEmptyLibrary();
        } else {
            view.displayAllDVDTitles(dao.getAllDVDTitles());
        }
    }

}
}
