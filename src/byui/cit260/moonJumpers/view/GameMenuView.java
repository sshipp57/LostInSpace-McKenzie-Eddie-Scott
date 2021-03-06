/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.moonJumpers.view;

import byui.cit260.moonJumpers.control.GameControl;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import moonjumpers.MoonJumpers;

/**
 *
 * @author mckenzietaggart
 */
class GameMenuView {

    private String menu;

    protected String displayMessage;

    protected final BufferedReader keyboard = MoonJumpers.getInFile();
    protected final PrintWriter console = MoonJumpers.getOutFile();

    public GameMenuView() {
        this.menu = "\n"
                + "\n-------------------------------------"
                + "\n| Game Menu                         |"
                + "\n-------------------------------------"
                + "\n T - Travel Options                  "
                + "\n L - Lift Off                        "
                + "\n G - Gather Fuel                     "
                + "\n F - View Fuel Percentage            "
                + "\n C - Current Weapon                  "
                + "\n A - Fight Alien                     "
                + "\n H - Help                            "
                + "\n Q - Quit                            ";
    }

    public void displayGameMenuView() {

        boolean done = false;
        do {
            //get main menu options
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q")) {//quit the menu
                return;//exit the game
            }
            //do the requested aciton and display the next view
            done = this.doAction(menuOption);

        } while (!done);
    }

    private String getMenuOption() {

        boolean valid = false;//initialize to not valid
        String value = null;//value to be returned
        try {

            while (!valid) {//loop while an invalid value is entered
                this.console.println("\nEnter a Menu Option" + this.menu);

                value = this.keyboard.readLine();//get next line typed from keyboard
                value = value.trim();//trim excess blanks

                if (value.length() < 1) {//value is blank
                    ErrorView.display(this.getClass().getName(), "\nInvalid value: value can not be blank");
                    continue;
                }

                break;//end the loop

            }
        } catch (Exception te) {
            System.out.println("Error reading output: " + te.getMessage());
        }
        return value;//return the value entered
    }

    public boolean doAction(String choice) {

        choice = choice.toUpperCase();//convert choice to upper case

        switch (choice) {
            case "T"://lift off to another celestial body
                this.travelMenu();
                break;
            case "L"://lift off to another celestial body
                this.liftOff();
                break;
            case "G"://gather fuel on the current planet
                this.gatherFuel();
                break;
            case "F"://current fuel percentage
                this.fuelPercentage();
                break;
            case "C"://current weapons available to use
                this.currentWeapon();
                break;
            case "A":
                this.FightAlien();
                break;
            case "S"://save game to play in the future
                this.saveGame();
                break;
            case "H"://help menu
                this.help();
                break;
            case "Q"://quit menu
                this.quit();
                break;
            default://returns invalid selection..try again to viewer
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return false;

    }

    private void travelMenu() {
        MapView mapView = new MapView();
        mapView.displayMap();
    }

    private void liftOff() {
        LiftOffView liftOffView = new LiftOffView();
        liftOffView.display();

    }

    private void gatherFuel() {
        GatherFuelView gatherFuelView = new GatherFuelView();
        gatherFuelView.display();
    }

    private void fuelPercentage() {
        FuelPercentageView fuelPercentageView = new FuelPercentageView();
        fuelPercentageView.display();
    }

    private void currentWeapon() {
        CurrentWeaponView currentWeaponView = new CurrentWeaponView();
        currentWeaponView.display();
    }

    private void saveGame() {
        this.console.println("***this function will save the game***");
    }

    private void help() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private void quit() {
        //quit function called in the do while statement above
    }

    private void FightAlien() {
        FightAlienView fightAlienView = new FightAlienView();
        fightAlienView.display();
    }

    
}
