import java.time.LocalDate;

public class Entrada implements IEntrada{

    public Entrada(String emailUsuario, String nombreDeEspectaculo,String ubicacion, 
                    String sector, LocalDate fechaDeFuncion, double precio) {

        this.email = emailUsuario;
        this.espectaculo = nombreDeEspectaculo;
        this.ubicacion = ubicacion;
        this.sector = sector;
        this.fecha = fechaDeFuncion;
        this.costoTotal = precio;

        CODIGO_DE_ENTRADA += 1;
        StringBuilder sb = new StringBuilder();
        sb.append(CODIGO_DE_ENTRADA);
        this.codigoEntrada = sb.toString();
    }

    private String email;   //necesita el email como referencia del usuario que la compró, para poder identificarlo rápidamente. 
    private String codigoEntrada;
    private String espectaculo;
    private String ubicacion;
    private String sector;
    private double costoTotal;
    private LocalDate fecha;

    private static int CODIGO_DE_ENTRADA;

    public int getCodigoDeEntrada() {
        return CODIGO_DE_ENTRADA;
    }

    public String getEmail(){
        return email;
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
