
package MiTicketek;

public class Estadio extends Sede{

    Estadio(String nombreSede, String direccion, int capMaxima) {
        
        super(nombreSede, direccion, capMaxima);

        this.sector = "CAMPO";

    }

    String sector;

    public String getSector(){
        return sector;
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("\n"+ super.toString());
        sb.append("Sector: " + sector + "\n");
        
        return sb.toString();
    }
}
