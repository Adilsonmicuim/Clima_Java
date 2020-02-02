package com.clima.arduino;

import com.clima.util.ArduinoSerial;
 import javax.swing.JOptionPane;

public class TempArduinoMAXeMIN extends javax.swing.JFrame {

    public TempArduinoMAXeMIN() {
        initComponents();

        ArduinoSerial tempds1820 = new ArduinoSerial("COM4"); //"COM3" é a porta do meu TempArduino.

        //Loop infinito fazendo processo separado para não sobrecarregar o sistema usado Threads
        Thread t = new Thread() {
            @Override
            public void run() {

                tempds1820.initialize();

                while (true) {
                    //Testando tempds1820 atual
                    lbTemperatura.setText(tempds1820.read());

                    //Comando Sql a seguir
                    if (tempds1820.read() != null && Double.parseDouble(tempds1820.read()) > 20.00) {

                        try {
                            TempArduinoDAO dao = new TempArduinoDAO();
                            TempArduinoBEAN temp = new TempArduinoBEAN();
                            
                            //Criar uma classe bean e dao separado - APENAS PARA TESTE - DATABASE
                            temp.setTempAtual(Double.parseDouble(tempds1820.read()));
                            
                            if (dao.save(temp)) {
                                System.out.println("Salvo!");
                            } else {
                                System.err.println("Erro!");
                            }
                            //Tempo para leitura a cada 9 segundos.
                            tempds1820.sleep(9000);
                        } catch (ClassNotFoundException ex) {
                           JOptionPane.showMessageDialog(null, ex);
                        }
                    }

                }
            }
        };
        //Chamando a thread
        t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelArduino = new javax.swing.JPanel();
        LogoArduino = new javax.swing.JLabel();
        lbTemperatura = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jblValorMaxima = new javax.swing.JLabel();
        jblValorMinima = new javax.swing.JLabel();
        jblDataHoraMaxima = new javax.swing.JLabel();
        jblDataHoraMinima = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LogoArduino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoArduino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/clima/icons/arduino_logo.png"))); // NOI18N

        lbTemperatura.setText("lbTemperatura");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Temperatura Máxima:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Temperatura Mínima:");

        jblValorMaxima.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jblValorMaxima.setForeground(new java.awt.Color(255, 0, 0));
        jblValorMaxima.setText("Valor");

        jblValorMinima.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jblValorMinima.setForeground(new java.awt.Color(0, 0, 153));
        jblValorMinima.setText("Valor");

        jblDataHoraMaxima.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jblDataHoraMaxima.setText("DataHora");

        jblDataHoraMinima.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jblDataHoraMinima.setText("DataHora");

        javax.swing.GroupLayout jPanelArduinoLayout = new javax.swing.GroupLayout(jPanelArduino);
        jPanelArduino.setLayout(jPanelArduinoLayout);
        jPanelArduinoLayout.setHorizontalGroup(
            jPanelArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArduinoLayout.createSequentialGroup()
                .addGroup(jPanelArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelArduinoLayout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(lbTemperatura))
                    .addGroup(jPanelArduinoLayout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addGroup(jPanelArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LogoArduino, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelArduinoLayout.createSequentialGroup()
                                .addGroup(jPanelArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelArduinoLayout.createSequentialGroup()
                                        .addComponent(jblValorMinima)
                                        .addGap(18, 18, 18)
                                        .addComponent(jblDataHoraMinima))
                                    .addGroup(jPanelArduinoLayout.createSequentialGroup()
                                        .addComponent(jblValorMaxima)
                                        .addGap(18, 18, 18)
                                        .addComponent(jblDataHoraMaxima)))))))
                .addContainerGap(266, Short.MAX_VALUE))
        );
        jPanelArduinoLayout.setVerticalGroup(
            jPanelArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArduinoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(LogoArduino)
                .addGap(39, 39, 39)
                .addGroup(jPanelArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jblValorMaxima)
                    .addComponent(jblDataHoraMaxima))
                .addGap(18, 18, 18)
                .addGroup(jPanelArduinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jblValorMinima)
                    .addComponent(jblDataHoraMinima))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(lbTemperatura)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelArduino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelArduino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(849, 541));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TempArduinoMAXeMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TempArduinoMAXeMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TempArduinoMAXeMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TempArduinoMAXeMIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TempArduinoMAXeMIN().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoArduino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelArduino;
    private javax.swing.JLabel jblDataHoraMaxima;
    private javax.swing.JLabel jblDataHoraMinima;
    private javax.swing.JLabel jblValorMaxima;
    private javax.swing.JLabel jblValorMinima;
    private javax.swing.JLabel lbTemperatura;
    // End of variables declaration//GEN-END:variables
}
