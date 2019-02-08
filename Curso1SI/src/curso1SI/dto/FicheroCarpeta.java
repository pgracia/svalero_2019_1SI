package curso1SI.dto;

public class FicheroCarpeta {
	private String nombre;
	private String ruta;
	private boolean esDirectorio;
	private boolean esOculto;
	
	public FicheroCarpeta(String nombre, String ruta, boolean esDirectorio, boolean esOculto) {
		super();
		this.nombre = nombre;
		this.ruta = ruta;
		this.esDirectorio = esDirectorio;
		this.esOculto = esOculto;
	}

	public FicheroCarpeta() {
		super();		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public boolean isEsDirectorio() {
		return esDirectorio;
	}

	public void setEsDirectorio(boolean esDirectorio) {
		this.esDirectorio = esDirectorio;
	}

	public boolean isEsOculto() {
		return esOculto;
	}

	public void setEsOculto(boolean esOculto) {
		this.esOculto = esOculto;
	}	
}
