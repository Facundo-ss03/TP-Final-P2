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
    private List<IEntrada> entradas;

    public boolean autenticar(String unaContrasenia){
        return this.contraseña.equals(unaContrasenia);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Nombre: " + nombre + " ");
        sb.append("Apellido: " + apellido);
        sb.append("Contraseña: " + contraseña);
        
        sb.append("Entradas: \n");
        
        for (IEntrada elem : entradas) {

            sb.append(elem.toString() + "\n");

        }

        return sb.toString();
        
    }
}
