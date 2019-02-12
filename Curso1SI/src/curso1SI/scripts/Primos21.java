/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso1SI.scripts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A7-PC00
 */
public class Primos21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int limite=73939133;
        Random alea=new Random();
        File f=new File("D:\\EntornosDesarrollo20182019\\primos.txt");
        try {
            FileWriter fw =new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(fw);
            
            
            
            for (int i = 0; i < 100; i++) {
                bw.write(Integer.toString(alea.nextInt(1000)));
                bw.newLine();
            }
            bw.write(Integer.toString(limite));
            
            
            bw.close();
            fw.close();
            
        } catch (IOException ex) {
            System.out.println(ex);
        }
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            
        String line;
        while ((line=br.readLine())!=null) {                
                System.out.println(line);
                System.out.println(numpri(Integer.parseInt(line), 2)? "es primo":"no es primo");
            }
        fr.close();
        br.close();    
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Primos2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Primos2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    private static boolean numpri(int num,int div){
        if (num/2<div) {
            return true;
        }else{
            if (num%div==0) {
                return false;
            }else{
                return numpri(num, div+1);
            }
        }
    }
}
