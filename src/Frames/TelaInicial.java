/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Class.Chave;
import Class.Class_DateTime;
import Class.Class_Connection;
import Class.Class_ValidaCPF;
import Class.Pessoa;
import java.awt.event.KeyEvent;

/**
 *
 * @author luciano
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {

        initComponents();
        Boot();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FUNDO_PAINEL = new javax.swing.JPanel();
        txtEmBrancoChave = new javax.swing.JLabel();
        txtEmBrancoPessoa = new javax.swing.JLabel();
        txtBuscaChave = new javax.swing.JTextField();
        txtBuscaPessoa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnBuscaChave = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscaPessoa = new javax.swing.JButton();
        JFOHoraSaida = new javax.swing.JFormattedTextField();
        JFODataSaida = new javax.swing.JFormattedTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbBuscaPessoa = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBuscaChave = new javax.swing.JTable();
        Fundo_Result_Busca1 = new javax.swing.JPanel();
        FUNDO = new javax.swing.JLabel();
        Fundo_Result_Busca = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmUso = new javax.swing.JTable();
        Fundo_Em_Uso = new javax.swing.JPanel();
        FUNDO_PESSOA = new javax.swing.JLabel();
        FUNDO_CHAVE1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTotPessoas = new javax.swing.JTextField();
        txtTotChave = new javax.swing.JTextField();
        testeDep = new javax.swing.JTextField();
        testeNome = new javax.swing.JTextField();
        testeNum = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        FUNDO_PAINEL.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CAUTELA DE CHAVE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CAUTELA DE CHAVE");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEmBrancoChave.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtEmBrancoChave.setForeground(new java.awt.Color(102, 102, 102));
        txtEmBrancoChave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEmBrancoChave.setText("DEIXAR EM BRANCO PARA LISTAR TUDO");
        getContentPane().add(txtEmBrancoChave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 103, -1, 20));

        txtEmBrancoPessoa.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtEmBrancoPessoa.setForeground(new java.awt.Color(102, 102, 102));
        txtEmBrancoPessoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEmBrancoPessoa.setText("DEIXAR EM BRANCO PARA LISTAR TUDO");
        getContentPane().add(txtEmBrancoPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 103, -1, 20));

        txtBuscaChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaChaveActionPerformed(evt);
            }
        });
        txtBuscaChave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaChaveKeyPressed(evt);
            }
        });
        getContentPane().add(txtBuscaChave, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 400, 25));

        txtBuscaPessoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscaPessoaMouseClicked(evt);
            }
        });
        txtBuscaPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaPessoaKeyPressed(evt);
            }
        });
        getContentPane().add(txtBuscaPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 100, 400, 25));

        jLabel7.setText("SAÍDA");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, -1, 20));

        btnBuscaChave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/procurar.png"))); // NOI18N
        btnBuscaChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaChaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscaChave, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 40, 40));

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/carraca.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR ");
        btnRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, 150, 60));

        btnBuscaPessoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/procurar.png"))); // NOI18N
        btnBuscaPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaPessoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscaPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1005, 90, 40, 40));

        JFOHoraSaida.setEditable(false);
        try {
            JFOHoraSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JFOHoraSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JFOHoraSaida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(JFOHoraSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 590, 70, 25));

        JFODataSaida.setEditable(false);
        try {
            JFODataSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JFODataSaida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JFODataSaida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(JFODataSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 590, 90, 25));

        tbBuscaPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "CPF", "TELEFONE", "EMPRESA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbBuscaPessoa);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 502, 180));

        tbBuscaChave.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUM", "LOCAL", "DPTO", "DISPONIVEL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbBuscaChave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbBuscaChaveChaveMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbBuscaChave);
        if (tbBuscaChave.getColumnModel().getColumnCount() > 0) {
            tbBuscaChave.getColumnModel().getColumn(0).setMinWidth(30);
            tbBuscaChave.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbBuscaChave.getColumnModel().getColumn(1).setMinWidth(90);
            tbBuscaChave.getColumnModel().getColumn(1).setPreferredWidth(90);
            tbBuscaChave.getColumnModel().getColumn(2).setMinWidth(30);
            tbBuscaChave.getColumnModel().getColumn(2).setPreferredWidth(30);
            tbBuscaChave.getColumnModel().getColumn(3).setMinWidth(10);
            tbBuscaChave.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 500, 180));

        Fundo_Result_Busca1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LOCALIZADO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        Fundo_Result_Busca1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Fundo_Result_Busca1.add(FUNDO);

        getContentPane().add(Fundo_Result_Busca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 500, 200));

        Fundo_Result_Busca.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LOCALIZADO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        getContentPane().add(Fundo_Result_Busca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 500, 200));

        tbEmUso.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tbEmUso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUM", "LOCAL", "DPTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbEmUso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tbEmUso);
        tbEmUso.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 480, 450, 170));

        Fundo_Em_Uso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EM USO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        getContentPane().add(Fundo_Em_Uso, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, 450, 200));

        FUNDO_PESSOA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCAR PESSOA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        getContentPane().add(FUNDO_PESSOA, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 500, 100));

        FUNDO_CHAVE1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        FUNDO_CHAVE1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCAR CHAVE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        getContentPane().add(FUNDO_CHAVE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 500, 100));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel9.setText("CHAVES TOTAIS:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 425, -1, 20));
        getContentPane().add(txtTotPessoas, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 430, 30, 20));

        txtTotChave.setEditable(false);
        txtTotChave.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtTotChave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotChave.setMaximumSize(new java.awt.Dimension(50, 55));
        getContentPane().add(txtTotChave, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 425, 30, 20));

        testeDep.setEditable(false);
        testeDep.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(testeDep, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, 80, -1));

        testeNome.setEditable(false);
        getContentPane().add(testeNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, 320, -1));

        testeNum.setEditable(false);
        testeNum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        testeNum.setMaximumSize(new java.awt.Dimension(50, 90));
        getContentPane().add(testeNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, 50, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 520, 380));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 520, 380));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setText("PESSOAS TOTAIS:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, -1, 20));

        jMenu1.setText("CADASTRAR");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("CHAVE");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("PESSOA");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("ALTERAÇÃO DE DADOS");

        jMenuItem3.setText("CHAVE");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("PESSOA");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new TelaCadastroChave().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        new TelaCadastroPessoa().setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        if (!"".equals(txtBuscaChave) | !"".equals(txtBuscaPessoa)) {
            btnRegistrar.setEnabled(true);

            Class_DateTime time = new Class_DateTime();
            JFODataSaida.setText(time.getDia());
            JFOHoraSaida.setText(time.getHora());
            Boot();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscaChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaChaveActionPerformed
        // TODO add your handling code here:
        BuscaChave();
    }//GEN-LAST:event_btnBuscaChaveActionPerformed

    private void btnBuscaPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaPessoaActionPerformed
        // TODO add your handling code here:
        BuscaPessoa();
    }//GEN-LAST:event_btnBuscaPessoaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        new TelaAlteracaoChave().setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void tbBuscaChaveChaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBuscaChaveChaveMousePressed
        // TODO add your handling code here:       
        ClickLinhaChave();
    }//GEN-LAST:event_tbBuscaChaveChaveMousePressed

    private void txtBuscaChaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaChaveKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            BuscaChave();
    }//GEN-LAST:event_txtBuscaChaveKeyPressed

    private void txtBuscaChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaChaveActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBuscaChaveActionPerformed

    private void txtBuscaPessoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscaPessoaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaPessoaMouseClicked

    private void txtBuscaPessoaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaPessoaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            BuscaPessoa();
    }//GEN-LAST:event_txtBuscaPessoaKeyPressed
    private void Boot() {

        Chave chave = new Chave();
        chave.EmUso(tbEmUso);
        Class_ValidaCPF valida = new Class_ValidaCPF();

    }

    public void ClickLinhaChave() {

        int linha = tbBuscaChave.getSelectedRow();
        String col_0 = String.valueOf(tbBuscaChave.getValueAt(linha, 0));
        String col_1 = String.valueOf(tbBuscaChave.getValueAt(linha, 1));
        String col_2 = String.valueOf(tbBuscaChave.getValueAt(linha, 2));

        testeNum.setText(col_0);
        testeNome.setText(col_1);
        testeDep.setText(col_2);
    }

    public void BuscaChave() {
        String Busca = null;
        Class_Connection con = new Class_Connection();
        con.Conecta();
        Chave chave = new Chave();

        Busca = txtBuscaChave.getText();
        chave.TabelaBuscaChave(tbBuscaChave, Busca);
        txtTotChave.setText(Integer.toString(chave.TotLinhas()));
    }

    public void BuscaPessoa() {
        String Busca = null;
        Class_Connection con = new Class_Connection();
        con.Conecta();
        Pessoa pessoa = new Pessoa();

        Busca = txtBuscaPessoa.getText();
        pessoa.TabelaBuscaPessoa(tbBuscaPessoa, Busca);
        txtTotPessoas.setText(Integer.toString(pessoa.TotLinhas()));

    }

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FUNDO;
    private javax.swing.JLabel FUNDO_CHAVE1;
    private javax.swing.JPanel FUNDO_PAINEL;
    private javax.swing.JLabel FUNDO_PESSOA;
    private javax.swing.JPanel Fundo_Em_Uso;
    private javax.swing.JPanel Fundo_Result_Busca;
    private javax.swing.JPanel Fundo_Result_Busca1;
    private javax.swing.JFormattedTextField JFODataSaida;
    private javax.swing.JFormattedTextField JFOHoraSaida;
    private javax.swing.JButton btnBuscaChave;
    private javax.swing.JButton btnBuscaPessoa;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbBuscaChave;
    private javax.swing.JTable tbBuscaPessoa;
    private javax.swing.JTable tbEmUso;
    private javax.swing.JTextField testeDep;
    private javax.swing.JTextField testeNome;
    private javax.swing.JTextField testeNum;
    private javax.swing.JTextField txtBuscaChave;
    private javax.swing.JTextField txtBuscaPessoa;
    private javax.swing.JLabel txtEmBrancoChave;
    private javax.swing.JLabel txtEmBrancoPessoa;
    private javax.swing.JTextField txtTotChave;
    private javax.swing.JTextField txtTotPessoas;
    // End of variables declaration//GEN-END:variables
}
