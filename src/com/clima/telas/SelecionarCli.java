package com.clima.telas;

import java.util.logging.Level;
import javax.swing.JOptionPane;
import java.util.logging.Logger;
import com.clima.bean.CadClienteBean;
import javax.swing.table.TableRowSorter;
import com.clima.dao.SelecionarClienteDAO;
import com.clima.telas.TelaPrincipalClima;
import javax.swing.table.DefaultTableModel;

public class SelecionarCli extends javax.swing.JFrame {

    //Contrutor
    private int id_cliente;
    
    public int getId_cliente() {
        return id_cliente;
    }
    
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public SelecionarCli() throws ClassNotFoundException {
        initComponents();
        listarNomeClientesJTable();
        txtIDCliente.setEditable(false);
        txtNomeCliente.setEditable(false);
        txtSobrenomeCliente.setEditable(false);
        txtIDCliente.setEnabled(false);
        txtNomeCliente.setEnabled(false);
        txtSobrenomeCliente.setEnabled(false);

        //Essas duas linhas abaixo é para ordenhar valores na tabela.
        DefaultTableModel listarClientes = (DefaultTableModel) jTableNomeCliente.getModel();
        jTableNomeCliente.setRowSorter(new TableRowSorter(listarClientes));
        
    }
    
    public void listarNomeClientesJTable() throws ClassNotFoundException {
        DefaultTableModel listarClientes = (DefaultTableModel) jTableNomeCliente.getModel();
        listarClientes.setNumRows(0);// Para não duplicar linhas na tabela

        SelecionarClienteDAO pdao = new SelecionarClienteDAO();
        for (CadClienteBean c : pdao.listarClientes()) {
            listarClientes.addRow(new Object[]{
                c.getId_cliente(),
                c.getNomeCliente(),
                c.getSobrenomeCliente(),
                c.getSituacao()
            });
        }
    }
    
    public void PesquisarNomeClientesJTable(String nome) throws ClassNotFoundException {
        DefaultTableModel PesquisarNomeCli = (DefaultTableModel) jTableNomeCliente.getModel();
        PesquisarNomeCli.setNumRows(0);// Para não duplicar linhas na tabela

        SelecionarClienteDAO pdao = new SelecionarClienteDAO();
        for (CadClienteBean c : pdao.PesquisarNomeCli(nome)) {
            PesquisarNomeCli.addRow(new Object[]{
                c.getId_cliente(),
                c.getNomeCliente(),
                c.getSobrenomeCliente(),
                c.getSituacao()
            });
        }
    }
    
    private void limparClientes() {// método para limparTemperatura campos para entrar com novos dados

        if (txtIDCliente.getText().trim().equals("")) {//trim: remove campos vazios
            //System.out.println("Campo vazio");
            JOptionPane.showMessageDialog(null, "Campo vazio.", "Erro", JOptionPane.WARNING_MESSAGE);
        } else {
            //System.out.println(" campo preenchido");
            JOptionPane.showMessageDialog(null, "Tem certeza que deseja limpar os campos?");
        }

        //A linha abaixo chama o método apagar os campos
        limparCamposCliente();
        
    }
    
    public void limparCamposCliente() {
        txtPesquisarNomeCliente.setText(null);
        txtIDCliente.setText(null);
        txtNomeCliente.setText(null);
        txtSobrenomeCliente.setText(null);
    }
    
