package sharanya_24WH1A0590;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmployee {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/24wh1a0590?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "1234";

        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect
            Connection connection = DriverManager.getConnection(url, user, password);

            // Create statement
            Statement statement = connection.createStatement();

            // DELETE query
            String sql = "DELETE FROM Employee WHERE emp_id = 1";

            // Execute update
            int rowsAffected = statement.executeUpdate(sql);

            // Result
            if (rowsAffected > 0) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("No record found with given condition.");
            }

            // Close connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
