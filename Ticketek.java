
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
			
		} else {
			throw new RuntimeException("Error: la sede ya existe.");
		}

	}

	@Override
	public void registrarUsuario(String email, String nombre, String apellido, String contrasenia) {
		
		if(email.trim().isEmpty()){
			throw new RuntimeException("Error: el email ingresado es inválido");
		}
		if(usuarios.containsKey(email)){
			throw new RuntimeException("Error: el usuario ya existe.");
		} 
		else {

			try {
				
				usuarios.put(email, new Usuario(nombre, apellido, contrasenia));
			
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
	}

	@Override
	public void registrarEspectaculo(String nombre) {
		
		if(espectaculos.containsKey(nombre)){

			throw new RuntimeException("Error: el espectaculo ya existe.");

		} else {

			try {
				
				espectaculos.put(nombre, new Espectaculo());
			
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}


		}
		
	}

	@Override
	public void agregarFuncion(String nombreEspectaculo, String fechaFuncion, String nombreSede, double precioBase) {
		
		if(!espectaculos.containsKey(nombreEspectaculo) || nombreEspectaculo.trim().isEmpty()){
			throw new RuntimeException("Error: el espectaculo solicitado es inválido o no corresponde a un espectaculo registrado.");
		}
		if(!sedes.containsKey(nombreSede) || nombreSede.trim().isEmpty()){
			throw new RuntimeException("Error: la sede solicitada es inválida o no corresponde a una sede registrada.");
		}

		try {
			
			Fecha fecha = new Fecha(fechaFuncion);
	
			if(fecha.esAnteriorALaActual()){
				throw new RuntimeException("Error: la fecha ingresada es incorrecta.");
			}
			//falta validar la fecha.
			else {
				
				Espectaculo espectaculo = espectaculos.get(nombreEspectaculo);
				Sede sede = sedes.get(nombreSede);
	
				espectaculo.agregarFuncion(fechaFuncion, sede, precioBase);
			
			}

		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());	
		}
		
	}

	@Override
	public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,
		int cantidadEntradas) {
			
			
		try {
			
			if(espectaculos.containsKey(nombreEspectaculo) && usuarios.containsKey(email)){
	
				if(usuarios.get(email).validarContraseña(contrasenia)){
					
					Espectaculo espectaculo = espectaculos.get(nombreEspectaculo); // terminar
					List<IEntrada> entradas = new ArrayList<IEntrada>();
		
					for (int i = 0; i < cantidadEntradas; i++) {
						
						entradas.add(espectaculo.procesarVenta(nombreEspectaculo, LocalDate.parse(fecha), email));
						
					}
				
					return entradas;
				} else {
					throw new RuntimeException("Error");
				}
	
			} else {
				throw new RuntimeException("Error");
			}

		} catch (Exception ex) {
			throw new RuntimeException("Error: ");
		}
		
	}

	private boolean usuarioValido(String email, String contrasenia){

		if(usuarios.containsKey(email)){
			Usuario usuario = usuarios.get(email);
			return usuario.validarContraseña(contrasenia);
		} else {
			throw new RuntimeException("No se pudo validar el usuario porque el email o la contraseña son incorrectos.");
		}
	}

	@Override
	public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,
			String sector, int[] asientos) {
		
		

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
