package Frames;

import Class.Chave;
import Class.Class_Connection;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author luciano
 */
public class TelaCadastroChave extends javax.swing.JFrame {

    /**
     * Creates new form Cadastro
     */
    public TelaCadastroChave() {
        initComponents();
    }

    public void CadastrarChave() {
        Class_Connection con = new Class_Connection();
        con.Conecta();
        Chave chave = new Chave();

        try {
            int intNumChave = Integer.parseInt(txtNumero.getText());
            String strLocal = txtLocal.getText().toUpperCase();
            String strDepartamento = txtDepartamento.getText().toUpperCase();

            do {
                chave.setIntNumChave(intNumChave);
            } while (intNumChave == 0);
            do {
                chave.setStrLocal(strLocal);
            } while (strLocal == null);
            do {
                chave.setStrDepartamento(strDepartamento);
            } while (strDepartamento == null);
            chave.InsertChave();
            TelaInicial tela = new TelaInicial();
            tela.BuscaChave();
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " DADOS EM BRANCO!", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLocal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        FUNDO = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRO DE CHAVE");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("NUM:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroKeyPressed(evt);
            }
        });
        getContentPane().add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 50, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("LOCAL:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        txtLocal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLocalKeyPressed(evt);
            }
        });
        getContentPane().add(txtLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 300, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("DPTO:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        txtDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDepartamentoKeyPressed(evt);
            }
        });
        getContentPane().add(txtDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 190, -1));

        btnCadastrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/carraca.png"))); // NOI18N
        btnCadastrar.setText("CADASTRAR ");
        btnCadastrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 110, 150, 50));

        FUNDO.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CADASTRO DE CHAVE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        getContentPane().add(FUNDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 170));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        CadastrarChave();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtLocalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalKeyPressed
        // TODO add your handling code here:
        if ((txtNumero.getText() != null) && (txtLocal.getText() != null)) {
            CadastrarChave();
        } else {
            JOptionPane.showMessageDialog(null, " DADOS EM BRANCO!", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_txtLocalKeyPressed

    private void txtNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if ((txtNumero.getText() != null) && (txtLocal.getText() != null)) {
                CadastrarChave();
            } else {
                JOptionPane.showMessageDialog(null, " DADOS EM BRANCO!", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtNumeroKeyPressed

    private void txtDepartamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDepartamentoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            JOptionPane.showMessageDialog(null, " DADOS EM BRANCO!", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_txtDepartamentoKeyPressed

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
            java.util.logging.Logger.getLogger(TelaCadastroChave.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroChave.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroChave.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroChave.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroChave().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FUNDO;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
