
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Espectaculo {

    public Espectaculo(){

        this.funciones = new HashMap<LocalDate, Funcion>();
    }

    private HashMap<LocalDate, Funcion> funciones;

    public void agregarFuncion(String fecha, String sede, double precioBase){

        if(!funciones.containsKey(fecha)){

            LocalDate fechaFormateada = LocalDate.parse(fecha);
            funciones.put(fechaFormateada, new Funcion(sede, precioBase));
        
        }

    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        for (Funcion elem : funciones.values()) {
         
            sb.append(funciones.toString());   
        
        }

        return sb.toString();

    }

}
