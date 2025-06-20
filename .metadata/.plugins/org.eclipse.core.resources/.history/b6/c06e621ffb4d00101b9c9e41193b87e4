package MiTicketek;
import java.util.Objects;

public class Sector {

    public Sector(int CAPACIDAD_MAXIMA, int ASIENTOS_X_FILA, int PORCENTAJE_ADICIONAL){

    	if(PORCENTAJE_ADICIONAL < 0) {
    		throw new RuntimeException("Error: el adicional es negativo.");
    	}
    	if(CAPACIDAD_MAXIMA < 0) {
    		throw new RuntimeException("Error: la capacidad máxima es negativa.");
    	}
    	
        this.ADICIONAL = PORCENTAJE_ADICIONAL;
        this.CAPACIDAD_MAXIMA = CAPACIDAD_MAXIMA;
        this.ASIENTOS_X_FILA = ASIENTOS_X_FILA;
    }
    
    private int ADICIONAL;
    private int CAPACIDAD_MAXIMA;
    private int ASIENTOS_X_FILA;

    public int getCapacidadMaxima(){
        return CAPACIDAD_MAXIMA;
    }

    //Calcula el costo final de la entrada según el sector.
    public double calcularCosto(double PRECIO_BASE){

        double PRECIO_FINAL = PRECIO_BASE + ((PRECIO_BASE*ADICIONAL)/100);

        return PRECIO_FINAL;

    }

    //Este método calcula en qué fila se encuentra el asiento.
    public int calcularFila(int NUMERO_DE_ASIENTO){
    	
        if(NUMERO_DE_ASIENTO <= CAPACIDAD_MAXIMA && NUMERO_DE_ASIENTO > 0){

            int fila = 1;
            for (int i = 1; i <= NUMERO_DE_ASIENTO; i++) {
                
                if(i % ASIENTOS_X_FILA == 0) fila++;
    
            }

            return fila;

        } else {

            throw new RuntimeException("Error: el número de asiento negativo o cero, o es mayor a la capacidad máxima.");
            
        }

    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Sector sector = (Sector) obj;
        return CAPACIDAD_MAXIMA == sector.CAPACIDAD_MAXIMA && ADICIONAL == sector.ADICIONAL;
    }

    @Override
    public int hashCode() {
        return Objects.hash(CAPACIDAD_MAXIMA, ADICIONAL);
    }

}
