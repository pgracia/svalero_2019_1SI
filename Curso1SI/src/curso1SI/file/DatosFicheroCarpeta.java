package curso1SI.file;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import curso1SI.interfaces.IGestionFicheros;
import curso1SI.services.GestionFicheros;

public class DatosFicheroCarpeta {

	static Scanner scanner = new Scanner(System.in);
	static ArrayList<File> ficheroCarpetaArray = new ArrayList<File>();

	private static void listarFicherosPorCarpeta(final File carpeta) {
        for (final File entrada : carpeta.listFiles()) {
            if (entrada.isDirectory()) {
            	ficheroCarpetaArray.add(entrada);
                listarFicherosPorCarpeta(entrada);
            } else {
            	ficheroCarpetaArray.add(entrada);
            }
        }
    }
	
	private static void generarResumen(ArrayList<String> info) {
		FileOutputStream fop = null;
		File ficheroDestino = new File(System.getProperty("java.io.tmpdir") + "resumen ficheros.txt");
		try {
			if (!ficheroDestino.exists()) {
				ficheroDestino.createNewFile();
			}
			fop = new FileOutputStream(ficheroDestino);
			
			Iterator<String> it = info.iterator();
			while (it.hasNext()) {
				String cadenaEscribir = it.next();
				byte[] contenido = cadenaEscribir.getBytes();
				fop.write(contenido);
				fop.write(System.lineSeparator().getBytes());
				fop.flush();
			}
			
			fop.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {			
			String origen = "";
			boolean pregunta = true;
			
			while (pregunta) {
				System.out.print("Carpeta origen : ");
				origen = scanner.next();
				
				File origenPath = new File(origen);
				if (origenPath.exists() && origenPath.isDirectory()) {					
					pregunta = !pregunta;
					listarFicherosPorCarpeta(origenPath);
				} else {
					System.err.println("Carpeta origen no encontrado. Vuelva a insertar");	
					System.out.println("");
				}				
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		Iterator<File> it = ficheroCarpetaArray.iterator();
		ArrayList<String> arrayInfo = new ArrayList<String>();
		while (it.hasNext()) {
			File fc = it.next();
			if (!fc.isDirectory()) {
				boolean isTexto = fc.getName().toLowerCase().endsWith("txt");
				boolean isHTML = fc.getName().toLowerCase().endsWith("html");
				IGestionFicheros iGestion = new GestionFicheros();
				
				if (isTexto) {
					arrayInfo.add(iGestion.infoFicheroTexto(fc));
				} else if (isHTML) {
					arrayInfo.add(iGestion.infoFicheroHTML(fc));
				} else {
					arrayInfo.add(iGestion.infoFicheroOtros(fc));
				}
			}
		}
		
		generarResumen(arrayInfo);
		
		System.exit(0);
	}
}
