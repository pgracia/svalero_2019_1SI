package curso1SI.scripts;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PrimoRecursivo {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println(recurPrimo(4,4));
        BufferedReader lectura = new BufferedReader(new FileReader("listaNumeros.txt"));
        String linea= "";
        while(linea != null){
            linea = lectura.readLine();
            System.out.println(recurPrimo(Integer.parseInt(linea), 2));
        }
        lectura.close();
    }

    public static boolean recurPrimo(int n, int i) {
        if(i == 2)
            return true;
        if(n % 2 == 0)
            return false;
        
        return recurPrimo(n,--i);
    }
}
