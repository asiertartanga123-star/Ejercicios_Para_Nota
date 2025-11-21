package modelo;

public class Patinete extends Vehiculo{
	
	private int autonomia;

	public Patinete(int idVehiculo, String marca, String modelo, double precioPorHora, int autonomia) {
		super(idVehiculo, marca, modelo, precioPorHora);
		autonomia = autonomia;
	}

	public int getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(int autonomia) {
		autonomia = autonomia;
	}
	
	public String descripcion() {
		return super.descripcion() + ", Autonomia: " + autonomia;
	}

}
