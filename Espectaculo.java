
import java.time.LocalDate;
import java.util.HashMap;

public class Espectaculo {

    public Espectaculo(){

        this.funciones = new HashMap<String, Funcion>();

    }

    private HashMap<String, Funcion> funciones;

    public Entrada procesarVenta(String nombreEspectaculo, String fecha, String email){

        if(funciones.containsKey(fecha)){

            Funcion funcion = funciones.get(fecha);
            Entrada entrada = funcion.crearEntrada(email, nombreEspectaculo, fecha);

            return entrada;

        } else {
            throw new RuntimeException("Error: la fecha ingresada no corresponde a ninguna función registrada.");
        }
    }

    public Entrada procesarVenta(String nombreEspectaculo, String fecha, String email, String sector, int asiento){

        if(funciones.containsKey(fecha)){

            Funcion funcion = funciones.get(fecha);
            Entrada entrada = funcion.crearEntrada(email, nombreEspectaculo, fecha, sector, asiento);

            return entrada;

        } else {
            throw new RuntimeException("Error: la fecha ingresada no corresponde a ninguna función registrada.");
        }
    }

    public String listarFunciones(){

        if(funciones.size() == 0){
            throw new RuntimeException("Error: el espectaculo no tiene ninguna función registrada.");
        }

        StringBuilder sb = new StringBuilder();
        for (Funcion elem : funciones.values()) {
            
            sb.append(elem.toString() + "\n");

        }

        return sb.toString();

    }

    public void agregarFuncion(String fecha, Sede sede, double precioBase){

        if(!funciones.containsKey(fecha)){

            funciones.put(fecha, new Funcion(sede, precioBase));
        
        }

    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();

        for (Funcion elem : funciones.values()) {
         
            sb.append(elem.toString());   
        
        }

        return sb.toString();

    }

}
