package com.clima.dao;

import static com.clima.telas.TelaPrincipalClima.jbl_RecebeIDclienteTelaPrincipal;
import static com.clima.telas.TelaPrincipalClima.jbl_RecebeIDusuarioTelaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.clima.bean.TemperaturaBean;
import com.clima.connection.ModuloConexao;


public class TemperaturaDAO {

    public List<TemperaturaBean> listarTemp() throws ClassNotFoundException {

        Connection con = ModuloConexao.conector();

        double totalregistros = 0;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<TemperaturaBean> temperaturas = new ArrayList<>();

        try {
//            stmt = con.prepareStatement("SELECT * FROM tb_temperatura ");
//            stmt = con.prepareStatement("SELECT * FROM tb_temperatura where id_cliente ="+jbl_RecebeIDclienteTelaPrincipal.getText());
            stmt = con.prepareStatement("SELECT\n"
                    + "tb_login.id_login,\n"
                    + "tb_cliente.id_cliente,\n"
                    + "tb_temperatura.id_temperatura,\n"
                    + "tb_temperatura.unidade_medida,\n"
                    + "tb_temperatura.data_temperatura,\n"
                    + "tb_temperatura.temp_maxima,\n"
                    + "tb_temperatura.temp_minima\n"
                    + "FROM\n"
                    + "tb_cliente\n"
                    + "INNER JOIN tb_login ON tb_cliente.id_login = tb_login.id_login\n"
                    + "INNER JOIN tb_temperatura ON tb_temperatura.id_cliente = tb_cliente.id_cliente\n"
                    + "WHERE tb_login.id_login ="+jbl_RecebeIDusuarioTelaPrincipal.getText()
                    + "AND tb_cliente.id_cliente ="+jbl_RecebeIDclienteTelaPrincipal.getText()
                    + "ORDER BY id_temperatura DESC");

            rs = stmt.executeQuery();

            while (rs.next()) {
                TemperaturaBean temp = new TemperaturaBean();

                temp.setId_temperatura(rs.getInt("id_temperatura"));
                temp.setUnidade_medida(rs.getString("unidade_medida"));
                temp.setData_temperatura(rs.getDate("data_temperatura"));
                temp.setTemp_maxima(rs.getDouble("temp_maxima"));
                temp.setTemp_minima(rs.getDouble("temp_minima"));
                temp.setId_cliente(rs.getInt("id_cliente"));
                temperaturas.add(temp);

                totalregistros = totalregistros + 1;
            }

        } catch (SQLException ex) {
//            Logger.getLogger(TemperaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro!" + ex);
        } finally {
            ModuloConexao.closeConnection(con, stmt, rs);
        }

        return temperaturas;

    }
//    
//    public void create(TemperaturaBean t) throws ClassNotFoundException {
//
//        Connection con = ModuloConexao.conector();
//
//        PreparedStatement stmt = null;
//
//        try {
//            stmt = con.prepareStatement("INSERT INTO tb_temperatura (unidade_medida,data_temperatura,temp_maxima,temp_minima,id_cliente)VALUES(?,?,?,?,?)");
//            stmt.setString(1, t.getUnidade_medida());
//            stmt.setDate(2, t.getData_temperatura());
//            stmt.setDouble(3, t.getTemp_maxima());
//            stmt.setDouble(4, t.getTemp_maxima());
//
//            stmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
//        } catch (SQLException ex) {
//            //System.out.println(ex);
//            JOptionPane.showMessageDialog(null, "Erro ao Salvar!" + ex);
//        } finally {
//            ModuloConexao.closeConnection(con, stmt);
//        }
//
//    }
//
//
//
//    public List<TemperaturaBean> pesquisarTempData(String data_temperatura) throws ClassNotFoundException {
//
//        Connection con = ModuloConexao.conector();
//
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        List<TemperaturaBean> temperaturas = new ArrayList<>();
//
//        try {
//            stmt = con.prepareStatement("SELECT * FROM tb_temperatura WHERE data_temperatura LIKE ?");
//            //SELECT * FROM tb_temperatura WHERE data_temperatura  = '04/01/2018'
//            stmt.setString(1, "%" + data_temperatura + "%");
//
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//
//                TemperaturaBean temp = new TemperaturaBean();
//
//                temp.setId_temperatura(rs.getInt("id_temperatura"));
//                temp.setUnidade_medida(rs.getString("unidade_medida"));
//                temp.setData_temperatura(rs.getDate("data_temperatura"));
//                temp.setTemp_maxima(rs.getDouble("temp_maxima"));
//                temp.setTemp_minima(rs.getDouble("temp_minima"));
//                temp.setId_cliente(rs.getInt("id_cliente"));
//                temperaturas.add(temp);
//            }
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro!" + ex);
////            Logger.getLogger(TemperaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            ModuloConexao.closeConnection(con, stmt, rs);
//        }
//
//        return temperaturas;
//
//    }
//
//    public void update(TemperaturaBean t) throws ClassNotFoundException {
//
//        Connection con = ModuloConexao.conector();
//
//        PreparedStatement stmt = null;
//
//        try {
//
//            stmt = con.prepareStatement("UPDATE tb_temperatura SET unidade_medida=?,data_temperatura=?,temp_maxima=?,temp_minima=? WHERE id_temperatura=?");
//            stmt.setString(1, t.getUnidade_medida());
//            stmt.setDate(2, t.getData_temperatura());
//            stmt.setDouble(3, t.getTemp_maxima());
//            stmt.setDouble(4, t.getTemp_maxima());
//            stmt.setInt(5, t.getId_temperatura());
//
//            stmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
//        } finally {
//            ModuloConexao.closeConnection(con, stmt);
//        }
//
//    }
//
//    public void delete(TemperaturaBean t) throws ClassNotFoundException {
//
//        Connection con = ModuloConexao.conector();
//
//        PreparedStatement stmt = null;
//
//        try {
//            stmt = con.prepareStatement("DELETE FROM tb_temperatura WHERE id_temperatura=?");
//            stmt.setInt(1, t.getId_temperatura());
//
//            stmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
//        } finally {
//            ModuloConexao.closeConnection(con, stmt);//Fecha a Conexão e o Statement
//        }
//
//    }
//
}
