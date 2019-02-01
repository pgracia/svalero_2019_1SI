package curso1SI.recursive;

import java.io.File;

public class FicherosRecursivo {

    public static void listarFicherosPorCarpeta(final File carpeta) {
        for (final File ficheroEntrada : carpeta.listFiles()) {
            if (ficheroEntrada.isDirectory()) {
                listarFicherosPorCarpeta(ficheroEntrada);
            } else {
                System.out.println(ficheroEntrada.getAbsolutePath());
            }
        }
    }
   
    public static void main(String[] args) {
        try {
            final File carpeta = new File("D:" + System.getProperty("file.separator") + "Pedro");
            listarFicherosPorCarpeta(carpeta );
        } catch (Exception e) {
            System.err.println("Ruta no existe " + e.getMessage());
        }       
    }   
}

