package com.example.api.domain;

import java.sql.DriverManager;

public class Connection {
    public static java.sql.Connection connectDB() throws Exception {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/BK_Car_Api", "axel", "ax3l1234");
        return con;
    }
}
