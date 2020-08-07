/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import Frames.TelaInicial;


/**
 *
 * @author luciano
 */
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Class_Connection con = new Class_Connection();
    //    con.ReadSave();
    new TelaInicial().setVisible(true);

    }
}
