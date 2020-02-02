
package com.clima.dao;


import com.clima.connection.ModuloConexao;
import java.sql.Connection;


public class PluviometriaDAO {
    private ModuloConexao postgres=new ModuloConexao();
//    private Connection con=postgres.conector();
    private String sSQL="";
    public Integer totalregistros;

}
//    private conexao mysql=new conexao();
//    private Connection cn=mysql.conectar();
//    private String sSQL="";
//     private String sSQL2="";
//    public Integer totalregistros;