package Frames;

import Class.Chave;
import Class.Class_Connection;
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
    
    

    public void InsertChave() {
        Class_Connection con = new Class_Connection();
        con.Conecta();
        Chave chave = new Chave();    
        
        try{
        int intNumChave = Integer.parseInt(txtNumero.getText());
        String strLocal = txtLocal.getText();
        String strDepartamento = txtDepartamento.getText();
        
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
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null," DADOS EM BRANCO", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
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
        btnOk = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRO DE CHAVE");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("NUMERO:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 20));
        getContentPane().add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 50, -1));

        jLabel2.setText("LOCAL:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));
        getContentPane().add(txtLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 260, -1));

        jLabel3.setText("D:EPARTAMENTO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        getContentPane().add(txtDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 190, -1));

        btnOk.setText("CADASTRAR");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        getContentPane().add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 110, 30));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 150));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
    InsertChave();
    txtNumero.setText(null);
    txtLocal.setText(null);
    txtDepartamento.setText(null);
    }//GEN-LAST:event_btnOkActionPerformed

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
        }

catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroChave.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroChave.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

catch (javax.swing.UnsupportedLookAndFeelException ex) {
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
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
