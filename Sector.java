
public class Sector {

    public Sector(int CAPACIDAD_MAXIMA, int ASIENTOS_X_FILA, int PORCENTAJE_ADICIONAL){

        this.ADICIONAL = PORCENTAJE_ADICIONAL;
        this.CAPACIDAD_MAXIMA = CAPACIDAD_MAXIMA;
        this.ASIENTOS_X_FILA = ASIENTOS_X_FILA;
    }
    
    private int ADICIONAL;
    private int CAPACIDAD_MAXIMA;
    private int ASIENTOS_X_FILA;

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

            throw new RuntimeException("El número de asiento ingresado es inválido.");
            
        }

    }

}
