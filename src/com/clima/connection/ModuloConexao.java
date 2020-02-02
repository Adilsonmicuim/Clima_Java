package com.clima.connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.postgresql.core.ConnectionFactory;

// Camada de acesso a dados
public class ModuloConexao {

    public ModuloConexao() {
    }
    // Método responsável por estabelecer a conexão com o banco

    public static Connection conector() throws ClassNotFoundException {
        //Connection é um conjunto de funcionalidades que vem junto import java.sql.*; - conector é o nome do método
        //Quando cria um método sem o "void" é necessário um return
        java.sql.Connection conexao = null; // criamos a variável conexao e atribuimos null - Ou seja ñ existe conexão no momento

        // linha abaixo chama o driver sql
        String driver = "org.postgres.Driver";

        // Armazenando informações referente ao banco
        String url = "jdbc:postgresql://localhost:5432/ControleClimaDB";
        String user = "root";
        String password = "";

        //JOptionPane.showMessageDialog(null,"Conectado com sucesso ao Banco de Dados");
        // Estabelecendo a conexão com o banco de dados
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            return DriverManager.getConnection("jdbc:postgresql://localhost/ControleClimaDB", "postgres", "postgres");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            //System.out.println(e); //msg apoio para esclarecer o erro.
            throw new RuntimeException(e);
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
