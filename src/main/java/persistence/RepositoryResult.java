package persistence;

import model.ResultData;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryResult {
    private Connection connection;

    public RepositoryResult() {
        connection = DBUtil.getDBConnection();
    }

    public List<ResultData> getResults(String firstName) {
        List<ResultData> resultDataList = new ArrayList<>();

        String sql = "SELECT r.id, r.date_of_test, u.first_name, r.value, m.amount_of_pills, se.side_effect, m.date_of_next_test \n" +
                "FROM user u \n" +
                "INNER JOIN result r \n" +
                "ON r.user_id = u.id \n" +
                "INNER JOIN management m \n" +
                "ON m.result_id = r.id \n" +
                "INNER JOIN side_effect se \n" +
                "ON se.management_id = m.id \n" +
                "WHERE u.first_name = ?;";


        try {
            PreparedStatement statement = DBUtil.getDBConnection().prepareStatement(sql);
            statement.setString(1, firstName);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ResultData rd = new ResultData();
                rd.setId(resultSet.getInt("id"));
                rd.setTestDate(resultSet.getTimestamp("date_of_test"));
                rd.setFirstName(resultSet.getString("first_name"));
                rd.setValue(resultSet.getDouble("value"));
                rd.setAmountOfPills(resultSet.getInt("amount_of_pills"));
                rd.setSideEffects(resultSet.getString("side_effect"));
                rd.setNextTestDate(resultSet.getTimestamp("date_of_next_test"));
                resultDataList.add(rd);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultDataList;
    }
}
