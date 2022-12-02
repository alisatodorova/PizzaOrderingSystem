package Database;

import java.sql.*;

public class BaseQuery {
    protected static Connection conn;
    protected ResultSet resultSet;
    protected Statement statement;
    private final String db = "jdbc:mysql://localhost:3306/restaurant";

    public void getConnection() {
        try {
            this.conn = DriverManager.getConnection(db, "root", "1234567890");
            System.out.println("Database Connected");
        } catch (Exception e) {
            System.out.println("Error: \n" + e);
        }
    }

    public void closeConnection() {
        try {
            if (this.resultSet != null) {
                this.resultSet.close();
            }
            if (this.statement != null) {
                this.statement.close();
            }
            if (this.conn != null) {
               this.conn.close();
                System.out.println("Connection Closed");
            }
        } catch (SQLException e) {
            System.out.println("Error: \n" + e);
        }
    }
}
