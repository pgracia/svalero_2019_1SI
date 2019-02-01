package curso1SI.interfaces;

import curso1SI.dto.Autobus;
import curso1SI.dto.Camion;
import curso1SI.dto.CamionAutobus;

public interface IGestionVehiculos {
    public Camion insertarCamion(int carga);
    public Autobus insertarAutobus(int asientos);
    public CamionAutobus insertarCamionAutobus(Camion camion, Autobus autobus);
}
