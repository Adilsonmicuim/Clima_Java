package com.clima.telas;

import com.clima.bean.CadClienteBean;
import com.clima.dao.CadClienteDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public final class CadastroCliente extends javax.swing.JInternalFrame {

    public CadastroCliente() throws ClassNotFoundException {
        initComponents();
        listarEvapotranspiracaoJTable();
        quantidadeRegistros();
        habilitaNovoRegistroClientes(false);
        ocultarColuna();
        //Essas duas linhas abaixo é para ordenhar valores na tabela.
        DefaultTableModel listarClientes = (DefaultTableModel) jTableCadastroCliente.getModel();
        jTableCadastroCliente.setRowSorter(new TableRowSorter(listarClientes));

    }
    private final String acao = "salvar";


    /*--------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public void listarEvapotranspiracaoJTable() throws ClassNotFoundException {
        DefaultTableModel listarClientes = (DefaultTableModel) jTableCadastroCliente.getModel();
        listarClientes.setNumRows(0);

        CadClienteDAO pdao = new CadClienteDAO();

        for (CadClienteBean listCli : pdao.listarClientes()) {
            listarClientes.addRow(new Object[]{
                listCli.getId_estado(),
                listCli.getNome_estado(),
                listCli.getMesorregiao(),
                listCli.getUf(),
                listCli.getId_cidade(),
                listCli.getNome_cidade(),
                listCli.getId_endereco(),
                listCli.getRua(),
                listCli.getNumero(),
                listCli.getNomeCliente(),
                listCli.getSobrenomeCliente(),
                listCli.getSituacao(),
                listCli.getId_cliente()
            });

        }

    }

    /*--------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public void quantidadeRegistros() {

        int totalRegistros = 0;
        for (int i = 0; i < jTableCadastroCliente.getRowCount(); i++) {
            if (jTableCadastroCliente.getValueAt(i, 0).toString().equals(">0"));
            totalRegistros++;
        }

        LB_NumeroClientes.setText("Total de Clientes: " + totalRegistros);

        //JOptionPane.showMessageDialog(null, cont);
    }

    /*--------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public void ocultarColuna() {
        //getColumn(0) É a posição da tabela.
        jTableCadastroCliente.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(0).setMinWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(1).setMaxWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(1).setMinWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(1).setPreferredWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(4).setMaxWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(4).setMinWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(4).setPreferredWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(6).setMaxWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(6).setMinWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(6).setPreferredWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(7).setMaxWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(7).setMinWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(7).setPreferredWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(8).setMaxWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(8).setMinWidth(0);
        jTableCadastroCliente.getColumnModel().getColumn(8).setPreferredWidth(0);
    }

    /*--------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public void habilitaNovoRegistroClientes(boolean estado) {
        cBoxNomeEstado.setEnabled(estado);
        txtMesorregiao.setEnabled(estado);
        cBoxUnidadeFederal.setEnabled(estado);
        txtNomeCidade.setEnabled(estado);
        txtRua.setEnabled(estado);
        txtNumero.setEnabled(estado);
        txtNomeCliente.setEnabled(estado);
        txtSobrenomeCliente.setEnabled(estado);
        cBoxSituacaoCliente.setEnabled(estado);
        btnNovo.setEnabled(!estado);//Inverso
        btnSalvar.setEnabled(estado);
        btnLimpar.setEnabled(estado);
        btnUpdate.setEnabled(estado);
    }

    /*--------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public void AtualizarRegistroClientes(boolean estado) {
        cBoxNomeEstado.setEnabled(estado);
        txtMesorregiao.setEnabled(estado);
        cBoxUnidadeFederal.setEnabled(estado);
        txtNomeCidade.setEnabled(estado);
        txtRua.setEnabled(estado);
        txtNumero.setEnabled(estado);
        txtNomeCliente.setEnabled(estado);
        txtSobrenomeCliente.setEnabled(estado);
        cBoxSituacaoCliente.setEnabled(estado);
        btnNovo.setEnabled(!estado);//Inverso
        btnSalvar.setEnabled(!estado);//Inverso
        btnLimpar.setEnabled(estado);
        btnUpdate.setEnabled(estado);

    }

    /*--------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public void LimparCamposCadastroCliente() {
        CadastroCliente.cBoxNomeEstado.setSelectedItem(null);
        CadastroCliente.cBoxUnidadeFederal.setSelectedItem(null);
        CadastroCliente.cBoxSituacaoCliente.setSelectedItem(null);
        CadastroCliente.txtMesorregiao.setText(null);
        CadastroCliente.txtNomeCidade.setText(null);
        CadastroCliente.txtRua.setText(null);
        CadastroCliente.txtNumero.setText(null);
        CadastroCliente.txtNomeCliente.setText(null);
        CadastroCliente.txtSobrenomeCliente.setText(null);
    }

    /*--------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public void pesquisarCliente(String buscar) {
        

    }


    /*--------------------------------------------------------------------------------------------------------------------------------------------------------*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtNumero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNomeCidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMesorregiao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cBoxNomeEstado = new javax.swing.JComboBox<>();
        cBoxUnidadeFederal = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        txtNomeCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSobrenomeCliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cBoxSituacaoCliente = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCadastroCliente = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        txtPesquisarCliente = new javax.swing.JTextField();
        jbl_idUsuarioTelCadastro = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        LB_NumeroClientes = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setText("UF:");

        jLabel8.setText("Nome do Estado:");

        jLabel9.setText("Mesorregião:");

        setTitle("Cadastro de Cliente");
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(164, 233, 233));

        jPanel3.setBackground(new java.awt.Color(164, 233, 233));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("*Nome da Cidade:");

        jLabel4.setText("N°:");

        jLabel6.setText("Rua:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtNomeCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNomeCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(164, 233, 233));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("*Nome do Estado:");

        jLabel2.setText("*Mesorregião:");

        jLabel3.setText("*UF:");

        cBoxNomeEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));

        cBoxUnidadeFederal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cBoxNomeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addComponent(txtMesorregiao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cBoxUnidadeFederal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtMesorregiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cBoxNomeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBoxUnidadeFederal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(164, 233, 233));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setText("*Nome do Cliente:");

        jLabel12.setText("*Sobrenome:");

        jLabel10.setText("*Situação:");

        cBoxSituacaoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "Ativo", "Inativo" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jLabel12)
                .addGap(20, 20, 20)
                .addComponent(txtSobrenomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(jLabel10)
                .addGap(20, 20, 20)
                .addComponent(cBoxSituacaoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSobrenomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cBoxSituacaoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableCadastroCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Estado", "Estado", "Messoregião", "UF", "ID Cidade", "Cidade", "ID Endereço", "Rua", "Número", "Cliente", "Sobrenome", "Situação", "ID do Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCadastroCliente.getTableHeader().setReorderingAllowed(false);
        jTableCadastroCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCadastroClienteMouseClicked(evt);
            }
        });
        jTableCadastroCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableCadastroClienteKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCadastroCliente);
        if (jTableCadastroCliente.getColumnModel().getColumnCount() > 0) {
            jTableCadastroCliente.getColumnModel().getColumn(0).setResizable(false);
            jTableCadastroCliente.getColumnModel().getColumn(1).setResizable(false);
            jTableCadastroCliente.getColumnModel().getColumn(2).setResizable(false);
            jTableCadastroCliente.getColumnModel().getColumn(3).setResizable(false);
            jTableCadastroCliente.getColumnModel().getColumn(4).setResizable(false);
            jTableCadastroCliente.getColumnModel().getColumn(5).setResizable(false);
            jTableCadastroCliente.getColumnModel().getColumn(6).setResizable(false);
            jTableCadastroCliente.getColumnModel().getColumn(7).setResizable(false);
            jTableCadastroCliente.getColumnModel().getColumn(8).setResizable(false);
            jTableCadastroCliente.getColumnModel().getColumn(9).setResizable(false);
            jTableCadastroCliente.getColumnModel().getColumn(10).setResizable(false);
            jTableCadastroCliente.getColumnModel().getColumn(11).setResizable(false);
            jTableCadastroCliente.getColumnModel().getColumn(12).setResizable(false);
        }

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnUpdate.setText("Atualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        txtPesquisarCliente.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jbl_idUsuarioTelCadastro.setForeground(new java.awt.Color(255, 0, 0));
        jbl_idUsuarioTelCadastro.setText("id_usuario");

        jLabel13.setText("Usuário:");

        LB_NumeroClientes.setText("N° de Clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnSair)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LB_NumeroClientes)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jbl_idUsuarioTelCadastro)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnLimpar, btnNovo, btnPesquisar, btnSair, btnSalvar, btnUpdate});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar)
                    .addComponent(btnUpdate)
                    .addComponent(btnSair))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(jbl_idUsuarioTelCadastro)
                    .addComponent(jLabel13)
                    .addComponent(LB_NumeroClientes))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLimpar, btnNovo, btnPesquisar, btnSair, btnSalvar, btnUpdate});

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

        setSize(new java.awt.Dimension(1029, 659));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        habilitaNovoRegistroClientes(true);
        btnUpdate.setEnabled(false);
//        btnNovo.setText("Salvar");
//        acao = "salvar";
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        //camposObrigatorios

        if (CadastroCliente.cBoxNomeEstado.getSelectedItem().toString().equals("=0")) {
            JOptionPane.showMessageDialog(rootPane, "Insira o nome do Estado.");
            cBoxNomeEstado.requestFocus();
            return;
        }
        if (txtMesorregiao.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira o nome da Mesorregião.");
            txtMesorregiao.requestFocus();
            return;
        }
        if (CadastroCliente.cBoxUnidadeFederal.getSelectedItem().toString().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira o nome da Unidade Federativa.");
            cBoxUnidadeFederal.requestFocus();
            return;
        }
        if (txtNomeCidade.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira o nome da Cidade.");
            txtNomeCidade.requestFocus();
            return;
        }
        if (txtNomeCliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira o nome do Cliente.");
            txtNomeCliente.requestFocus();
            return;
        }
        if (txtSobrenomeCliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira o Sobrenome do Cliente.");
            txtSobrenomeCliente.requestFocus();
            return;
        }

        if (cBoxSituacaoCliente.getSelectedItem().toString().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira a situação do Cliente.");
            cBoxSituacaoCliente.requestFocus();
            return;
        }

        /*--------------------------------------------------------------------------------------------------------------------------------------------------------*/
        CadClienteBean dts = new CadClienteBean();
        CadClienteDAO func = null;
        try {
            func = new CadClienteDAO();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        //tb_estado
        int selecionado = cBoxNomeEstado.getSelectedIndex();
        dts.setNome_estado((String) cBoxNomeEstado.getItemAt(selecionado));
        dts.setMesorregiao(txtMesorregiao.getText());
        selecionado = cBoxUnidadeFederal.getSelectedIndex();
        dts.setUf((String) cBoxUnidadeFederal.getItemAt(selecionado));

        //tb_cidade
        dts.setNome_cidade(txtNomeCidade.getText());

        //tb_endereco
        dts.setRua(txtRua.getText());
        dts.setNumero(txtNumero.getText());

        //tb_cliente
        dts.setNomeCliente(txtNomeCliente.getText());
        dts.setSobrenomeCliente(txtSobrenomeCliente.getText());

        selecionado = cBoxSituacaoCliente.getSelectedIndex();
        dts.setSituacao((String) cBoxSituacaoCliente.getItemAt(selecionado));

        //tb_login
        dts.setId_loginUsuario(Integer.parseInt(jbl_idUsuarioTelCadastro.getText()));//Pega o valor da jLabel "jbl_idUsuarioTelCadastro" na tela de cadastro 
//        dts.setId_loginUsuario(Integer.parseInt(TelaPrincipalClima.jbl_RecebeIDclienteTelaPrincipal.getText()));

        if (acao.equals("salvar")) {
            if (func.salvarCadastroCliente(dts)) {
                JOptionPane.showMessageDialog(rootPane, "O cliente foi registrado com sucesso!");

                //Após registros limpar os campos.
                LimparCamposCadastroCliente();
            } else {
                JOptionPane.showMessageDialog(rootPane, "O cliente NÃO foi registrado!");
            }
        }
        try {
            listarEvapotranspiracaoJTable();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        quantidadeRegistros();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jTableCadastroClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCadastroClienteKeyReleased
        //A clicar na linha da tabela, setar valores nos campos de digitação.
        if (jTableCadastroCliente.getSelectedRow() != -1) {

            cBoxNomeEstado.setSelectedItem(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 1).toString());
            txtMesorregiao.setText(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 2).toString());
            cBoxUnidadeFederal.setSelectedItem(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 3).toString());
            txtNomeCidade.setText(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 5).toString());
            txtRua.setText(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 7).toString());
            txtNumero.setText(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 8).toString());
            txtNomeCliente.setText(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 9).toString());
            txtSobrenomeCliente.setText(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 10).toString());
            cBoxSituacaoCliente.setSelectedItem(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 11).toString());

            AtualizarRegistroClientes(true);
        }
    }//GEN-LAST:event_jTableCadastroClienteKeyReleased

    private void jTableCadastroClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCadastroClienteMouseClicked
        //A clicar na linha da tabela, setar valores nos campos de digitação.
        if (jTableCadastroCliente.getSelectedRow() != -1) {

            cBoxNomeEstado.setSelectedItem(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 1).toString());
            txtMesorregiao.setText(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 2).toString());
            cBoxUnidadeFederal.setSelectedItem(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 3).toString());
            txtNomeCidade.setText(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 5).toString());
            txtRua.setText(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 7).toString());
            txtNumero.setText(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 8).toString());
            txtNomeCliente.setText(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 9).toString());
            txtSobrenomeCliente.setText(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 10).toString());
            cBoxSituacaoCliente.setSelectedItem(jTableCadastroCliente.getValueAt(jTableCadastroCliente.getSelectedRow(), 11).toString());

            AtualizarRegistroClientes(true);
        }
    }//GEN-LAST:event_jTableCadastroClienteMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, " Deseja fechar tela de cadastro de cliente? ", " Atenção ", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        //mostrar(txt_pesquisar.getText());
        AtualizarRegistroClientes(true);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        LimparCamposCadastroCliente();
        habilitaNovoRegistroClientes(false);
        txtPesquisarCliente.setText(null);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        LimparCamposCadastroCliente();
        habilitaNovoRegistroClientes(false);
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LB_NumeroClientes;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUpdate;
    public static javax.swing.JComboBox<String> cBoxNomeEstado;
    public static javax.swing.JComboBox<String> cBoxSituacaoCliente;
    public static javax.swing.JComboBox<String> cBoxUnidadeFederal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableCadastroCliente;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    public static javax.swing.JLabel jbl_idUsuarioTelCadastro;
    public static javax.swing.JTextField txtMesorregiao;
    public static javax.swing.JTextField txtNomeCidade;
    public static javax.swing.JTextField txtNomeCliente;
    public static javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPesquisarCliente;
    public static javax.swing.JTextField txtRua;
    public static javax.swing.JTextField txtSobrenomeCliente;
    // End of variables declaration//GEN-END:variables
}
