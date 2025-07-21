
package com.securefileapp.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConfig {
    private static final String PROPERTIES_FILE = "/config.properties";

    public static Connection getConnection() throws Exception {
        Properties props = new Properties();
        try (InputStream input = DBConfig.class.getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                throw new RuntimeException("❌ config.properties file not found in resources");
            }
            props.load(input);
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }
}



//Class.forName("com.mysql.cj.jdbc.Driver");
