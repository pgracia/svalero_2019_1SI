package curso1SI.ejemplos;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class ConvertirMaysuculasSalidaFichero {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String origen = scanner.nextLine();
		
		FileOutputStream fop = null;
		File ficheroDestino = new File(System.getProperty("java.io.tmpdir") + "salida.txt");
		try {
			if (!ficheroDestino.exists()) {
				ficheroDestino.createNewFile();
			}
			fop = new FileOutputStream(ficheroDestino);
			fop.write(origen.toUpperCase().getBytes());
			fop.flush();
			fop.close();
		} catch (Exception e) {
			
		}
		System.out.println("Creado en : " + ficheroDestino.getAbsolutePath());
	}
}
