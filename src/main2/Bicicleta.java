package modelo;

public class Bicicleta extends Vehiculo {
	
	private String tipoFreno;

	public Bicicleta(int idVehiculo, String marca, String modelo, double precioPorHora,String tipoFreno) {
		super(idVehiculo, marca, modelo, precioPorHora);
		this.tipoFreno = tipoFreno;
	}

	public String getTipoFreno() {
		return tipoFreno;
	}

	public void setTipoFreno(String tipoFreno) {
		this.tipoFreno = tipoFreno;
	}
	
	public String descripcion() {
		return super.descripcion() + ", TipoFreno: " + tipoFreno;
	}
	
	

}
