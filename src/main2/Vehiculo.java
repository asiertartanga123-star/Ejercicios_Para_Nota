package modelo;

public class Vehiculo {
	private int idVehiculo;
	private String marca;
	private String modelo;
	private double precioPorHora;

	public Vehiculo(int idVehiculo, String marca, String modelo, double precioPorHora) {
		super();
		this.idVehiculo = idVehiculo;
		this.marca = marca;
		this.modelo = modelo;
		this.precioPorHora = precioPorHora;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecioPorHora() {
		return precioPorHora;
	}

	public void setPrecioPorHora(double precioPorHora) {
		this.precioPorHora = precioPorHora;
	}

	public double calcularPrecioAlquiler(int horas) {
		return (horas * this.precioPorHora);

	}

	public String descripcion() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", marca=" + marca + ", modelo=" + modelo + ", precioPorHora="
				+ precioPorHora + "]";

	}

}
