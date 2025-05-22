import java.util.HashMap;

public class Sector {

    public Sector(int CAPACIDAD_MAXIMA, int ASIENTOS_X_FILA, int PORCENTAJE_ADICIONAL){

        this.ADICIONAL = PORCENTAJE_ADICIONAL;
        this.CAPACIDAD_MAXIMA = CAPACIDAD_MAXIMA;
        this.ASIENTOS_X_FILA = ASIENTOS_X_FILA;
    }
    
    private int ADICIONAL;
    private int CAPACIDAD_MAXIMA;
    private int ASIENTOS_X_FILA;

    public String getAsientoYFila(int numeroDeAsiento){

        if(numeroDeAsiento <= CAPACIDAD_MAXIMA && numeroDeAsiento > 0){

            int fila = 1;
            for (int i = 1; i <= numeroDeAsiento; i++) {
                
                if(i % ASIENTOS_X_FILA == 0) fila++;
    
            }

            StringBuilder sb = new StringBuilder();
            sb.append("f:" + fila + " a:" + numeroDeAsiento);
            return sb.toString();

        } else {
            throw new RuntimeException("El número de asiento ingresado es inválido.");
        }

    }

}
