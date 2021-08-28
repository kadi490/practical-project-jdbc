package persistence;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepositoryUser {
    private Connection connection;

    public RepositoryUser() {
        connection = DBUtil.getDBConnection();
    }

    public void updateEmail(String newEmail, int userId) {
        String sql = "UPDATE User u SET u.email_address = ? WHERE u.id = ?";


        try {
            PreparedStatement statement = DBUtil.getDBConnection().prepareStatement(sql);
            statement.setString(1, newEmail);
            statement.setInt(2, userId);
            statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
