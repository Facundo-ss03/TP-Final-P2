
public class Entrada implements IEntrada{

    public Entrada(String emailUsuario, String nombreDeEspectaculo, String nombreSede, Fecha fechaDeFuncion, double precio) {

        this.email = emailUsuario;
        this.espectaculo = nombreDeEspectaculo;
        this.sede = nombreSede;

        this.sector = "CAMPO";
        this.ubicacion = sector;

        this.fecha = fechaDeFuncion;
        this.costoTotal = precio;

        CODIGO_DE_ENTRADA += 1;
        this.codigoEntrada = CODIGO_DE_ENTRADA + "";
    }

    public Entrada(String emailUsuario, String nombreDeEspectaculo, String nombreSede, String sector, int numeroDeAsiento, int numeroDeFila, Fecha fechaDeFuncion, double precio){
        
        this.email = emailUsuario;
        this.espectaculo = nombreDeEspectaculo;
        this.sede = nombreSede;
        this.asiento = numeroDeAsiento;
        this.fila = numeroDeFila;

        this.ubicacion = "f: " + numeroDeFila + " a: " + numeroDeAsiento;

        this.fecha = fechaDeFuncion;
        this.costoTotal = precio;

        CODIGO_DE_ENTRADA += 1;
        this.codigoEntrada = CODIGO_DE_ENTRADA + "";
    }

    private String codigoEntrada;
    private String email;   //necesita el email como referencia del usuario que la compró, para poder identificarlo rápidamente. 
    private String espectaculo;
    private String sede;
    private String sector;
    private int asiento;
    private int fila;
    private String ubicacion;
    private double costoTotal;
    private Fecha fecha;

    private static int CODIGO_DE_ENTRADA = 1000;

    public String getSector(){
        return sector;
    }

    public int getNumeroDeAsiento(){
        return asiento;
    }

    public String getSede(){
        return sede;
    }

    public String getEspectaculo(){
        return espectaculo;
    }

    public String getCodigoDeEntrada() {
        return codigoEntrada;
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
                "Código: " + codigoEntrada + 
                " Espectaculo: " + espectaculo + 
                " Ubicación: " + ubicacion + 
                " Precio Final: " + costoTotal +  
                " Ubicación: " + ubicacion + 
                " Fecha: " + fecha.toString()
                );

        return sb.toString();
    }

}
