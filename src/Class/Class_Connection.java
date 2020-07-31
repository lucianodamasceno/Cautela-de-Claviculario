/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

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
    private static String localBD = null;

    public ResultSet getRsBusca() {
        return rsBusca;
    }
    
    
    

    public void SaveConfig() {

        FileWriter fw = null;
        try {
            fw = new FileWriter("configBD.ini");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA GRAVAÇÃO DO ARQUIVO!");
        }
        try ( PrintWriter pw = new PrintWriter(fw)) {
            pw.println("LocalBD = " + localBD);
        }
    }

    public static String getLocalBD() {
        return localBD;
    }

    public static void setLocalBD(String localBD) {
        Class_Connection.localBD = localBD;
    }
    
    
    
    public void ReadSave() {
        File arquivo = new File("configBD.ini");
        FileReader fr;

        try {
            fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            try {
                while (br.ready()) {
                    localBD = br.readLine().substring(10);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "ERRO  AO LER AS CONFIGURAÇÕES!:", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ARQUIVO NÃO ENCONTRADO!:", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "CAMINHO NÃO ENCONTRADO!", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
            }
            try {
                Comando = Conexao.createStatement();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "SEM CONEXÃO COM O BANCO DE DADOS!", "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA CONFIGURAÇÃO 'CLASS FORNAME'","MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
        }
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

}
