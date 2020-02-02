

package com.clima.dao;

import javax.swing.table.DefaultTableModel;
import com.clima.connection.ModuloConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;



public class AlterLoginDAO {
    private final ModuloConexao postgres=new ModuloConexao();
    private final Connection con;
    private String sSQL="";
    public Integer totalregistros;


    public AlterLoginDAO() throws ClassNotFoundException {
        this.con = ModuloConexao.conector();
    }
    
    
    public DefaultTableModel mostrar(String buscar){
        
    DefaultTableModel modelo;
    String[] titulos = {"ID", "Login", "Senha", "Email", "Perfil"};
    String[] registro = new String[5];
    totalregistros = 0;
    
    modelo = new DefaultTableModel(null, titulos);
    sSQL = "select * from tb_login where login like '%" + buscar + "%' order by id_login";
    
    try{
        Statement st = con.createStatement();
        ResultSet rs=st.executeQuery(sSQL);
        while(rs.next()){
           registro [0]=rs.getString("id_login");
               registro [1]=rs.getString("login");
               registro [2]=rs.getString("senha");
               registro [3]=rs.getString("email");
               registro [4]=rs.getString("perfil");
                
               
               totalregistros = totalregistros +1;
               modelo.addRow(registro);
        }
        return modelo;
    }catch (Exception e){
        JOptionPane.showConfirmDialog(null, e);
        return null;
    }
    
    }
    
//    public boolean inserir (AlterLoginDAO dts){
//        sSQL = "insert into tb_login (login, senha, email, perfil)" +
//                "values(?,?,?,?)";
//        
//        try {
//            
//            PreparedStatement pst=con.prepareStatement(sSQL);
//            pst.setString(1, dts.getLogin());
//            pst.setString(2, dts.getSenha());
//            pst.setString(3, dts.getEmail());
//            pst.setDouble(4, dts.getPerfil());
//           
//            
//            int n=pst.executeUpdate();
//            if (n!=0){
//                return true;
//            }else{
//                return false;
//            }
//            
//        }catch (Exception e){
//             JOptionPane.showConfirmDialog(null, e);
//             return false;
//        }
//    }
//    
//    public boolean editar (AlterLoginDAO dts){
//        
//        sSQL="update tb_login set login=?, senha=?, email=?, perfil=?" +
//                "where id_login=?";
//        
//               
//        try {
//            PreparedStatement pst=con.prepareStatement(sSQL);
//            pst.setString(1, dts.getLogin());
//            pst.setString(2, dts.getSenha());
//            pst.setString(3, dts.getEmail());
//            pst.setDouble(4, dts.getPerfil());
//          
//            pst.setInt(5, dts.getId_login());
//            
//             int n=pst.executeUpdate();
//            if (n!=0){
//                return true;
//            }else{
//                return false;
//            }
//            
//        }catch (Exception e){
//             JOptionPane.showConfirmDialog(null, e);
//         return false;
//        }
//    }
//    
//    public boolean deletar (AlterLoginDAO dts){
//        sSQL="delete from getId_login where id_login=?";
//        
//        try {
//            PreparedStatement pst=con.prepareStatement(sSQL);
//            pst.setInt(1, dts.getId_login());
//             int n=pst.executeUpdate();
//            if (n!=0){
//                return true;
//            }else{
//                return false;
//            }
//        }catch (Exception e){
//             JOptionPane.showConfirmDialog(null, e);
//             return false;
//        }
//    }
    

}

