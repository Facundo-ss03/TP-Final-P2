
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Ticketek implements ITicketek{

	public Ticketek() {
		
		this.usuarios = new HashMap<String, Usuario>();
		this.espectaculos = new HashMap<String, Espectaculo>();
		this.sedes = new HashMap<String, Sede>();
		this.recaudacionDeEspectaculos = new HashMap<String, Double>();
	}

	private HashMap<String, Usuario> usuarios;
	private HashMap<String, Espectaculo> espectaculos;
	private HashMap<String, Sede> sedes;
	private HashMap<String, Double> recaudacionDeEspectaculos;

	@Override
	public void registrarSede(String nombre, String direccion, int capacidadMaxima) {
	
		try {
			
			if(sedes.containsKey(nombre)){	
				throw new RuntimeException("Error: la sede ya está registrada en el sistema.");
			} else {
				sedes.put(nombre, new Estadio(nombre, direccion, capacidadMaxima));
			}
		} catch(RuntimeException ex) {
			throw new RuntimeException(ex);
		}

	}

	@Override
	public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,
			String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
				
		if(!sedes.containsKey(nombre) && !nombre.trim().isEmpty()){

			sedes.put(nombre, new Teatro(nombre, direccion, capacidadMaxima, asientosPorFila, 
											sectores, capacidad, porcentajeAdicional));

		}

	}

	@Override
	public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,
			int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad,
			int[] porcentajeAdicional) {
				
		if(!sedes.containsKey(nombre) && !nombre.trim().isEmpty()){

			sedes.put(nombre, new MiniTeatro(nombre, direccion, capacidadMaxima, asientosPorFila, cantidadPuestos,
											precioConsumicion, sectores, capacidad, porcentajeAdicional));
			
		} else {
			throw new RuntimeException("Error: la sede ya existe.");
		}

	}

	@Override
	public void registrarUsuario(String email, String nombre, String apellido, String contrasenia) {
		
		try {

			if(emailValido(email) == false){
				throw new RuntimeException("Error: el email ingresado es inválido");
			}
			if(usuarios.containsKey(email) == true){
				throw new RuntimeException("Error: el usuario ya existe.");
			}
				
			usuarios.put(email, new Usuario(nombre, apellido, contrasenia));
			
		} catch (Exception ex) {
			throw new RuntimeException("Error al registrar el usuario.", ex);
		}
	}

	@Override
	public void registrarEspectaculo(String nombre) {

		try {
			if(espectaculos.containsKey(nombre)){
				throw new RuntimeException("Error: el espectaculo ya existe.");
			} else {
				espectaculos.put(nombre, new Espectaculo(nombre));
				recaudacionDeEspectaculos.put(nombre, 0.0);				
			}
			
			} catch (RuntimeException ex) {
				throw new RuntimeException("Error al registrar un espectaculo");
		}		
	}


	@Override
	public void agregarFuncion(String nombreEspectaculo, String fechaFuncion, String nombreSede, double precioBase) {

		try {
				
			if(!espectaculos.containsKey(nombreEspectaculo)){
				throw new RuntimeException("Error: el espectaculo no corresponde a un espectaculo registrado.");
			}
			if(nombreEspectaculo.trim().isEmpty()) {
				throw new RuntimeException("Error: el nombre del espectáculo es inválido.");	
			}
			if(!sedes.containsKey(nombreSede)){
				throw new RuntimeException("Error: la sede solicitada no corresponde a una sede registrada.");
			}
			if(nombreSede.trim().isEmpty()) {
				throw new RuntimeException("Error: la sede solicitada es inválida.");
			}

			Espectaculo espectaculo = espectaculos.get(nombreEspectaculo);
			Sede sede = sedes.get(nombreSede);
	
			espectaculo.agregarFuncion(fechaFuncion, sede, precioBase);
			
		} catch (RuntimeException ex) {
			throw new RuntimeException("Error al agregar una función.", ex);	
		}
		
	}

	@Override
	public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,
		int cantidadEntradas) {
			
		try {
			
			if(usuarioValido(email, contrasenia)){
				
				if(epectaculoValido(nombreEspectaculo)){
				
					Espectaculo espectaculo = espectaculos.get(nombreEspectaculo); // terminar
					List<IEntrada> entradas = new ArrayList<IEntrada>();
					Usuario comprador = usuarios.get(email);
		
					for (int i = 0; i < cantidadEntradas; i++) {
						
						Entrada nuevaEntrada = espectaculo.procesarVenta(email, nombreEspectaculo, fecha);
						
						agregarEntradaARecaudacion(nombreEspectaculo, nuevaEntrada.precio());
						
						entradas.add(nuevaEntrada);
						comprador.agregarEntrada(nuevaEntrada);
					}
				
					return entradas;

				} else {
					throw new RuntimeException("Error: el espectaculo solicitado no existe o se ingresó un nombre incorrecto.");
				}
			} else {
				throw new RuntimeException("Error: el usuario que solicita la entrada no está registrado o ingresó datos incorrectos.");
			}
		} catch (Exception ex) {
			throw new RuntimeException("Error en el procesamiento de la venta", ex);
		}
		
	}

	private boolean usuarioValido(String email, String contrasenia){

		boolean resultado;
		if(usuarios.containsKey(email)){
	
			Usuario usuario = usuarios.get(email);
	
			if(usuario.validarContraseña(contrasenia)){
				resultado = true;
			} else {
				resultado = false;
			}

		} else {
			resultado = false;
		}
		return resultado;
	}

	private boolean emailValido(String email){
		if(email.isEmpty() == false){

			return true;

		} else {
			return false;
		
		}
	}

	private boolean epectaculoValido(String nombreEspectaculo){
		if(nombreEspectaculo.trim().isEmpty() == false && espectaculos.containsKey(nombreEspectaculo)) return true;
			else return false;
	}

	@Override
	public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,
			String sector, int[] asientos) {
		
		try {
			
			if(usuarioValido(email, contrasenia)){
				
				if(epectaculoValido(nombreEspectaculo)){
				
					Espectaculo espectaculo = espectaculos.get(nombreEspectaculo); // terminar
					List<IEntrada> entradas = new ArrayList<IEntrada>();
					Usuario comprador = usuarios.get(email);

					for (int i = 0; i < asientos.length; i++) {
						
						Entrada nuevaEntrada = espectaculo.procesarVenta(email, nombreEspectaculo, fecha, sector, asientos[i]);
						
						agregarEntradaARecaudacion(nombreEspectaculo, nuevaEntrada.precio());

						entradas.add(nuevaEntrada);
						comprador.agregarEntrada(nuevaEntrada);
					}
				
					return entradas;

				} else {
					throw new RuntimeException("Error: el espectaculo solicitado no existe o se ingresó un nombre incorrecto.");
				}
			} else {
				throw new RuntimeException("Error: el usuario que solicita la entrada no está registrado o ingresó datos incorrectos.");
			}
		} catch (RuntimeException ex) {
			throw new RuntimeException("Error en el procesamiento de la venta de entradas.", ex);
		}
	}

	@Override
	public String listarFunciones(String nombreEspectaculo) {
		
		try {
	
			if(epectaculoValido(nombreEspectaculo)){
	
				String funciones = espectaculos.get(nombreEspectaculo).listarFunciones();
				return funciones;
			} else {
				throw new RuntimeException("Error al listar las funciones del espectaculo.");
			}

		} catch (Exception ex) {
			throw new RuntimeException("Error al listar las funciones del espectaculo", ex);
		}

	}

	@Override
	public List<IEntrada> listarEntradasEspectaculo(String nombreEspectaculo) {
		
		ArrayList<IEntrada> lista = new ArrayList<>();

		for (Usuario user : usuarios.values()) {
			
			lista.addAll(user.listarEntradasPorEspectaculo(nombreEspectaculo));

		}

		return lista;
	}

	@Override
	public List<IEntrada> listarEntradasFuturas(String email, String contrasenia) {
		try {
			
			if(usuarioValido(email, contrasenia)){
			
				Usuario usuario = usuarios.get(email);
				return usuario.listarEntradasFuturas();
	
			} else {
				throw new RuntimeException("Error: no se puede listar las entradas porque los datos no corresponden a un usuario registrado.");
			}

		} catch (Exception ex) {
			throw new RuntimeException("Error al listar entradas futuras", ex);
		}
	}

	@Override
	public List<IEntrada> listarTodasLasEntradasDelUsuario(String email, String contrasenia) {
		
		try {
			
			if(usuarioValido(email, contrasenia)){
			
				Usuario usuario = usuarios.get(email);
				return usuario.listarEntradas();
	
			} else {
				throw new RuntimeException("Error: no se puede listar las entradas porque los datos no corresponden a un usuario registrado.");
			}

		} catch (Exception ex) {
			throw new RuntimeException("Error al listar entradas", ex);
		}

	}

	@Override
	public boolean anularEntrada(IEntrada entrada, String contrasenia) {
		
		Entrada entradaAntigua = (Entrada) entrada;
		Usuario user = usuarios.get(entradaAntigua.getEmail());
			
		if(user.validarContraseña(contrasenia)){

			user.eliminarEntrada(entradaAntigua.getCodigoDeEntrada());

			Espectaculo espectaculo = espectaculos.get(entradaAntigua.getEspectaculo());
			espectaculo.eliminarEntrada(entradaAntigua);
				
			//descuento la entrada eliminada de la recaudación.
			descontarEntradaDeRecaudacion(entradaAntigua.getEspectaculo(), entradaAntigua.precio());
			
			return true;
		} else {
			throw new RuntimeException("Error: la contraseña o el email son inválidos.");
		}
	}

	private void descontarEntradaDeRecaudacion(String espectaculo, double precio){

		recaudacionDeEspectaculos.put(espectaculo, recaudacionDeEspectaculos.get(espectaculo) - precio); 

	}

	private void agregarEntradaARecaudacion(String espectaculo, double precio){

		recaudacionDeEspectaculos.put(espectaculo, recaudacionDeEspectaculos.get(espectaculo) + precio); 

	}

	@Override
	public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha, String sector, int asiento) {

		Entrada entradaAntigua = (Entrada) entrada;
		int[] nuevoAsiento = {asiento};

		try {
			
			if(usuarioValido(entradaAntigua.getEmail(), contrasenia)){
	
				usuarios.get(entradaAntigua.getEmail()).eliminarEntrada(entradaAntigua.getCodigoDeEntrada());	//le quito la entrada al usuario

				entrada = venderEntrada(entradaAntigua.getEspectaculo(), entradaAntigua.getFecha().toString(), 
						entradaAntigua.getEmail(), contrasenia, sector, nuevoAsiento).get(0);

				Espectaculo espectaculo = espectaculos.get(entradaAntigua.getEspectaculo());
				espectaculo.eliminarEntrada(entradaAntigua);

				//descuento el valor de la nueva entrada de la recaudación, porque no se
				//vendió una entrada nueva, solo se reemplazó
				descontarEntradaDeRecaudacion(entradaAntigua.getEspectaculo(), entradaAntigua.precio());

				return entrada;

			} else {
				throw new RuntimeException("Error: la contraseña ingresada es inválida.");
			}


		} catch (Exception ex) {
			throw new RuntimeException("Error al cambiar la entrada.", ex);
		}
	}

	@Override
	public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha) {		

		try {
			
			Entrada entradaAntigua = (Entrada) entrada;

			if(usuarioValido(entradaAntigua.getEmail(), contrasenia)){
				
				usuarios.get(entradaAntigua.getEmail()).eliminarEntrada(entradaAntigua.getCodigoDeEntrada());	//le quito la entrada al usuario
				entrada = venderEntrada(entradaAntigua.getEspectaculo(), fecha, entradaAntigua.getEmail(), contrasenia, 1).get(0);	//y le asigno una nueva
				Espectaculo espectaculo = espectaculos.get(entradaAntigua.getEspectaculo());
				espectaculo.eliminarEntrada(entradaAntigua);

				//descuento el valor de la nueva entrada de la recaudación, porque no se
				//vendió una entrada nueva, solo se reemplazó
				descontarEntradaDeRecaudacion(entradaAntigua.getEspectaculo(), entradaAntigua.precio());

				return entrada;

			} else {
				throw new RuntimeException("Error: la contraseña ingresada es inválida.");
			}
	

		} catch (Exception ex) {
			throw new RuntimeException("Error al cambiar la entrada.", ex);
		}

	}

	@Override
	public double costoEntrada(String nombreEspectaculo, String fecha) {
		
		try {
			
			if(epectaculoValido(nombreEspectaculo)){
	
				return espectaculos.get(nombreEspectaculo).obtenerCosto(fecha);
	
			} else {
				throw new RuntimeException("Error: el espectaculo solicitado es inválido.");
			}

		} catch (Exception ex) {
			throw new RuntimeException("Error al obtener el costo de la entrada", ex);
		}

	}

	@Override
	public double costoEntrada(String nombreEspectaculo, String fecha, String sector) {
		
		try {
			
			if(epectaculoValido(nombreEspectaculo)){
	
				return espectaculos.get(nombreEspectaculo).obtenerCosto(fecha, sector);
	
			} else {
				throw new RuntimeException("Error: el espectaculo solicitado es inválido.");
			}

		} catch (Exception ex) {
			throw new RuntimeException("Error al obtener el costo de la entrada", ex);
		}
	}

	@Override
	public double totalRecaudado(String nombreEspectaculo) {
		
		try {

			if(recaudacionDeEspectaculos.containsKey(nombreEspectaculo)){
	
				return recaudacionDeEspectaculos.get(nombreEspectaculo);
	
			} else {
				throw new RuntimeException("Error: el nombre ingresado no corresponde a ningún espectaculo registrado");
			}
			
		} catch (Exception ex) {
			throw new RuntimeException("Error al obtener la recaudación de un espectaculo.", ex);
		}
	}

	@Override
	public double totalRecaudadoPorSede(String nombreEspectaculo, String nombreSede) {
		
		try {

			if(espectaculos.containsKey(nombreEspectaculo)){
	
				return espectaculos.get(nombreEspectaculo).obtenerRecaudacionDeSede(nombreSede);

			} else {
				throw new RuntimeException("Error: el espectaculo solicitado no existe en el sistema.");
			}

		} catch (Exception ex) {
				throw new RuntimeException("Error al obtener la recaudación de una sede.", ex);
		}

	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder("Información del sistema:\n\n");
		
		sb.append("\n====================Usuarios====================\n");
		
		for (Map.Entry<String, Usuario> usuario : usuarios.entrySet()) {
			sb.append("Email: " + usuario.getKey());
			sb.append(usuario.getValue().toString());
			sb.append("\n");

		}
		
		sb.append("\n====================Sedes====================\n\n");
		
		for (Map.Entry<String, Sede> entry : sedes.entrySet()) {
			
			sb.append("Nombre: " + entry.getKey());
			sb.append(entry.getValue().toString());
			sb.append("\n");
		}

		sb.append("\n====================Espectaculos====================\n");
		for (Espectaculo elem : espectaculos.values()) {
			sb.append(elem.toString());
			sb.append("\n");
		}

		return sb.toString();

	}

}
