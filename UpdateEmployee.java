package sharanya_24WH1A0590;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateEmployee {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/24wh1a0590?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            // UPDATE query
            String sql = "UPDATE Employee SET salary = salary + 5000 WHERE dept = 'CSE'";

            // executeUpdate() returns number of affected rows
            int noOfRecordsUpdated = statement.executeUpdate(sql);

            // Print number of updated records
            System.out.println("Number of records updated: " + noOfRecordsUpdated);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found.");
            e.printStackTrace();
        }
    }
}
