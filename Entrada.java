import java.time.LocalDate;

public class Entrada implements IEntrada{

    public Entrada(String emailUsuario, String nombreDeEspectaculo, String nombreSede, String ubicacion, 
                    String sector, Fecha fechaDeFuncion, double precio) {

        this.email = emailUsuario;
        this.espectaculo = nombreDeEspectaculo;
        this.sede = nombreSede;
        this.ubicacion = ubicacion;
        this.sector = sector;
        this.fecha = fechaDeFuncion;
        this.costoTotal = precio;

        CODIGO_DE_ENTRADA += 1;
        StringBuilder sb = new StringBuilder();
        sb.append(CODIGO_DE_ENTRADA);
        this.codigoEntrada = sb.toString();
    }

    private String codigoEntrada;
    private String email;   //necesita el email como referencia del usuario que la compró, para poder identificarlo rápidamente. 
    private String espectaculo;
    private String sede;
    private String ubicacion;
    private String sector;
    private double costoTotal;
    private Fecha fecha;

    private static int CODIGO_DE_ENTRADA;

    public String getSector(){
        return sector;
    }

    public String getSede(){
        return sede;
    }

    public String getEspectaculo(){
        return espectaculo;
    }

    public int getCodigoDeEntrada() {
        return CODIGO_DE_ENTRADA;
    }

    public String getEmail(){
        return email;
    }

    public Fecha getFecha(){
        return fecha;
    }

    @Override
    public double precio() {
        return costoTotal;
    }

    @Override
    public String ubicacion() {
        return ubicacion;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(
                "Código: " + CODIGO_DE_ENTRADA + 
                " Espectaculo: " + espectaculo + 
                " Ubicación: " + ubicacion + 
                " Precio Final: " + costoTotal +  
                " Ubicación: " + ubicacion + 
                " Fecha" + fecha.toString()
                );

        return sb.toString();
    }

}
