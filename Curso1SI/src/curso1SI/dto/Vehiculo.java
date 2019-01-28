package curso1SI.dto;

public class Vehiculo {
	public String marca;

    public Vehiculo(String marca) {
        this.marca = marca;
    }

    public Vehiculo() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }   
}
