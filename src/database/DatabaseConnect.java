package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DatabaseConnect {
        final String DB_URL = "jdbc:mysql://root@localhost:3306/Lab5_MAP";
        final String USER = "root";
        final String PASS = "admin";

        public Connection getConnection() throws SQLException {

            return DriverManager.getConnection(DB_URL, USER, PASS);
        }
    }

