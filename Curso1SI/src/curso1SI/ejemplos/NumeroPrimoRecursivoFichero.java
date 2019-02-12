package curso1SI.ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class NumeroPrimoRecursivoFichero {
	
	private static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args) {
    	boolean pedir = true;
    	String rutaUsuario = "";
    	while (pedir) {
	        System.out.print("Introduce ruta fichero: ");
	        rutaUsuario = sc.nextLine();
	        File ruta = new File(rutaUsuario);
	        if (!ruta.isFile()) {
	        	System.err.println("Es necesario introducir una ruta a un fichero existente");
	        } else {
	        	pedir = !pedir;
	        }
    	}
        
        String contenido = abrirFicheroOrigen(rutaUsuario);
        String[] contenidoSeparado = contenido.split(",");
        for (int i=0; i < contenidoSeparado.length; i++) {
        	String numeroString = contenidoSeparado[i];
        	BigInteger numero = new BigInteger(numeroString.trim());
        	System.out.printf("%nEl numero %d ", numero);
	        if (numero.intValue() < 2)  {
	        	System.out.print("no es un número primo.");
	        	System.exit(0);
	        }
	        System.out.print(numeroPrimo(numero, 2)?"es un número primo.":"no es un número primo.");
        }
    }
     
    private static boolean numeroPrimo(BigInteger num, int divisor){
        if(num.divide(BigInteger.valueOf(new Integer(2).longValue())).compareTo(BigInteger.valueOf(divisor)) == -1){
            return true;
        } else {
        	BigInteger div[] = num.divideAndRemainder(BigInteger.valueOf(divisor));
            if(div[0].compareTo(BigInteger.valueOf(0)) == 0){
                return false;
            } else {
                return numeroPrimo(num, divisor+1);
            }
        }
    }
    
    private static String abrirFicheroOrigen(String origen) {
		FileInputStream fis = null;
		String cadenaFichero = "";			
		try {
			fis = new FileInputStream(new File(origen));			
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			
			String linea = "";
			while ((linea = br.readLine()) != null) {
				cadenaFichero += linea;
			}		 
			br.close();			
			fis.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cadenaFichero;
	}
}
