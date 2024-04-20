package com.mthoko.censorapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionUtil {
    private static final String URL ="jdbc:sqlserver://localhost;trustServerCertificate=true;Database=master;";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "RPSsql12345";
/**
 * Server=localhost\SQLEXPRESS01;Database=master;Trusted_Connection=True;
 * @throws ClassNotFoundException 
 *
 */
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
       /**
        * Properties properties = new Properties();

        properties.setProperty("user", USERNAME);
       properties.setProperty("password", PASSWORD);
        *  */ 
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
