package curso1SI.dto;

public class FicheroHTML extends FicheroCarpeta {

	@Override
	public String toString() {
		return "FicheroHTML [cadena Titulo=" + cadenaTitle + ", Nombre=" + getNombre() + ", Ruta=" + getRuta()
				+ ", es Directorio=" + isEsDirectorio() + ", es Oculto=" + isEsOculto() + "]";
	}

	private String cadenaTitle;

	public String getCadenaTitle() {
		return cadenaTitle;
	}

	public void setCadenaTitle(String cadenaTitle) {
		this.cadenaTitle = cadenaTitle;
	}
	
	
}
