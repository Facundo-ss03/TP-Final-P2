import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Usuario {

    public Usuario(String nombre, String apellido, String contraseña){

        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.entradas = new HashMap<String, Entrada>();
    }

    private String nombre;
    private String apellido;
    private String contraseña;
    private HashMap<String, Entrada> entradas;

    public boolean validarContraseña(String contraseña){
        
        if(contraseña.trim().isEmpty()){
            throw new RuntimeException("Error: la contraseña ingresada es inválida.");
        }
        
        if(contraseña.equals(this.contraseña)) return true;
        else return false;
        
    }

    public List<IEntrada> listarEntradasPorEspectaculo(String espectaculo){

        ArrayList<IEntrada> lista = new ArrayList<IEntrada>();

        for (Entrada elem : entradas.values()) {
            
            if(elem.getEspectaculo().equals(espectaculo)) lista.add(elem);
        }

        return lista;
                
    }

    public List<IEntrada> listarEntradasFuturas(){

        ArrayList<IEntrada> lista = new ArrayList<IEntrada>();

        for (Entrada elem : entradas.values()) {
            
            if(Fecha.esPosteriorALaActual(elem.getFecha())) lista.add(elem);
            
        }

        return lista;
                
    }
    
    public List<IEntrada> listarEntradas(){

        ArrayList<IEntrada> lista = new ArrayList<IEntrada>();

        for (Entrada elem : entradas.values()) {
            
            lista.add(elem);

        }

        return lista;
        

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Nombre: " + nombre + " ");
        sb.append("Apellido: " + apellido);
        sb.append("Contraseña: " + contraseña);
        
        sb.append("Entradas: \n");
        
        for (IEntrada elem : entradas.values()) {

            sb.append(elem.toString() + "\n");

        }

        return sb.toString();
        
    }
}
