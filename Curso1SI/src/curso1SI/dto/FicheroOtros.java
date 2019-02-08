package curso1SI.dto;

public class FicheroOtros extends FicheroCarpeta {
	@Override
	public String toString() {
		return "FicheroOtros [longitud=" + size + ", Nombre=" + getNombre() + ", Ruta=" + getRuta()
				+ ", es Directorio=" + isEsDirectorio() + ", es Oculto()=" + isEsOculto() + "]";
	}

	private long size;

	public long getSize() {
		return size;
	}

	public void setSize(long l) {
		this.size = l;
	}	
	
	
}
