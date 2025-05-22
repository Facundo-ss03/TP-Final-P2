import java.util.HashMap;

public class Funcion {
    
    public Funcion(String sede, double precio){
        
        this.sede = sede;
        this.precioBase = precio;
        this.entradasVendidas = new HashMap<String, Boolean>();
    }

    private String sede;
    private HashMap entradasVendidas;
    private double precioBase;

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();

        sb.append("Sede: " + sede);
        sb.append("Entradas Vendidas: " + entradasVendidas);
        sb.append("Precio Base: " + precioBase);

        return sb.toString();

    }

}
