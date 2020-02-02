package com.clima.telas;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import com.clima.util.GerenciadorDeJanelas;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class TelaPrincipalClima extends javax.swing.JFrame {

    /*-------------------------------------------------------------------------------------------*/
    GerenciadorDeJanelas gerenciadorDeJanelas;
    JDesktopPane JDesktopPane;


    /*-------------------------------------------------------------------------------------------*/
    public TelaPrincipalClima() { // Este trecho de código não é método e sim um construtor
        initComponents(); // Inicializa os componentes
        //this.setExtendedState(TelaPrincipalClima.MAXIMIZED_BOTH); //Gerar tamanho da tela
        //habilitaBotoes(false);
        this.setTitle("Sistema para controle climático");

        /*-------------------------------------------------------------------------------------------*/
        this.gerenciadorDeJanelas = new GerenciadorDeJanelas(JDesktopPane);

    }

    // Método para habilitar botoes na tela principal
    public void habilitaBotoes(boolean estado) {
        //jButtonCadastro.setEnabled(estado);
        ButtonTemperaturas.setEnabled(estado);
        ButtonPluviometria.setEnabled(estado);
        ButtonEvapo.setEnabled(estado);
        ButtonIrrigacao.setEnabled(estado);
        ButtonRelatorios.setEnabled(estado);

        ButtonCadastro.setEnabled(!estado); //Exclamação para negação
        //jButtonRelatorios.setEnabled(!estado); //Exclamação para negação
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jDesktopPrincipal = new javax.swing.JPanel();
        jPanelIcones = new javax.swing.JPanel();
        ButtonRelatorios = new javax.swing.JButton();
        jlRelatorios = new javax.swing.JLabel();
        ButtonIrrigacao = new javax.swing.JButton();
        jlIrrigacao = new javax.swing.JLabel();
        ButtonEvapo = new javax.swing.JButton();
        jlEvapotranspiracao = new javax.swing.JLabel();
        ButtonPluviometria = new javax.swing.JButton();
        jlPluviometria = new javax.swing.JLabel();
        ButtonTemperaturas = new javax.swing.JButton();
        jlTemperaturas = new javax.swing.JLabel();
        ButtonCadastro = new javax.swing.JButton();
        jlCadastro = new javax.swing.JLabel();
        jblUsuario = new javax.swing.JLabel();
        jblTipoUsuario = new javax.swing.JLabel();
        ButtonCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbl_Cliente = new javax.swing.JLabel();
        jbl_RecebeIDclienteTelaPrincipal = new javax.swing.JLabel();
        jbl_RecebeIDusuarioTelaPrincipal = new javax.swing.JLabel();
        jMenu = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuArquivo_EsclolherCliente = new javax.swing.JMenuItem();
        jMenuArquivo_Login = new javax.swing.JMenuItem();
        jMenuArquivo_Config = new javax.swing.JMenuItem();
        jMenuArquivo_Sair = new javax.swing.JMenuItem();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuCadastro_CadastroUsuario = new javax.swing.JMenuItem();
        jMenuCadastro_CadastroClientes = new javax.swing.JMenuItem();
        jMenuRelatorio = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuHelp_Conteudo = new javax.swing.JMenuItem();
        jMenuHelp_Ajuda = new javax.swing.JMenuItem();
        jMenuHelp_Sobre = new javax.swing.JMenuItem();
        TestandoJInternalF = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1100, 805));

        jDesktopPrincipal.setBackground(new java.awt.Color(153, 204, 255));
        jDesktopPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jDesktopPrincipalMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPrincipalLayout = new javax.swing.GroupLayout(jDesktopPrincipal);
        jDesktopPrincipal.setLayout(jDesktopPrincipalLayout);
        jDesktopPrincipalLayout.setHorizontalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1132, Short.MAX_VALUE)
        );
        jDesktopPrincipalLayout.setVerticalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );

        jPanelIcones.setBackground(new java.awt.Color(153, 204, 255));

        ButtonRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/clima/icons/relatorios.png"))); // NOI18N
        ButtonRelatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRelatoriosActionPerformed(evt);
            }
        });

        jlRelatorios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlRelatorios.setText("Relatórios");

        ButtonIrrigacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/clima/icons/irrigacao.png"))); // NOI18N
        ButtonIrrigacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonIrrigacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonIrrigacaoActionPerformed(evt);
            }
        });

        jlIrrigacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIrrigacao.setText("Irrigação");

        ButtonEvapo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/clima/icons/evapotrasnpiracao.png"))); // NOI18N
        ButtonEvapo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonEvapo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEvapoActionPerformed(evt);
            }
        });

        jlEvapotranspiracao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlEvapotranspiracao.setText("Evapotranspiração");

        ButtonPluviometria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/clima/icons/pluviometria.png"))); // NOI18N
        ButtonPluviometria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonPluviometria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPluviometriaActionPerformed(evt);
            }
        });

        jlPluviometria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPluviometria.setText("Pluviometria");

        ButtonTemperaturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/clima/icons/temperatura.png"))); // NOI18N
        ButtonTemperaturas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonTemperaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTemperaturasActionPerformed(evt);
            }
        });

        jlTemperaturas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTemperaturas.setText("Temperaturas");

        ButtonCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/clima/icons/cadastro.png"))); // NOI18N
        ButtonCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonCadastro.setFocusable(false);
        ButtonCadastro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonCadastro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCadastroActionPerformed(evt);
            }
        });

        jlCadastro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCadastro.setText("Cadastro");

        jblUsuario.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblUsuario.setText("Usuário");

        jblTipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jblTipoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jblTipoUsuario.setText("Tipo  ");

        ButtonCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/clima/icons/Cliente.png"))); // NOI18N
        ButtonCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonClienteActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cliente");

        jbl_Cliente.setForeground(new java.awt.Color(0, 116, 6));
        jbl_Cliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jbl_Cliente.setText("Cliente");

        jbl_RecebeIDclienteTelaPrincipal.setForeground(new java.awt.Color(0, 116, 6));
        jbl_RecebeIDclienteTelaPrincipal.setText("id");

        jbl_RecebeIDusuarioTelaPrincipal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbl_RecebeIDusuarioTelaPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbl_RecebeIDusuarioTelaPrincipal.setText("id");

        javax.swing.GroupLayout jPanelIconesLayout = new javax.swing.GroupLayout(jPanelIcones);
        jPanelIcones.setLayout(jPanelIconesLayout);
        jPanelIconesLayout.setHorizontalGroup(
            jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIconesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonCadastro))
                .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelIconesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(ButtonCliente))
                    .addGroup(jPanelIconesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20)
                .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlTemperaturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonTemperaturas))
                .addGap(20, 20, 20)
                .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlPluviometria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonPluviometria))
                .addGap(20, 20, 20)
                .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlEvapotranspiracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonEvapo))
                .addGap(20, 20, 20)
                .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonIrrigacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlIrrigacao, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlRelatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonRelatorios))
                .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIconesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbl_Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(jblTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbl_RecebeIDclienteTelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(jbl_RecebeIDusuarioTelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelIconesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelIconesLayout.setVerticalGroup(
            jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIconesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIconesLayout.createSequentialGroup()
                        .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonCadastro)
                            .addComponent(ButtonCliente))
                        .addGap(5, 5, 5)
                        .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlCadastro)
                            .addComponent(jLabel1)))
                    .addGroup(jPanelIconesLayout.createSequentialGroup()
                        .addComponent(ButtonTemperaturas)
                        .addGap(5, 5, 5)
                        .addComponent(jlTemperaturas))
                    .addGroup(jPanelIconesLayout.createSequentialGroup()
                        .addComponent(ButtonIrrigacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlIrrigacao))
                    .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanelIconesLayout.createSequentialGroup()
                            .addComponent(ButtonPluviometria)
                            .addGap(5, 5, 5)
                            .addComponent(jlPluviometria))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelIconesLayout.createSequentialGroup()
                            .addComponent(ButtonEvapo)
                            .addGap(5, 5, 5)
                            .addComponent(jlEvapotranspiracao)))
                    .addGroup(jPanelIconesLayout.createSequentialGroup()
                        .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonRelatorios)
                            .addGroup(jPanelIconesLayout.createSequentialGroup()
                                .addComponent(jblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jblTipoUsuario)
                                    .addComponent(jbl_RecebeIDusuarioTelaPrincipal))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jbl_Cliente)
                                    .addComponent(jbl_RecebeIDclienteTelaPrincipal))))
                        .addGap(5, 5, 5)
                        .addComponent(jlRelatorios))))
        );

        jMenuArquivo.setMnemonic('A');
        jMenuArquivo.setText("Arquivo");

        jMenuArquivo_EsclolherCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuArquivo_EsclolherCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/clima/icons/user-icon.png"))); // NOI18N
        jMenuArquivo_EsclolherCliente.setMnemonic('C');
        jMenuArquivo_EsclolherCliente.setText("Cliente");
        jMenuArquivo_EsclolherCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArquivo_EsclolherClienteActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuArquivo_EsclolherCliente);

        jMenuArquivo_Login.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        jMenuArquivo_Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/clima/icons/padlock.png"))); // NOI18N
        jMenuArquivo_Login.setText("Login");
        jMenuArquivo_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArquivo_LoginActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuArquivo_Login);

        jMenuArquivo_Config.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.ALT_MASK));
        jMenuArquivo_Config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/clima/icons/Configuration.png"))); // NOI18N
        jMenuArquivo_Config.setText("Config");
        jMenuArquivo.add(jMenuArquivo_Config);

        jMenuArquivo_Sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuArquivo_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/clima/icons/close.png"))); // NOI18N
        jMenuArquivo_Sair.setText("Sair");
        jMenuArquivo_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArquivo_SairActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuArquivo_Sair);

        jMenu.add(jMenuArquivo);

        jMenuCadastro.setMnemonic('C');
        jMenuCadastro.setText("Cadastro");
        jMenuCadastro.setEnabled(false);

        jMenuCadastro_CadastroUsuario.setText("Cadastrar usuário");
        jMenuCadastro_CadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastro_CadastroUsuarioActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadastro_CadastroUsuario);

        jMenuCadastro_CadastroClientes.setText("Cadastro clientes");
        jMenuCadastro_CadastroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastro_CadastroClientesActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadastro_CadastroClientes);

        jMenu.add(jMenuCadastro);

        jMenuRelatorio.setMnemonic('R');
        jMenuRelatorio.setText("Relatórios");
        jMenuRelatorio.setEnabled(false);

        jMenuItem2.setText("jMenuItem");
        jMenuRelatorio.add(jMenuItem2);

        jMenu.add(jMenuRelatorio);

        jMenuHelp.setMnemonic('H');
        jMenuHelp.setText("Help");
        jMenuHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuHelp_Conteudo.setText("Conteúdo");
        jMenuHelp_Conteudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHelp_ConteudoActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuHelp_Conteudo);

        jMenuHelp_Ajuda.setText("Ajuda");
        jMenuHelp.add(jMenuHelp_Ajuda);

        jMenuHelp_Sobre.setText("Sobre");
        jMenuHelp_Sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHelp_SobreActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuHelp_Sobre);

        TestandoJInternalF.setText("TestandoJInternalFrame");
        TestandoJInternalF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TestandoJInternalFActionPerformed(evt);
            }
        });
        jMenuHelp.add(TestandoJInternalF);

        jMenu.add(jMenuHelp);

        setJMenuBar(jMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelIcones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelIcones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jDesktopPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1150, 642));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuArquivo_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArquivo_SairActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, " Tem certeza que deseja sair? ", " Atenção ", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuArquivo_SairActionPerformed

    private void jMenuHelp_ConteudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHelp_ConteudoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuHelp_ConteudoActionPerformed

    private void jMenuHelp_SobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHelp_SobreActionPerformed

    }//GEN-LAST:event_jMenuHelp_SobreActionPerformed

    private void ButtonTemperaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTemperaturasActionPerformed
        // TODO add your handling code here:
        try {
            Temperaturas obj = new Temperaturas();
            jDesktopPrincipal.add(obj, BorderLayout.NORTH);
            obj.setVisible(true);
            obj.toFront();//Aparecer na frente
            obj.setSize(1130, 610);
            //obj.setSize(1920, 850);
            //Algumas configurações gerais
            obj.setClosable(true);//Se o frame vai poder ser fechado pelo botão fechar 
            obj.setIconifiable(true);//Se o frame vai poder ser minimizado.
            obj.setMaximizable(true);//Se o frame vai poder ser maximizado.
            //obj.setResizable(true);//Pemite editar o tamanho.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar Tela!\nErro: " + e);
        }

        /*-------------------------------------------------------------------------------------------*/
        //A linha a baixo esta passando o id do CLIENTE para a tela Temperatura.
        //Ele captura o ID da telaPrincipalClima.
        Temperaturas.txt_id_cliente_Temperatura.setText(jbl_RecebeIDclienteTelaPrincipal.getText());

        /*-------------------------------------------------------------------------------------------*/

    }//GEN-LAST:event_ButtonTemperaturasActionPerformed

    private void ButtonPluviometriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPluviometriaActionPerformed
        // TODO add your handling code here:
        try {
            Pluviometria obj = new Pluviometria();
            jDesktopPrincipal.add(obj, BorderLayout.NORTH);
            obj.setVisible(true);
            obj.toFront();//Aparecer na frente
            obj.setSize(1130, 610);
            //obj.setSize(1920, 850);
            //Algumas configurações gerais
            obj.setClosable(true);//Se o frame vai poder ser fechado pelo botão fechar 
            obj.setIconifiable(true);//Se o frame vai poder ser minimizado.
            obj.setMaximizable(true);//Se o frame vai poder ser maximizado.
            //obj.setResizable(true);//Pemite editar o tamanho.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar Tela!\nErro: " + e);
        }
    }//GEN-LAST:event_ButtonPluviometriaActionPerformed

    private void ButtonEvapoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEvapoActionPerformed
        // TODO add your handling code here:
        try {
            Evapotranspiracao obj = new Evapotranspiracao();
            jDesktopPrincipal.add(obj, BorderLayout.NORTH);
            obj.setVisible(true);
            obj.toFront();//Aparecer na frente
            obj.setSize(1130, 610);
            //obj.setSize(1920, 850);
            //Algumas configurações gerais
            obj.setClosable(true);//Se o frame vai poder ser fechado pelo botão fechar 
            obj.setIconifiable(true);//Se o frame vai poder ser minimizado.
            obj.setMaximizable(true);//Se o frame vai poder ser maximizado.
            //obj.setResizable(true);//Pemite editar o tamanho.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar Tela!\nErro: " + e);
        }

        /*-------------------------------------------------------------------------------------------*/
        //A linha a baixo esta passando o id do CLIENTE para a tela Evapotranspiração.
        //Ele captura o ID da telaPrincipalClima.
        Evapotranspiracao.txt_id_cliente_Evapotranspiracao.setText(jbl_RecebeIDclienteTelaPrincipal.getText());

        /*-------------------------------------------------------------------------------------------*/

    }//GEN-LAST:event_ButtonEvapoActionPerformed

    private void ButtonIrrigacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonIrrigacaoActionPerformed
        // TODO add your handling code here:
        try {
            Irrigacao obj = new Irrigacao();
            jDesktopPrincipal.add(obj, BorderLayout.NORTH);
            obj.setVisible(true);
            obj.toFront();//Aparecer na frente
            obj.setSize(1130, 610);
            //obj.setSize(1920, 850);
            //Algumas configurações gerais
            obj.setClosable(true);//Se o frame vai poder ser fechado pelo botão fechar 
            obj.setIconifiable(true);//Se o frame vai poder ser minimizado.
            obj.setMaximizable(true);//Se o frame vai poder ser maximizado.
            //obj.setResizable(true);//Pemite editar o tamanho.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar Tela!\nErro: " + e);
        }
    }//GEN-LAST:event_ButtonIrrigacaoActionPerformed

    private void jMenuCadastro_CadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastro_CadastroUsuarioActionPerformed
        try {
            CadastroUsuario obj = new CadastroUsuario();
            jDesktopPrincipal.add(obj, BorderLayout.NORTH);
            obj.setVisible(true);
            obj.toFront();//Aparecer na frente
            obj.setSize(1130, 610);
            //obj.setSize(1920, 850);
            //Algumas configurações gerais
            obj.setClosable(true);//Se o frame vai poder ser fechado pelo botão fechar 
            obj.setIconifiable(true);//Se o frame vai poder ser minimizado.
            obj.setMaximizable(true);//Se o frame vai poder ser maximizado.
            //obj.setResizable(true);//Pemite editar o tamanho.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar Tela!\nErro: " + e);
        }
    }//GEN-LAST:event_jMenuCadastro_CadastroUsuarioActionPerformed

    private void jMenuCadastro_CadastroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastro_CadastroClientesActionPerformed
        try {
            CadastroCliente obj = new CadastroCliente();
            jDesktopPrincipal.add(obj, MAXIMIZED_BOTH, 6);
            jDesktopPrincipal.add(obj, MAXIMIZED_HORIZ, 2);
            jDesktopPrincipal.add(obj, MAXIMIZED_VERT, 4);
            obj.setVisible(true);
            obj.toFront();//Aparecer na frente
            obj.setSize(1130, 610);
            //obj.setSize(1920, 850);
            //Algumas configurações gerais
            obj.setClosable(true);//Se o frame vai poder ser fechado pelo botão fechar 
            obj.setIconifiable(true);//Se o frame vai poder ser minimizado.
            obj.setMaximizable(true);//Se o frame vai poder ser maximizado.
            //obj.setResizable(true);//Pemite editar o tamanho.

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar Tela!\nErro: " + e);
        }
    }//GEN-LAST:event_jMenuCadastro_CadastroClientesActionPerformed

    private void jMenuArquivo_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArquivo_LoginActionPerformed
        try {
            AlterarLogin obj = new AlterarLogin();
            jDesktopPrincipal.add(obj, MAXIMIZED_BOTH, 6);
            jDesktopPrincipal.add(obj, MAXIMIZED_HORIZ, 2);
            jDesktopPrincipal.add(obj, MAXIMIZED_VERT, 4);
            obj.setVisible(true);
            obj.toFront();//Aparecer na frente
            obj.setSize(1130, 610);
            //obj.setSize(1920, 850);
            //Algumas configurações gerais
            obj.setClosable(true);//Se o frame vai poder ser fechado pelo botão fechar 
            obj.setIconifiable(true);//Se o frame vai poder ser minimizado.
            obj.setMaximizable(true);//Se o frame vai poder ser maximizado.
            //obj.setResizable(true);//Pemite editar o tamanho.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar Tela!\nErro: " + e);
        }
    }//GEN-LAST:event_jMenuArquivo_LoginActionPerformed

    private void ButtonCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCadastroActionPerformed
        try {
            CadastroCliente obj = new CadastroCliente();
            jDesktopPrincipal.add(obj, BorderLayout.NORTH);
            obj.setVisible(true);
            obj.toFront();//Aparecer na frente
            obj.setSize(1130, 610);
            //obj.setSize(1920, 850);
            //Algumas configurações gerais
            obj.setClosable(true);//Se o frame vai poder ser fechado pelo botão fechar 
            obj.setIconifiable(true);//Se o frame vai poder ser minimizado.
            obj.setMaximizable(true);//Se o frame vai poder ser maximizado.
            //obj.setResizable(true);//Pemite editar o tamanho.
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar Tela!\nErro: " + e);
        }

        /*-------------------------------------------------------------------------------------------*/
        //A linha a baixo esta passando o id do USUÁRIO logado para a tela CadastroCliente
        //Ele captura o ID da telaPrincipalClima.
        CadastroCliente.jbl_idUsuarioTelCadastro.setText(jbl_RecebeIDusuarioTelaPrincipal.getText());

        /*-------------------------------------------------------------------------------------------*/
        //No momento da chamada da tela limpar as caixas da tela CadastroCliente
        CadastroCliente.cBoxNomeEstado.setSelectedItem(null);
        CadastroCliente.cBoxUnidadeFederal.setSelectedItem(null);
        CadastroCliente.cBoxSituacaoCliente.setSelectedItem(null);
        CadastroCliente.txtMesorregiao.setText(null);
        CadastroCliente.txtNomeCidade.setText(null);
        CadastroCliente.txtRua.setText(null);
        CadastroCliente.txtNumero.setText(null);
        CadastroCliente.txtNomeCliente.setText(null);
        CadastroCliente.txtSobrenomeCliente.setText(null);

    }//GEN-LAST:event_ButtonCadastroActionPerformed

    private void jMenuArquivo_EsclolherClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArquivo_EsclolherClienteActionPerformed

        SelecionarCli frameSelecionarCli = null;
        try {
            frameSelecionarCli = new SelecionarCli();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipalClima.class.getName()).log(Level.SEVERE, null, ex);
        }
        frameSelecionarCli.setVisible(true);
        
    }//GEN-LAST:event_jMenuArquivo_EsclolherClienteActionPerformed

    private void TestandoJInternalFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TestandoJInternalFActionPerformed

        try {
            gerenciadorDeJanelas.abrirJanelas(TestandoJInternalFrame.getInstancia());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

//        try {
//            jDesktopPrincipal.add(TestandoJInternalFrame.getInstancia());
//        } catch (ClassNotFoundException e) {
//            JOptionPane.showMessageDialog(null, "Erro ao chamar Tela!\nErro: " + e);
//        }

    }//GEN-LAST:event_TestandoJInternalFActionPerformed

    private void jDesktopPrincipalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDesktopPrincipalMouseReleased

    }//GEN-LAST:event_jDesktopPrincipalMouseReleased

    private void ButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonClienteActionPerformed

        SelecionarCli frameSelecionarCli = null;
        try {
            frameSelecionarCli = new SelecionarCli();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipalClima.class.getName()).log(Level.SEVERE, null, ex);
        }
        frameSelecionarCli.setVisible(true);

