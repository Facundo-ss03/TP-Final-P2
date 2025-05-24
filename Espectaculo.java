
import java.time.LocalDate;
import java.util.HashMap;

public class Espectaculo {

    public Espectaculo(){

        this.funciones = new HashMap<LocalDate, Funcion>();
    }

    private HashMap<LocalDate, Funcion> funciones;

    public Entrada procesarVenta(String nombreEspectaculo, LocalDate fecha, String email){

        if(funciones.containsKey(fecha)){

            Funcion funcion = funciones.get(fecha);
            Entrada entrada = funcion.crearEntrada(email, nombreEspectaculo, fecha);

            return entrada;

        } else {
            throw new RuntimeException("Error: la fecha ingresada no corresponde a ninguna función registrada.");
        }

        
    }

    public void agregarFuncion(String fecha, Sede sede, double precioBase){

        if(!funciones.containsKey(fecha)){

            LocalDate fechaFormateada = LocalDate.parse(fecha);
            funciones.put(fechaFormateada, new Funcion(sede, precioBase));
        
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
