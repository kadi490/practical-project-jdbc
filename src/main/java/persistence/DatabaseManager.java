package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBUtil;

public class DatabaseManager {

    private Connection connection;

    public DatabaseManager() {
        DBUtil.createDatabase();
        connection = DBUtil.getDBConnection();
    }

    private void createTableUser() {
        String sql = "CREATE TABLE IF NOT EXISTS user (\n" +
                "  `id` INT NOT NULL,\n" +
                "  `first_name` VARCHAR(45) NULL,\n" +
                "  `last_name` VARCHAR(45) NULL,\n" +
                "  `email_address` VARCHAR(45) NULL,\n" +
                "  `national_emergency_number` VARCHAR(45) NULL,\n" +
                "  `care_provider_number` VARCHAR(45) NULL,\n" +
                "  `next_of_kin_number` VARCHAR(45) NULL,\n" +
                "  `password` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`id`));";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableResult() {
        String sql = "CREATE TABLE IF NOT EXISTS result (\n" +
                "  `id` INT NOT NULL,\n" +
                "  `date_of_test` DATETIME NULL,\n" +
                "  `value` DOUBLE NULL,\n" +
                "  `user_id` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  INDEX `fk_results_user1_idx` (`user_id` ASC) VISIBLE,\n" +
                "  CONSTRAINT `fk_results_user1`\n" +
                "    FOREIGN KEY (`user_id`)\n" +
                "    REFERENCES user (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION);";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableManagement() {
        String sql = "CREATE TABLE IF NOT EXISTS management (\n" +
                "  `id` INT NOT NULL,\n" +
                "  `amount_of_pills` INT NULL,\n" +
                "  `date_of_next_test` DATETIME NULL,\n" +
                "  `result_id` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  INDEX `fk_management_results1_idx` (`result_id` ASC) VISIBLE,\n" +
                "  CONSTRAINT `fk_management_results1`\n" +
                "    FOREIGN KEY (`result_id`)\n" +
                "    REFERENCES result (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION);\n";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTablePossibleSideEffect() {
        String sql = "CREATE TABLE IF NOT EXISTS possible_side_effect (\n" +
                "  `id` INT NOT NULL,\n" +
                "  `description` VARCHAR(255) NULL,\n" +
                "  `management_id` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  INDEX `fk_possible_side_effects_management1_idx` (`management_id` ASC) VISIBLE,\n" +
                "  CONSTRAINT `fk_possible_side_effects_management1`\n" +
                "    FOREIGN KEY (`management_id`)\n" +
                "    REFERENCES management (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION);\n";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableSideEffect() {
        String sql = "CREATE TABLE IF NOT EXISTS side_effect (\n" +
                "  `id` INT NOT NULL,\n" +
                "  `side_effect` VARCHAR(45) NULL,\n" +
                "  `comments` VARCHAR(255) NULL,\n" +
                "  `management_id` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  INDEX `fk_side_effects_management1_idx` (`management_id` ASC) VISIBLE,\n" +
                "  CONSTRAINT `fk_side_effects_management1`\n" +
                "    FOREIGN KEY (`management_id`)\n" +
                "    REFERENCES management (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION);";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableModusOperandi() {
        String sql = "CREATE TABLE IF NOT EXISTS modus_operandi (\n" +
                "  `id` INT NOT NULL,\n" +
                "  `suggestions` VARCHAR(255) NULL,\n" +
                "  `user_id` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  INDEX `fk_modus_operandi_user1_idx` (`user_id` ASC) VISIBLE,\n" +
                "  CONSTRAINT `fk_modus_operandi_user1`\n" +
                "    FOREIGN KEY (`user_id`)\n" +
                "    REFERENCES user (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION);";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableCustomer() {
        String sql = "CREATE TABLE IF NOT EXISTS customer (\n"
                + "	customer_id int NOT NULL AUTO_INCREMENT,\n"
                        + "	account_status int DEFAULT NULL,\n"
                        + "	email varchar(255) DEFAULT NULL,\n"
                        + "	first_name varchar(255) DEFAULT NULL,\n"
                        + "	last_name varchar(255) DEFAULT NULL,\n"
                        + "	password varchar(255) DEFAULT NULL,\n"
                        + "	phone_number varchar(255) DEFAULT NULL,\n"
                        + "	profile_image varchar(255) DEFAULT NULL,\n"
                        + "	username varchar(255) DEFAULT NULL,\n"
                        + "	 PRIMARY KEY (customer_id)\n"
                + ");";
        
        try {
             Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //private void (Tablename)
    public void initTables() {
        createTableCustomer();
        createTableUser();
        createTableResult();
        createTableManagement();
        createTablePossibleSideEffect();
        createTableSideEffect();
        createTableModusOperandi();
    }
}
