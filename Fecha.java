
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Fecha{

    public Fecha(String fecha){

        try {
            
            fechaParseada = LocalDate.parse(fecha, formato);
        
        } catch (DateTimeParseException ex) {
            throw new RuntimeException("Error: no se pudo convertir la fecha al tipo LocalDate.");
        }
    }

    private LocalDate fechaParseada;
    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");

    public LocalDate getFecha(){
        return fechaParseada;
    }
    
    public boolean fechaAnterior(String fecha){

        try {
            
            LocalDate nuevaFecha = LocalDate.parse(fecha, formato);
    
            if(fechaParseada.isBefore(nuevaFecha)) return true;
                else return false;
        
        } catch (DateTimeParseException ex) {
            throw new RuntimeException("Error: la fecha a comparar es inválida.");
        }

    }

    public boolean fechaPosterior(String fecha){

        try {
            
            LocalDate nuevaFecha = LocalDate.parse(fecha, formato);
    
            if(fechaParseada.isAfter(nuevaFecha)) return true;
                else return false;
        
        } catch (DateTimeParseException ex) {
            throw new RuntimeException("Error: la fecha a comparar es inválida.");
        }

    }

    public static boolean esAnteriorALaActual(Fecha fecha){

        LocalDate actual = LocalDate.now();

        if(actual.isAfter(fecha.fechaParseada)) return true;
            else return false;

    }

    public static boolean esPosteriorALaActual(Fecha fecha){

        LocalDate actual = LocalDate.now();

        if(actual.isBefore(fecha.fechaParseada)) return true;
            else return false;

    }

    @Override
    public String toString() {

        String fechaOriginal = fechaParseada.format(formato);

        return fechaOriginal;
    }



}