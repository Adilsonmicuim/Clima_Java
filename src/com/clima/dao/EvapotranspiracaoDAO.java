package com.clima.dao;

import static com.clima.telas.TelaPrincipalClima.jbl_RecebeIDclienteTelaPrincipal;
import static com.clima.telas.TelaPrincipalClima.jbl_RecebeIDusuarioTelaPrincipal;
import com.clima.bean.EvapotranspiracaoBean;
import com.clima.connection.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EvapotranspiracaoDAO {
    
    public List<EvapotranspiracaoBean> listarEvap() throws ClassNotFoundException {
        
        Connection con = ModuloConexao.conector();
        
        PreparedStatement stmt = null;
//        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        
        List<EvapotranspiracaoBean> evap = new ArrayList<>();
        
        try {
//            stmt = con.prepareStatement("SELECT * FROM tb_evapotranspiracao where id_cliente ="+jbl_RecebeIDclienteTelaPrincipal.getText());
//            stmt2 = con.prepareStatement("SELECT * FROM tb_modeloequipamentoevapo");
            stmt = con.prepareStatement("SELECT\n"
                    + "tb_cliente.id_cliente,\n"
                    + "tb_cliente.id_login,\n"
                    + "tb_modeloequipamentoevapo.id_modeloequipamentoevapo,\n"
                    + "tb_evapotranspiracao.id_evapotranspiracao,\n"
                    + "tb_evapotranspiracao.unidade_medida,\n"
                    + "tb_evapotranspiracao.data_evapotranspiracao,\n"
                    + "tb_evapotranspiracao.qtidade_evapo\n"
                    + "FROM\n"
                    + "tb_login\n"
                    + "INNER JOIN tb_cliente ON tb_cliente.id_login = tb_login.id_login\n"
                    + "INNER JOIN tb_evapotranspiracao ON tb_evapotranspiracao.id_cliente = tb_cliente.id_cliente\n"
                    + "INNER JOIN tb_modeloequipamentoevapo ON tb_evapotranspiracao.id_modeloequipamentoevapo = tb_modeloequipamentoevapo.id_modeloequipamentoevapo\n"
                    + "WHERE tb_login.id_login ="+jbl_RecebeIDusuarioTelaPrincipal.getText()
                    + "AND tb_cliente.id_cliente ="+jbl_RecebeIDclienteTelaPrincipal.getText()
                    + "ORDER BY id_evapotranspiracao DESC");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                EvapotranspiracaoBean ev = new EvapotranspiracaoBean();
                
                ev.setId_evapotranspiracao(rs.getInt("id_evapotranspiracao"));
                ev.setUnidade_medida(rs.getString("unidade_medida"));
                ev.setData_evapotranspiracao(rs.getDate("data_evapotranspiracao"));
                ev.setQtidade_evapo(rs.getDouble("qtidade_evapo"));
                ev.setId_modeloequipamentoevapo(rs.getInt("id_modeloequipamentoevapo"));
                //ev.setModelo_descricao(rs.getString("modelo_descricao"));
                ev.setId_cliente(rs.getInt("id_cliente"));
                evap.add(ev);
            }
            
        } catch (SQLException ex) {
//            Logger.getLogger(TemperaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro!" + ex);
        } finally {
            ModuloConexao.closeConnection(con, stmt, rs);
        }
        
        return evap;
        
    }

//    public void create(EvapotranspiracaoBean e) throws ClassNotFoundException {
//
//        Connection con = ModuloConexao.conector();
//
//        PreparedStatement stmt = null;
//
//        try {
//            stmt = con.prepareStatement("INSERT INTO tb_evapotranspiracao (unidade_medida,data_evapotranspiracao,qtidade_evapo,id_cliente)VALUES(?,?,?,?)");
//            //stmt = con.prepareStatement("INSERT INTO tb_modeloequipamentoevapo (modelo_descricao)VALUES(?)");
//            stmt.setString(1, e.getUnidade_medida());
//            stmt.setDate(2, e.getData_evapotranspiracao());
//            stmt.setDouble(3, e.getQtidade_evapo());
//            stmt.setInt(4, e.getId_cliente());
//            //stmt.setString(5, e.getModelo_descricao());
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
//    public void update(EvapotranspiracaoBean e) throws ClassNotFoundException {
//
//        Connection con = ModuloConexao.conector();
//
//        PreparedStatement stmt = null;
//
//        try {
//
//            stmt = con.prepareStatement("UPDATE tb_evapotranspiracao SET unidade_medida=?,data_evapotranspiracao=?,qtidade_evapo=? WHERE id_evapotranspiracao=?");
//            //stmt = con.prepareStatement("UPDATE tb_modeloequipamentoevapo SET modelo_descricao=? WHERE id_modeloequipamentoevapo=?");
//            stmt.setString(1, e.getUnidade_medida());
//            stmt.setDate(2, e.getData_evapotranspiracao());
//            stmt.setDouble(3, e.getQtidade_evapo());
//            //stmt.setInt(4, e.getId_cliente());
//            //stmt.setString(4, e.getModelo_descricao());
//            stmt.setInt(4, e.getId_evapotranspiracao());
//            //stmt.setInt(5, e.getId_modeloequipamentoevapo());
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
//    public void delete(EvapotranspiracaoBean e) throws ClassNotFoundException {
//
//        Connection con = ModuloConexao.conector();
//
//        PreparedStatement stmt = null;
//
//        try {
//            stmt = con.prepareStatement("DELETE FROM tb_evapotranspiracao WHERE id_evapotranspiracao=?");
//            stmt.setInt(1, e.getId_evapotranspiracao());
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
//    public List<EvapotranspiracaoBean> PesquisarEvapData(String data_evapotranspiracao) throws ClassNotFoundException {
//
//        Connection con = ModuloConexao.conector();
//
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        List<EvapotranspiracaoBean> evap = new ArrayList<>();
//
//        try {
//
//            stmt = con.prepareStatement("SELECT * FROM tb_evapotranspiracao WHERE data_evapotranspiracao LIKE ?");
//            stmt.setString(1, "%" + data_evapotranspiracao + "%");
//
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//
//                EvapotranspiracaoBean ev = new EvapotranspiracaoBean();
//
//                ev.setId_evapotranspiracao(rs.getInt("id_evapotranspiracao"));
//                ev.setUnidade_medida(rs.getString("unidade_medida"));
//                ev.setData_evapotranspiracao(rs.getDate("data_evapotranspiracao"));
//                ev.setQtidade_evapo(rs.getDouble("qtidade_evapo"));
//                ev.setId_cliente(rs.getInt("id_cliente"));
//                evap.add(ev);
//            }
//
//        } catch (SQLException ex) {
////            Logger.getLogger(TemperaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Erro!" + ex);
//        } finally {
//            ModuloConexao.closeConnection(con, stmt, rs);
//        }
//
//        return evap;
//
//    }
}
