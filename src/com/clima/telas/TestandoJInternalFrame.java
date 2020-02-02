package com.clima.telas;

 public class TestandoJInternalFrame extends javax.swing.JInternalFrame {

    public static Evapotranspiracao testandoJInternalFrame;

    public static Evapotranspiracao getInstancia() throws ClassNotFoundException {
        if (testandoJInternalFrame == null) {
            testandoJInternalFrame = new Evapotranspiracao();
        }
        return testandoJInternalFrame;
    }

    public TestandoJInternalFrame() {
        initComponents();

    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );

        setBounds(0, 0, 700, 531);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
