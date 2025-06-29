package MiTicketek;

import java.util.List;
import java.util.Objects;

public abstract class Sede{

	public Sede(String nombreSede, String direccion, int capacidadMaxima){
		
		if(nombreSede.trim().isEmpty()) {
			throw new RuntimeException("Error: el nombre está vacío.");
		}
		if(direccion.trim().isEmpty()) {
			throw new RuntimeException("Error: la dirección está vacía.");
		}
		if(capacidadMaxima <= 0) {
			throw new RuntimeException("Error: la capacidad máxima es negativa o cero.");
		}
		
		this.nombre = nombreSede;
		this.direccion = direccion;
		this.capacidadMaxima = capacidadMaxima;
		
	}
	
    private String nombre;
	private String direccion;
	private int capacidadMaxima;
	
	public abstract double calcularCostoFinal(String sector, double precioBase);

	public abstract String[] listarSectores();

	public String getUbicacionDeAsiento(){
		return "";
	}
	
	public String getUbicacionDeAsiento(String Sector, int asiento){
		return "";
	}

	public String getDireccion(){
		return direccion;
	}

	public String getNombre(){
		return nombre;
	}

	public int getCapacidadMaxima(){
		return capacidadMaxima;
	}

	public int getCapacidadMaxima(String sector){
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
		return capacidadMaxima == sede.capacidadMaxima && Objects.equals(direccion, sede.direccion);

	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, direccion, capacidadMaxima);
	}

}
