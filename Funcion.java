import java.time.LocalDate;
import java.util.ArrayList;

public class Funcion {
    
    public Funcion(Sede sede, double precio){
        
        this.sede = sede;
        this.precioBase = precio;
        this.asientosVendidos = new ArrayList<Integer>();
    }

    private Sede sede;
    private double precioBase;
    private ArrayList<Integer> asientosVendidos;    //anularEntrada() debe eliminar de este array los asientos de las entradas anuladas


    public Entrada crearEntrada(String emailUsuario, String nombreDeEspectaculo, LocalDate fechaDeFuncion) {

        Estadio estadio = (Estadio) sede;

        String ubicacion = estadio.getDireccion();
        String sector = estadio.getSector();
        
        Entrada entrada = new Entrada(emailUsuario, nombreDeEspectaculo, ubicacion, sector, fechaDeFuncion, precioBase);

        return entrada;

    }

    private boolean agregarAsientoVendido(){

        if(asientosVendidos.size() < sede.getCapacidadMaxima()){

            asientosVendidos.add(1);
            return true;
        
        } else {
        
            return false;
        
        }
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();

        sb.append("Sede: " + sede);

        for (Integer integer : asientosVendidos) {
            
            sb.append("Entradas Vendidas: " + integer);

        }

        sb.append("Precio Base: " + precioBase);

        return sb.toString();

    }

}
