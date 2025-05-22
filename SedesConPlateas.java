import java.util.HashMap;

public abstract class SedesConPlateas extends Sede {

    SedesConPlateas(String direccion, int CAPACIDAD_MAXIMA, String[] listaDeSectores, 
                    int[] capacidadPorFila, int ASIENTOS_X_FILA, int[] porcentajesAdicionales) {

        super(direccion, CAPACIDAD_MAXIMA);

        sectores = new  HashMap<String, Sector>();
    }

    HashMap sectores;


}
