
import java.util.HashMap;
import java.util.HashSet;

public class Funcion {
    
    public Funcion(Sede sede, double precio){
        
        this.sede = sede;
        this.precioBase = precio;

        if(sede instanceof SedesConPlateas){

            SedesConPlateas cast = (SedesConPlateas) sede;
            this.asientosVendidos = new HashMap<String, HashSet<Integer>>();

            for (String sector : cast.listarSectores()) {
                
                asientosVendidos.put(sector, new HashSet<>());

            }

        } else {

            this.asientosVendidosEstadio = 0;
        
        }
    }

    private Sede sede;
    private double precioBase;
    private HashMap<String, HashSet<Integer>> asientosVendidos;  //<codigoEntrada, nroAsiento>  //anularEntrada() debe eliminar de este mapa los asientos de las entradas anuladas
    private int asientosVendidosEstadio;

    public Entrada crearEntrada(String emailUsuario, String nombreDeEspectaculo, String fechaDeFuncion) {

        if(consultarDisponibilidadDeAsiento()){

            Fecha fecha = new Fecha(fechaDeFuncion);
            
            Entrada entrada = new Entrada(emailUsuario, nombreDeEspectaculo, sede.getNombre(), fecha, precioBase);
            asientosVendidosEstadio++;
    
            return entrada;

        } else {
            throw new RuntimeException("No hay entradas disponibles (el estadio está lleno).");
        }

    }

    public Entrada crearEntrada(String emailUsuario, String nombreDeEspectaculo,
                                String fechaDeFuncion, String sector, int asiento) {

        Entrada entrada;
        try {
            
            if(consultarDisponibilidadDeAsiento(asiento) == false){
                
                if(sede instanceof SedesConPlateas){
            
                    SedesConPlateas sedeSeleccionada = (SedesConPlateas) sede;
                
                    int fila = sedeSeleccionada.buscarFila(sector, asiento);
                    Fecha fecha = new Fecha(fechaDeFuncion);

                    StringBuilder sb = new StringBuilder();
                    sb.append(sector + " " + "f: " + fila + "a: " + asiento);
                    
                    double precioFinal = sedeSeleccionada.calcularCostoConAdicional(sector, precioBase);

                    entrada = new Entrada(emailUsuario, nombreDeEspectaculo, sede.getNombre(), sector, asiento, fila, fecha, precioFinal);
                    asientosVendidos.get(sector).add(asiento);

                    return entrada;
                }
                else{
                    throw new RuntimeException("Error: La sede ingresada no es un Teatro ni Miniteatro.");
                }

            } else {
                throw new RuntimeException("El asiento solicitado no está disponible.");
            }
            
        } catch (Exception ex) {
            throw new RuntimeException("Error al crear la entrada.", ex);
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
                return s.calcularCostoConAdicional(sector, precioBase);
    
            } else {
                throw new RuntimeException("Error: la sede de la función no tiene plateas.");
            }

        } catch (Exception ex) {
            throw new RuntimeException("Error al calcular el costo total.", ex);
        }

    }

    public String getNombreSede(){
        return sede.getNombre();
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();

        if(asientosVendidos == null){

            sb.append(sede.getNombre() + " - ");
            sb.append(asientosVendidosEstadio + "/" + sede.getCapacidadMaxima());
            sb.append("\n");
    
        } else {

            SedesConPlateas miSede = (SedesConPlateas) sede;
            sb.append(sede.getNombre() + " - ");
            for (String sector : miSede.listarSectores()) {

                sb.append(sector + ": ");
                sb.append(asientosVendidos.get(sector).size());
                sb.append("/" + miSede.getCapacidadMaximaDeSector(sector));
                sb.append(" | ");
                
            }

            if(sb.length() > 3){
                sb.setLength(sb.length()-3);
            }

        }

        return sb.toString();

    }

}
