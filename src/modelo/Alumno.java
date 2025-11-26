package modelo;

public class Alumno {
	private String nif;
	public static String nombre;
	public static String fechaNacimiento;
	public static String ciclo;
	public static boolean repetidor;
	
	public Alumno(String nif, String nombre, String fechaNacimiento, String ciclo, boolean repetidor) {
		this.nif = nif;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.ciclo = ciclo;
		this.repetidor = repetidor;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public boolean isRepetidor() {
		return repetidor;
	}

	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}
	public enum ciclo {
		DAM,DAW
	}
	@Override
	public String toString() {
		return "Alumno [nif=" + nif + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", ciclo=" + ciclo
				+ ", repetidor=" + repetidor + "]";
	}
	
}
