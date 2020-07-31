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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luciano
 */
public class Class_Chave {

    Class_Connection con = new Class_Connection();
    private int intNumChave;
    private String strLocal, strDepartamento;
    java.sql.Connection Conexao = con.getConexao();

    public Class_Chave(int intNumChave, String strLocal, String strDepartamento) {
        this.intNumChave = intNumChave;
        this.strLocal = strLocal;
        this.strDepartamento = strDepartamento;
    }

    public Class_Chave() {

    }

    public int getIntNumChave() {
        return intNumChave;
    }

    public void setIntNumChave(int intNumChave) {
        this.intNumChave = intNumChave;
    }

    public String getStrLocal() {
        return strLocal;
    }

    public void setStrLocal(String strLocal) {
        this.strLocal = strLocal;
    }

    public String getStrDepartamento() {
        return strDepartamento;
    }

    public void setStrDepartamento(String strDepartamento) {
        this.strDepartamento = strDepartamento;
    }

    public void InsertChave() {
        con.Conecta();
        Conexao = con.getConexao();
        PreparedStatement strComandoSQL = null;

        if ((intNumChave != 0) && (strLocal != null) && (strDepartamento != null)) {
            try {

                strComandoSQL = Conexao.prepareStatement("INSERT INTO TBChave (Num_Chave, local, departamento)"
                        + "VALUES(?,?,?)");
                strComandoSQL.setInt(1, intNumChave);
                strComandoSQL.setString(2, strLocal);
                strComandoSQL.setString(3, strDepartamento);
                int intRegistro = strComandoSQL.executeUpdate();
                if (intRegistro != 0) {
                    JOptionPane.showMessageDialog(null, "Chave Nº: " + intNumChave + "\nLocal: " + strLocal + "\nDepartamento: "
                            + strDepartamento, "CADASTRO EFETUADO!", JOptionPane.INFORMATION_MESSAGE);
                    con.getComando().close();
                    con.Conexao.close();
                } else {
                    JOptionPane.showMessageDialog(null, "CHAVE NÃO ADICIONADA!!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    con.Comando.close();
                    con.Conexao.close();
                }
            } catch (Exception Excecao) {
                JOptionPane.showMessageDialog(null, "CHAVE JÁ CADASTRADA!");
            }
        }
    }

    public void AlterarChave(String strNovoLocal, String strNovoDep, int where) {
        con.Conecta();
        Conexao = con.getConexao();
        try {
            PreparedStatement strComandoSQL = null;
            strComandoSQL = Conexao.prepareStatement("UPDATE TBChave SET local ='" + strNovoLocal + "',"
                    + "departamento ='" + strNovoDep + "' WHERE Num_Chave =" + where);
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

    public void DeletarChave(int where) {
        con.Conecta();
        Conexao = con.getConexao();
        try {
            PreparedStatement strComandoSQL = null;

            strComandoSQL = Conexao.prepareStatement("DELETE from TBChave WHERE Num_Chave =" + where);
            int intRegistro = strComandoSQL.executeUpdate();
            if (intRegistro == 0) {
                JOptionPane.showMessageDialog(null, "EXLUSÃO EFETUADA", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
                con.Comando.close();
                con.Conexao.close();
            }
        } catch (Exception Excecao) {
            JOptionPane.showMessageDialog(null, "ERROR AO EXLUIR");
        }

    }

    public int TotLinhas() {
        con.Conecta();
        int tot = 0;
        try {
            PreparedStatement strComandoSQL;
            strComandoSQL = con.Conexao.prepareStatement("SELECT * FROM TBChave WHERE local != 'VAZIO'");
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

    public void Consulta(String BuscaChave, JTextField Num, JTextField Local) {
        if (BuscaChave != null) {

            try {
                PreparedStatement strComandoSQL;
                strComandoSQL = con.Conexao.prepareStatement("SELECT * FROM TBChave WHERE local LIKE '*"
                        + BuscaChave + "*' or Num_Chave LIKE '*" + BuscaChave + "*'"); // COMANDO OKBUSCA POR NUMERO
                strComandoSQL.setCursorName(BuscaChave);
                con.rsBusca = strComandoSQL.executeQuery();
                if (con.rsBusca.next()) {
                    Num.setText(con.rsBusca.getString("Num_Chave"));
                    Local.setText(con.rsBusca.getString("local"));
                } else {
                    JOptionPane.showMessageDialog(null, "Chave não encontrada !", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
                con.Comando.close();
                con.Conexao.close();
            } catch (SQLException Excecao) {
                JOptionPane.showMessageDialog(null, "ERRO AO OBTER DADOS NA BUSCA");
            }
        }
    }

    public void TabelaBuscaChave(JTable tbBusca, String Busca) {
        con.Conecta();
        DefaultTableModel modelo = (DefaultTableModel) tbBusca.getModel();
        modelo.setNumRows(0);
        tbBusca.getColumnModel().getColumn(0);
        try {
            PreparedStatement pstmstrComandoSQL = null;
            pstmstrComandoSQL = con.Conexao.prepareStatement("SELECT * FROM TBChave WHERE local LIKE '*"
                    + Busca + "*' or Num_Chave LIKE '*" + Busca + "*'  ORDER BY Num_Chave");
            con.rsBusca = pstmstrComandoSQL.executeQuery();
            while (con.rsBusca.next()) {
                modelo.addRow(new Object[]{
                    con.rsBusca.getInt(1),
                    con.rsBusca.getString(2),
                    con.rsBusca.getString(3),
                    con.rsBusca.getBoolean(4),});
            }
            con.Conexao.close();
            con.Comando.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO OBTER DADOS PARA A TABLE!");
        }
    }

    public void EmUso(JTable tbChave) {

        con.Conecta();
        DefaultTableModel modelo = (DefaultTableModel) tbChave.getModel();
        modelo.setNumRows(0);
        tbChave.getColumnModel().getColumn(0);
        try {
            PreparedStatement pstmstrComandoSQL = null;
            pstmstrComandoSQL = con.Conexao.prepareStatement("SELECT Num_Chave, local, nome, dataSaida, horaSaida from((TBHistorico"
                    + " INNER JOIN TBChave ON TBHistorico.idChave = TBChave.Num_Chave)"
                    + " INNER JOIN TBPessoa ON TBHistorico.idPessoa = TBPessoa.idPessoa)");
            con.rsBusca = pstmstrComandoSQL.executeQuery();
            while (con.rsBusca.next()) {
                modelo.addRow(new Object[]{
                    con.rsBusca.getInt(1),
                    con.rsBusca.getString(2),
                    con.rsBusca.getString(3),
                    con.rsBusca.getString(4),
                    con.rsBusca.getString(5)});
            }
            con.Conexao.close();

    }
    catch (Exception ex

    
        ) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os dados!");
    }
}

}
