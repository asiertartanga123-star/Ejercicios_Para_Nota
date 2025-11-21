package principal;
import modelo.*;
public class Principal {

	public static void main(String[] args) {
		Vehiculo bicicleta = new Bicicleta(1235, "Decathlon", "MontanBike", 1999.99,"V-Brake" );
		Vehiculo coche = new Coche(1659,"Ferrari", "Gt", 499.99, 2, false);
		Vehiculo patinete = new Patinete(2849, "Xiaomi", "9T", 20.99, 25);
		
		System.out.println(bicicleta.descripcion());
		System.out.println(coche.descripcion());
		System.out.println(patinete.descripcion());

	}

}
