import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Fecha{

    public Fecha(String fecha){

        try {
            
            fechaParseada = LocalDate.parse(fecha);
        
        } catch (DateTimeParseException ex) {
            throw new RuntimeException("Error: no se pudo convertir la fecha al tipo LocalDate.");
        }
    }

    private LocalDate fechaParseada;

    public LocalDate getFecha(){
        return fechaParseada;
    }
    
    public boolean fechaAnterior(String fecha){

        try {
            
            LocalDate nuevaFecha = LocalDate.parse(fecha);
    
            if(fechaParseada.isBefore(nuevaFecha)) return true;
                else return false;
        
        } catch (DateTimeParseException ex) {
            throw new RuntimeException("Error: la fecha a comparar es inválida.");
        }

    }

    public boolean fechaPosterior(String fecha){

        try {
            
            LocalDate nuevaFecha = LocalDate.parse(fecha);
    
            if(fechaParseada.isAfter(nuevaFecha)) return true;
                else return false;
        
        } catch (DateTimeParseException ex) {
            throw new RuntimeException("Error: la fecha a comparar es inválida.");
        }

    }

    public boolean esAnteriorALaActual(){

        LocalDate actual = LocalDate.now();

        if(fechaParseada.isBefore(actual)) return true;
            else return false;

    }



}