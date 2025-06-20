
package MiTicketek;
public class Teatro extends SedesConPlateas{

    Teatro(String nombreSede, String direccion, int capacidadMaxima, int asientosPorFila,
            String[] listaDeSectores, int[] capacidadPorSector, int[] porcentajesAdicionales) {
                
        super(nombreSede, direccion, capacidadMaxima, listaDeSectores, capacidadPorSector, asientosPorFila, porcentajesAdicionales);
        
    }

}
