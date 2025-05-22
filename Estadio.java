
public class Estadio extends Sede{

    Estadio(String direccion, int capMaxima) {
        
        super(direccion, capMaxima);

        sector = "CAMPO";

    }

    String sector;

}
