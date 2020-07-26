/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;
/**
 *
 * @author luciano
 */
public class Class_ValidaCPF {

    public boolean validaCPF(String CPF) {
        char[] NCPF = new char[11];
        int i = 0;
        int j = 10;
        float soma1 = 0;
        float soma2 = 0;
        int[] intCPF = new int[11];

        for (i = 0; i < 11; i++) {
            NCPF[i] = CPF.charAt(i);
            intCPF[i] = Character.getNumericValue(NCPF[i]);
        }
        i = 0;
        while (j >1) {
            soma1 += +intCPF[i] * j;
            j--;
            i++;
        }
        float resto1 = 11-(soma1%11);
        i = 0;
        j = 11;
        intCPF[10] = (int)resto1;
         while (j >1) {
            soma2 += +intCPF[i] * j;
            j--;
            i++;
        }
         float resto2 = 11-(soma2%11);
        
         if(resto2 >=10){
             resto2 =0;
         }
         i=0;
         for (i = 0; i < 11; i++) {
            NCPF[i] = CPF.charAt(i);
            intCPF[i] = Character.getNumericValue(NCPF[i]);
        }
         if((int)resto1 == intCPF[9] && (int)resto2 == intCPF[10]){
             return true;
         }
         else{
             return false;
         }        
    }

}
