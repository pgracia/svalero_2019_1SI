package curso1SI.dto;

public class CamionAutobus {
	private int asientos;
    private int carga;

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public void datosCamionAutobus(Autobus autobus, Camion camion) {
        this.setAsientos(autobus.getAsientos());
        this.setCarga(camion.getCarga());
    }
}
