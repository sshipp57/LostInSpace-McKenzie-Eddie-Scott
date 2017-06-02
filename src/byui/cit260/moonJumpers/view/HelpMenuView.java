/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.moonJumpers.view;

import java.util.Scanner;

/**
 *
 * @author sshipp57
 */
public class HelpMenuView {
    private String menu;

    public HelpMenuView() {
        this.menu = "\n"
              + "\n-------------------------------------"
              + "\n| Help Menu                         |"
              + "\n-------------------------------------"
              + "\n G - What is the goal of the game?   "
              + "\n M - How to Move                     "
              + "\n F - View Fuel Percentage            "
              + "\n Q - Quit                            ";
    }

    public void displayHelpMenuView() {
 boolean done = false;
        do {
        
              String menuOption = this.getMenuOption();
              if (menuOption.toUpperCase().equals("Q"))
                  return;
              
              done = this.doAction(menuOption);
        
        
        
        } while (!done);
    }

    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid) {
            System.out.println("\nEnter a Help Menu Option" + this.menu);
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() < 1) {
                System.out.println("\nInvalid value: value can not be blank");
                continue;
            }
        
            break;
        
        }
        
        return value;
    }

    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase();
        
        switch (choice) {
            case "G":
                this.goalGame();
                break;
            case "M":
                this.howMove();
                break;
            case "F":
                this.fuelPercentage();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
        
    }

    private void goalGame() {
        System.out.println("\n*** Calls goalGame() function ***");
    }

    private void howMove() {
        System.out.println("\n*** Calls howMove() function ***");
    }

    private void fuelPercentage() {
        System.out.println("\n*** Calls fuelPercentage() function ***");
    }

    }