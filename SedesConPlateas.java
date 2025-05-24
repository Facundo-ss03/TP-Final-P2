import java.util.HashMap;

public abstract class SedesConPlateas extends Sede {

    SedesConPlateas(String direccion, int CAPACIDAD_MAXIMA, String[] listaDeSectores, 
                    int[] capacidadPorSector, int ASIENTOS_X_FILA, int[] porcentajesAdicionales) {

        super(direccion, CAPACIDAD_MAXIMA);

        sectores = new  HashMap<String, Sector>();

        configurarSectores(listaDeSectores, capacidadPorSector, ASIENTOS_X_FILA, porcentajesAdicionales);
    }

    private HashMap<String, Sector> sectores;

    private void configurarSectores(String[] listaDeSectores, int[] capacidadPorSector, int ASIENTOS_X_FILA, int[] porcentajesAdicionales){
        
        for (int i = 0; i < listaDeSectores.length; i++) {
            
            sectores.put(listaDeSectores[i], new Sector(capacidadPorSector[i], ASIENTOS_X_FILA, porcentajesAdicionales[i]));

        }

    }

    //Este método está pensado para validar si el sector solicitado existe, y para obtener la fila en la que se encuentra el asiento.
    public int buscarFila(String sector, int NUMERO_DE_ASIENTO){
        
        if(sectores.containsKey(sector)){

            Sector s = sectores.get(sector);

            return s.calcularFila(NUMERO_DE_ASIENTO);
        
        } else {

            throw new RuntimeException("No existe el asiento en el sector solicitado");

        }


    }

}
