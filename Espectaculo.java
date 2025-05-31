
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Espectaculo {

    public Espectaculo(String nombreEspectaculo){

        this.nombre = nombreEspectaculo;
        this.funciones = new HashMap<String, Funcion>();
        
    }

    private String nombre;
    private HashMap<String, Funcion> funciones;

    //Procesa la venta de una entrada para una sede de tipo estadio.
    public Entrada procesarVenta(String email, String nombreEspectaculo, String fecha){

        if(funciones.containsKey(fecha)){

            Funcion funcion = funciones.get(fecha);
            Entrada entrada = funcion.crearEntrada(email, nombreEspectaculo, fecha);

            return entrada;

        } else {
            throw new RuntimeException("Error: la fecha ingresada no corresponde a ninguna función registrada.");
        }
    }

    //Procesa la venta de una entrada para una sede de tipo Teatro o Miniteatro.
    public Entrada procesarVenta(String email, String nombreEspectaculo, String fecha, String sector, int asiento){

        if(funciones.containsKey(fecha)){

            Funcion funcion = funciones.get(fecha);
            Entrada entrada = funcion.crearEntrada(email, nombreEspectaculo, fecha, sector, asiento);

            return entrada;

        } else {
            throw new RuntimeException("Error: la fecha ingresada no corresponde a ninguna función registrada.");
        }
    }

    public void eliminarEntrada(Entrada entrada){

        String fecha;
        Fecha fechaEntrada = entrada.getFecha();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");
        fecha = fechaEntrada.getFecha().format(formato);
        Funcion funcion = funciones.get(fecha);

        if(entrada.getSector() == "CAMPO"){
            funcion.quitarEntrada();
        } else {
            funcion.quitarEntrada(entrada.getSector(), entrada.getNumeroDeAsiento());
        }

    }

    public String listarFunciones(){

        if(funciones.size() == 0){
            throw new RuntimeException("Error: el espectaculo no tiene ninguna función registrada.");
        }

        StringBuilder sb = new StringBuilder();
        for (Funcion elem : funciones.values()) {
            
            sb.append(elem.toString() + "\n\n");

        }

        return sb.toString();

    }

    public void agregarFuncion(String fecha, Sede sede, double precioBase, String nombreSede){

        if(funciones.containsKey(fecha)){
        	throw new RuntimeException("La fecha ya está ocupada por otra función.");
        } else {
        	
        	funciones.put(fecha, new Funcion(sede, precioBase, nombreSede));

        }

    }

    public double obtenerCosto(String fecha){

        try {
            
            if(funciones.containsKey(fecha)){
    
                return funciones.get(fecha).calcularCostoFinal();
    
            } else {
                throw new RuntimeException("Error: la fecha ingresada no corresponde a ninguna función registrada.");
            }
            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public double obtenerCosto(String fecha, String sector){
        
        try {
            
            if(funciones.containsKey(fecha)){
    
                return funciones.get(fecha).calcularCostoFinal(sector);
    
            } else {
                throw new RuntimeException("Error: la fecha ingresada no corresponde a ninguna función registrada.");
            }
            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("\nnombre: " + nombre);
        
        sb.append("\n" + "Cantidad de funciones: " + funciones.size());

        return sb.toString();

    }

}
