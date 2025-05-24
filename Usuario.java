import java.util.HashMap;
import java.util.List;

public class Usuario {

    public Usuario(String nombre, String apellido, String contraseña){

        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.entradas = new HashMap<String, IEntrada>();
    }

    private String nombre;
    private String apellido;
    private String contraseña;
    private HashMap<String, IEntrada> entradas;

    public boolean validarContraseña(String contraseña){

        if(contraseña.equals(this.contraseña)) return true;
        else return false;

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
