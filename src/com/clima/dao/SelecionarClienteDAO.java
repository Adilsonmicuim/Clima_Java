package com.clima.dao;

import static com.clima.telas.TelaPrincipalClima.jbl_RecebeIDusuarioTelaPrincipal;
import com.clima.bean.CadClienteBean;
import com.clima.connection.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SelecionarClienteDAO {

    public List<CadClienteBean> listarClientes() throws ClassNotFoundException {

        Connection con = ModuloConexao.conector();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CadClienteBean> cli = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_cliente WHERE id_login ="+jbl_RecebeIDusuarioTelaPrincipal.getText());
            rs = stmt.executeQuery();

            while (rs.next()) {

                CadClienteBean c = new CadClienteBean();

                c.setId_cliente(rs.getInt("id_cliente"));
                c.setNomeCliente(rs.getString("nome"));
                c.setSobrenomeCliente(rs.getString("sobrenome"));
                c.setSituacao(rs.getString("situacao"));
                cli.add(c);
            }

        } catch (SQLException ex) {
//            Logger.getLogger(TemperaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro!" + ex);
        } finally {
            ModuloConexao.closeConnection(con, stmt, rs);
        }

        return cli;

    }

    public List<CadClienteBean> PesquisarNomeCli(String nome) throws ClassNotFoundException {

        Connection con = ModuloConexao.conector();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CadClienteBean> cli = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM tb_cliente WHERE nome LIKE ?");
            stmt.setString(1, "%" + nome + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                CadClienteBean c = new CadClienteBean();

                c.setId_cliente(rs.getInt("id_cliente"));
                c.setNomeCliente(rs.getString("nome"));
                c.setSobrenomeCliente(rs.getString("sobrenome"));
                c.setSituacao(rs.getString("situacao"));
                cli.add(c);

            }

        } catch (SQLException ex) {
//            Logger.getLogger(TemperaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro!" + ex);
        } finally {
            ModuloConexao.closeConnection(con, stmt, rs);
        }

        return cli;

    }
}
