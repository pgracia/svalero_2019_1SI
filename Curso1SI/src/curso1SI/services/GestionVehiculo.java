package curso1SI.services;

import curso1SI.dto.Autobus;
import curso1SI.dto.Camion;
import curso1SI.dto.CamionAutobus;
import curso1SI.interfaces.IGestionVehiculos;

public  class GestionVehiculo implements IGestionVehiculos {

	@Override
    public Camion insertarCamion(int carga) {
        Camion camion = new Camion();
        camion.setCarga(carga);
        return camion;
    }

    @Override
    public Autobus insertarAutobus(int asientos) {
        Autobus autobus = new Autobus();
        autobus.setAsientos(asientos);
        return autobus;
    }

    @Override
    public CamionAutobus insertarCamionAutobus(Camion camion, Autobus autobus) {
        CamionAutobus camionAutobus = new CamionAutobus();
        camionAutobus.datosCamionAutobus(autobus, camion);
        return camionAutobus;
    }

}
