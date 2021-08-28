package menu;

import model.Customer;
import model.ResultData;
import persistence.RepositoryCustomer;
import persistence.RepositoryResult;

import java.util.List;
import java.util.Scanner;

public class MenuResult {

    RepositoryResult repositoryResult = new RepositoryResult();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all results for a user");
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
                    menuListAllResults(input);
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

    private void menuListAllResults(Scanner input) {
        System.out.println("Type user first name: ");
        String firstName = input.next();

        List<ResultData> results = repositoryResult.getResults(firstName);

        if (results == null || results.isEmpty()) {
            System.out.println("No results were found for: " + firstName);
            menuOptions(input);
        } else {
            for (ResultData rd: results) {
                System.out.println(rd.toString());
            }
        }
    }
}
