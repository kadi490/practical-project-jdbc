package menu;

import model.ResultData;
import persistence.RepositoryResult;
import persistence.RepositoryUser;

import java.util.List;
import java.util.Scanner;

public class MenuUser {
    RepositoryUser repositoryUser = new RepositoryUser();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Update email for user");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    menuUpdateEmail(input);
                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            } // End of switch statement
        } while (userChoice != 100);
    }

    private void menuUpdateEmail(Scanner input) {

        System.out.println("Enter user id: ");
        int userId = input.nextInt();

        System.out.println("Enter new email address: ");
        String email = input.next();

        repositoryUser.updateEmail(email, userId);

        System.out.println("Email has been changed. ");
        menuOptions(input);

    }
}