//        try {
//            SelecionarCliente obj = new SelecionarCliente();
//            jDesktopPrincipal.add(obj, BorderLayout.NORTH);
//            obj.setVisible(true);
//            obj.toFront();//Aparecer na frente
//            obj.setSize(1130, 610);
//            //obj.setSize(1920, 850);
//            //Algumas configurações gerais
//            obj.setClosable(true);//Se o frame vai poder ser fechado pelo botão fechar 
//            obj.setIconifiable(true);//Se o frame vai poder ser minimizado.
//            obj.setMaximizable(true);//Se o frame vai poder ser maximizado.
//            //obj.setResizable(true);//Pemite editar o tamanho.
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro ao chamar Tela!\nErro: " + e);
//        }
    }//GEN-LAST:event_ButtonClienteActionPerformed

    private void ButtonRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRelatoriosActionPerformed
	int confirma = JOptionPane.showConfirmDialog(null, "Confirma a impressão deste relatório? ","Atenção ", JOptionPane.YES_NO_OPTION);
	if (confirma == JOptionPane.YES_OPTION){
	    //imprimindo relatório com framework JasperReport
	    

	}     
    }//GEN-LAST:event_ButtonRelatoriosActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalClima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipalClima().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton ButtonCadastro;
    public static javax.swing.JButton ButtonCliente;
    public static javax.swing.JButton ButtonEvapo;
    public static javax.swing.JButton ButtonIrrigacao;
    public static javax.swing.JButton ButtonPluviometria;
    public static javax.swing.JButton ButtonRelatorios;
    public static javax.swing.JButton ButtonTemperaturas;
    public static javax.swing.JMenuItem TestandoJInternalF;
    private javax.swing.JButton jButton1;
    public javax.swing.JPanel jDesktopPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuItem jMenuArquivo_Config;
    private javax.swing.JMenuItem jMenuArquivo_EsclolherCliente;
    private javax.swing.JMenuItem jMenuArquivo_Login;
    private javax.swing.JMenuItem jMenuArquivo_Sair;
    public static javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuCadastro_CadastroClientes;
    private javax.swing.JMenuItem jMenuCadastro_CadastroUsuario;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuHelp_Ajuda;
    private javax.swing.JMenuItem jMenuHelp_Conteudo;
    private javax.swing.JMenuItem jMenuHelp_Sobre;
    private javax.swing.JMenuItem jMenuItem2;
    public static javax.swing.JMenu jMenuRelatorio;
    private javax.swing.JPanel jPanelIcones;
    public static javax.swing.JLabel jblTipoUsuario;
    public static javax.swing.JLabel jblUsuario;
    private javax.swing.JLabel jbl_Cliente;
    public static javax.swing.JLabel jbl_RecebeIDclienteTelaPrincipal;
    public static javax.swing.JLabel jbl_RecebeIDusuarioTelaPrincipal;
    private javax.swing.JLabel jlCadastro;
    private javax.swing.JLabel jlEvapotranspiracao;
    private javax.swing.JLabel jlIrrigacao;
    private javax.swing.JLabel jlPluviometria;
    private javax.swing.JLabel jlRelatorios;
    private javax.swing.JLabel jlTemperaturas;
    // End of variables declaration//GEN-END:variables

}
