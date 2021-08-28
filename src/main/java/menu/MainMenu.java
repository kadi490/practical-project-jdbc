package menu;

import java.util.List;
import java.util.Scanner;

import model.ResultData;
import persistence.DatabaseManager;
import persistence.RepositoryResult;
import persistence.RepositoryUser;

public class MainMenu {
    private static DatabaseManager databaseManager;
    private static SubMenuOptions subMenuOptions;
    private static Scanner input;

    public static void main(String[] args) {
        databaseManager = new DatabaseManager();
        databaseManager.initTables();

        //RepositoryUser repositoryUser = new RepositoryUser();
        //repositoryUser.updateEmail("serkangmail.com", 1);

        //RepositoryResult repositoryResult = new RepositoryResult();
        // List<ResultData> data = repositoryResult.getResults("Stacey");

        //for (ResultData rd : data) {
        //    System.out.println(rd.toString());
        //}

        input = new Scanner(System.in);
        subMenuOptions = new SubMenuOptions();
        subMenuOptions.menuChoice(input);
    }

    public static void getMainMenu() {
        subMenuOptions.menuChoice(input);
    }
}
