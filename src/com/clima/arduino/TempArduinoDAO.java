package com.clima.arduino;

import com.clima.connection.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TempArduinoDAO {

    Connection con;
    Connection conexao = null;

    public boolean save(TempArduinoBEAN tp) throws ClassNotFoundException {
        this.con = ModuloConexao.conector();
        //Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tb_temparduino (temp_atual) VALUES (?)");
            stmt.setDouble(1, tp.getTempAtual());

            stmt.executeUpdate();
            return true; 

        } catch (SQLException ex) {

            System.err.println("Erro ao salvar" + ex);

            return false;
        } finally {
            //ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
//
// //https://tinyurl.com/y6qmnub3   - Java com Arduino - #03 - Criando Bean e DAO
//
//    //Apenas para testar se esta funcionando - Salvando o valor 23.0 no DataBase
//    public static void main(String []args) throws ClassNotFoundException{
//        TempArduinoBEAN temp = new TempArduinoBEAN();
//        temp.setTempAtual(25.0);
//        
//        TempArduinoDAO dao = new TempArduinoDAO();
//        if(dao.save(temp)){
//            System.out.println("Salvo com sucesso");
//        }else{
//            System.err.println("Erro ao salvar");
//        }
//    }
}
