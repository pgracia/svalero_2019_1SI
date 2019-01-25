package curso1SI;

import java.util.ArrayList;
import java.util.Iterator;

import curso1SI.dto.Autobus;
import curso1SI.dto.Camion;
import curso1SI.services.GestionVehiculo;

public class Main {
    private static final String CAMION = "C";
    private static final String AUTOBUS = "A";
    private static final String CAMION_AUTOBUS = "X";
    private static final String SALIR = "S";
    
    static GestionVehiculo gestionVehiculo = new GestionVehiculo();
    
    static ArrayList arrayVehiculos = new ArrayList();
	public static void main(String[] args) {
		if (args.length < 2) {
            System.err.println("Número de argumentos incorrecto");
            System.exit(0);
        }
        
        try {
          Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.err.println("Se espera un valor numérico");
            System.exit(0);
        }
        
        switch (args[0]) {
            case CAMION:
                Camion camion = new Camion();
                arrayVehiculos.add(gestionVehiculo.insertarCamion(Integer.parseInt(args[1])));
                break;
            case AUTOBUS:
                Autobus autobus = new Autobus();
                arrayVehiculos.add(gestionVehiculo.insertarAutobus(Integer.parseInt(args[1])));
                break;
        }
        
        Iterator e = arrayVehiculos.iterator();
        while (e.hasNext()) {
            Object o = e.next();
            if (o instanceof Camion) {
                System.out.println("Camión con carga : " + ((Camion) o).getCarga());
            }
            if (o instanceof Autobus) {
                System.out.println("Autobús con asientos : " + ((Autobus) o).getAsientos());
            }
        }

	}

}
