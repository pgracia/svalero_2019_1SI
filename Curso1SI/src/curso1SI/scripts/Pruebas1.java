package curso1SI.scripts;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class Pruebas1 {

    public static boolean esPrimo(BigInteger numero) {
        BigInteger contador = new BigInteger(0 + "");
        BigInteger i = new BigInteger(1 + "");
        BigInteger resto = new BigInteger(0 + "");
        BigInteger incremento = new BigInteger(1 + "");
        BigInteger primo = new BigInteger(2+ "");
        int n;
        n = i.compareTo(numero);
        while(n == -1 && n == 0) {

            if ((numero.mod(i)) == resto) {

                contador.add(incremento);

            }

        }

        if (contador == primo) {

            return true;

        } else {

            return false;

        }

    }
    
    public static String[] leerFichero(String ruta) {
        
        ArrayList <String>numeros = new ArrayList<>();
        
        File f = new File(ruta);
        
        try  (Scanner leer = new Scanner(f)) {

            while (leer.hasNext()) { 
                numeros.add(leer.next());
            }

        }catch (Exception e) {
        }
        
        String [] serie = new String [numeros.size()];
        
        for (int i = 0; i < serie.length; i++) {
            serie[i] = numeros.get(i);
        }
        return serie;
    }

    public static void main(String[] args) throws IOException {

        Scanner leerTeclado = new Scanner(System.in);
        
        String ruta = leerTeclado.nextLine();
        
        BigInteger numeroLeido;
        
        for (int i = 0; i < leerFichero(ruta).length; i++) {
            numeroLeido = new BigInteger(leerFichero(ruta)[i]);
            if(esPrimo(numeroLeido)){
                System.out.println("Primo");
            }
            else{
                System.out.println("No primo");
            }
        }
        
    }

}
