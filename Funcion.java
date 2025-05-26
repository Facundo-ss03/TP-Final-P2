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


    public Entrada crearEntrada(String emailUsuario, String nombreDeEspectaculo, String fechaDeFuncion) {

        Estadio estadio = (Estadio) sede;

        String ubicacion = estadio.getDireccion();
        String sector = estadio.getSector();
        Fecha fecha = new Fecha(fechaDeFuncion);

        Entrada entrada = new Entrada(emailUsuario, nombreDeEspectaculo, ubicacion, sector, fecha, precioBase);

        return entrada;

    }

   
    public Entrada crearEntrada(String emailUsuario, String nombreDeEspectaculo, String fechaDeFuncion, String sector, int asiento) {

        if(consultarDisponibilidadDeAsiento(asiento)){
            
            if(sede.getClass() == Teatro.class){
        
                Teatro teatro = (Teatro) sede;
                String ubicacion = teatro.getDireccion();
                if(teatro.consultarDisponibilidadDeAsiento(sector, asiento)){
        
                    int fila = teatro.buscarFila(sector, asiento);
                    
                }
            }
        }

        Fecha fecha = new Fecha(fechaDeFuncion);

        Entrada entrada = new Entrada(emailUsuario, nombreDeEspectaculo, ubicacion, sector, fecha, precioBase);

        return entrada;

    }

    private boolean consultarDisponibilidadDeAsiento(int asiento){
        if(asientosVendidos.contains(asientosVendidos)) return false;
            return true;
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
