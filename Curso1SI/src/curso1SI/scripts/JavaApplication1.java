
package curso1SI.scripts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class JavaApplication1 {

    public static boolean esPrimo(int num) {
    int contador = 2;
  boolean primo=true;
  while ((primo) && (contador!=num)){
    if (num % contador == 0)
      primo = false;
    contador++;
  }
  return primo;
}
    
    
    public static void main(String[] args) {
        File primos = new File("primos.txt");
        try{
            Scanner scan = new Scanner(primos);
            BufferedReader br = new BufferedReader(new FileReader(primos));
            String linea;
            while(scan.hasNextInt()){
                int primo = scan.nextInt();
                if(esPrimo(primo)){
                    System.out.println(primo+" es primo");
                }
            }
        }catch(IOException ex){
            System.out.println("Fichero no encontrado");
        }
    
    
    }
}
