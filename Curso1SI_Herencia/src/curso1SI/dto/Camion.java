package curso1SI.dto;

public class Camion extends Vehiculo {
	 public int carga;
	 
	    public Camion() {
	        
	    }
	    
	    public Camion(String marca) {
	        super(marca);
	    }

	    public int getCarga() {
	        return carga;
	    }

	    public void setCarga(int carga) {
	        this.carga = carga;
	    }
}
