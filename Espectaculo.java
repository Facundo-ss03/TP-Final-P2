
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Espectaculo {

    public Espectaculo(String nombreEspectaculo){

        if(nombreEspectaculo.trim().isEmpty()){
            throw new RuntimeException("Error: el nombre ingresado está vacío.");
        }

        this.nombre = nombreEspectaculo;


        this.funciones = new HashMap<String, Funcion>();
        this.recaudacionesDeSedes = new HashMap<String, Double>();
    }

    private String nombre;
    private HashMap<String, Funcion> funciones;
    private HashMap<String, Double> recaudacionesDeSedes;

	private void agregarEntradaARecaudacion(String sede, double precio){

		recaudacionesDeSedes.put(sede, recaudacionesDeSedes.get(sede) + precio); 


	}

	private void descontarEntradaDeRecaudacion(String sede, double precio){

		recaudacionesDeSedes.put(sede, recaudacionesDeSedes.get(sede) - precio); 

	}
    //Procesa la venta de una entrada para una sede de tipo estadio.
    public Entrada procesarVenta(String email, String nombreEspectaculo, String fecha){

        if(funciones.containsKey(fecha)){

            Funcion funcion = funciones.get(fecha);
            Entrada nuevaEntrada = funcion.crearEntrada(email, nombreEspectaculo, fecha);

			agregarEntradaARecaudacion(funcion.getNombreSede(), nuevaEntrada.precio());
            
            return nuevaEntrada;

        } else {
            throw new RuntimeException("Error: la fecha ingresada no corresponde a ninguna función registrada.");
        }
    }

    //Procesa la venta de una entrada para una sede de tipo Teatro o Miniteatro.
    public Entrada procesarVenta(String email, String nombreEspectaculo, String fecha, String sector, int asiento){

        if(funciones.containsKey(fecha)){

            Funcion funcion = funciones.get(fecha);
            Entrada nuevaEntrada = funcion.crearEntrada(email, nombreEspectaculo, fecha, sector, asiento);
            
			agregarEntradaARecaudacion(funcion.getNombreSede(), nuevaEntrada.precio());
            
            return nuevaEntrada;

        } else {
            throw new RuntimeException("Error: la fecha ingresada no corresponde a ninguna función registrada.");
        }
    }

    public void eliminarEntrada(Entrada entrada){

        Funcion funcion = funciones.get(entrada.getFecha().toString());

		descontarEntradaDeRecaudacion(funcion.getNombreSede(), entrada.precio());

        if(entrada.getSector() == "CAMPO"){
            funcion.quitarEntrada();        
        } else {
            funcion.quitarEntrada(entrada.getSector(), entrada.getNumeroDeAsiento());
        }

    }

    public String listarFunciones(){

        if(funciones.size() == 0){
            throw new RuntimeException("Error: el espectaculo no tiene ninguna función registrada.");
        }

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Funcion> funcion : funciones.entrySet()) {
            
            sb.append(" - ");
            sb.append("(" + funcion.getKey() + ") ");
            sb.append(funcion.getValue().toString());
            sb.append("\n");


        }

        return sb.toString();

    }

    public void agregarFuncion(String fecha, Sede sede, double precioBase){

        if(funciones.containsKey(fecha)){
        	throw new RuntimeException("Error: la fecha ya está ocupada por otra función.");
        } else {
        	
        	funciones.put(fecha, new Funcion(sede, precioBase));
            
            if(!recaudacionesDeSedes.containsKey(sede.getNombre())){

                recaudacionesDeSedes.put(sede.getNombre(), 0.0);

            }
        }
     
    }

    public double obtenerCosto(String fecha){

        try {
            
            if(funciones.containsKey(fecha)){
    
                return funciones.get(fecha).calcularCostoFinal();
    
            } else {
                throw new RuntimeException("Error: la fecha ingresada no corresponde a ninguna función registrada.");
            }
            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public double obtenerCosto(String fecha, String sector){
        
        try {
            
            if(funciones.containsKey(fecha)){
    
                return funciones.get(fecha).calcularCostoFinal(sector);
    
            } else {
                throw new RuntimeException("Error: la fecha ingresada no corresponde a ninguna función registrada.");
            }
            
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public double obtenerRecaudacionDeSede(String nombreSede){

        if(recaudacionesDeSedes.containsKey(nombreSede)){

            return recaudacionesDeSedes.get(nombreSede);

        } else {
            throw new RuntimeException("Error: el nombre ingresado no corresponde a ninguna sede del espectaculo solicitado.");
        }

    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("\nnombre: " + nombre);
        
        sb.append("\n" + "Cantidad de funciones: " + funciones.size());

        return sb.toString();

    }

}
