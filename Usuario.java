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

    public void agregarEntrada(Entrada nuevaEntrada){

        entradas.put(nuevaEntrada.getCodigoDeEntrada(), nuevaEntrada);

    }

    public boolean validarContraseña(String contraseña){
        
        if(contraseña.trim().isEmpty()){
            throw new RuntimeException("Error: la contraseña ingresada es inválida.");
        }
        if(this.contraseña.equals(contraseña)) return true;
            else return false;
        
    }

    public List<Entrada> listarEntradasPorEspectaculo(String espectaculo){

        ArrayList<Entrada> lista = new ArrayList<Entrada>();

        for (Entrada elem : entradas.values()) {
        
            if(elem.getEspectaculo().equals(espectaculo)){
            
                lista.add(elem);
           
            }

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

    public void eliminarEntrada(String codigo){

        if(entradas.containsKey(codigo)){

            entradas.remove(codigo);

        }

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("\n" + "Nombre: " + nombre + " ");
        sb.append("\n" + "Apellido: " + apellido);
        sb.append("\n" + "Contraseña: " + contraseña);
        
        sb.append("\nEntradas: \n");
        
        for (Entrada elem : entradas.values()) {

            sb.append(elem.toString() + "\n");

        }

        return sb.toString();
        
    }
}
