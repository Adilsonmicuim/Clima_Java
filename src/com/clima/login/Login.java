/*

 */
package com.clima.login;


//import java.awt.Font;
//import javax.swing.JTextField;
//import javax.swing.JPasswordField;
import java.sql.*;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.clima.connection.ModuloConexao;
import com.clima.telas.TelaPrincipalClima;

/**
 *
 * @author Adilson Lima de Paula
 */
public class Login extends javax.swing.JFrame {

    //atributos
    Connection conexao = null;
    PreparedStatement pst = null; //PreparedStatement: conjunto de bibliotecas - Variavel pst
    ResultSet rs = null; //exibir o resultado das instruções slq
    private Object data;

//*********************************************************************    
    public void logar() {
        // variável sql

        String sql = "select * from public.tb_login where login = ? and senha = ?";
        try {
            //As linhas abaixo captura o que esta sendo digitado na caixa de texto e consulta no banco.
            pst = conexao.prepareStatement(sql); // Prepara a variavel sql: select * from tb_login where login = ? and senha = ?
            pst.setString(1, jTextLogin.getText()); //Campo 01 - Substitui a interrogação pelo que foi digitado no campo 01
            pst.setString(2, jPasswordSenha.getText()); // campo 02 - Substitui a interrogação pelo que foi digitado no campo 02
            //a linha abaixo executa a query: Consulta ao banco de dados.
            rs = pst.executeQuery(); // executa o comando acima, pesquisando no DB.
            // na linha abaixo se existir usuário e senha correspondente
            // se existir vai acessar a tela Principal

//*********************************************************************  
            if (rs.next()) { // Estrutura de decisão
                // A linha abaixo obtem o conteúdo do campo "perfil" da tabela "tb_login"
                String perfil = rs.getString(5); // busca o conteúdo no campo 6 que esta relacionado ao "perfil"
                System.out.println(perfil);

                if (perfil.equals("admin")) {// se perfil igual admin

                    TelaPrincipalClima principal = new TelaPrincipalClima();
                    principal.setVisible(true);
//                    SelecionarCli cliente = new SelecionarCli();
//                    cliente.setVisible(true);

                    // Se o ususário for Admin tem acesso aos relatórios e cadastro
                    TelaPrincipalClima.jMenuRelatorio.setEnabled(true);
                    TelaPrincipalClima.jMenuCadastro.setEnabled(true);

                    //*********************************************************************  
                    // As 4 linhas abaixo apenas insere na Tela Principal quem é o usuário e seu perfil.
                    // Caso não queira identificar usuário e perfil basta comentar as linhas ou apagar o código
                    // Para mostrar na tela ptincipal o "jblUsuario" deve ser Public e estático.
                    TelaPrincipalClima.jblUsuario.setText(rs.getString(2));//mostra na tela principal nome do usuário
                    TelaPrincipalClima.jblUsuario.setForeground(Color.black);
                    // Para mostrar na tela ptincipal o "jblIDusuario" deve ser Public e estático.
                    TelaPrincipalClima.jbl_RecebeIDusuarioTelaPrincipal.setText(rs.getString(1));//mostra na tela principal ID do usuário
                    TelaPrincipalClima.jbl_RecebeIDusuarioTelaPrincipal.setForeground(Color.red);
                    // Para mostrar na tela ptincipal o "jblTipoUsuario" deve ser Public e estático.
                    TelaPrincipalClima.jblTipoUsuario.setText(rs.getString(5));//mostra na tela principal perfil do usuário
                    TelaPrincipalClima.jblTipoUsuario.setForeground(Color.red);
                    //*********************************************************************  
                    
                    habilitaBotoes(false);

                    this.dispose(); // Apos logar essa linha trata de fechar a tela Login
                    conexao.close(); // Esta linha é para fechar a conexão
                } else {
                    TelaPrincipalClima principal = new TelaPrincipalClima();
                    principal.setVisible(true);// assim que logar tela principal fica disponivel 
//                    SelecionarCli cliente = new SelecionarCli();
//                    cliente.setVisible(true);

                    // Se o ususário for Admin tem acesso aos relatórios e cadastro
                    TelaPrincipalClima.jMenuRelatorio.setEnabled(false);
                    TelaPrincipalClima.jMenuCadastro.setEnabled(false);

                    //*********************************************************************
                    // As 4 linhas abaixo apenas insere na Tela Principal quem é o usuário e seu perfil.
                    // Caso não queira identificar usuário e perfil basta comentar as linhas ou apagar o código
                    // Para mostrar na tela ptincipal o "jblUsuario" deve ser Public e estático.
                    TelaPrincipalClima.jblUsuario.setText(rs.getString(2));//mostra na tela principal nome do usuário
                    TelaPrincipalClima.jblUsuario.setForeground(Color.black);
                    // Para mostrar na tela ptincipal o "jblIDusuario" deve ser Public e estático.
                    TelaPrincipalClima.jbl_RecebeIDusuarioTelaPrincipal.setText(rs.getString(1));//mostra na tela principal ID do usuário
                    TelaPrincipalClima.jbl_RecebeIDusuarioTelaPrincipal.setForeground(Color.blue);
                    // Para mostrar na tela ptincipal o "jblTipoUsuario" deve ser Public e estático.
                    TelaPrincipalClima.jblTipoUsuario.setText(rs.getString(5));//mostra na tela principal perfil do usuário
                    TelaPrincipalClima.jblTipoUsuario.setForeground(Color.blue);
                    //*********************************************************************  

                    habilitaBotoes(false);
                    
                    this.dispose();//após logar fechar tela de login
                    conexao.close();//fechando conecxão com DB
                }
            } else {
                // Se não existir, mensagem na tela: Usuário ou Senha inválido.
                JOptionPane.showMessageDialog(null, "Usuário ou Senha inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }


    
    //*********************************************************************    
    public Login() { // Este trecho de código não é método e sim um construtor
        initComponents();  // Inicializa os componentes
        try {
            conexao = ModuloConexao.conector();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        // A linha abaixo serve de apoio para o desenvolvedor
        System.out.println(conexao); //Imprimi a string de conexão, ex: org.postgresql.jdbc3g.Jdbc3gConnection@721de9a5

//*********************************************************************        
        // imprimi se esta conectado ou Não conectado na tela do login
        if (conexao != null) {
            lblStatus.setText("Conectado, entre com suas credenciais!");
            //lblStatus.setForeground(Color.blue);
            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/clima/icons/dbok.png")));
        } else {
            lblStatus.setText("Não conectado, tente novamente!");
            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/clima/icons/dberror.png")));
            lblStatus.setForeground(Color.red);
//*********************************************************************  
        }
    }
    
    
    
    // Método para habilitar botoes na tela principal
    public void habilitaBotoes(boolean estado) {
        //jButtonCadastro.setEnabled(estado);
        TelaPrincipalClima.ButtonTemperaturas.setEnabled(estado);
        TelaPrincipalClima.ButtonPluviometria.setEnabled(estado);
        TelaPrincipalClima.ButtonEvapo.setEnabled(estado);
        TelaPrincipalClima.ButtonIrrigacao.setEnabled(estado);
        TelaPrincipalClima.ButtonRelatorios.setEnabled(estado);

        TelaPrincipalClima.ButtonCadastro.setEnabled(!estado); //Exclamação para negação
        TelaPrincipalClima.ButtonCliente.setEnabled(!estado); //Exclamação para negação
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelLoginDeAcesso = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        jButtonEntrar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jTextLogin = new javax.swing.JTextField();
        jPasswordSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(600, 610));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabelLoginDeAcesso.setFont(new java.awt.Font("Calibri", 0, 52)); // NOI18N
        jLabelLoginDeAcesso.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLoginDeAcesso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoginDeAcesso.setText("Login de Acesso");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLoginDeAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabelLoginDeAcesso)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(91, 95, 99));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("status");

        jButtonEntrar.setBackground(new java.awt.Color(0, 102, 153));
        jButtonEntrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonEntrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEntrar.setText("Entrar");
        jButtonEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonEntrarMouseExited(evt);
            }
        });
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });

        jButtonSair.setBackground(new java.awt.Color(255, 51, 51));
        jButtonSair.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonSair.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSair.setText("Sair");
        jButtonSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonSairMouseExited(evt);
            }
        });
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jTextLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextLogin.setToolTipText("");
        jTextLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextLoginActionPerformed(evt);
            }
        });

        jPasswordSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPasswordSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordSenhaActionPerformed(evt);
            }
        });

        jLabel1.setText("Login");

        jLabel2.setText("Senha");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPasswordSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatus)
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButtonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEntrarMouseEntered
        jButtonEntrar.setBackground(new Color(235, 235, 235));
        jButtonEntrar.setForeground(new Color(58, 65, 84));
    }//GEN-LAST:event_jButtonEntrarMouseEntered

    private void jButtonSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSairMouseEntered
        jButtonSair.setBackground(new Color(235, 235, 235));
        jButtonSair.setForeground(new Color(217, 81, 51));
    }//GEN-LAST:event_jButtonSairMouseEntered

    private void jButtonEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEntrarMouseExited
        jButtonEntrar.setBackground(new Color(58, 65, 84));
        jButtonEntrar.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButtonEntrarMouseExited

    private void jButtonSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSairMouseExited
        jButtonSair.setBackground(new Color(217, 81, 51));
        jButtonSair.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButtonSairMouseExited

    private void jTextLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextLoginActionPerformed
        jTextLogin.requestFocus();//O campo fica pronto para digitação (jText)
        jTextLogin.transferFocus();// Quando apertar enter pula para próxima linha
    }//GEN-LAST:event_jTextLoginActionPerformed

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        // Chama o método logar
        logar();
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jPasswordSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordSenhaActionPerformed
        jPasswordSenha.transferFocus();// Quando apertar enter pula para próxima linha
    }//GEN-LAST:event_jPasswordSenhaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelLoginDeAcesso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPasswordField jPasswordSenha;
    public static javax.swing.JTextField jTextLogin;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}
