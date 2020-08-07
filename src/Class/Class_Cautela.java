/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author luciano
 */
public class Class_Cautela {

    private int idPessoa;
    private int idChave;
    private String dataSaida;
    private String horaSaida;
    private String dataRetorno;
    private String horaRetorno;

    Class_Connection con = new Class_Connection();
    java.sql.Connection Conexao = con.getConexao();

    public Class_Cautela(int idPessoa, int idChave, String dataSaida, String horaSaida, String dataRetorno, String horaRetorno) {
        this.idPessoa = idPessoa;
        this.idChave = idChave;
        this.dataSaida = dataSaida;
        this.horaSaida = horaSaida;
        this.dataRetorno = dataRetorno;
        this.horaRetorno = horaRetorno;
    }

    public Class_Cautela() {

    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getIdChave() {
        return idChave;
    }

    public void setIdChave(int idChave) {
        this.idChave = idChave;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public String getHoraRetorno() {
        return horaRetorno;
    }

    public void setHoraRetorno(String horaRetorno) {
        this.horaRetorno = horaRetorno;
    }

    public void Descautela(int idHistorico, int num_Chave, String data, String hora) {
        con.Conecta();
        PreparedStatement strComandoSQL = null;
        Conexao = con.getConexao();

        if ((num_Chave != 0)) {
            try {
                strComandoSQL = Conexao.prepareStatement("UPDATE TBChave SET disponivel = TRUE WHERE Num_Chave =" + num_Chave);
                int intRegistro = strComandoSQL.executeUpdate();

                strComandoSQL = Conexao.prepareStatement("UPDATE TBHistorico SET dataRetorno ='" + data + "'  WHERE idHistorico = " + idHistorico);
                intRegistro = strComandoSQL.executeUpdate();

                strComandoSQL = Conexao.prepareStatement("UPDATE TBHistorico SET horaRetorno ='" + hora + "' WHERE idHistorico = " + idHistorico);
                intRegistro = strComandoSQL.executeUpdate();
                if (intRegistro != 0) {
                    JOptionPane.showMessageDialog(null, "DESCAUTELA EFETUADA!");

                    con.getComando().close();
                    con.Conexao.close();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERRO AO DAR BAIXA!", "Mensagem", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "DADOS EM BRANCO", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void Cautela(int idPessoa, int num_Chave, String dataSaida, String horaSaida) {
        con.Conecta();
        PreparedStatement strComandoQSL = null;
        Conexao = con.getConexao();

        if ((idPessoa != 0) && (num_Chave != 0) && (dataSaida != null) && (horaSaida != null)) {

            try {

                strComandoQSL = Conexao.prepareStatement("UPDATE TBChave SET disponivel = FALSE WHERE Num_Chave =" + num_Chave);
                int intRegistro = strComandoQSL.executeUpdate();

                strComandoQSL = Conexao.prepareStatement("INSERT INTO TBHistorico (idPessoa, idChave,dataSaida,"
                        + "horaSaida) VALUES(?,?,?,?)");

                strComandoQSL.setInt(1, idPessoa);
                strComandoQSL.setInt(2, num_Chave);
                strComandoQSL.setString(3, dataSaida);
                strComandoQSL.setString(4, horaSaida);

                intRegistro = strComandoQSL.executeUpdate();
                if (intRegistro != 0) {
                    JOptionPane.showMessageDialog(null, "CAUTELA EFETUADA!");
                    con.getComando().close();
                    con.Conexao.close();
                } else {
                    JOptionPane.showMessageDialog(null, "ERRO AO REGISTRAR!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    con.Comando.close();
                    con.Conexao.close();
                }
            } catch (Exception Excecao) {
                JOptionPane.showMessageDialog(null, "ERROR IN INSERT!", "MENSAGEN", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "HÁ DADOS NÃO PREENCHIDOS!", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean checaDispo(int num_Chave) {
        Conexao = con.getConexao();
       

        PreparedStatement strComandoQSL = null;
        try {
            strComandoQSL = con.Conexao.prepareStatement("SELECT TBChave WHERE disponivel =" + num_Chave);
            con.rsBusca = strComandoQSL.executeQuery();
            boolean dispo = con.rsBusca.getBoolean(4);
            if (dispo == true) {
                dispo = true;
            } else {
                JOptionPane.showMessageDialog(null, "CHAVE NÃO DISPONÍVEL", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO REGISTRAR- insertFT!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return false;
    }
}
