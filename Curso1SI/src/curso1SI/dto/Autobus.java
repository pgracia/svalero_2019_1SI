package curso1SI.dto;

public class Autobus extends Vehiculo {
	public int asientos;
    
    public Autobus(String marca) {
        super(marca);
    }
    
    public Autobus() {
        
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }
    
}
