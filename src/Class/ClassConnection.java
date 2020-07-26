/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.DriverManager;
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
public class ClassConnection {

    private int intNumChave;
    private String strLocal, strDepartamento;
    private String strNome, strCPF, strEmpresa, strTelefone;
    java.sql.Connection Conexao;
    java.sql.Statement Comando;
    java.sql.ResultSet rsBusca;

    public void Conecta() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\lucia\\Documents\\CautelaChaves.accdb";
            String url = "jdbc:ucanaccess://" + path;
            try {
                Conexao = DriverManager.getConnection(url);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: arquivo nao encontrado!");
            }
            try {
                Comando = Conexao.createStatement();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: não foi possível estabelecer conexão com o arquivo!");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro: Class not found");
        }
    }
    
    

    public void setIntNumChave(int intNumChave) {
        this.intNumChave = intNumChave;
    }

    public void setStrLocal(String strLocal) {
        this.strLocal = strLocal;
    }

    public void setStrDepartamento(String strDepartamento) {
        this.strDepartamento = strDepartamento;
    }

    public void setStrNome(String strNome) {
        this.strNome = strNome;
    }

    public void setStrCPF(String strCPF) {
        this.strCPF = strCPF;
    }

    public void setStrEmpresa(String strEmpresa) {
        this.strEmpresa = strEmpresa;
    }

    public void setStrTelefone(String strTelefone) {
        this.strTelefone = strTelefone;
    }

    public void InsertChave() {
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
                    // JOptionPane.showMessageDialog(null, "Registro adicionado !", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    Comando.close();
                    Conexao.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Registro não adicionado !", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    Comando.close();
                    Conexao.close();
                }
            } catch (Exception Excecao) {
                JOptionPane.showMessageDialog(null, "Numero ja cadastrado");
            }

        }
    }

    public void InsertPessoa() {
        if ((strNome != null) && (strCPF != null) && (strEmpresa != null) && (strTelefone != null)) {
            try {
                PreparedStatement strComandoSQL = null;
                strComandoSQL = Conexao.prepareStatement("INSERT INTO TBPessoa (nome, CPF, empresa, telefone)"
                        + "VALUES(?,?,?,?)");

                strComandoSQL.setString(1, strNome);
                strComandoSQL.setString(2, strCPF);
                strComandoSQL.setString(3, strEmpresa);
                strComandoSQL.setString(4, strTelefone);
                int intRegistro = strComandoSQL.executeUpdate();
                if (intRegistro != 0) {
                    JOptionPane.showMessageDialog(null, "Registro adicionado !", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    Comando.close();
                    Conexao.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Registro não adicionado !", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    Comando.close();
                    Conexao.close();
                }
            } catch (Exception Excecao) {
                JOptionPane.showMessageDialog(null, "Pessoa ja cadastrado");
            }

        }
    }

    public void All(JTable tbChave) { // EXCLUIDO

        Conecta();
        DefaultTableModel modelo = (DefaultTableModel) tbChave.getModel();
        modelo.setNumRows(0);
        tbChave.getColumnModel().getColumn(0);
        try {
            PreparedStatement pstmstrComandoSQL = null;
            pstmstrComandoSQL = Conexao.prepareStatement("SELECT * FROM TBChave WHERE disponivel = NO");
            rsBusca = pstmstrComandoSQL.executeQuery();
            while (rsBusca.next()) {
                modelo.addRow(new Object[]{
                    rsBusca.getInt(1),
                    rsBusca.getString(2),
                    rsBusca.getString(3),
                    rsBusca.getBoolean(4)
                });
            }
            Conexao.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os dados!");

        }
    }

    public void ListaBusca(JTable tbBusca, String Busca) { // RENOMEADO PARA "TabelaBusca"
        Conecta();
        DefaultTableModel modelo = (DefaultTableModel) tbBusca.getModel();
        modelo.setNumRows(0);
        tbBusca.getColumnModel().getColumn(0);
        try {
            PreparedStatement pstmstrComandoSQL = null;
            pstmstrComandoSQL = Conexao.prepareStatement("SELECT * FROM TBChave WHERE local LIKE '*"
                    + Busca + "*' or Num_Chave LIKE '*" + Busca + "*'");
            rsBusca = pstmstrComandoSQL.executeQuery();
            while (rsBusca.next()) {
                modelo.addRow(new Object[]{
                    rsBusca.getInt(1),
                    rsBusca.getString(2),
                    rsBusca.getString(3),
                    rsBusca.getBoolean(4),});
            }
            Conexao.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os dados!");
        }
    }
    
    public void Consulta(String BuscaChave, JTextField Num, JTextField Local) {
        if (BuscaChave != null) {

            try {
                PreparedStatement strComandoSQL;
                strComandoSQL = Conexao.prepareStatement("SELECT * FROM TBChave WHERE local LIKE '*"
                        + BuscaChave + "*' or Num_Chave LIKE '*" + BuscaChave + "*'"); // COMANDO OKBUSCA POR NUMERO
                strComandoSQL.setCursorName(BuscaChave); // COMANDO OKBUSCA POR STRING
                rsBusca = strComandoSQL.executeQuery();
                if (rsBusca.next()) {
                    Num.setText(rsBusca.getString("Num_Chave"));
                    Local.setText(rsBusca.getString("local"));
                } else {
                    JOptionPane.showMessageDialog(null, "Chave não encontrada !", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
                Comando.cancel();
                Conexao.close();
            } catch (SQLException Excecao) {
                JOptionPane.showMessageDialog(null, "Erro em busca por local");
            }
        }
    }

} //FINAL
