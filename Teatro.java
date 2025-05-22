
import java.util.HashMap;

public class Teatro extends SedesConPlateas{

    Teatro(String direccion, int CAPACIDAD_MAXIMA, int ASIENTOS_X_FILA , String[] listaDeSectores, 
                    int[] capacidadPorSector, int[] porcentajesAdicionales) {
                
        super(direccion, CAPACIDAD_MAXIMA, listaDeSectores, capacidadPorSector, ASIENTOS_X_FILA, porcentajesAdicionales);
        
        

    }


    private int sumarCapacidadesDeSectores(int[] capacidades){

        int acumulador = 0;

        for(int i = 0; i < capacidades.length; i++){

            acumulador += capacidades[i];

        }

        return acumulador;

    }


}
