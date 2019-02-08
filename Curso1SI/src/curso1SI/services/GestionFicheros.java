package curso1SI.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import curso1SI.dto.FicheroHTML;
import curso1SI.dto.FicheroOtros;
import curso1SI.dto.FicheroTexto;
import curso1SI.interfaces.IGestionFicheros;

public class GestionFicheros implements IGestionFicheros {
	
	private final String tagTituloAbrir = "<title>";
	private final String tagTituloCerrar = "</title>";

	@Override
	public String infoFicheroTexto(File fc) {
		FicheroTexto fichero = new FicheroTexto();
		fichero.setEsDirectorio(fc.isDirectory());
		fichero.setEsOculto(fc.isHidden());
		fichero.setNombre(fc.getName());
		fichero.setRuta(fc.getPath());
		fichero.setNumeroCaracteres(contarCaracteres(fc));
		return fichero.toString();
	}

	@Override
	public String infoFicheroHTML(File fc) {
		FicheroHTML fichero = new FicheroHTML();
		fichero.setEsDirectorio(fc.isDirectory());
		fichero.setEsOculto(fc.isHidden());
		fichero.setNombre(fc.getName());
		fichero.setRuta(fc.getPath());
		fichero.setCadenaTitle(buscarTitulo(fc));
		return fichero.toString();
	}

	@Override
	public String infoFicheroOtros(File fc) {
		FicheroOtros fichero = new FicheroOtros();
		fichero.setEsDirectorio(fc.isDirectory());
		fichero.setEsOculto(fc.isHidden());
		fichero.setNombre(fc.getName());
		fichero.setRuta(fc.getPath());
		fichero.setSize(fc.length());
		return fichero.toString();
	}

	private int contarCaracteres(File f) {
		FileInputStream fis;
		int contador = 0;
		try {
			fis = new FileInputStream(f);

			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String linea = "";
			while ((linea = br.readLine()) != null) {
				contador += linea.length();
			}
			br.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return contador;
	}
	
	private String buscarTitulo(File f) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(f);

			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String linea = "";
			while ((linea = br.readLine()) != null) {
				if (linea.toLowerCase().contains(tagTituloAbrir) && linea.toLowerCase().contains(tagTituloCerrar)) {
					br.close();
					fis.close();
					return linea.substring(linea.toLowerCase().indexOf(tagTituloAbrir) + tagTituloAbrir.length(), linea.toLowerCase().indexOf(tagTituloCerrar));
				}
			}
			br.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return "";
	}
}
