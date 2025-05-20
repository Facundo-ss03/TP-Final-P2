
import java.util.HashMap;
import java.util.Map;

public class MiniTeatro extends SedesConPlateas{

    MiniTeatro(String direccion, int capMaxima, int cantPuestos, double valorDeConsumicion,
                String[] listaSectores, int asientosPorFila, int[] porcentajeAdicional) {
        
        super(direccion, capMaxima, listaSectores, porcentajeAdicional, asientosPorFila, porcentajeAdicional);

        this.puestos = cantPuestos;
        this.ConsumicionLibre = valorDeConsumicion;

        HashMap a = getSectores();
    }

    private int puestos;
    private double ConsumicionLibre;
    
}
