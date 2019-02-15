package curso1SI.scripts;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Numeros_primos_recursividad {

    private static boolean numeroPrimo(int num, int divisor) {
        if (num / 2 < divisor) {
            return true;
        } else {
            if (num % divisor == 0) {
                return false;
            } else {
                return numeroPrimo(num, divisor + 1);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        BufferedReader br = new BufferedReader(new FileReader("primos.txt"));
        String linea = "";
        while (linea != null) {
            linea = br.readLine();
            if (linea != null) {
                BigInteger bi = BigInteger.valueOf(Integer.parseInt(linea));
//                System.out.printf("numero: "+ bi + ". primo: "+ numeroPrimo (bi ,2));
                System.out.println(bi);
            }
        }
        br.close();
    }

}
