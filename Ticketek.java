
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Ticketek implements ITicketek{

	public Ticketek() {
		
		this.usuarios = new HashMap<String, Usuario>();
		this.espectaculos = new HashMap<String, Espectaculo>();
		this.sedes = new HashMap<String, Sede>();

	}

	private HashMap<String, Usuario> usuarios;
	private HashMap<String, Espectaculo> espectaculos;
	private HashMap<String, Sede> sedes;
	
	@Override
	public void registrarSede(String nombre, String direccion, int capacidadMaxima) {

		if(!sedes.containsKey(nombre) && !nombre.trim().isEmpty()){

			sedes.put(nombre, new Estadio(direccion, capacidadMaxima));
			
		}
		
	}

	@Override
	public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,
			String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
				
		if(!sedes.containsKey(nombre) && !nombre.trim().isEmpty()){

			sedes.put(nombre, new Teatro(direccion, capacidadMaxima, asientosPorFila, 
											sectores, capacidad, porcentajeAdicional));
			
		}

	}

	@Override
	public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,
			int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad,
			int[] porcentajeAdicional) {
				
		if(!sedes.containsKey(nombre) && !nombre.trim().isEmpty()){

			sedes.put(nombre, new MiniTeatro(direccion, capacidadMaxima, asientosPorFila, cantidadPuestos,
											precioConsumicion, sectores, capacidad, porcentajeAdicional));
			
		}

	}

	@Override
	public void registrarUsuario(String email, String nombre, String apellido, String contrasenia) {
		
		if(!usuarios.containsKey(email)){

			usuarios.put(email, new Usuario(nombre, apellido, contrasenia));

		}
		
	}

	@Override
	public void registrarEspectaculo(String nombre) {
		
		if(!espectaculos.containsKey(nombre)){

			espectaculos.put(nombre, new Espectaculo());

		}
		
	}

	@Override
	public void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {
		
		Espectaculo espectaculo = espectaculos.get(nombreEspectaculo);
		
		espectaculo.agregarFuncion(fecha, sede, precioBase);
		
	}

	@Override
	public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,
			int cantidadEntradas) {
				
			

		return null;
	}

	@Override
	public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,
			String sector, int[] asientos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listarFunciones(String nombreEspectaculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IEntrada> listarEntradasEspectaculo(String nombreEspectaculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IEntrada> listarEntradasFuturas(String email, String contrasenia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IEntrada> listarTodasLasEntradasDelUsuario(String email, String contrasenia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean anularEntrada(IEntrada entrada, String contrasenia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha, String sector, int asiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double costoEntrada(String nombreEspectaculo, String fecha) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double costoEntrada(String nombreEspectaculo, String fecha, String sector) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double totalRecaudado(String nombreEspectaculo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double totalRecaudadoPorSede(String nombreEspectaculo, String nombreSede) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
