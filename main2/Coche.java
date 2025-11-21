package modelo;

public class Coche extends Vehiculo {

	private int numPuertas;
	private boolean esElectrico;

	public Coche(int idVehiculo, String marca, String modelo, double precioPorHora, int numPuertas,
			boolean esElectrico) {
		super(idVehiculo, marca, modelo, precioPorHora);
		this.numPuertas = numPuertas;
		this.esElectrico = esElectrico;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public boolean isEsElectrico() {
		return esElectrico;
	}

	public void setEsElectrico(boolean esElectrico) {
		this.esElectrico = esElectrico;
	}
	
	public double calcularPrecioAlquiler(int horas) {
		if(esElectrico == true) {
			return super.calcularPrecioAlquiler(horas)*0.9;
		}else {
			return super.calcularPrecioAlquiler(horas);
		}
		
	}

}
