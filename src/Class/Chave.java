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
public class Chave {

    private int intNumChave;
    private String strLocal, strDepartamento;
    java.sql.Connection Conexao;

    Class_Connection con = new Class_Connection();

    public Chave(int intNumChave, String strLocal, String strDepartamento) {
        this.intNumChave = intNumChave;
        this.strLocal = strLocal;
        this.strDepartamento = strDepartamento;
    }

    public Chave() {

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

        if ((intNumChave != 0) && (strLocal != null) && (strDepartamento != null)) {
            try {
                PreparedStatement strComandoSQL = null;

                strComandoSQL = Conexao.prepareStatement("INSERT INTO TBChave (Num_Chave, local, departamento)"
                        + "VALUES(?,?,?)");

                strComandoSQL.setInt(1, intNumChave);
                strComandoSQL.setString(2, strLocal);
                strComandoSQL.setString(3, strDepartamento);
                int intRegistro = strComandoSQL.executeUpdate();
                if (intRegistro != 0) {
                    JOptionPane.showMessageDialog(null, "Chave Nº: " + intNumChave + "\nLocal: " + strLocal + "\nDepartamento: "
                            + strDepartamento, "CADASTRO EFETUADO", JOptionPane.INFORMATION_MESSAGE);
                    con.getComando().close();
                    con.Conexao.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Registro não adicionado !", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    con.Comando.close();
                    con.Conexao.close();
                }
            } catch (Exception Excecao) {
                JOptionPane.showMessageDialog(null, "Numero ja cadastrado");
            }

        }
    }

    public void AlterarChave(String strNovoLocal, String strNovoDep, int where) {
        con.Conecta();
        Conexao = con.getConexao();

        try {
            PreparedStatement strComandoSQL = null;

//            strComandoSQL = Conexao.prepareStatement("UPDATE TBChave SET local ='" + strNovoLocal + "',"
//                    + "departamento ='" + strNovoDep + "' WHERE Num_Chave =" + where);


            strComandoSQL = Conexao.prepareStatement("UPDATE TBChave SET local ='" + strNovoLocal + "',"
                    + "departamento ='" + strNovoDep + "' WHERE Num_Chave =" + where);

             
            int intRegistro = strComandoSQL.executeUpdate();
            if (intRegistro != 0) {
            JOptionPane.showMessageDialog(null, "ALTERAÇÃO EFETUADA", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
            con.Comando.close();
            con.Conexao.close();
            
            }
            
        } catch (Exception Excecao) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }

    public int TotLinhas() {
        con.Conecta();
        int tot = 0;
        try {
            PreparedStatement strComandoSQL;
            strComandoSQL = con.Conexao.prepareStatement("SELECT * FROM TBChave");
            con.rsBusca = strComandoSQL.executeQuery();
            while (con.rsBusca.next()) {
                tot = con.rsBusca.getRow();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao obter total de chaves",
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
                con.Comando.cancel();
                con.Conexao.close();
            } catch (SQLException Excecao) {
                JOptionPane.showMessageDialog(null, "Erro em busca por local");
            }
        }
    }

    public void TabelaBusca(JTable tbBusca, String Busca) {
        con.Conecta();
        DefaultTableModel modelo = (DefaultTableModel) tbBusca.getModel();
        modelo.setNumRows(0);
        tbBusca.getColumnModel().getColumn(0);
        try {
            PreparedStatement pstmstrComandoSQL = null;
            pstmstrComandoSQL = con.Conexao.prepareStatement("SELECT * FROM TBChave WHERE local LIKE '*"
                    + Busca + "*' or Num_Chave LIKE '*" + Busca + "*'");
            con.rsBusca = pstmstrComandoSQL.executeQuery();
            while (con.rsBusca.next()) {
                modelo.addRow(new Object[]{
                    con.rsBusca.getInt(1),
                    con.rsBusca.getString(2),
                    con.rsBusca.getString(3),
                    con.rsBusca.getBoolean(4),});
            }
            con.Conexao.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os dados!");
        }
    }

    public void EmUso(JTable tbChave) {

        con.Conecta();
        DefaultTableModel modelo = (DefaultTableModel) tbChave.getModel();
        modelo.setNumRows(0);
        tbChave.getColumnModel().getColumn(0);
        try {
            PreparedStatement pstmstrComandoSQL = null;
            pstmstrComandoSQL = con.Conexao.prepareStatement("SELECT * FROM TBChave WHERE disponivel = NO");
            con.rsBusca = pstmstrComandoSQL.executeQuery();
            while (con.rsBusca.next()) {
                modelo.addRow(new Object[]{
                    con.rsBusca.getInt(1),
                    con.rsBusca.getString(2),
                    con.rsBusca.getString(3),
                    con.rsBusca.getBoolean(4)
                });
            }
            con.Conexao.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os dados!");

        }
    }

}
