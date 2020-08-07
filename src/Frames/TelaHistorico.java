/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Class.Class_Chave;
import Class.Class_Connection;
import Class.Class_Pessoa;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luciano
 */
public class TelaHistorico extends javax.swing.JFrame {

    /**
     * Creates new form TelaHistorico
     */
    public TelaHistorico() {
        initComponents();
        int um = 1;

    }

    /**
     * Creates new form SelectChave
     */
    public void ClickLinhaChave() {

        int linha = tbBuscaChave.getSelectedRow();
        String col_0 = String.valueOf(tbBuscaChave.getValueAt(linha, 0));
        String col_1 = String.valueOf(tbBuscaChave.getValueAt(linha, 1));
        String col_2 = String.valueOf(tbBuscaChave.getValueAt(linha, 2));
        Historico(Integer.parseInt(col_0), tblHistChave);

    }

    public void BuscaChave() {
        String Busca = null;

        Class_Connection con = new Class_Connection();
        con.Conecta();
        Class_Chave chave = new Class_Chave();

        Busca = txtBuscaChave.getText();
        chave.TabelaBuscaChave(tbBuscaChave, Busca);
    }

    public void Historico(int Chave, JTable tabela) {
        String orderBy = null;
        if (orderByNome.isSelected()) {
            orderBy = "nome";
        } else {
            orderBy = " dataSaida";
        }
        Class_Connection con = new Class_Connection();
        con.Conecta();
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        tabela.getColumnModel().getColumn(0);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();

        for (int i = 0; i < 8; i++) {
            tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            centralizado.setHorizontalTextPosition(SwingConstants.CENTER);
        }

        if (Chave != 0) {

            try {
                PreparedStatement strComandoSQL;
                strComandoSQL = con.getConexao().prepareStatement("SELECT nome,cpf, telefone, empresa, dataSaida, horaSaida, dataRetorno, horaRetorno FROM TBPessoa p\n"
                        + "INNER JOIN TBHistorico h\n"
                        + "ON p.idPessoa = h.idPessoa\n"
                        + "where idChave =" + Chave + " ORDER BY " + orderBy); // COMANDO OK. BUSCA POR NUMERO

                strComandoSQL.setCursorName(Integer.toString(Chave));
                ResultSet rsBusca = strComandoSQL.executeQuery();
                con.setRsBusca(rsBusca);
                while (con.getRsBusca().next()) {
                    modelo.addRow(new Object[]{
                        con.getRsBusca().getString(1),
                        con.getRsBusca().getString(2),
                        con.getRsBusca().getString(3),
                        con.getRsBusca().getString(4),
                        con.getRsBusca().getString(5),
                        con.getRsBusca().getString(6),
                        con.getRsBusca().getString(7),
                        con.getRsBusca().getString(8),});
                }
                con.setComando(con.getComando());
                con.setConexao(con.getConexao());
            } catch (SQLException Excecao) {
                JOptionPane.showMessageDialog(null, "ERRO AO OBTER DADOS NA BUSCA");
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        FundoPainel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelChave = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBuscaChave = new javax.swing.JTable();
        Fundo_Result_Busca = new javax.swing.JPanel();
        txtBuscaChave = new javax.swing.JTextField();
        btnBuscaChave = new javax.swing.JButton();
        FUNDO_CHAVE1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistChave = new javax.swing.JTable();
        orderByNome = new javax.swing.JRadioButton();
        orderByDSaida = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHistChave1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        painelChave.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelChave.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbBuscaChave.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUM", "LOCAL", "DPTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            tbBuscaChave.getColumnModel().getColumn(0).setMinWidth(0);
            tbBuscaChave.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbBuscaChave.getColumnModel().getColumn(0).setMaxWidth(50);
            tbBuscaChave.getColumnModel().getColumn(2).setMinWidth(0);
            tbBuscaChave.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbBuscaChave.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        painelChave.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 460, 260));

        Fundo_Result_Busca.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LOCALIZADO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        painelChave.add(Fundo_Result_Busca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 460, 280));

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
        painelChave.add(txtBuscaChave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 52, 370, 25));

        btnBuscaChave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/procurar.png"))); // NOI18N
        btnBuscaChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaChaveActionPerformed(evt);
            }
        });
        painelChave.add(btnBuscaChave, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 45, 40, 40));

        FUNDO_CHAVE1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        FUNDO_CHAVE1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCAR CHAVE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        painelChave.add(FUNDO_CHAVE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 460, 100));

        tblHistChave.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "CPF", "TEL", "EMPRESA", "DATA SAIDA", "HORA SAIDA", "DATA RETORNO", "HORA RETORNO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHistChave);
        if (tblHistChave.getColumnModel().getColumnCount() > 0) {
            tblHistChave.getColumnModel().getColumn(0).setMinWidth(0);
            tblHistChave.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblHistChave.getColumnModel().getColumn(0).setMaxWidth(150);
            tblHistChave.getColumnModel().getColumn(1).setMinWidth(0);
            tblHistChave.getColumnModel().getColumn(1).setPreferredWidth(110);
            tblHistChave.getColumnModel().getColumn(1).setMaxWidth(110);
            tblHistChave.getColumnModel().getColumn(2).setMinWidth(0);
            tblHistChave.getColumnModel().getColumn(2).setPreferredWidth(110);
            tblHistChave.getColumnModel().getColumn(2).setMaxWidth(110);
            tblHistChave.getColumnModel().getColumn(3).setMinWidth(0);
            tblHistChave.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblHistChave.getColumnModel().getColumn(3).setMaxWidth(120);
            tblHistChave.getColumnModel().getColumn(4).setMinWidth(0);
            tblHistChave.getColumnModel().getColumn(4).setPreferredWidth(82);
            tblHistChave.getColumnModel().getColumn(4).setMaxWidth(82);
            tblHistChave.getColumnModel().getColumn(5).setMinWidth(0);
            tblHistChave.getColumnModel().getColumn(5).setPreferredWidth(85);
            tblHistChave.getColumnModel().getColumn(5).setMaxWidth(85);
            tblHistChave.getColumnModel().getColumn(6).setMinWidth(0);
            tblHistChave.getColumnModel().getColumn(6).setPreferredWidth(105);
            tblHistChave.getColumnModel().getColumn(6).setMaxWidth(105);
            tblHistChave.getColumnModel().getColumn(7).setMinWidth(0);
            tblHistChave.getColumnModel().getColumn(7).setPreferredWidth(110);
            tblHistChave.getColumnModel().getColumn(7).setMaxWidth(110);
        }

        painelChave.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 850, 390));

        buttonGroup1.add(orderByNome);
        orderByNome.setText("NOME");
        painelChave.add(orderByNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, -1, -1));

        buttonGroup1.add(orderByDSaida);
        orderByDSaida.setText("DATA SAÍDA");
        painelChave.add(orderByDSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, -1, 20));

        jTabbedPane1.addTab("CHAVE ESPECÍFICA", painelChave);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblHistChave1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "CPF", "TEL", "EMPRESA", "DATA SAIDA", "HORA SAIDA", "DATA RETORNO", "HORA RETORNO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblHistChave1);
        if (tblHistChave1.getColumnModel().getColumnCount() > 0) {
            tblHistChave1.getColumnModel().getColumn(0).setMinWidth(0);
            tblHistChave1.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblHistChave1.getColumnModel().getColumn(0).setMaxWidth(150);
            tblHistChave1.getColumnModel().getColumn(1).setMinWidth(0);
            tblHistChave1.getColumnModel().getColumn(1).setPreferredWidth(110);
            tblHistChave1.getColumnModel().getColumn(1).setMaxWidth(110);
            tblHistChave1.getColumnModel().getColumn(2).setMinWidth(0);
            tblHistChave1.getColumnModel().getColumn(2).setPreferredWidth(110);
            tblHistChave1.getColumnModel().getColumn(2).setMaxWidth(110);
            tblHistChave1.getColumnModel().getColumn(3).setMinWidth(0);
            tblHistChave1.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblHistChave1.getColumnModel().getColumn(3).setMaxWidth(120);
            tblHistChave1.getColumnModel().getColumn(4).setMinWidth(0);
            tblHistChave1.getColumnModel().getColumn(4).setPreferredWidth(82);
            tblHistChave1.getColumnModel().getColumn(4).setMaxWidth(82);
            tblHistChave1.getColumnModel().getColumn(5).setMinWidth(0);
            tblHistChave1.getColumnModel().getColumn(5).setPreferredWidth(85);
            tblHistChave1.getColumnModel().getColumn(5).setMaxWidth(85);
            tblHistChave1.getColumnModel().getColumn(6).setMinWidth(0);
            tblHistChave1.getColumnModel().getColumn(6).setPreferredWidth(105);
            tblHistChave1.getColumnModel().getColumn(6).setMaxWidth(105);
            tblHistChave1.getColumnModel().getColumn(7).setMinWidth(0);
            tblHistChave1.getColumnModel().getColumn(7).setPreferredWidth(110);
            tblHistChave1.getColumnModel().getColumn(7).setMaxWidth(110);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 850, 370));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 370, 310));

        jTabbedPane1.addTab("GERAL", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout FundoPainelLayout = new javax.swing.GroupLayout(FundoPainel);
        FundoPainel.setLayout(FundoPainelLayout);
        FundoPainelLayout.setHorizontalGroup(
            FundoPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoPainelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        FundoPainelLayout.setVerticalGroup(
            FundoPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoPainelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(FundoPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(FundoPainel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1400, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscaChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaChaveActionPerformed
        // TODO add your handling code here:
        BuscaChave();
    }//GEN-LAST:event_btnBuscaChaveActionPerformed

    private void txtBuscaChaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaChaveKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            BuscaChave();
    }//GEN-LAST:event_txtBuscaChaveKeyPressed

    private void txtBuscaChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaChaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaChaveActionPerformed

    private void tbBuscaChaveChaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBuscaChaveChaveMousePressed
        // TODO add your handling code here:
        ClickLinhaChave();
    }//GEN-LAST:event_tbBuscaChaveChaveMousePressed

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
            java.util.logging.Logger.getLogger(TelaHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaHistorico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaHistorico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FUNDO_CHAVE1;
    private javax.swing.JPanel FundoPainel;
    private javax.swing.JPanel Fundo_Result_Busca;
    private javax.swing.JButton btnBuscaChave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton orderByDSaida;
    private javax.swing.JRadioButton orderByNome;
    private javax.swing.JPanel painelChave;
    private javax.swing.JTable tbBuscaChave;
    private javax.swing.JTable tblHistChave;
    private javax.swing.JTable tblHistChave1;
    private javax.swing.JTextField txtBuscaChave;
    // End of variables declaration//GEN-END:variables
}
