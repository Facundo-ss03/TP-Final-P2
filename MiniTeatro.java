
public class MiniTeatro extends SedesConPlateas{

    MiniTeatro(String direccion, int capMaxima, int asientosPorFila, int cantPuestos, 
                double valorDeConsumicion, String[] listaSectores, int[] capacidadPorSector, int[] porcentajeAdicional) {
        
        super(direccion, capMaxima, listaSectores, porcentajeAdicional, asientosPorFila, porcentajeAdicional);

        this.puestos = cantPuestos;
        this.ConsumicionLibre = valorDeConsumicion;

    }

    private int puestos;
    private double ConsumicionLibre;
    
}
