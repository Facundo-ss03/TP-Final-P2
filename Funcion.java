
import java.util.HashMap;
import java.util.HashSet;

public class Funcion {
    
    public Funcion(Sede sede, double precio, String nombreSede){
        
        this.sede = sede;
        this.nombreSede = nombreSede;
        this.precioBase = precio;
        this.asientosVendidos = new HashMap<String, HashSet<Integer>>();
        if(sede.getClass() != Estadio.class){

            asientosVendidos.put("Platea VIP", new HashSet<>());
            asientosVendidos.put("Platea Común", new HashSet<>());
            asientosVendidos.put("Platea Baja", new HashSet<>());
            asientosVendidos.put("Platea Alta", new HashSet<>());

        } else {

            this.asientosVendidosEstadio = 0;
        
        }
    }

    private Sede sede;
    private String nombreSede;
    private double precioBase;
    private HashMap<String, HashSet<Integer>> asientosVendidos;  //<codigoEntrada, nroAsiento>  //anularEntrada() debe eliminar de este mapa los asientos de las entradas anuladas
    private int asientosVendidosEstadio;

    public Entrada crearEntrada(String emailUsuario, String nombreDeEspectaculo, String fechaDeFuncion) {

        if(consultarDisponibilidadDeAsiento()){

            Fecha fecha = new Fecha(fechaDeFuncion);
            
            Entrada entrada = new Entrada(emailUsuario, nombreDeEspectaculo, nombreSede, fecha, precioBase);
            asientosVendidosEstadio++;
    
            return entrada;

        } else {
            throw new RuntimeException("No hay entradas disponibles (el estadio está lleno).");
        }

    }

    public Entrada crearEntrada(String emailUsuario, String nombreDeEspectaculo,
                                String fechaDeFuncion, String sector, int asiento) {

        Entrada entrada;
        
        if(consultarDisponibilidadDeAsiento(asiento) == false){
            
            if(sede.getClass() == Teatro.class){
        
                Teatro sedeSeleccionada = (Teatro) sede;
            
                int fila = sedeSeleccionada.buscarFila(sector, asiento);
                Fecha fecha = new Fecha(fechaDeFuncion);

                StringBuilder sb = new StringBuilder();
                sb.append(sector + " " + "f: " + fila + "a: " + asiento);
                
                double precioFinal = sedeSeleccionada.calcularCostoTotal(sector, precioBase);

                entrada = new Entrada(emailUsuario, nombreDeEspectaculo, nombreSede, sector, asiento, fila, fecha, precioFinal);
                asientosVendidos.get(sector).add(asiento);

                return entrada;
            }
            else if(sede.getClass() == MiniTeatro.class){

                MiniTeatro sedeSeleccionada = (MiniTeatro) sede;

                int fila = sedeSeleccionada.buscarFila(sector, asiento);
                Fecha fecha = new Fecha(fechaDeFuncion);

                StringBuilder sb = new StringBuilder();
                sb.append(sector + " " + "f: " + fila + " a: " + asiento);
        
                double precioFinal = sedeSeleccionada.calcularCostoTotal(sector, precioBase);

                entrada = new Entrada(emailUsuario, nombreDeEspectaculo, nombreSede, sector, asiento, fila, fecha, precioFinal);
                asientosVendidos.get(sector).add(asiento);
        
                return entrada;
            } 
            else{
                throw new RuntimeException("Error: La sede ingresada no es un Teatro ni Miniteatro.");
            }

        } else {
            throw new RuntimeException("El asiento solicitado no está disponible.");
        }
    }

    private boolean consultarDisponibilidadDeAsiento(){
        if(asientosVendidosEstadio < sede.getCapacidadMaxima()) return true;
            else return false;
    }

    private boolean consultarDisponibilidadDeAsiento(int asiento){
        if(asientosVendidos.values().contains(asiento)) return true;
            else return false;
    }

    public void  quitarEntrada(String sector, int asiento){

        asientosVendidos.get(sector).remove(asiento);    

    }

    public void quitarEntrada(){
        asientosVendidosEstadio -= 1;
    }

    public double calcularCostoFinal(){

        return precioBase;

    }

    public double calcularCostoFinal(String sector){

        try {
            
            if(sede instanceof SedesConPlateas){
    
                SedesConPlateas s = (SedesConPlateas) sede;
                return s.calcularCostoTotal(sector, precioBase);
    
            } else {
                throw new RuntimeException("Error: la sede de la función no tiene plateas.");
            }

        } catch (Exception ex) {
            throw new RuntimeException("Error al calcular el costo total.", ex);
        }

    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();

        if(asientosVendidos == null){

                sb.append("Entradas Vendidas: " + asientosVendidosEstadio);
    
        } else {

            sb.append("Entradas Vendidas: ");

            for (String sector : asientosVendidos.keySet()) {
                
                sb.append(sector + ": ");
                sb.append(asientosVendidos.get(sector).size());

            }

        }


        sb.append("Precio Base: " + precioBase);

        return sb.toString();

    }

}
