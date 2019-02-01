package curso1SI.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CopiarDelReves {

	static Scanner scanner = new Scanner(System.in);

	private static String abrirFicheroOrigen(String origen) {
		FileInputStream fis = null;
		String cadenaFichero = "";		
		
		try {
			fis = new FileInputStream(new File(origen));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			
			String linea = "";
			while ((linea = br.readLine()) != null) {
				cadenaFichero += linea.concat("\r\n");
			}		 
			br.close();			
			fis.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reverse(cadenaFichero);		
	}
	
	private static String reverse(String frase) {
        if (frase.isEmpty())
            return frase;
        return reverse(frase.substring(1)) + frase.charAt(0);
    }
	
	private static void crearFicheroDestino(String cadenaInvertida, String destino) {
		FileOutputStream fop = null;
		File ficheroDestino = new File(destino);
		try {
			fop = new FileOutputStream(ficheroDestino);
			
			if (!ficheroDestino.exists()) {
				ficheroDestino.createNewFile();
			}
			
			byte[] contenido = cadenaInvertida.getBytes();
			fop.write(contenido);
			fop.flush();
			fop.close();			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		System.out.println("Fichero creado en la ruta : " + ficheroDestino.getAbsolutePath());
	}

	public static void main(String[] args) {
		try {			
			String origen = "";
			boolean pregunta = true;
			
			while (pregunta) {
				System.out.print("Ruta Fichero origen : ");
				origen = scanner.next();
				
				File origenPath = new File(origen);
				if (origenPath.exists() && origenPath.isFile()) {					
					pregunta = !pregunta;
				} else {
					System.err.println("Fichero origen no encontrado. Vuelva a insertar");	
					System.out.println("");
				}
			}
			
			String destino = "";			
			pregunta = true;
			
			while (pregunta) {
				System.out.print("Ruta destino : ");
				destino = scanner.next();
				File destinoPath = new File(destino);
				if (destinoPath.exists()) {					
					pregunta = !pregunta;
				} else {
					System.err.println("Carpeta destino no existe. Vuelva a insertar");	
				}
			}
			
			int posicionUltimoSeparador = origen.lastIndexOf("\\");
			String nombreFichero = origen.substring(posicionUltimoSeparador);
			
			String cadenaInvertida = abrirFicheroOrigen(origen);
			crearFicheroDestino(cadenaInvertida, destino.concat(nombreFichero));
		} catch (Exception e) {

		}
	}
}
