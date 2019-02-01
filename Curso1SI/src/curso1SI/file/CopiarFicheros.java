package curso1SI.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CopiarFicheros {
	static Scanner scanner = new Scanner(System.in);

	static String origenUsuario;

	static ArrayList<File> arraySizeMayor = new ArrayList<File>();
	static ArrayList<File> arraySizeMenor = new ArrayList<File>();
	static ArrayList<File> arrayNombreMayor = new ArrayList<File>();
	static ArrayList<File> arrayNombreMenor = new ArrayList<File>();

	private static void recorrerArray(ArrayList<File> array, File ficheroCopiado, String comprobar) {
		Iterator<File> it = array.iterator();
		while (it.hasNext()) {
			File fichero = it.next();
			if (comprobar.equals("sizeMayor")) {
				if (fichero.length() < ficheroCopiado.length()) {
					array.remove(fichero);
					array.add(ficheroCopiado);
				} else if (fichero.length() == ficheroCopiado.length()) {
					array.add(ficheroCopiado);
				}
			} else if (comprobar.equals("sizeMenor")) {
				if (fichero.length() > ficheroCopiado.length()) {
					array.remove(fichero);
					array.add(ficheroCopiado);
				} else if (fichero.length() == ficheroCopiado.length()) {
					array.add(ficheroCopiado);
				}
			}

			int posicionUltimoSeparador = fichero.getAbsolutePath().lastIndexOf("\\");
			String nombreFicheroArray = fichero.getAbsolutePath().substring(posicionUltimoSeparador);
			posicionUltimoSeparador = ficheroCopiado.getAbsolutePath().lastIndexOf("\\");
			String nombreFicheroCopiado = ficheroCopiado.getAbsolutePath().substring(posicionUltimoSeparador);
			
			if (comprobar.equals("nombreMayor")) {				
				if (nombreFicheroArray.length() < nombreFicheroCopiado.length()) {
					array.remove(fichero);
					array.add(ficheroCopiado);
				} else if (nombreFicheroArray.length() == nombreFicheroCopiado.length()) {
					array.add(ficheroCopiado);
				}
			}
			
			if (comprobar.equals("nombreMenor")) {				
				if (nombreFicheroArray.length() > nombreFicheroCopiado.length()) {
					array.remove(fichero);
					array.add(ficheroCopiado);
				} else if (nombreFicheroArray.length() == nombreFicheroCopiado.length()) {
					array.add(ficheroCopiado);
				}
			}
		}
	}

	private static void copiaFichero(String origen, String destino) {
		Path origenPath = Paths.get(origen);

		int posicionUltimoSeparador = origen.lastIndexOf("\\");
		String nombreFichero = origen.substring(posicionUltimoSeparador);
		Path destinoPath = Paths.get(destino.concat(nombreFichero));

		try {
			Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

		File ficheroCopiado = new File(destino.concat(nombreFichero));
		if (arraySizeMayor.isEmpty()) {
			arraySizeMayor.add(ficheroCopiado);
		} else {
			recorrerArray(arraySizeMayor, ficheroCopiado, "sizeMayor");
		}

		if (arraySizeMenor.isEmpty()) {
			arraySizeMenor.add(ficheroCopiado);
		} else {
			recorrerArray(arraySizeMenor, ficheroCopiado, "sizeMenor");
		}

		if (arrayNombreMayor.isEmpty()) {
			arrayNombreMayor.add(ficheroCopiado);
		} else {
			recorrerArray(arrayNombreMayor, ficheroCopiado, "nombreMayor");
		}

		if (arrayNombreMenor.isEmpty()) {
			arrayNombreMenor.add(ficheroCopiado);
		} else {
			recorrerArray(arrayNombreMenor, ficheroCopiado, "nombreMenor");
		}
	}

	public static void listarFicherosPorCarpeta(final File origen, String destino) {
		if (origen.exists()) {
			for (final File ficheroEntrada : origen.listFiles()) {
				if (ficheroEntrada.isDirectory()) {
					listarFicherosPorCarpeta(ficheroEntrada, destino);
				} else {
					copiaFichero(ficheroEntrada.getAbsolutePath(), destino);
				}
			}
		}
	}

	public static void main(String[] args) {
		try {
			System.out.print("Ruta Fichero(s) origen : ");
			origenUsuario = scanner.next();
			final File carpeta = new File(origenUsuario);
			System.out.print("Ruta destino : ");
			String destino = scanner.next();
			listarFicherosPorCarpeta(carpeta, destino);
		} catch (Exception e) {
			
		}
		
		System.out.println("Fichero mayor tamaño es : " + arraySizeMayor.get(0));		
		System.out.println("Fichero menor tamaño es : " + arraySizeMenor.get(0));
		System.out.println("Fichero mayor nombre es : " + arrayNombreMayor.get(0));		
		System.out.println("Fichero menor nombre es : " + arrayNombreMenor.get(0));
	}
}