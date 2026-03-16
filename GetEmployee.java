package sharanya_24WH1A0590;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetEmployee {
    public static void main(String[] args) {
        // JDBC URL, username and password
        String url = "jdbc:mysql://localhost:3306/24wh1a0590?useSSL=false&serverTimezone=UTC";
        String user = "root";             // or your dedicated user
        String password = "1234";         // Make sure it matches your MySQL root password

        try {
            // Step 1: Load MySQL JDBC Driver (optional for modern Connector/J)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to database
            Connection connection = DriverManager.getConnection(url, user, password);

            // Step 3: Create statement
            Statement statement = connection.createStatement();

            // Step 4: Execute query
            ResultSet rs = statement.executeQuery("SELECT * FROM Employee");

            // Step 5: Process results
            System.out.println("emp_id\temp_name\tdept\tsalary");
            while (rs.next()) {
                System.out.println(rs.getInt("emp_id") + "\t" +
                                   rs.getString("emp_name") + "\t" +
                                   rs.getString("dept") + "\t" +
                                   rs.getDouble("salary"));
            }

            // Step 6: Close connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found. Add the Connector/J jar to classpath.");
            e.printStackTrace();
        }
    }
}
