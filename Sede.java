
public abstract class Sede{

	public Sede(String direccion, int CAPACIDAD_MAXIMA){
		
		boolean direccionValida = direccion.trim().isEmpty();
		boolean capacidadValida = CAPACIDAD_MAXIMA > 0;
		boolean datosValidos = !direccionValida && capacidadValida;
		
		if(datosValidos){

			this.direccion = direccion;
			this.capacidadMaxima = CAPACIDAD_MAXIMA;
		
		}
	}
	
	private String direccion;
	private int capacidadMaxima;
	
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

}
