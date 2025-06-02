
public abstract class Sede{

	public Sede(String nombreSede, String direccion, int CAPACIDAD_MAXIMA){
		
		boolean direccionValida = direccion.trim().isEmpty();
		boolean capacidadValida = CAPACIDAD_MAXIMA > 0;
		boolean datosValidos = !direccionValida && capacidadValida;
		
		if(datosValidos){

			this.nombre = nombreSede;
			this.direccion = direccion;
			this.capacidadMaxima = CAPACIDAD_MAXIMA;
		
		}
	}
	
    private String nombre;
	private String direccion;
	private int capacidadMaxima;
	
	public String getNombre(){
		return nombre;
	}

	public String getDireccion(){
		return direccion;
	}

	public int getCapacidadMaxima(){
		return capacidadMaxima;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Dirección: " + direccion + "\n");
		sb.append("Capacidad máxima: " + capacidadMaxima + "\n");

		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj){
			return true;
		}
		if(obj == null || getClass() != obj.getClass()){
			return false;
		}

		Sede sede = (Sede) obj;
		return direccion.equals(sede.direccion);

	}

	@Override
	public int hashCode() {
		return direccion.hashCode();
	}

}
