
package MiTicketek;

public class Teatro extends SedesConPlateas{

    Teatro(String nombreSede, String direccion, int CAPACIDAD_MAXIMA, int ASIENTOS_X_FILA,
            String[] listaDeSectores, int[] capacidadPorSector, int[] porcentajesAdicionales) {
                
        super(nombreSede, direccion, CAPACIDAD_MAXIMA, listaDeSectores, capacidadPorSector, ASIENTOS_X_FILA, porcentajesAdicionales);
        
    }
}
