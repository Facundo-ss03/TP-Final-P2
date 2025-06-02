
public class MiniTeatro extends SedesConPlateas{

    MiniTeatro(String nombreSede, String direccion, int capMaxima, int asientosPorFila, int cantPuestos, 
                double valorDeConsumicion, String[] listaSectores, int[] capacidadPorSector, int[] porcentajeAdicional) {
        
        super(nombreSede, direccion, capMaxima, listaSectores, capacidadPorSector, asientosPorFila, porcentajeAdicional);

        this.puestos = cantPuestos;
        this.consumicionLibre = valorDeConsumicion;

    }

    private int puestos;
    private double consumicionLibre;
    
    @Override
    public double calcularCostoConAdicional(String sector, double precioBase) {
        
        return super.calcularCostoConAdicional(sector, precioBase) + consumicionLibre;

    }

}