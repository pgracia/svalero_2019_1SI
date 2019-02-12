package curso1SI.scripts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecursividadNumPrimo {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        int num;
        
        leerFichero();

        System.out.println("Escribe un número");
        num = sc.nextInt();
        sc.nextLine();
        
        if (num == 0 || num == 1) {
            System.out.println("NO ES UN NÚMERO PRIMO");
            
        }else{
        System.out.printf("%nEl numero %d ", num);
        System.out.print(numeroPrimo(num, 2) ? " es un número primo.": "no es un número primo");
        }
    }
    
    private static boolean numeroPrimo(int num, int divisor){
        if (num/2 < divisor) {
            return true;
        } else{
            if (num%divisor==0) {
                return false;
            } else{
                return numeroPrimo(num, divisor + 1);
            }
        }
    }
    
    static void leerFichero() throws IOException{
        File f = new File("D:\\Desktop\\ENTORNOS\\RecursividadNumPrimo\\numeros.txt");
        FileReader fr;
        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            int [] numerosFichero = new int[5];
            
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null) {                
                numerosFichero[contador] = Integer.parseInt(linea);
                contador++;
                System.out.println(linea);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecursividadNumPrimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
