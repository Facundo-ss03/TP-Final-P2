import java.util.List;

public class Usuario {

    public Usuario(String nombre, String apellido, String contraseña){

        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;

    }

    private String nombre;
    private String apellido;
    private String contraseña;
    private List<String> entradas;

    @Override
    public String toString() {

        return nombre + " - " + apellido;
        
    }
}
