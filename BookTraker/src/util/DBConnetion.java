package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnetion {
    private static final String URL = "jdbc:postgresql://localhost:5432/booktracker";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Conexao estabelecida!");
            return conn;
        } catch (SQLException e) {
            System.err.println(" Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
}
