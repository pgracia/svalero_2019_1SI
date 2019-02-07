package curso1SI.dto;

public class FicheroTexto extends FicheroCarpeta {

	@Override
	public String toString() {
		return "FicheroTexto [numeroCaracteres=" + numeroCaracteres + ", Nombre=" + getNombre() + ", Ruta()="
				+ getRuta() + ", es Directorio=" + isEsDirectorio() + ", es Oculto=" + isEsOculto() + "]";
	}

	private int numeroCaracteres;

	public int getNumeroCaracteres() {
		return numeroCaracteres;
	}

	public void setNumeroCaracteres(int numeroCaracteres) {
		this.numeroCaracteres = numeroCaracteres;
	}
	
	
}
