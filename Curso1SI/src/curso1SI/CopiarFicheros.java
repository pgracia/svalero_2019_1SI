package curso1SI.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CopiarFicheros {
    static Scanner scanner = new Scanner(System.in);

    static String origenUsuario;

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
    }

    public static void listarFicherosPorCarpeta(final File origen, String destino) {
        if (origen.exists()) {
            for (final File ficheroEntrada : origen.listFiles()) {
                if (ficheroEntrada.isDirectory()) {
                    listarFicherosPorCarpeta(ficheroEntrada, destino);
                } else {
                    copiaFichero(origen.getAbsolutePath(), destino);
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
            System.err.println("Ruta no existe " + e.getMessage());
        }
    }
}