
public abstract class Sede{

	public Sede(String direccion, int CAPACIDAD_MAXIMA){
		
		boolean direccionValida = direccion.trim().isEmpty();
		boolean capacidadValida = CAPACIDAD_MAXIMA > 0;
		boolean datosValidos = direccionValida && capacidadValida;
		
		if(datosValidos){

			this.capacidadMaxima = CAPACIDAD_MAXIMA;
			this.direccion = direccion;
		
		}
	}
	
	private int capacidadMaxima;
	private String direccion;
	
	public String getDireccion(){
		return direccion;
	}

	public int getCapacidadMaxima(){
		return capacidadMaxima;
	}

}
