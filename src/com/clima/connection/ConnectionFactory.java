package com.clima.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConnectionFactory {

    private static final String DRIVER = "org.postgres.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/ControleClimaDB3";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            return DriverManager.getConnection("jdbc:postgresql://localhost/ControleClimaDB3", "postgres", "postgres");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            throw new RuntimeException("Erro na conexão: ", e);
        }

    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
