package org.contabancaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String url = "jdbc:mysql://localhost:3306/sistema_bancario";
    private static final String user = "root";
    private static final String password = "3617";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao Banco de Dados");
        }
    }
}
