/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingContainer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author luciano
 */
public class Class_Pessoa {

    Class_Connection con = new Class_Connection();
    private String strNome, strCPF, strEmpresa, strTelefone;
    java.sql.Connection Conexao = con.getConexao();

    public Class_Pessoa(String strNome, String strCPF, String strEmpresa, String strTelefone) {
        this.strNome = strNome;
        this.strCPF = strCPF;
        this.strEmpresa = strEmpresa;
        this.strTelefone = strTelefone;
    }

    public Class_Pessoa() {

    }

    public String getStrNome() {
        return strNome;
    }

    public void setStrNome(String strNome) {
        this.strNome = strNome;
    }

    public String getStrEmpresa() {
        return strEmpresa;
    }

    public void setStrEmpresa(String strEmpresa) {
        this.strEmpresa = strEmpresa;
    }

    public String getStrTelefone() {
        return strTelefone;
    }

    public void setStrTelefone(String strTelefone) {
        this.strTelefone = strTelefone;

    }

    public String getStrCPF() {
        return strCPF;
    }

    public void setStrCPF(String strCPF) {
        this.strCPF = strCPF;
    }

    public void InsertChave() {
        con.Conecta();
        Conexao = con.getConexao();
        PreparedStatement strComandoQSL = null;

        if ((strNome != null) && (strCPF != null) && (strTelefone != null) && (strEmpresa != null)) {
            try {

                strComandoQSL = Conexao.prepareStatement("INSERT INTO TBPessoa (nome, CPF, telefone, empresa) VALUES (?,?,?,?)");
                strComandoQSL.setString(1, strNome);
                strComandoQSL.setString(2, strCPF);
                strComandoQSL.setString(3, strTelefone);
                strComandoQSL.setString(4, strEmpresa);
                int intRegistro = strComandoQSL.executeUpdate();
                if (intRegistro != 0) {
                    JOptionPane.showMessageDialog(null, "Nome: " + strNome + "\nCPF: " + strCPF + "\nTelefone: " + strTelefone + "\nEmpresa: " + strEmpresa,
                            "CADASTRO EFETUADO!", JOptionPane.INFORMATION_MESSAGE);
                    con.getComando().close();
                    con.Conexao.close();
                } else {
                    JOptionPane.showMessageDialog(null, "ERRO AO REGISTRAR!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    con.Comando.close();
                    con.Conexao.close();
                }
            } catch (Exception Excecao) {
                JOptionPane.showMessageDialog(null, "CPF JÁ CADASTRADO!");
            }

        }

    }

    public void DeletarPessoa(String where) {
        con.Conecta();
        Conexao = con.Conexao;
        try {
            PreparedStatement strComandoSQL = null;
            strComandoSQL = Conexao.prepareStatement(" DELETE from TBPessoa WHERE idPessoa ='" + where + "'");
            int intRegistro = strComandoSQL.executeUpdate();
            if (intRegistro == 0) {
                JOptionPane.showMessageDialog(null, "EXLUSÃO EFETUADA", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
                con.Comando.close();
                con.Conexao.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR AO EXLUIR");

        }
    }

    public void AlterarPessoa(String strNovoNome, String strNovoCPF, String strNovoTel, String strNovaEmp, String where) {
        con.Conecta();
        Conexao = con.getConexao();
        try {
            PreparedStatement strComandoSQL = null;
            strComandoSQL = Conexao.prepareStatement("UPDATE TBPessoa SET nome ='" + strNovoNome
                    + "', CPF ='" + strNovoCPF + "', telefone ='" + strNovoTel + "', empresa ='" + strNovaEmp + "' WHERE idPessoa ='" + where + "'");
            int intRegistro = strComandoSQL.executeUpdate();
            if (intRegistro != 0) {
                JOptionPane.showMessageDialog(null, "ALTERAÇÃO EFETUADA", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
                con.Comando.close();
                con.Conexao.close();
            }
        } catch (Exception Excecao) {
            JOptionPane.showMessageDialog(null, "ERROR NA ALTERAÇÃO");
        }
    }

    public void TabelaBuscaPessoa(JTable tbBusca, String Busca) {
        con.Conecta();
        DefaultTableModel modelo = (DefaultTableModel) tbBusca.getModel();
        modelo.setNumRows(0);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        
        JTableHeader header = tbBusca.getTableHeader();
        DefaultTableCellHeaderRenderer centralizadoH = (DefaultTableCellHeaderRenderer) header.getDefaultRenderer();
        centralizadoH.setHorizontalAlignment(SwingConstants.CENTER);
        int i =0;
        
        while(i<5){
        tbBusca.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        i++;
        }
        
        tbBusca.getColumnModel().getColumn(0);
        try {
            PreparedStatement pstmstrComandoSQL = null;
            pstmstrComandoSQL = con.Conexao.prepareStatement("SELECT * FROM TBPessoa WHERE nome LIKE '*"
                    + Busca + "*' or CPF LIKE '*" + Busca + "*'  ORDER BY idPessoa");
            con.rsBusca = pstmstrComandoSQL.executeQuery();
            while (con.rsBusca.next()) {
                modelo.addRow(new Object[]{
                    con.rsBusca.getString(5),
                    con.rsBusca.getString(1),
                    con.rsBusca.getString(2),
                    con.rsBusca.getString(4),
                    con.rsBusca.getString(3)});
            }
            con.Conexao.close();
            con.Comando.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO OBTER DADOS PARA A TABLE PESSOA!");
        }
    }

    public int TotLinhas() {
        con.Conecta();
        int tot = 0;
        try {
            PreparedStatement strComandoSQL;
            strComandoSQL = con.Conexao.prepareStatement("SELECT * FROM TBPessoa");
            con.rsBusca = strComandoSQL.executeQuery();
            while (con.rsBusca.next()) {
                tot = con.rsBusca.getRow();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO OBTER DADOS TOTAIS",
                    "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
        }
        return tot;
    }

}
