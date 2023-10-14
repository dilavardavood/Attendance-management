package configs;

import java.sql.*;

public class JDBC {
    Connection con = null;
    Statement statement = null;
    PreparedStatement prepareStat = null;
    ResultSet result = null;

    public Connection jdbc() throws ClassNotFoundException, SQLException{
        try {
          //  Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/styria?user=root");
        } catch (SQLException e) {
            System.out.println("Error :" +e.getMessage());
            return null;
        }

    }

}
