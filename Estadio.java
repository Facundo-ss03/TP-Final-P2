
public class Estadio extends Sede{

    Estadio(String direccion, int capMaxima) {
        
        super(direccion, capMaxima);

        this.sector = "CAMPO";

    }

    String sector;

    public String getSector(){
        return sector;
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Sector: " + sector + "\n");
        
        return sb.toString();
    }
}
