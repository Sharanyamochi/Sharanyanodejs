import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/5c8",
            "root",
            "1234"
        );
    }

    public int insert(Employee e) {

        int status = 0;

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();

            String sql =
                "INSERT INTO employee VALUES (" +
                e.getEid() + ", '" +
                e.getEname() + "', " +
                e.getSalary() + ", " +
                e.getAge() + ")";

            status = st.executeUpdate(sql);

            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public List<Employee> getAllEmployees() {

        List<Employee> list = new ArrayList<>();

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                Employee e = new Employee();

                e.setEid(rs.getInt("eid"));
                e.setEname(rs.getString("ename"));
                e.setSalary(rs.getInt("salary"));
                e.setAge(rs.getInt("age"));

                list.add(e);
            }

            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public int deleteEmployee(int eid) {

        int status = 0;

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();

            String sql = "DELETE FROM employee WHERE eid=" + eid;

            status = st.executeUpdate(sql);

            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public int updateEmployee(Employee e) {

        int status = 0;

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();

            String sql =
                "UPDATE employee SET " +
                "ename='" + e.getEname() + "', " +
                "salary=" + e.getSalary() + ", " +
                "age=" + e.getAge() +
                " WHERE eid=" + e.getEid();

            status = st.executeUpdate(sql);

            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
}
