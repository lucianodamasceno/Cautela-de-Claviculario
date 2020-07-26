/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.DriverManager;
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

  
    public void Conecta() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "C:\\Users\\lucia\\Documents\\CautelaChaves2.accdb";
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
   
    public Class_Connection(){
        
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
