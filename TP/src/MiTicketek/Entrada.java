package MiTicketek;
import java.util.Objects;

public class Entrada implements IEntrada{

    public Entrada(String emailUsuario, String nombreDeEspectaculo, String nombreSede, Fecha fechaDeFuncion, double costo) {

    	if(emailUsuario.trim().isEmpty()) {
    		throw new RuntimeException("Error: el email está vacío.");
    	}
    	if(nombreDeEspectaculo.trim().isEmpty()) {
    		throw new RuntimeException("Error: el nombre de espectaculo está vacío.");
    	}
    	if(nombreSede.trim().isEmpty()) {
    		throw new RuntimeException("Error: el nombre de sede está vacío.");
    	}
    	if(fechaDeFuncion == null) {
    		throw new RuntimeException("Error: la fecha de la función es nula.");
    	}
    	if(costo < 0) {
    		throw new RuntimeException("Error: el precio es negativo.");
    	}
    	
        this.email = emailUsuario;
        this.espectaculo = nombreDeEspectaculo;
        this.sede = nombreSede;

        this.sector = "CAMPO";
        this.ubicacion = sector;

        this.fecha = fechaDeFuncion;
        this.costoTotal = costo;

        CODIGO_DE_ENTRADA += 1;
        this.codigoEntrada = CODIGO_DE_ENTRADA + "";
    }

    public Entrada(String emailUsuario, String nombreDeEspectaculo, String nombreSede, String sector, String asiento, Fecha fechaDeFuncion, double precio){

    	if(emailUsuario.trim().isEmpty()) {
    		throw new RuntimeException("Error: el email está vacío.");
    	}
    	if(nombreDeEspectaculo.trim().isEmpty()) {
    		throw new RuntimeException("Error: el nombre de espectaculo está vacío.");
    	}
    	if(nombreSede.trim().isEmpty()) {
    		throw new RuntimeException("Error: el nombre de sede está vacío.");
    	}
    	if(sector.trim().isEmpty()) {
    		throw new RuntimeException("Error: el nombre del sector está vacío.");
    	}
    	if(fechaDeFuncion == null) {
    		throw new RuntimeException("Error: la fecha de la función es nula.");
    	}
    	if(precio < 0) {
    		throw new RuntimeException("Error: el precio es negativo.");
    	}
    	
        this.email = emailUsuario;
        this.espectaculo = nombreDeEspectaculo;
        this.sede = nombreSede;
        this.sector = sector;

        this.ubicacion = sector + " - " + asiento;

        this.fecha = fechaDeFuncion;
        this.costoTotal = precio;
        this.asiento = asiento;

        CODIGO_DE_ENTRADA += 1;
        this.codigoEntrada = CODIGO_DE_ENTRADA + "";
    }

    private String codigoEntrada;
    private String email;   //necesita el email como referencia del usuario que la compró, para poder identificarlo rápidamente. 
    private String espectaculo;
    private String sede;
    private String sector;
    private String asiento;
    private String ubicacion;
    private double costoTotal;
    private Fecha fecha;

    private static int CODIGO_DE_ENTRADA = 1000;    //lo inicializo en 1000 solo para que quede parecido a los ejemplos de IEntrada.

    public String getSector(){
        return sector;
    }

    public String getNumeroDeAsiento(){
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
        
        sb.append(codigoEntrada);
        sb.append(" - " + espectaculo);
        sb.append(" - " + fecha.toString());
        sb.append(" - " + sede);
        sb.append(" - " + ubicacion + " - ");

        if(Fecha.esAnteriorALaActual(fecha)){
            sb.append("P - ");
        } else {
            sb.append(" - ");
        }
        
        return sb.toString();
    }

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj){
			return true;
		}
		if(obj == null || getClass() != obj.getClass()){
			return false;
		}

		Entrada entrada = (Entrada) obj;
		return Objects.equals(codigoEntrada, entrada.codigoEntrada);

	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoEntrada, espectaculo);
	}

}
