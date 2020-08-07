/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import Frames.TelaFile;
import Frames.TelaInicial;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author luciano
 */
public class Class_Connection {

    java.sql.Connection Conexao;
    java.sql.Statement Comando;
    java.sql.ResultSet rsBusca;

    private static String localBD;
    private static boolean autoCarrega;
    TelaFile file = new TelaFile();

    public ResultSet getRsBusca() {
        return rsBusca;
    }

    public static boolean isAutoCarrega() {
        return autoCarrega;
    }

    public static void setAutoCarrega(boolean autoCarrega) {
        Class_Connection.autoCarrega = autoCarrega;
    }

    public void setRsBusca(ResultSet rsBusca) {
        this.rsBusca = rsBusca;
    }

    public static String getLocalBD() {
        return localBD;
    }

    public static void setLocalBD(String localBD) {
        Class_Connection.localBD = localBD;
    }

    public Class_Connection() {

    }

    public java.sql.Connection getConexao() {
        return Conexao;
    }

    public void setConexao(java.sql.Connection Conexao) {
        this.Conexao = Conexao;
    }

    public Statement getComando() {
        return Comando;
    }

    public void setComando(Statement Comando) {
        this.Comando = Comando;
    }

    public void SaveConfig() {

        FileWriter fw = null;
        try {
            fw = new FileWriter("configBD.ini");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA GRAVAÇÃO DO ARQUIVO!");
        }
        try (PrintWriter pw = new PrintWriter(fw)) {
            pw.println(localBD);
            pw.println("Auto Carregar: " + autoCarrega);
        }
    }

    public void ReadSave() {
        File arquivo = new File("configBD.ini");
        FileReader fr;
        String[] configs = new String[2];
        int i = 0;
        try {
            fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            try {
                while (br.ready()) {
                    //localBD = br.readLine();
                    configs[0] = br.readLine();
                    configs[1] = br.readLine();
                }
                if (configs[0].contains("accdb")) {
                    localBD = configs[0];
                }
                if (configs[1].contains("true")) {
                    autoCarrega = true;
                }
                //   new TelaInicial().setVisible(true);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "ERRO  AO LER AS CONFIGURAÇÕES!:", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "BANCO DE DADOS NÃO ENCONTRADO! \nSELECIONE O ARQUIVO NAS CONFIGURAÇÕES:", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
            new TelaInicial().setVisible(true);
        }

    }

    public void Conecta() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = localBD;
            String url = "jdbc:ucanaccess://" + path;

            try {
                Conexao = DriverManager.getConnection(url);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "CAMINHO BANCO DE DADOS NÃO ENCONTRADO!", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
                TelaFile telaF = new TelaFile();
                telaF.ChooseBD();
                new TelaInicial().setVisible(true);
            }
            try {
                Comando = Conexao.createStatement();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "SEM CONEXÃO COM O BANCO DE DADOS!", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA CONFIGURAÇÃO 'CLASS FORNAME'", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
