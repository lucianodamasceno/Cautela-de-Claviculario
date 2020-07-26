package Frames;

import Class.ClassConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author luciano
 */
public class TelaCadastroPessoa extends javax.swing.JFrame {


    /**
     * Creates new form Cadastro
     */
    public TelaCadastroPessoa() {
        initComponents();

    }
    
    public void InsereDados() {

        ClassConnection conecction = new ClassConnection();
        String strNome = txtNome.getText();
        String strCPF = JformCPF.getText();
        String strEmpresa = txtEmpresa.getText();
        String strTelefone = JFormTelefone.getText();
        do {
            conecction.setStrNome(strNome);
        } while (strNome == null);
        do {
            conecction.setStrCPF(strCPF);
        } while (strCPF == null);
        do {
            conecction.setStrEmpresa(strEmpresa);
        } while (strEmpresa == null);
        do {
            conecction.setStrTelefone(strTelefone);
        } while(strTelefone == null);
        conecction.Conecta();
        conecction.InsertPessoa();
        txtAdicionado.setText("Nome: "+ strNome + "\nCPF: "+strCPF + "\nEmpresa: " + strEmpresa + "Telefone: " + strTelefone);

}

@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLABELNOME = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAdicionado = new javax.swing.JTextArea();
        JformCPF = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        JFormTelefone = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        FUNDO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLABELNOME.setText("NOME:");
        getContentPane().add(jLABELNOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 20));

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 260, -1));

        jLabel2.setText("CPF:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 30, -1));

        jLabel3.setText("EMPRESA:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        getContentPane().add(txtEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 190, -1));

        btnOk.setText("CADASTRAR");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        getContentPane().add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 120, 30));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtAdicionado.setEditable(false);
        txtAdicionado.setBackground(new java.awt.Color(240, 240, 240));
        txtAdicionado.setColumns(20);
        txtAdicionado.setRows(5);
        jScrollPane1.setViewportView(txtAdicionado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 400, 70));

        try {
            JformCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(JformCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 110, -1));

        jLabel1.setText("TELEFONE:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        try {
            JFormTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(JFormTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 110, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RESULTADO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 400, 90));
        getContentPane().add(FUNDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 310));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
    InsereDados();
    txtNome.setText(null);
    JformCPF.setText(null);
    txtEmpresa.setText(null);
    JFormTelefone.setText(null);
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
            java.util.logging.Logger.getLogger(TelaCadastroPessoa.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoa.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoa.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoa.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FUNDO;
    private javax.swing.JFormattedTextField JFormTelefone;
    private javax.swing.JFormattedTextField JformCPF;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLABELNOME;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAdicionado;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
