package com.clima.telas;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.awt.HeadlessException;
import com.clima.dao.TemperaturaDAO;
import com.clima.bean.TemperaturaBean;
import javax.swing.table.TableRowSorter;
import com.clima.connection.ModuloConexao;
import javax.swing.table.DefaultTableModel;
import static com.clima.telas.TelaPrincipalClima.jbl_RecebeIDclienteTelaPrincipal;


public final class Temperaturas extends javax.swing.JInternalFrame {

    //Chamando a Janela SelecionarCli para setar o ID do Cliente em outra Janela.
    private SelecionarCli selecionarCli;

    //atributos
    Connection conexao = null;
    PreparedStatement pst = null;//PreparedStatement: conjunto de bibliotecas - Variavel pst
    ResultSet rs = null; //exibir o resultado das instruções slq


    /*#######################################################################################################################################################*/
    public Temperaturas() throws ClassNotFoundException {
        initComponents();
        listarTemperaturaJTable(); // Este método esta abaixo do método limpar. Assim que entrar na tela ele já vai listarTemp as temperaturas.
        //A linha abaixo Instanciando no construtor - Chamada da janela SelecionarCli
        this.selecionarCli = new SelecionarCli();
        registrosInicialTemperatura(true);
        quantidadeRegistros();
        mediaTemperaturaMaxima();
        mediaTemperaturaMinima();
        txt_id_cliente_Temperatura.setEnabled(false);
        jButtonSelecionarCliente.setEnabled(false);
        //ocultarColuna();

        //Essas duas linhas abaixo é para ordenhar valores na tabela.
        DefaultTableModel listarTemp = (DefaultTableModel) jTableTemperatura.getModel();
        jTableTemperatura.setRowSorter(new TableRowSorter(listarTemp));

        try {
            conexao = ModuloConexao.conector();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /*#######################################################################################################################################################*/
    private void salvarTemperatura() {// método para salvarTemperatura novos dados "ADICIONAR"
        String sql = "INSERT INTO public.tb_temperatura (unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente) values (?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, cboxTemperatura.getSelectedItem().toString()); // .toString() = É´para converter para string
            pst.setDate(2, new java.sql.Date(DateChooserTemperatura.getDate().getTime()));
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            String date = sdf.format(DateChooserTemperatura.getDate());
//            pst.setString(2, date);
            pst.setDouble(3, (Double) (Number) Double.parseDouble(txtTemperaturaMaxima.getText()));
            pst.setDouble(4, (Double) (Number) Double.parseDouble(txtTemperaturaMinima.getText()));
            pst.setInt(5, Integer.parseInt(TelaPrincipalClima.jbl_RecebeIDclienteTelaPrincipal.getText()));

            //A linha abaixo atualiza a tabela de temperaturas com os dados preenchidos - digitado.
            int adicionado = pst.executeUpdate();
            System.out.println(adicionado);//apenas para apoio ao entendimento da lógica
            if (adicionado > 0) { //Se valor adicionado no banco de dados for maior que Um
                JOptionPane.showMessageDialog(null, "Cadastro concluído com sucesso! ");

                //A linha abaixo chama o método apagar os campos
                limparCamposTemperatura();
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
//            JOptionPane.showMessageDialog(null, " Erro ao salvar dados\n ERRO: " + e);//Caso ocorra alguma excessão será exibido na tela
        }

    }

    /*#######################################################################################################################################################*/
    private void consultarTemperatura() {//método para pesquisar
        String sql = "select * from public.tb_temperatura where id_temperatura = ? AND id_cliente ="+jbl_RecebeIDclienteTelaPrincipal.getText();

        try {
            pst = conexao.prepareStatement(sql);

            //Na linha abaixo ele vai pesquisar o ID 
            int id = Integer.parseInt(txtIDTemperatura.getText());
            pst.setInt(1, id);//obter o valor digitado no campo, substitui a interrogação por "id_temperatura"

            rs = pst.executeQuery();
            //Linha abaixo caso tenha o registro (ID) correspondente preencher os campos
            if (rs.next()) { // caso tenha a ID correspôndente, setar os campos
                cboxTemperatura.setSelectedItem(rs.getString(2));// O Número 2 significa que vai pegar o segundo campo da tabela no banco de dados.
                DateChooserTemperatura.setDate(rs.getDate(3));//Data da temperatura
                txtTemperaturaMaxima.setText(rs.getString(4));//Temperatura Máxima
                txtTemperaturaMinima.setText(rs.getString(5));//Tempreratura Mínima

            } else {
                JOptionPane.showMessageDialog(null, "Temperatura não Cadastrada.");//caso não encontre nenhuma temperatura cadastrado exibe a mensagem.
                //Caso ID não encontrada no banco de dados faz chama do método abaixo
                //A linha abaixo chama o método apagar os campos
                limparCamposTemperatura();
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            //JOptionPane.showMessageDialog(null, " Erro ao consultar dados\n ERRO: " + e);//Caso ocorra alguma excessão será exibido na tela.
        }
    }

    /*#######################################################################################################################################################*/
    private void limparTemperatura() {// método para limparTemperatura campos e entrar com novos dados

        if (txtIDTemperatura.getText().trim().equals("")) {//trim: remove campos vazios
            //System.out.println("Campo vazio");
            JOptionPane.showMessageDialog(null, "Campo vazio.", "Erro", JOptionPane.WARNING_MESSAGE);
        } else {
            //System.out.println(" campo preenchido");
            JOptionPane.showMessageDialog(null, "Tem certeza que deseja limpar os campos?");
        }

        //A linha abaixo chama o método apagar os campos
        limparCamposTemperatura();

    }

    /*#######################################################################################################################################################*/
    private void updateTemperatura() {// método para atualizar novos dados
        String sql = "UPDATE public.tb_temperatura SET unidade_medida=?, data_temperatura=?, temp_maxima=?, temp_minima=? WHERE id_temperatura=?";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, cboxTemperatura.getSelectedItem().toString()); // .toString() = É´para converter para string
            pst.setDate(2, new java.sql.Date(DateChooserTemperatura.getDate().getTime()));
            pst.setDouble(3, (Double) (Number) Double.parseDouble(txtTemperaturaMaxima.getText()));
            pst.setDouble(4, (Double) (Number) Double.parseDouble(txtTemperaturaMinima.getText()));
            pst.setInt(5, Integer.parseInt(txtIDTemperatura.getText()));

            int adicionado = pst.executeUpdate();
            //System.out.println(adicionado);//apenas para apoio ao entendimento da lógica
            if (adicionado > 0) { //Se valor adicionado no banco de dados for maior que Um
                JOptionPane.showMessageDialog(null, "Cadastro concluído com sucesso! ");

            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            //JOptionPane.showMessageDialog(null, " Erro ao atualizar dados\n ERRO: " + e);//Caso ocorra alguma excessão será exibido na tela
        }

    }

    /*#######################################################################################################################################################*/
    private void excluirTemperatura() {// método para apagar dados do DB
        // A estrutura abaixo confirma a remoção dos dados
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja EXLUIR OS DADOS?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM public.tb_temperatura WHERE id_temperatura=?";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(txtIDTemperatura.getText()));

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
    public void limparCamposTemperatura() {
        txtIDTemperatura.setText(null);
        //jComboBoxUnidadeTemperatura.setSelectedItem(null);
        DateChooserTemperatura.setDate(null);
        txtTemperaturaMaxima.setText(null);
        txtTemperaturaMinima.setText(null);
        registrosInicialTemperatura(true);
    }

    /*#######################################################################################################################################################*/
    // Método para habilitar cadastro temperatura
    //Exclamação para negação
    public void registrosInicialTemperatura(boolean estado) {
        txtIDTemperatura.setEnabled(estado);
        jButtonConsultarTemperatura.setEnabled(estado);
        jButtonNovaTemperatura.setEnabled(estado);
        jButtonSalvarTemperatura.setEnabled(!estado);
        jButtonExcluirTemperatura.setEnabled(!estado);
        jButtonUpdateTemperatura.setEnabled(!estado);
        jButtonLimparTemperatura.setEnabled(estado);
        DateChooserTemperatura.setEnabled(!estado);
        cboxTemperatura.setEnabled(!estado);
        txtTemperaturaMaxima.setEnabled(!estado);
        txtTemperaturaMinima.setEnabled(!estado);

    }

    /*#######################################################################################################################################################*/
    public void habilitaNovoRegistroTemperatura() {
        jButtonNovaTemperatura.setEnabled(false);
        jButtonSalvarTemperatura.setEnabled(true);
        jButtonExcluirTemperatura.setEnabled(false);
        jButtonUpdateTemperatura.setEnabled(false);
        DateChooserTemperatura.setEnabled(true);
        cboxTemperatura.setEnabled(true);
        txtTemperaturaMaxima.setEnabled(true);
        txtTemperaturaMinima.setEnabled(true);
        jButtonConsultarTemperatura.setEnabled(false);
        txtIDTemperatura.setEnabled(false);
    }

    /*#######################################################################################################################################################*/
    public void habilitaUpdateExcluirTemperatura() {
        jButtonNovaTemperatura.setEnabled(false);
        jButtonSalvarTemperatura.setEnabled(false);
        jButtonExcluirTemperatura.setEnabled(true);
        jButtonUpdateTemperatura.setEnabled(true);
        DateChooserTemperatura.setEnabled(true);
        cboxTemperatura.setEnabled(true);
        txtTemperaturaMaxima.setEnabled(true);
        txtTemperaturaMinima.setEnabled(true);
        jButtonConsultarTemperatura.setEnabled(true);
        txtIDTemperatura.setEnabled(true);
    }

    /*#######################################################################################################################################################*/
    public void ocultarColuna() {
        //getColumn(0) É a posição da tabela.
        jTableTemperatura.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableTemperatura.getColumnModel().getColumn(0).setMinWidth(0);
        jTableTemperatura.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    /*#######################################################################################################################################################*/
    public void quantidadeRegistros() {

        int totalRegistros = 0;
        for (int i = 0; i < jTableTemperatura.getRowCount(); i++) {
            if (jTableTemperatura.getValueAt(i, 2).toString().equals("°C"));
            totalRegistros++;
        }

        LB_registros.setText("Total de Registros: " + totalRegistros);

        //JOptionPane.showMessageDialog(null, cont);
    }

    /*#######################################################################################################################################################*/
//    public void somaValores() {
//
//        double totalRegistros = 0;
//        for (int i = 0; i < jTableTemperatura.getRowCount(); i++) {
//            totalRegistros += Double.parseDouble(jTableTemperatura.getValueAt(i, 3).toString());
//        }
//        LB_registros.setText("Total de Registros: " + totalRegistros);
//    }

    /*#######################################################################################################################################################*/
    public void mediaTemperaturaMaxima() {

        float somaMaxima = 0f;
        float totalRegistros = 0;
        float media;
        //quantidadeRegistros
        for (int i = 0; i < jTableTemperatura.getRowCount(); i++) {
            if (jTableTemperatura.getValueAt(i, 3).toString().isEmpty());
            totalRegistros++;
        }
        //Somando as temperaturas Máximas
        for (int i = 0; i < totalRegistros; i++) {
            somaMaxima += Double.parseDouble(jTableTemperatura.getValueAt(i, 3/*Colun Temp.Máxima*/).toString());
        }
        media = (somaMaxima / totalRegistros);
        mediaMaxima.setText("Média: " + String.format("%.2f", media));
    }

    /*#######################################################################################################################################################*/
    public void mediaTemperaturaMinima() {

        float somaMinima = 0f;
        float totalRegistros = 0;
        float media;
        //quantidadeRegistros
        for (int i = 0; i < jTableTemperatura.getRowCount(); i++) {
            if (jTableTemperatura.getValueAt(i, 4).toString().isEmpty());
            totalRegistros++;
        }
        //Somando as temperaturas Minimas
        for (int i = 0; i < totalRegistros; i++) {
            somaMinima += Double.parseDouble(jTableTemperatura.getValueAt(i, 4/*Colun Temp.Mínima*/).toString());
        }
        media = (somaMinima / totalRegistros);
        mediaMinima.setText("Média: " + String.format("%.2f", media));
    }

    /*#######################################################################################################################################################*/
    public void listarTemperaturaJTable() throws ClassNotFoundException {
        DefaultTableModel listarTemp = (DefaultTableModel) jTableTemperatura.getModel();
        listarTemp.setNumRows(0);

        TemperaturaDAO pdao = new TemperaturaDAO();

        for (TemperaturaBean t : pdao.listarTemp()) {
            listarTemp.addRow(new Object[]{
                t.getId_temperatura(),
                t.getUnidade_medida(),
                t.getData_temperatura(),
                t.getTemp_maxima(),
                t.getTemp_minima(),
                t.getId_cliente()
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

    /*#######################################################################################################################################################*/
    public void camposObrigatorios() {
        if (cboxTemperatura.getSelectedItem().toString().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira a unidade de medida.");
            cboxTemperatura.requestFocus();
            return;
        }

        if (DateChooserTemperatura.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Insira a data referente ao registro.");
            cboxTemperatura.requestFocus();
            return;
        }

        if (txtTemperaturaMaxima.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira a Temperatura Maxima.");
            txtTemperaturaMaxima.requestFocus();
            return;
        }

        if (txtTemperaturaMinima.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira a Temperatura Mínima.");
            txtTemperaturaMinima.requestFocus();
        }
    }

    /*#######################################################################################################################################################*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIDTemperatura = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTemperaturaMinima = new javax.swing.JTextField();
        txtTemperaturaMaxima = new javax.swing.JTextField();
        jButtonConsultarTemperatura = new javax.swing.JButton();
        cboxTemperatura = new javax.swing.JComboBox<>();
        jButtonSalvarTemperatura = new javax.swing.JButton();
        jButtonLimparTemperatura = new javax.swing.JButton();
        jButtonExcluirTemperatura = new javax.swing.JButton();
        jButtonUpdateTemperatura = new javax.swing.JButton();
        jButtonsSairTemperatura = new javax.swing.JButton();
        DateChooserTemperatura = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTemperatura = new javax.swing.JTable();
        jButtonNovaTemperatura = new javax.swing.JButton();
        idUsuarioLogado = new javax.swing.JLabel();
        LB_registros = new javax.swing.JLabel();
        mediaMaxima = new javax.swing.JLabel();
        mediaMinima = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_id_cliente_Temperatura = new javax.swing.JTextField();
        jButtonSelecionarCliente = new javax.swing.JButton();

        setTitle("Temperaturas");

        jPanel1.setBackground(new java.awt.Color(164, 233, 233));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID:");

        txtIDTemperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDTemperaturaActionPerformed(evt);
            }
        });

        jLabel2.setText("*Unidade:");

        jLabel3.setText("*Data:");

        jLabel4.setText("*Máxima:");

        jLabel5.setText("*Mínima:");

        txtTemperaturaMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTemperaturaMinimaActionPerformed(evt);
            }
        });
        txtTemperaturaMinima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTemperaturaMinimaKeyReleased(evt);
            }
        });

        txtTemperaturaMaxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTemperaturaMaximaActionPerformed(evt);
            }
        });
        txtTemperaturaMaxima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTemperaturaMaximaKeyReleased(evt);
            }
        });

        jButtonConsultarTemperatura.setText("Pesquisar");
        jButtonConsultarTemperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarTemperaturaActionPerformed(evt);
            }
        });

        cboxTemperatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "°C", "°F" }));

        jButtonSalvarTemperatura.setText("Salvar");
        jButtonSalvarTemperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarTemperaturaActionPerformed(evt);
            }
        });

        jButtonLimparTemperatura.setText("Limpar");
        jButtonLimparTemperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparTemperaturaActionPerformed(evt);
            }
        });

        jButtonExcluirTemperatura.setText("Excluir");
        jButtonExcluirTemperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirTemperaturaActionPerformed(evt);
            }
        });

        jButtonUpdateTemperatura.setText("Atualizar");
        jButtonUpdateTemperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateTemperaturaActionPerformed(evt);
            }
        });

        jButtonsSairTemperatura.setText("Sair");
        jButtonsSairTemperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsSairTemperaturaActionPerformed(evt);
            }
        });

        jTableTemperatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Unidade", "Data", "Temp. Máxima", "Temp. Mínima", "Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTemperatura.getTableHeader().setReorderingAllowed(false);
        jTableTemperatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTemperaturaMouseClicked(evt);
            }
        });
        jTableTemperatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableTemperaturaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTemperatura);
        if (jTableTemperatura.getColumnModel().getColumnCount() > 0) {
            jTableTemperatura.getColumnModel().getColumn(0).setResizable(false);
            jTableTemperatura.getColumnModel().getColumn(1).setResizable(false);
            jTableTemperatura.getColumnModel().getColumn(2).setResizable(false);
            jTableTemperatura.getColumnModel().getColumn(3).setResizable(false);
            jTableTemperatura.getColumnModel().getColumn(4).setResizable(false);
            jTableTemperatura.getColumnModel().getColumn(5).setResizable(false);
        }

        jButtonNovaTemperatura.setText("Novo");
        jButtonNovaTemperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaTemperaturaActionPerformed(evt);
            }
        });

        idUsuarioLogado.setText("1");

        LB_registros.setText("Registro");

        mediaMaxima.setText("Média");

        mediaMinima.setText("Média");

        jLabel6.setText("*Cliente:");

        jButtonSelecionarCliente.setText("Cliente");
        jButtonSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonNovaTemperatura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonUpdateTemperatura))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonExcluirTemperatura, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jButtonSalvarTemperatura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonsSairTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLimparTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_id_cliente_Temperatura)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSelecionarCliente))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIDTemperatura)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonConsultarTemperatura))
                            .addComponent(cboxTemperatura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTemperaturaMinima)
                            .addComponent(txtTemperaturaMaxima)
                            .addComponent(DateChooserTemperatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LB_registros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mediaMaxima)
                        .addGap(57, 57, 57)
                        .addComponent(mediaMinima)
                        .addGap(83, 83, 83)
                        .addComponent(idUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonExcluirTemperatura, jButtonLimparTemperatura, jButtonNovaTemperatura, jButtonSalvarTemperatura, jButtonUpdateTemperatura, jButtonsSairTemperatura});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonConsultarTemperatura)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtIDTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(cboxTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DateChooserTemperatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTemperaturaMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTemperaturaMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id_cliente_Temperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jButtonSelecionarCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSalvarTemperatura)
                            .addComponent(jButtonLimparTemperatura)
                            .addComponent(jButtonNovaTemperatura))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonsSairTemperatura)
                            .addComponent(jButtonExcluirTemperatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonUpdateTemperatura))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_registros)
                    .addComponent(idUsuarioLogado)
                    .addComponent(mediaMinima)
                    .addComponent(mediaMaxima))
                .addContainerGap(204, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonExcluirTemperatura, jButtonLimparTemperatura, jButtonNovaTemperatura, jButtonSalvarTemperatura, jButtonUpdateTemperatura, jButtonsSairTemperatura});

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

    private void jButtonConsultarTemperaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarTemperaturaActionPerformed

        if (txtIDTemperatura.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Campo vazio.", "Erro", JOptionPane.WARNING_MESSAGE);
            txtIDTemperatura.requestFocus();
            registrosInicialTemperatura(true);
            return;

            //System.out.println("Campo vazio");
        } else {
            habilitaUpdateExcluirTemperatura();
            //System.out.println(" campo preenchido");
        }
        consultarTemperatura();

    }//GEN-LAST:event_jButtonConsultarTemperaturaActionPerformed

    private void jButtonLimparTemperaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparTemperaturaActionPerformed
        // TODO add your handling code here:
        limparTemperatura();
        registrosInicialTemperatura(true);
    }//GEN-LAST:event_jButtonLimparTemperaturaActionPerformed

    private void jButtonUpdateTemperaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateTemperaturaActionPerformed
        if (cboxTemperatura.getSelectedItem().toString().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira a unidade de medida.");
            cboxTemperatura.requestFocus();
            return;
        }

        if (DateChooserTemperatura.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Insira a data referente ao registro.");
            cboxTemperatura.requestFocus();
            return;
        }

        if (txtTemperaturaMaxima.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira a Temperatura Maxima.");
            txtTemperaturaMaxima.requestFocus();
            return;
        }

        if (txtTemperaturaMinima.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira a Temperatura Mínima.");
            txtTemperaturaMinima.requestFocus();
            return;
        }
        updateTemperatura();
        limparCamposTemperatura();
        registrosInicialTemperatura(true);
        try {
            listarTemperaturaJTable();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        quantidadeRegistros();
        mediaTemperaturaMaxima();
        mediaTemperaturaMinima();
    }//GEN-LAST:event_jButtonUpdateTemperaturaActionPerformed

    private void jButtonsSairTemperaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsSairTemperaturaActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, " Deseja fechar os registros de Temperatura? ", " Atenção ", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            this.dispose();
        } //fecha somente o JFrame em questão, onde this = JFrame.
    }//GEN-LAST:event_jButtonsSairTemperaturaActionPerformed

    private void jButtonSalvarTemperaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarTemperaturaActionPerformed
        if (cboxTemperatura.getSelectedItem().toString().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira a unidade de medida.");
            cboxTemperatura.requestFocus();
            return;
        }

        if (DateChooserTemperatura.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Insira a data referente ao registro.");
            cboxTemperatura.requestFocus();
            return;
        }

        if (txtTemperaturaMaxima.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira a Temperatura Maxima.");
            txtTemperaturaMaxima.requestFocus();
            return;
        }

        if (txtTemperaturaMinima.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Insira a Temperatura Mínima.");
            txtTemperaturaMinima.requestFocus();
            return;
        }
        salvarTemperatura();
        registrosInicialTemperatura(true);
        try {
            listarTemperaturaJTable();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        quantidadeRegistros();
        mediaTemperaturaMaxima();
        mediaTemperaturaMinima();

    }//GEN-LAST:event_jButtonSalvarTemperaturaActionPerformed

    private void jButtonExcluirTemperaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirTemperaturaActionPerformed
        // chamando o método excluirTemperatura(remover)
        excluirTemperatura();
        limparCamposTemperatura();
        try {
            listarTemperaturaJTable();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        quantidadeRegistros();
        mediaTemperaturaMaxima();
        mediaTemperaturaMinima();

    }//GEN-LAST:event_jButtonExcluirTemperaturaActionPerformed

    private void jTableTemperaturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableTemperaturaKeyReleased
        //A clicar na linha da tabela, setar valores nos campos de digitação.
        if (jTableTemperatura.getSelectedRow() != -1) {

            txtIDTemperatura.setText(jTableTemperatura.getValueAt(jTableTemperatura.getSelectedRow(), 0).toString());
            cboxTemperatura.setSelectedItem(jTableTemperatura.getValueAt(jTableTemperatura.getSelectedRow(), 1).toString());
            DateChooserTemperatura.setDate((Date) jTableTemperatura.getValueAt(jTableTemperatura.getSelectedRow(), 2));
            txtTemperaturaMaxima.setText(jTableTemperatura.getValueAt(jTableTemperatura.getSelectedRow(), 3).toString());
            txtTemperaturaMinima.setText(jTableTemperatura.getValueAt(jTableTemperatura.getSelectedRow(), 4).toString());
            //txt_id_cliente_Temperatura.setText(jTableTemperatura.getValueAt(jTableTemperatura.getSelectedRow(), 5).toString());
            habilitaUpdateExcluirTemperatura();
        }
    }//GEN-LAST:event_jTableTemperaturaKeyReleased

    private void jTableTemperaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTemperaturaMouseClicked
        //A clicar na linha da tabela, setar valores nos campos de digitação.
        if (jTableTemperatura.getSelectedRow() != -1) {

            txtIDTemperatura.setText(jTableTemperatura.getValueAt(jTableTemperatura.getSelectedRow(), 0).toString());
            cboxTemperatura.setSelectedItem(jTableTemperatura.getValueAt(jTableTemperatura.getSelectedRow(), 1).toString());
            DateChooserTemperatura.setDate((Date) jTableTemperatura.getValueAt(jTableTemperatura.getSelectedRow(), 2));
            txtTemperaturaMaxima.setText(jTableTemperatura.getValueAt(jTableTemperatura.getSelectedRow(), 3).toString());
            txtTemperaturaMinima.setText(jTableTemperatura.getValueAt(jTableTemperatura.getSelectedRow(), 4).toString());
            //txt_id_cliente_Temperatura.setText(jTableTemperatura.getValueAt(jTableTemperatura.getSelectedRow(), 5).toString());
            habilitaUpdateExcluirTemperatura();
        }
    }//GEN-LAST:event_jTableTemperaturaMouseClicked

    private void txtTemperaturaMaximaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTemperaturaMaximaKeyReleased

        //Chamando o método
        teclaPressionada(evt, txtTemperaturaMaxima);
    }//GEN-LAST:event_txtTemperaturaMaximaKeyReleased

    private void txtTemperaturaMinimaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTemperaturaMinimaKeyReleased
        //Chmando o método
        teclaPressionada(evt, txtTemperaturaMinima);

//        //ASCII trocando virgula por ponto - Usei um método ao invés de usar o código abaixo.
//        if (evt.getKeyCode() == 44) {
//            jTextFieldTemperaturaMinima.setText(jTextFieldTemperaturaMinima.getText() + ".");
//        }
    }//GEN-LAST:event_txtTemperaturaMinimaKeyReleased

    private void txtIDTemperaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDTemperaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDTemperaturaActionPerformed

    private void jButtonNovaTemperaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaTemperaturaActionPerformed
        limparCamposTemperatura();
        habilitaNovoRegistroTemperatura();
    }//GEN-LAST:event_jButtonNovaTemperaturaActionPerformed

    private void txtTemperaturaMaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTemperaturaMaximaActionPerformed
        //Ao dar ENTER pula de linha para txt MINIMA
        txtTemperaturaMaxima.transferFocus();

    }//GEN-LAST:event_txtTemperaturaMaximaActionPerformed

    private void txtTemperaturaMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTemperaturaMinimaActionPerformed
        //Ao dar ENTER pula de linha
        txtTemperaturaMinima.transferFocus();
    }//GEN-LAST:event_txtTemperaturaMinimaActionPerformed

    private void jButtonSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarClienteActionPerformed

        SelecionarCli frameSelecionarCli = null;
        try {
            frameSelecionarCli = new SelecionarCli();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipalClima.class.getName()).log(Level.SEVERE, null, ex);
        }
        frameSelecionarCli.setVisible(true);
    }//GEN-LAST:event_jButtonSelecionarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooserTemperatura;
    private javax.swing.JLabel LB_registros;
    private javax.swing.JComboBox<String> cboxTemperatura;
    private javax.swing.JLabel idUsuarioLogado;
    private javax.swing.JButton jButtonConsultarTemperatura;
    private javax.swing.JButton jButtonExcluirTemperatura;
    private javax.swing.JButton jButtonLimparTemperatura;
    private javax.swing.JButton jButtonNovaTemperatura;
    private javax.swing.JButton jButtonSalvarTemperatura;
    private javax.swing.JButton jButtonSelecionarCliente;
    private javax.swing.JButton jButtonUpdateTemperatura;
    private javax.swing.JButton jButtonsSairTemperatura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTemperatura;
    private javax.swing.JLabel mediaMaxima;
    private javax.swing.JLabel mediaMinima;
    private javax.swing.JTextField txtIDTemperatura;
    private javax.swing.JTextField txtTemperaturaMaxima;
    private javax.swing.JTextField txtTemperaturaMinima;
    public static javax.swing.JTextField txt_id_cliente_Temperatura;
    // End of variables declaration//GEN-END:variables

}
