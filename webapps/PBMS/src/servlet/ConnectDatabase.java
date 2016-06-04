package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public ConnectDatabase(String driver, String database, String database_user, String database_password) {
        try {
            Class.forName(driver);

            connection = DriverManager.getConnection(database, database_user, database_password);

        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("com.mysql.jdbc.Driver not found");
        } catch (SQLException sqlexception) {
            System.out.println("Connection database error");
        }
    }
}
