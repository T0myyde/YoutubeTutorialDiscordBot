package ch.tomyy.bot.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQL {

    public static Connection connection;

    public static void startMySQL() {
        Properties properties = new Properties();

        try {
            properties.put("user", "root");
            properties.put("password", "");
            properties.put("autoReconnect", "true");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/main", properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