        // Método para habilitar botoes na tela principal
    public void habilitaBotoes(boolean estado) {
        //jButtonCadastro.setEnabled(estado);
        TelaPrincipalClima.ButtonTemperaturas.setEnabled(estado);
        TelaPrincipalClima.ButtonPluviometria.setEnabled(estado);
        TelaPrincipalClima.ButtonEvapo.setEnabled(estado);
        TelaPrincipalClima.ButtonIrrigacao.setEnabled(estado);
        TelaPrincipalClima.ButtonRelatorios.setEnabled(estado);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNomeCliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtIDCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSobrenomeCliente = new javax.swing.JTextField();
        ButtonPegar = new javax.swing.JButton();
        ButtonSair = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ButtonClientePesquisar = new javax.swing.JButton();
        txtPesquisarNomeCliente = new javax.swing.JTextField();
        jButtonLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecionar um Cliente");

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTableNomeCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Sobrenome", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableNomeCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNomeClienteMouseClicked(evt);
            }
        });
        jTableNomeCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableNomeClienteKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableNomeCliente);

        jLabel1.setText("ID:");

        txtIDCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setText("Nome:");

        txtNomeCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setText("Sobrenome:");

        txtSobrenomeCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        ButtonPegar.setText("Pegar");
        ButtonPegar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonPegarMouseClicked(evt);
            }
        });
        ButtonPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPegarActionPerformed(evt);
            }
        });

        ButtonSair.setText("Sair");
        ButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSairActionPerformed(evt);
            }
        });

        jLabel4.setText("Nome:");

        ButtonClientePesquisar.setText("Pesquisar");
        ButtonClientePesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonClientePesquisarActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(ButtonPegar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jButtonLimpar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(txtPesquisarNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(ButtonClientePesquisar))
                        .addComponent(txtIDCliente)
                        .addComponent(txtSobrenomeCliente))
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ButtonClientePesquisar)
                            .addComponent(txtPesquisarNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtSobrenomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonPegar)
                            .addComponent(ButtonSair)
                            .addComponent(jButtonLimpar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1040, 659));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableNomeClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNomeClienteMouseClicked
        //A clicar na linha da tabela, setar valores nos campos de digitação.
        if (jTableNomeCliente.getSelectedRow() != -1) {
            
            txtIDCliente.setText(jTableNomeCliente.getValueAt(jTableNomeCliente.getSelectedRow(), 0).toString());
            txtNomeCliente.setText(jTableNomeCliente.getValueAt(jTableNomeCliente.getSelectedRow(), 1).toString());
            txtSobrenomeCliente.setText(jTableNomeCliente.getValueAt(jTableNomeCliente.getSelectedRow(), 2).toString());
            
        }
    }//GEN-LAST:event_jTableNomeClienteMouseClicked

    private void jTableNomeClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableNomeClienteKeyReleased
        //A clicar na linha da tabela, setar valores nos campos de digitação.
        if (jTableNomeCliente.getSelectedRow() != -1) {
            
            txtIDCliente.setText(jTableNomeCliente.getValueAt(jTableNomeCliente.getSelectedRow(), 0).toString());
            txtNomeCliente.setText(jTableNomeCliente.getValueAt(jTableNomeCliente.getSelectedRow(), 1).toString());
            txtSobrenomeCliente.setText(jTableNomeCliente.getValueAt(jTableNomeCliente.getSelectedRow(), 2).toString());
            
        }
    }//GEN-LAST:event_jTableNomeClienteKeyReleased

    private void ButtonPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPegarActionPerformed
        //Esta linha pega o valor do ID do cliente converte para inteiro e joga para a variável id_cliente (Contrutor).

        if (txtIDCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo vazio.", "Erro", JOptionPane.WARNING_MESSAGE);
            
        } else {
            //Esta linha abaixo pega o valor do ID do cliente converte para inteiro e joga para a variável id_cliente (Contrutor).
            String cod;
            cod = txtIDCliente.getText();
            //Temperaturas.txtIDclienteRecebe.setText(cod);
            TelaPrincipalClima.jbl_RecebeIDclienteTelaPrincipal.setText(cod);
            JOptionPane.showMessageDialog(null, "ID: " + txtIDCliente.getText() + "\nNome: " + txtNomeCliente.getText() + "\nSobrenome: " + txtSobrenomeCliente.getText());
            habilitaBotoes(true);
            this.dispose();//fecha a janela
        }
        //---------------------------------------------------------------------------------------------------------------------------------------------
//        if (txtIDCliente.getText().equals("")) {
//            JOptionPane.showMessageDialog(null, "Campo vazio.", "Erro", JOptionPane.WARNING_MESSAGE);
//        } else {
//            //Esta linha abaixo pega o valor do ID do cliente converte para inteiro e joga para a variável id_cliente (Contrutor).
//            this.id_cliente = Integer.parseInt(this.txtIDCliente.getText());
//            JOptionPane.showMessageDialog(null, "ID: " + txtIDCliente.getText() + "\nNome: " + txtNomeCliente.getText() + "\nSobrenome: " + txtSobrenomeCliente.getText());
//            this.dispose();//fecha a janela
//        }
        //---------------------------------------------------------------------------------------------------------------------------------------------
//        if (txtIDCliente.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Campo vazio.", "Erro", JOptionPane.WARNING_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(null, "ID: " + txtIDCliente.getText() + "\nNome: " + txtNomeCliente.getText() + "\nSobrenome: " + txtSobrenomeCliente.getText());
//
//            SelecionarClienteBean IDcliente = new SelecionarClienteBean();
//            IDcliente.setId_cliente(txtIDCliente.getText());
//            TelaPrincipalClima jblIDClienteTelaPrincipal = new TelaPrincipalClima();
//            jblIDClienteTelaPrincipal.exportarIDCliente(IDcliente);
//            jblIDClienteTelaPrincipal.setVisible(true);
//            this.dispose();//fecha a janela
//        }
//---------------------------------------------------------------------------------------------------------------------------------------------
    }//GEN-LAST:event_ButtonPegarActionPerformed

    private void ButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, " Deseja fechar a tela de seleção de cliente? ", " Atenção ", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            this.dispose();
        } //fecha somente o JFrame em questão, onde this = JFrame.
    }//GEN-LAST:event_ButtonSairActionPerformed

    private void ButtonClientePesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonClientePesquisarActionPerformed
        // TODO add your handling code here:
        if (txtPesquisarNomeCliente.getText().trim().equals("")) {//trim: remove campos vazios
            //System.out.println("Campo vazio");
            JOptionPane.showMessageDialog(null, "Campo vazio.", "Erro", JOptionPane.WARNING_MESSAGE);
        } else {
            //System.out.println(" campo preenchido");
        }
        
        try {
            PesquisarNomeClientesJTable(txtPesquisarNomeCliente.getText());
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(SelecionarCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Cliente não Cadastrado." + ex);
        }
        //limparCamposCliente();
    }//GEN-LAST:event_ButtonClientePesquisarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        limparClientes();

    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void ButtonPegarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPegarMouseClicked

//        TelaPrincipalClima principal = new TelaPrincipalClima();
//        principal.setVisible(false); dispose(); 
    }//GEN-LAST:event_ButtonPegarMouseClicked

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
            java.util.logging.Logger.getLogger(SelecionarCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecionarCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecionarCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecionarCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SelecionarCli().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SelecionarCli.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonClientePesquisar;
    private javax.swing.JButton ButtonPegar;
    private javax.swing.JButton ButtonSair;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNomeCliente;
    private javax.swing.JTextField txtIDCliente;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtPesquisarNomeCliente;
    private javax.swing.JTextField txtSobrenomeCliente;
    // End of variables declaration//GEN-END:variables
}
