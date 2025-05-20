
public abstract class Sede<T> {

	public Sede(String direccion, int CAPACIDAD_MAXIMA){
		
		boolean datosValidos = !direccion.trim().isEmpty() || CAPACIDAD_MAXIMA > 0;
		
		if(datosValidos){

			this.capacidadMaxima = CAPACIDAD_MAXIMA;
			this.direccion = direccion;
		
		}
	}

	public Sede(String direccion, int CAPACIDAD_MAXIMA, String sector) {

		this.direccion = direccion;
		this.capacidadMaxima = CAPACIDAD_MAXIMA;

	}
	
	private int capacidadMaxima;
	private String direccion;
	protected T sectores;
	
	public String getDireccion(){
		return direccion;
	}

	public int getCapacidadMaxima(){
		return capacidadMaxima;
	}

	protected void setSectores(T sectores) {
		this.sectores = sectores;
	}

	protected T getSectores(){
		return sectores;
	}

}
