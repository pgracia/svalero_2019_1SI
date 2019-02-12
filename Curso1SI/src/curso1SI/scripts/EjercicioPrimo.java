package curso1SI.scripts;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

// Víctor Fernández
public class EjercicioPrimo {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("numeros.txt"));
        String numeroString;

        BigInteger numeroParaEvaluar;
        while ((numeroString = br.readLine()) != null) {
            numeroParaEvaluar = new BigInteger(numeroString);
            System.out.print("El número " + numeroParaEvaluar + " ");
            System.out.println(esPrimo(numeroParaEvaluar) ? "es primo" : "no es primo");
        }
    }

    static boolean esPrimo(BigInteger num) {
        if (!num.isProbablePrime(5)) {
            return false;
        }

        BigInteger dos = new BigInteger("2");
        if (!dos.equals(num) && BigInteger.ZERO.equals(num.mod(dos))) {
            return false;
        }

        for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(num) < 1; i = i.add(dos)) {
            if (BigInteger.ZERO.equals(num.mod(i))) {
                return false;
            }
        }
        return true;
    }
}
