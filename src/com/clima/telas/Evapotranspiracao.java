package com.clima.telas;

import static com.clima.telas.TelaPrincipalClima.jbl_RecebeIDclienteTelaPrincipal;
import com.clima.dao.EvapotranspiracaoDAO;
import javax.swing.table.DefaultTableModel;
import com.clima.bean.EvapotranspiracaoBean;
import com.clima.connection.ModuloConexao;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableRowSorter;

public final class Evapotranspiracao extends javax.swing.JInternalFrame {

    //atributos
    Connection conexao = null;
    PreparedStatement pst = null;//PreparedStatement: conjunto de bibliotecas - Variavel pst
    ResultSet rs = null; //exibir o resultado das instruções slq

    public Evapotranspiracao() throws ClassNotFoundException {
        initComponents();
        listarEvapotranspiracaoJTable();
        registrosInicialEvapotranspiracao(true);
        jButtonSelecionarCliente.setEnabled(false);
        txt_id_cliente_Evapotranspiracao.setEnabled(false);

        //Essas duas linhas abaixo é para ordenhar valores na tabela.
        DefaultTableModel listarEvap = (DefaultTableModel) jTableEvapotranspiracao.getModel();
        jTableEvapotranspiracao.setRowSorter(new TableRowSorter(listarEvap));

        try {
            conexao = ModuloConexao.conector();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Temperaturas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void salvarEvapotranspiracao() {// método para salvarEvapotranspiração novos dados "ADICIONAR"
        String sql = "INSERT INTO public.tb_evapotranspiracao (unidade_medida, data_evapotranspiracao, qtidade_evapo, id_cliente, id_modeloequipamentoevapo) values (?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, ComboBoxUnEvap.getSelectedItem().toString()); // .toString() = É´para converter para string
            pst.setDate(2, new java.sql.Date(DateChooserEvap.getDate().getTime()));
            pst.setDouble(3, (Double) (Number) Double.parseDouble(txtQtidadeEvap.getText()));
            pst.setInt(4, Integer.parseInt(txt_id_cliente_Evapotranspiracao.getText()));
            pst.setInt(5, Integer.parseInt(idAparelho.getText())); //Modelo do aparelho

            //A linha abaixo atualiza a tabela de temperaturas com os dados preenchidos - digitado.
            int adicionado = pst.executeUpdate();
            System.out.println(adicionado);//apenas para apoio ao entendimento da lógica
            if (adicionado > 0) { //Se valor adicionado no banco de dados for maior que Um
                JOptionPane.showMessageDialog(null, "Cadastro concluído com sucesso! ");

                //A linha abaixo chama o método apagar os campos
                limparCamposEvapotranspiracao();
                //A linha abaixo após SALVAR listarEvapotranspiracao dados na tabela.
                listarEvapotranspiracaoJTable();

            }
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, " Erro ao salvar dados\n ERRO: " + e);//Caso ocorra alguma excessão será exibido na tela
        }

    }

