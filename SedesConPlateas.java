import java.util.HashMap;

public class SedesConPlateas extends Sede<HashMap> {

    SedesConPlateas(String direccion, int CAPACIDAD_MAXIMA, String[] listaDeSectores, 
                    int[] capacidadPorFila, int ASIENTOS_X_FILA, int[] porcentajesAdicionales) {

        super(direccion, CAPACIDAD_MAXIMA);

        sectores = armarSectores(listaDeSectores, capacidadPorFila, ASIENTOS_X_FILA);
        this.porcentajesAdicionales = armarListaDeAdicionales(listaDeSectores, porcentajesAdicionales);//key: nombre del sector, value: porcentaje
        setSectores(armarSectores(listaDeSectores, capacidadPorFila, ASIENTOS_X_FILA));
    }

    HashMap porcentajesAdicionales; 

    //Este método construye los sectores, mapeando los asientos en una matriz de booleanos, los cuales se inician en false.
    //false = libre y true = ocupado.
    /* 
     * ejemplo:
     * 
     * f f f f f f
     * t t t f t f
     * f f f f f f
     * t t f f f f
     * f f f t f f
    */  
    private HashMap armarSectores(String[] nombresDeSectores, int[] capacidadPorSector, int ASIENTOS_X_FILA){

        HashMap sectores = new HashMap<String, boolean[][]>();

        for (int j = 0; j < capacidadPorSector.length; j++) {
            
            boolean[][] filasYAsientos = new boolean[capacidadPorSector[j]/ASIENTOS_X_FILA][ASIENTOS_X_FILA];
            sectores.put(nombresDeSectores[j], filasYAsientos);

        }

        /*int CANTIDAD_DE_FILAS = getCapacidadMaxima()/asientosPorFila+1;
        for (int i = 0; i < capacidadPorSector.length; i++) {
            
            if(capacidadPorSector[i]%asientosPorFila != 0){
                
                boolean[][] filasYAsientos = new boolean[capacidadPorSector[i]/asientosPorFila][asientosPorFila];
                sectores.put(nombresDeSectores[i], filasYAsientos);
            } else {

                boolean[][] filasYAsientos = new boolean[capacidadPorSector[i]/asientosPorFila+1][];

                for (int j = 0; j < filasYAsientos.length-1; j++) {
                    
                    filasYAsientos[i] = new boolean[asientosPorFila];

                }

                if(capacidadPorSector[i]%asientosPorFila < asientosPorFila){
                    filasYAsientos[filasYAsientos.length-1] = new boolean[capacidadPorSector[i]%asientosPorFila];
                }

                sectores.put(nombresDeSectores[i], filasYAsientos); 

            }

        }*/

        return sectores;

    }

    private HashMap armarListaDeAdicionales(String[] listaDeSectores, int[] listaDePorcentajes){

        HashMap adicionales =  new HashMap<String, Double>();

        for (int i = 0; i < listaDePorcentajes.length; i++) {
            adicionales.put(listaDeSectores[i], listaDePorcentajes[i]);
        }

        return adicionales;
    }

    
}
