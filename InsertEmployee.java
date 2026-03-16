package sharanya_24WH1A0590;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployee {
    public static void main(String[] args) {

        // JDBC URL, username and password
        String url = "jdbc:mysql://localhost:3306/24wh1a0590?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "1234";

        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to database
            Connection connection = DriverManager.getConnection(url, user, password);

            // Step 3: Create statement
            Statement statement = connection.createStatement();

            // Step 4: INSERT query
            String sql = "INSERT INTO Employee (emp_id, emp_name, dept, salary) " +
                         "VALUES (101, 'Ravi', 'IT', 45000)";

            // Step 5: Execute INSERT
            int rowsInserted = statement.executeUpdate(sql);

            if (rowsInserted > 0) {
                System.out.println("Employee record inserted successfully.");
            }

            // Step 6: Close connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.print("MySQL Driver not found.");
            e.printStackTrace();
        }
    }
}
