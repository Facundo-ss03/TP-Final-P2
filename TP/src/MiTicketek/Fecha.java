
package MiTicketek;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Fecha{

    public Fecha(String fecha){
   
    	if(fecha.trim().isEmpty()) {
    		throw new RuntimeException("Error: el String está vacío.");
    	}
    	
    	fechaParseada = LocalDate.parse(fecha, formato);
    	
    	if(fechaParseada == null) {
    		throw new RuntimeException("Error: no se pudo convertir la fecha.");
    	}
         
    }

    private LocalDate fechaParseada;
    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy");

    public LocalDate getFecha(){
        return fechaParseada;
    }
    
    public boolean fechaAnterior(String fecha){
            
    	LocalDate nuevaFecha = LocalDate.parse(fecha, formato);
    
    	if(nuevaFecha == null) {
            throw new RuntimeException("Error: la fecha a comparar es inválida.");
    	}
    	
        if(fechaParseada.isBefore(nuevaFecha)) return true;
        	else return false;

    }

    public boolean fechaPosterior(String fecha){

    	LocalDate nuevaFecha = LocalDate.parse(fecha, formato);
            
    	if(nuevaFecha == null) {
        	throw new RuntimeException("Error: la fecha a comparar es inválida.");
        }
        	
        if(fechaParseada.isAfter(nuevaFecha)) return true;
        	else return false;
        

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

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Fecha fecha = (Fecha) obj;
        return fechaParseada.equals(fecha.fechaParseada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaParseada);
    }


}