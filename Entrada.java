import java.util.Date;

public class Entrada implements IEntrada{

    public Entrada(String codigoDeEspectaculo, String nombreDeEspectaculo, String ubicacion, Date fecha){

    }

    private String codigoEspectaculo;
    private String nombreEspectaculo;
    private String ubicacion;
    private double precio;
    private int fila;
    private int asiento;
    private Date fecha;

    @Override
    public double precio() {
        return precio;
    }

    @Override
    public String ubicacion() {
        return ubicacion;
    }

    @Override
    public String toString() {

        StringBuilder informacion = new StringBuilder("Código: " + codigoEspectaculo + 
                                            "Espectaculo: " + nombreEspectaculo + 
                                            "Ubicación: " + ubicacion + 
                                            "Precio Final: " + precio +  
                                            "Asiento: " + "f:" + fila + "a:" + asiento + 
                                            "Fecha" + fecha);
        return informacion.toString();
    }

}