    /*#######################################################################################################################################################*/
    private void consultarEvapotranspiracao() {//método para pesquisar
        String sql = "select * from public.tb_evapotranspiracao where id_evapotranspiracao = ? AND id_cliente ="+jbl_RecebeIDclienteTelaPrincipal.getText();

        try {
            pst = conexao.prepareStatement(sql);

            //Na linha abaixo ele vai pesquisar o ID 
            int id = Integer.parseInt(txtIDEvapotranspiracao.getText());
            pst.setInt(1, id);//obter o valor digitado no campo, substitui a interrogação por "id_evapotranspiracao"

            rs = pst.executeQuery();
            //Linha abaixo caso tenha o registro (ID) correspondente preencher os campos
            if (rs.next()) { // caso tenha a ID correspôndente, setar os campos
                ComboBoxUnEvap.setSelectedItem(rs.getString(2));// O Número 2 significa que vai pegar o segundo campo da tabela no banco de dados.
                DateChooserEvap.setDate(rs.getDate(3));//Data da evapotranspiração
                txtQtidadeEvap.setText(rs.getString(4));//Evapotranspiração quantidade
                txt_ModelAparEvapotranspiracao.setText(rs.getString(5));//Modelo aparelho

            } else {
                JOptionPane.showMessageDialog(null, "Evapotranspiração não Cadastrada.");//caso não encontre nenhuma temperatura cadastrado exibe a mensagem.
                //Caso ID não encontrada no banco de dados faz chama do método abaixo
                //A linha abaixo chama o método apagar os campos
                limparCamposEvapotranspiracao();
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            //JOptionPane.showMessageDialog(null, " Erro ao consultar dados\n ERRO: " + e);//Caso ocorra alguma excessão será exibido na tela.
        }
    }


    /*#######################################################################################################################################################*/
    private void updateEvapotranspiracao() {// método para atualizar novos dados
        String sql = "UPDATE public.tb_evapotranspiracao SET unidade_medida=?, data_evapotranspiracao=?, qtidade_evapo=?, id_modeloequipamentoevapo=? WHERE id_evapotranspiracao=?";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, ComboBoxUnEvap.getSelectedItem().toString()); // .toString() = É´para converter para string
            pst.setDate(2, new java.sql.Date(DateChooserEvap.getDate().getTime()));
            pst.setDouble(3, (Double) (Number) Double.parseDouble(txtQtidadeEvap.getText()));
            pst.setInt(4, Integer.parseInt(idAparelho.getText())); //Modelo do aparelho
            pst.setInt(5, Integer.parseInt(txtIDEvapotranspiracao.getText()));

            int adicionado = pst.executeUpdate();
            //System.out.println(adicionado);//apenas para apoio ao entendimento da lógica
            if (adicionado > 0) { //Se valor adicionado no banco de dados for maior que Um
                JOptionPane.showMessageDialog(null, "Atualização feita com sucesso! ");
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, " Erro ao atualizar dados\n ERRO: " + e);//Caso ocorra alguma excessão será exibido na tela
        }

    }

    /*#######################################################################################################################################################*/
    private void excluirEvapotranspiracao() {// método para apagar dados do DB
        // A estrutura abaixo confirma a remoção dos dados
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja EXLUIR OS DADOS?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM public.tb_evapotranspiracao WHERE id_evapotranspiracao=?";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(txtIDEvapotranspiracao.getText()));

                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Registro removido com sucesso!");

                }
            } catch (HeadlessException | NumberFormatException | SQLException e) {
                //JOptionPane.showMessageDialog(null, e);
            }
        }

    }


    /*#######################################################################################################################################################*/
    public void limparCamposEvapotranspiracao() {
        txtIDEvapotranspiracao.setText(null);
        //ComboBoxUnEvap.setSelectedItem(null);
        DateChooserEvap.setDate(null);
        txtQtidadeEvap.setText(null);
        //txtModelAparEvap.setText(null);
        //txt_ModelAparEvapotranspiracao.setText(null);
        //txtIDclienteReceb.setText(null);
        registrosInicialEvapotranspiracao(true);
    }


    /*#######################################################################################################################################################*/
    // Método para habilitar cadastro evapotranspiração.
    //Exclamação para negação
    public void registrosInicialEvapotranspiracao(boolean estado) {
        txtIDEvapotranspiracao.setEnabled(estado);
        jButtonPesquisarEvap.setEnabled(estado);
        jButtonNovaEvap.setEnabled(estado);
        ButtonSalvarEvap.setEnabled(!estado);
        ButtonExcluirEvap.setEnabled(!estado);
        ButtonUpdateEvap.setEnabled(!estado);
        ButtonLimparEvap.setEnabled(estado);
        DateChooserEvap.setEnabled(!estado);
        txtQtidadeEvap.setEnabled(!estado);
        txt_ModelAparEvapotranspiracao.setEnabled(!estado);
        jButtonSelecionaAparelhoEvap.setEnabled(!estado);

    }

    /*#######################################################################################################################################################*/
    public void habilitaNovoRegistroEvapotranspiracao() {
        jButtonNovaEvap.setEnabled(false);
        ButtonSalvarEvap.setEnabled(true);
        ButtonExcluirEvap.setEnabled(false);
        ButtonUpdateEvap.setEnabled(false);
        DateChooserEvap.setEnabled(true);
        ComboBoxUnEvap.setEnabled(true);
        txtQtidadeEvap.setEnabled(true);
        txt_ModelAparEvapotranspiracao.setEnabled(true);
        jButtonSelecionaAparelhoEvap.setEnabled(true);
        txtIDEvapotranspiracao.setEnabled(false);
        jButtonPesquisarEvap.setEnabled(false);
    }

    /*#######################################################################################################################################################*/
    public void habilitaUpdateExcluirEvapotranspiracao() {
        jButtonNovaEvap.setEnabled(false);
        ButtonSalvarEvap.setEnabled(false);
        ButtonExcluirEvap.setEnabled(true);
        ButtonUpdateEvap.setEnabled(true);
        DateChooserEvap.setEnabled(true);
        ComboBoxUnEvap.setEnabled(true);
        txtQtidadeEvap.setEnabled(true);
        txt_ModelAparEvapotranspiracao.setEnabled(true);
        jButtonSelecionaAparelhoEvap.setEnabled(true);
        txtIDEvapotranspiracao.setEnabled(true);
        jButtonPesquisarEvap.setEnabled(true);
    }

    /*#######################################################################################################################################################*/
    public void camposObrigatorios() {
        if (ComboBoxUnEvap.getSelectedItem().toString().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira a unidade de medida.");
            ComboBoxUnEvap.requestFocus();
            return;
        }

        if (DateChooserEvap.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Insira a data referente ao registro.");
            DateChooserEvap.requestFocus();
            return;
        }

        if (txtQtidadeEvap.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira a quantdade Evapotranspiração.");
            txtQtidadeEvap.requestFocus();
            return;
        }

        if (txt_ModelAparEvapotranspiracao.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira o Modelo de Aparelho.");
            txt_ModelAparEvapotranspiracao.requestFocus();
            return;
        }
    }

    /*#######################################################################################################################################################*/
    public void listarEvapotranspiracaoJTable() throws ClassNotFoundException {
        DefaultTableModel listarEvap = (DefaultTableModel) jTableEvapotranspiracao.getModel();
        listarEvap.setNumRows(0);

        EvapotranspiracaoDAO pdao = new EvapotranspiracaoDAO();
        for (EvapotranspiracaoBean e : pdao.listarEvap()) {
            listarEvap.addRow(new Object[]{
                e.getId_evapotranspiracao(),
                e.getUnidade_medida(),
                e.getData_evapotranspiracao(),
                e.getQtidade_evapo(),
                e.getId_modeloequipamentoevapo(),
                e.getId_cliente()
            });

        }

    }
    /*#######################################################################################################################################################*/
    //Método para substituir virgula por ponto e recusar teclas não numéricas.
    public void teclaPressionada(KeyEvent tecla, JTextField txt) {
        //ASCII Numero zero até nove é representado pelo 48 até 57
        //ASCII Space é representado pelo valor 8
        //ASCII Ponto é representado pelo valor 46
        if (((tecla.getKeyCode() < 48 || tecla.getKeyCode() > 57)
                && (tecla.getKeyCode() < 96 || tecla.getKeyCode() > 105) //Linha de código feito para meu teclado numérico.
                && (tecla.getKeyCode() != 8 && tecla.getKeyCode() != 46))) {
            if (txt.getText().length() > 0) {
                txt.setText(txt.getText().
                        substring(0, txt.getText().length() - 1));
            }
        }

        //ASCII trocando virgula por ponto
        if (tecla.getKeyCode() == 44 || tecla.getKeyCode() == 110) {//A virgula é representado pelo valor 44 e o 110 teclado numérico.
            txt.setText(txt.getText() + ".");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIDEvapotranspiracao = new javax.swing.JTextField();
        txtQtidadeEvap = new javax.swing.JTextField();
        jButtonPesquisarEvap = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_ModelAparEvapotranspiracao = new javax.swing.JTextField();
        ComboBoxUnEvap = new javax.swing.JComboBox<>();
        DateChooserEvap = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEvapotranspiracao = new javax.swing.JTable();
        ButtonSalvarEvap = new javax.swing.JButton();
        ButtonLimparEvap = new javax.swing.JButton();
        ButtonUpdateEvap = new javax.swing.JButton();
        ButtonExcluirEvap = new javax.swing.JButton();
        ButtonSair = new javax.swing.JButton();
        idAparelho = new javax.swing.JLabel();
        jButtonNovaEvap = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButtonSelecionarCliente = new javax.swing.JButton();
        txt_id_cliente_Evapotranspiracao = new javax.swing.JTextField();
        jButtonSelecionaAparelhoEvap = new javax.swing.JButton();

        setTitle("Evapotranspiração");

        jPanel1.setBackground(new java.awt.Color(164, 233, 233));

        jLabel1.setText("ID:");

        jLabel2.setText("*Unidade:");

        jLabel3.setText("*Data:");

        jLabel4.setText("*Quantidade:");

        txtQtidadeEvap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtidadeEvapActionPerformed(evt);
            }
        });
        txtQtidadeEvap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtidadeEvapKeyReleased(evt);
            }
        });

        jButtonPesquisarEvap.setText("Pesquisar");
        jButtonPesquisarEvap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarEvapActionPerformed(evt);
            }
        });

        jLabel5.setText("Model. Aparelho:");

        txt_ModelAparEvapotranspiracao.setText("1");

        ComboBoxUnEvap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mm" }));

        jTableEvapotranspiracao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Unidade", "Data", "Qtidade", "Aparelho", "Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEvapotranspiracao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEvapotranspiracaoMouseClicked(evt);
            }
        });
        jTableEvapotranspiracao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableEvapotranspiracaoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEvapotranspiracao);
        if (jTableEvapotranspiracao.getColumnModel().getColumnCount() > 0) {
            jTableEvapotranspiracao.getColumnModel().getColumn(0).setResizable(false);
            jTableEvapotranspiracao.getColumnModel().getColumn(1).setResizable(false);
            jTableEvapotranspiracao.getColumnModel().getColumn(2).setResizable(false);
            jTableEvapotranspiracao.getColumnModel().getColumn(3).setResizable(false);
            jTableEvapotranspiracao.getColumnModel().getColumn(4).setResizable(false);
            jTableEvapotranspiracao.getColumnModel().getColumn(5).setResizable(false);
        }

        ButtonSalvarEvap.setText("Salvar");
        ButtonSalvarEvap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalvarEvapActionPerformed(evt);
            }
        });

        ButtonLimparEvap.setText("Limpar");
        ButtonLimparEvap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLimparEvapActionPerformed(evt);
            }
        });

        ButtonUpdateEvap.setText("Atualizar");
        ButtonUpdateEvap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUpdateEvapActionPerformed(evt);
            }
        });

        ButtonExcluirEvap.setText("Excluir");
        ButtonExcluirEvap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExcluirEvapActionPerformed(evt);
            }
        });

        ButtonSair.setText("Sair");
        ButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSairActionPerformed(evt);
            }
        });

        idAparelho.setText("1");

        jButtonNovaEvap.setText("Novo");
        jButtonNovaEvap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaEvapActionPerformed(evt);
            }
        });

        jLabel6.setText("*Cliente:");

        jButtonSelecionarCliente.setText("Cliente");
        jButtonSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarClienteActionPerformed(evt);
            }
        });

        txt_id_cliente_Evapotranspiracao.setText("1");

        jButtonSelecionaAparelhoEvap.setText("Selecionar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idAparelho)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ButtonUpdateEvap, javax.swing.GroupLayout.PREFERRED_SIZE, 82, Short.MAX_VALUE)
                                    .addComponent(jButtonNovaEvap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ButtonLimparEvap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ButtonSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtIDEvapotranspiracao, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonPesquisarEvap))
                                    .addComponent(txtQtidadeEvap)
                                    .addComponent(DateChooserEvap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComboBoxUnEvap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ButtonExcluirEvap, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(ButtonSalvarEvap, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_ModelAparEvapotranspiracao)
                                                    .addComponent(txt_id_cliente_Evapotranspiracao))))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButtonSelecionaAparelhoEvap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButtonSelecionarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ButtonExcluirEvap, ButtonLimparEvap, ButtonSair, ButtonSalvarEvap, ButtonUpdateEvap, jButtonNovaEvap});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIDEvapotranspiracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPesquisarEvap))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ComboBoxUnEvap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DateChooserEvap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtQtidadeEvap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_ModelAparEvapotranspiracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSelecionaAparelhoEvap))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jButtonSelecionarCliente)
                            .addComponent(txt_id_cliente_Evapotranspiracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonSalvarEvap)
                            .addComponent(jButtonNovaEvap)
                            .addComponent(ButtonLimparEvap))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonExcluirEvap)
                            .addComponent(ButtonUpdateEvap)
                            .addComponent(ButtonSair)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(idAparelho)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ButtonExcluirEvap, ButtonLimparEvap, ButtonSair, ButtonSalvarEvap, ButtonUpdateEvap, jButtonNovaEvap});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableEvapotranspiracaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableEvapotranspiracaoKeyReleased
        //A clicar na linha da tabela, setar valores nos campos de digitação.
        if (jTableEvapotranspiracao.getSelectedRow() != -1) {

            txtIDEvapotranspiracao.setText(jTableEvapotranspiracao.getValueAt(jTableEvapotranspiracao.getSelectedRow(), 0).toString());
            ComboBoxUnEvap.setSelectedItem(jTableEvapotranspiracao.getValueAt(jTableEvapotranspiracao.getSelectedRow(), 1).toString());
            DateChooserEvap.setDate((Date) jTableEvapotranspiracao.getValueAt(jTableEvapotranspiracao.getSelectedRow(), 2));
            txtQtidadeEvap.setText(jTableEvapotranspiracao.getValueAt(jTableEvapotranspiracao.getSelectedRow(), 3).toString());
            txt_ModelAparEvapotranspiracao.setText(jTableEvapotranspiracao.getValueAt(jTableEvapotranspiracao.getSelectedRow(), 4).toString());
            //txt_id_cliente_Evapotranspiracao.setText(jTableEvapotranspiracao.getValueAt(jTableEvapotranspiracao.getSelectedRow(), 5).toString());
            habilitaUpdateExcluirEvapotranspiracao();
        }

    }//GEN-LAST:event_jTableEvapotranspiracaoKeyReleased

    private void jTableEvapotranspiracaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEvapotranspiracaoMouseClicked
        //A clicar na linha da tabela, setar valores nos campos de digitação.
        if (jTableEvapotranspiracao.getSelectedRow() != -1) {

            txtIDEvapotranspiracao.setText(jTableEvapotranspiracao.getValueAt(jTableEvapotranspiracao.getSelectedRow(), 0).toString());
            ComboBoxUnEvap.setSelectedItem(jTableEvapotranspiracao.getValueAt(jTableEvapotranspiracao.getSelectedRow(), 1).toString());
            DateChooserEvap.setDate((Date) jTableEvapotranspiracao.getValueAt(jTableEvapotranspiracao.getSelectedRow(), 2));
            txtQtidadeEvap.setText(jTableEvapotranspiracao.getValueAt(jTableEvapotranspiracao.getSelectedRow(), 3).toString());
            txt_ModelAparEvapotranspiracao.setText(jTableEvapotranspiracao.getValueAt(jTableEvapotranspiracao.getSelectedRow(), 4).toString());
            //txt_id_cliente_Evapotranspiracao.setText(jTableEvapotranspiracao.getValueAt(jTableEvapotranspiracao.getSelectedRow(), 5).toString());
            habilitaUpdateExcluirEvapotranspiracao();
        }

    }//GEN-LAST:event_jTableEvapotranspiracaoMouseClicked

    private void ButtonSalvarEvapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalvarEvapActionPerformed
        if (ComboBoxUnEvap.getSelectedItem().toString().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira a unidade de medida.");
            ComboBoxUnEvap.requestFocus();
            return;
        }

        if (DateChooserEvap.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Insira a data referente ao registro.");
            DateChooserEvap.requestFocus();
            return;
        }

        if (txtQtidadeEvap.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira a quantdade Evapotranspiração.");
            txtQtidadeEvap.requestFocus();
            return;
        }

        if (txt_ModelAparEvapotranspiracao.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira o Modelo de Aparelho.");
            txt_ModelAparEvapotranspiracao.requestFocus();
            return;
        }
        salvarEvapotranspiracao();
        registrosInicialEvapotranspiracao(true);
        try {
            listarEvapotranspiracaoJTable();
        } catch (ClassNotFoundException ex) {
            //JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_ButtonSalvarEvapActionPerformed

    private void ButtonLimparEvapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimparEvapActionPerformed
        limparCamposEvapotranspiracao();
        registrosInicialEvapotranspiracao(true);

    }//GEN-LAST:event_ButtonLimparEvapActionPerformed

    private void ButtonUpdateEvapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUpdateEvapActionPerformed
        if (ComboBoxUnEvap.getSelectedItem().toString().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira a unidade de medida.");
            ComboBoxUnEvap.requestFocus();
            return;
        }

        if (DateChooserEvap.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Insira a data referente ao registro.");
            DateChooserEvap.requestFocus();
            return;
        }

        if (txtQtidadeEvap.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira a quantdade Evapotranspiração.");
            txtQtidadeEvap.requestFocus();
            return;
        }

        if (txt_ModelAparEvapotranspiracao.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira o Modelo de Aparelho.");
            txt_ModelAparEvapotranspiracao.requestFocus();
            return;
        }
        updateEvapotranspiracao();
        limparCamposEvapotranspiracao();
        registrosInicialEvapotranspiracao(true);
        try {
            listarEvapotranspiracaoJTable();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_ButtonUpdateEvapActionPerformed

    private void ButtonExcluirEvapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExcluirEvapActionPerformed
        // chamando o método excluirEvapotranspiracao()
        excluirEvapotranspiracao();
        limparCamposEvapotranspiracao();
        try {
            listarEvapotranspiracaoJTable();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_ButtonExcluirEvapActionPerformed

    private void ButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, " Deseja fechar os registros de Evapotranspiração? ", " Atenção ", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            this.dispose();
        } //fecha somente o JFrame em questão, onde this = JFrame.
    }//GEN-LAST:event_ButtonSairActionPerformed

    private void jButtonSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarClienteActionPerformed
        //Setar o valor recebido em outra janela.

        SelecionarCli frameSelecionarCli = null;
        try {
            frameSelecionarCli = new SelecionarCli();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipalClima.class.getName()).log(Level.SEVERE, null, ex);
        }
        frameSelecionarCli.setVisible(true);

    }//GEN-LAST:event_jButtonSelecionarClienteActionPerformed

    private void jButtonNovaEvapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaEvapActionPerformed
        limparCamposEvapotranspiracao();
        habilitaNovoRegistroEvapotranspiracao();

    }//GEN-LAST:event_jButtonNovaEvapActionPerformed

    private void txtQtidadeEvapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtidadeEvapKeyReleased
        //Chmando o método
        teclaPressionada(evt, txtQtidadeEvap);
    }//GEN-LAST:event_txtQtidadeEvapKeyReleased

    private void jButtonPesquisarEvapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarEvapActionPerformed

        if (txtIDEvapotranspiracao.getText().trim().equals("")) {//trim: remove campos vazios
            //System.out.println("Campo vazio");
            JOptionPane.showMessageDialog(null, "Campo vazio.", "Erro", JOptionPane.WARNING_MESSAGE);
            registrosInicialEvapotranspiracao(true);
        } else {
            habilitaUpdateExcluirEvapotranspiracao();
            //System.out.println(" campo preenchido");
        }
        consultarEvapotranspiracao();

    }//GEN-LAST:event_jButtonPesquisarEvapActionPerformed

    private void txtQtidadeEvapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtidadeEvapActionPerformed
        txtQtidadeEvap.transferFocus();
    }//GEN-LAST:event_txtQtidadeEvapActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExcluirEvap;
    private javax.swing.JButton ButtonLimparEvap;
    private javax.swing.JButton ButtonSair;
    private javax.swing.JButton ButtonSalvarEvap;
    private javax.swing.JButton ButtonUpdateEvap;
    private javax.swing.JComboBox<String> ComboBoxUnEvap;
    private com.toedter.calendar.JDateChooser DateChooserEvap;
    private javax.swing.JLabel idAparelho;
    private javax.swing.JButton jButtonNovaEvap;
    private javax.swing.JButton jButtonPesquisarEvap;
    private javax.swing.JButton jButtonSelecionaAparelhoEvap;
    private javax.swing.JButton jButtonSelecionarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEvapotranspiracao;
    private javax.swing.JTextField txtIDEvapotranspiracao;
    private javax.swing.JTextField txtQtidadeEvap;
    private javax.swing.JTextField txt_ModelAparEvapotranspiracao;
    public static javax.swing.JTextField txt_id_cliente_Evapotranspiracao;
    // End of variables declaration//GEN-END:variables
}
