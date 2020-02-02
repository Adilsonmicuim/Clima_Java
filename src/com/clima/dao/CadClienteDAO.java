package com.clima.dao;

import com.clima.bean.CadClienteBean;
import com.clima.connection.ModuloConexao;
import static com.clima.telas.TelaPrincipalClima.jbl_RecebeIDusuarioTelaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CadClienteDAO {

    //atributos
    //ModuloConexao postgres = new ModuloConexao();
    Connection cn;
    String sSQL = "";
    String sSQL1 = "";
    String sSQL2 = "";
    String sSQL3 = "";
    String sSQL4 = "";
    Connection conexao = null;
    public Integer totalregistros;

    public CadClienteDAO() throws ClassNotFoundException {
        this.cn = ModuloConexao.conector();

        try {
            conexao = ModuloConexao.conector();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

   
    /*#######################################################################################################################################################*/
    public boolean salvarCadastroCliente(CadClienteBean dts) {
        sSQL1 = "INSERT INTO tb_estado (nome_estado, mesorregiao, uf)" + "VALUES(?,?,?)";
        sSQL2 = "INSERT INTO tb_cidade (nome_cidade, id_estado) VALUES(?,(select id_estado from tb_estado order by id_estado desc limit 1))";
        sSQL3 = "INSERT INTO tb_endereco (rua, numero, id_cidade) VALUES(?,?,(select id_cidade from tb_cidade order by id_cidade desc limit 1))";
        sSQL4 = "INSERT INTO tb_cliente (nome, sobrenome, situacao, id_login, id_endereco, id_estado) VALUES(?,?,?,?,"
                + "(select id_endereco from tb_endereco order by id_endereco desc limit 1),(select id_estado from tb_estado order by id_estado desc limit 1))";

//        sSQL = "BEGIN;\n"
//                + "   INSERT INTO tb_estado (nome_estado, mesorregiao, uf) VALUES (?,?,?);\n"
//                + "   INSERT INTO tb_cidade (nome_cidade, id_estado) VALUES(?,(select id_estado from tb_estado order by id_estado desc limit 1));\n"
//                + "   INSERT INTO tb_endereco (rua, numero, id_cidade) VALUES(?,?,(select id_cidade from tb_cidade order by id_cidade desc limit 1));\n"
//                + "   INSERT INTO tb_cliente (nome, sobrenome, situacao, id_endereco, id_login, id_estado) VALUES(?,?,?,(select id_endereco from tb_endereco order by id_endereco desc limit 1),?,(select id_estado from tb_estado order by id_estado desc limit 1));\n"
//                + "COMMIT;";
        try {

            PreparedStatement pst1 = cn.prepareStatement(sSQL1);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            PreparedStatement pst3 = cn.prepareStatement(sSQL3);
            PreparedStatement pst4 = cn.prepareStatement(sSQL4);

            pst1.setString(1, dts.getNome_estado());
            pst1.setString(2, dts.getMesorregiao());
            pst1.setString(3, dts.getUf());

            pst2.setString(1, dts.getNome_cidade());

            pst3.setString(1, dts.getRua());
            pst3.setString(2, dts.getNumero());

            pst4.setString(1, dts.getNomeCliente());
            pst4.setString(2, dts.getSobrenomeCliente());
            pst4.setString(3, dts.getSituacao());
            pst4.setInt(4, dts.getId_loginUsuario());

            int n = pst1.executeUpdate();
            if (n != 0) {

                int n2 = pst2.executeUpdate();
                if (n2 != 0) {

                    int n3 = pst3.executeUpdate();
                    if (n3 != 0) {

                        int n4 = pst4.executeUpdate();
                        if (n4 != 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    /*#######################################################################################################################################################*/
    public List<CadClienteBean> listarClientes() throws ClassNotFoundException {

        Connection con = ModuloConexao.conector();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<CadClienteBean> CadastroCliente = new ArrayList<>();

        try {
//         //stmt = con.prepareStatement("SELECT * FROM tb_estado, tb_cidade, tb_endereco, tb_cliente");
//----------------------------------------------------------------------------------------------------------------------------------------
//           stmt = con.prepareStatement("SELECT * FROM tb_cliente\n"
//                    + "INNER JOIN tb_estado ON tb_estado.id_estado = tb_cliente.id_estado\n"
//                    + "INNER JOIN tb_cidade ON tb_cidade.id_estado = tb_cliente.id_estado\n"
//                    + "INNER JOIN tb_endereco ON tb_endereco.id_cidade = tb_cidade .id_cidade\n"
//                    + "WHERE id_login ="+jbl_RecebeIDusuarioTelaPrincipal.getText());
//----------------------------------------------------------------------------------------------------------------------------------------
//            stmt = con.prepareStatement("SELECT\n"
//                    + "tb_cliente.id_cliente,\n"
//                    + "tb_cliente.nome,\n"
//                    + "tb_cliente.sobrenome,\n"
//                    + "tb_cliente.situacao,\n"
//                    + "tb_cliente.id_endereco,\n"
//                    + "tb_endereco.rua,\n"
//                    + "tb_endereco.numero,\n"
//                    + "tb_cidade.id_cidade,\n"
//                    + "tb_cidade.nome_cidade,\n"
//                    + "tb_estado.id_estado,\n"
//                    + "tb_estado.nome_estado,\n"
//                    + "tb_estado.mesorregiao,\n"
//                    + "tb_estado.uf\n"
//                    + "FROM\n"
//                    + "tb_cliente\n"
//                    + "INNER JOIN tb_endereco ON tb_cliente.id_endereco = tb_endereco.id_endereco\n"
//                    + "INNER JOIN tb_cidade ON tb_endereco.id_cidade = tb_cidade.id_cidade\n"
//                    + "INNER JOIN tb_estado ON tb_cliente.id_estado = tb_estado.id_estado AND tb_cidade.id_estado = tb_estado.id_estado");
//----------------------------------------------------------------------------------------------------------------------------------------
            stmt = con.prepareStatement("SELECT\n"
                    + "	tb_cliente.id_login,\n"
                    + "	tb_cliente.id_cliente,\n"
                    + "	tb_cliente.nome,\n"
                    + "	tb_cliente.sobrenome,\n"
                    + "	tb_cliente.situacao,\n"
                    + "	tb_endereco.id_endereco,\n"
                    + "	tb_endereco.rua,\n"
                    + "	tb_endereco.numero,\n"
                    + "	tb_cidade.id_cidade,\n"
                    + "	tb_cidade.nome_cidade,\n"
                    + "	tb_estado.id_estado,\n"
                    + "	tb_estado.nome_estado,\n"
                    + "	tb_estado.mesorregiao,\n"
                    + "	tb_estado.uf \n"
                    + "FROM\n"
                    + "	tb_estado\n"
                    + "	INNER JOIN tb_cidade ON tb_cidade.id_estado = tb_estado.id_estado\n"
                    + "	INNER JOIN tb_endereco ON tb_endereco.id_cidade = tb_cidade.id_cidade\n"
                    + "	INNER JOIN tb_cliente ON tb_cliente.id_estado = tb_estado.id_estado \n"
                    + "	AND tb_cliente.id_endereco = tb_endereco.id_endereco\n"
                    + "	WHERE id_login =" + jbl_RecebeIDusuarioTelaPrincipal.getText()
                    + " ORDER BY id_cliente DESC");

            rs = stmt.executeQuery();

            while (rs.next()) {

                CadClienteBean cadCli = new CadClienteBean();

                cadCli.setId_estado(rs.getInt("id_estado"));
                cadCli.setNome_estado(rs.getString("nome_estado"));
                cadCli.setMesorregiao(rs.getString("mesorregiao"));
                cadCli.setUf(rs.getString("uf"));
                cadCli.setId_cidade(rs.getInt("id_cidade"));
                cadCli.setNome_cidade(rs.getString("nome_cidade"));
                cadCli.setId_endereco(rs.getInt("id_endereco"));
                cadCli.setRua(rs.getString("rua"));
                cadCli.setNumero(rs.getString("numero"));
                cadCli.setNomeCliente(rs.getString("nome"));
                cadCli.setSobrenomeCliente(rs.getString("sobrenome"));
                cadCli.setSituacao(rs.getString("situacao"));
                cadCli.setId_cliente(rs.getInt("id_cliente"));
                CadastroCliente.add(cadCli);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: Precisa fazer o Login!\n" + ex);
        } finally {
            ModuloConexao.closeConnection(con, stmt, rs);
        }

        return CadastroCliente;

    }
     /*#######################################################################################################################################################*/
//    public DefaultTableModel pesquisar(String buscar) {
//
//        DefaultTableModel modelo;
//        String[] titulos = {"id_login", "id_cliente", "nome", "sobrenome", "situacao", "id_endereco", "rua", "numero", "id_cidade", "nome_cidade", "id_estado", "nome_estado", "mesorregiao", "uf"};
//        String[] registro = new String[14];
//        totalregistros = 0;
//
//        modelo = new DefaultTableModel(null, titulos);
//
//        sSQL = "SELECT\n"
//                + "	tb_cliente.id_login,\n"
//                + "	tb_cliente.id_cliente,\n"
//                + "	tb_cliente.nome,\n"
//                + "	tb_cliente.sobrenome,\n"
//                + "	tb_cliente.situacao,\n"
//                + "	tb_endereco.id_endereco,\n"
//                + "	tb_endereco.rua,\n"
//                + "	tb_endereco.numero,\n"
//                + "	tb_cidade.id_cidade,\n"
//                + "	tb_cidade.nome_cidade,\n"
//                + "	tb_estado.id_estado,\n"
//                + "	tb_estado.nome_estado,\n"
//                + "	tb_estado.mesorregiao,\n"
//                + "	tb_estado.uf \n"
//                + "FROM\n"
//                + "	tb_estado\n"
//                + "	INNER JOIN tb_cidade ON tb_cidade.id_estado = tb_estado.id_estado\n"
//                + "	INNER JOIN tb_endereco ON tb_endereco.id_cidade = tb_cidade.id_cidade\n"
//                + "	INNER JOIN tb_cliente ON tb_cliente.id_estado = tb_estado.id_estado \n"
//                + "	AND tb_cliente.id_endereco = tb_endereco.id_endereco\n"
//                + "	WHERE tb_cliente.nome =" + buscar + " ORDER BY id_cliente DESC";
//        
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
//            while (rs.next()) {
//                registro[0] = rs.getString("id_login");
//                registro[1] = rs.getString("id_cliente");
//                registro[2] = rs.getString("nome");
//                registro[3] = rs.getString("sobrenome");
//                registro[4] = rs.getString("situacao");
//                registro[5] = rs.getString("id_endereco");
//                registro[6] = rs.getString("rua");
//                registro[7] = rs.getString("numero");
//                registro[8] = rs.getString("id_cidade");
//                registro[9] = rs.getString("nome_cidade");
//                registro[10] = rs.getString("id_estado");
//                registro[11] = rs.getString("nome_estado");
//                registro[12] = rs.getString("mesorregiao");
//                registro[13] = rs.getString("uf");
//
//                totalregistros = totalregistros + 1;
//
//                modelo.addRow(registro);
//            }
//            return modelo;
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(null, e);
//            return null;
//        }
//
//    }

}
