package principal;
import java.util.ArrayList;
import modelo.Alumno;
public class Ejercicio1 {

	public static void main(String[] args) {
	int opcion;
	ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
	do {
	menu();
	System.out.println("Seleccione una opción:");
	opcion = Util.leerInt();
	switch (opcion) {
	case 1:
		añadirAlumno(listaAlumnos);
		break;
	case 2:
		listar(listaAlumnos);
		break;
	case 3:
		buscar(listaAlumnos);
		break;
	case 4:
		modificar(listaAlumnos);
		break;
	case 5:
		
		break;
	case 6:
	System.out.println("Saliendo del programa...");
		break;
	}
	}while (opcion != 6);
	}

	

	private static void menu() {
		System.out.println("Menú de opciones:");
		System.out.println("1. Añadir alumno");
		System.out.println("2. Mostrar alumnos");
		System.out.println("3. Mostrar alumno por NIF");
		System.out.println("4. Modificar alumno");
		System.out.println("5. Eliminar alumno");
		System.out.println("6. Salir");
	}
	 public static int contar(String nif, ArrayList<Alumno> listaAlumnos) {
	        int c = 0;
	        for (Alumno a : listaAlumnos)
	            if (a.getNif().equals(nif)) c++;
	        return c;
	    }
	 public static String cicloQueFalta(String nif, ArrayList<Alumno> listaAlumnos) {
	        for (Alumno a : listaAlumnos)
	            if (a.getNif().equals(nif))
	                return a.getCiclo().equals("DAM") ? "DAW" : "DAM";
	        return "";
	    }
	 private static void añadirAlumno(ArrayList<Alumno> listaAlumnos) {
			
		 System.out.println("Introduce el NIF del alumno:");
	     System.out.print("NIF: ");
	     String nif = Util.introducirCadena();

	     int veces = contar(nif, listaAlumnos);

	     if (veces == 2) {
	         System.out.println("Ya está en los dos ciclos.");
	         return;
	     }

	     String ciclo;

	     if (veces == 0) {
	         System.out.print("Ciclo (DAM/DAW): ");
	         ciclo =Util.introducirCadena().toUpperCase();
	     } else {
	         ciclo = cicloQueFalta(nif,listaAlumnos);
	         System.out.println("Solo puede matricularse en: " + ciclo);
	     }

	     System.out.print("Nombre: ");
	     String nombre = Util.introducirCadena();

	     System.out.print("fechaNacimiento: ");
	     String fechaNacimiento = Util.introducirCadena();

	     System.out.print("¿Repetidor? (s/n): ");
	     boolean rep = Util.introducirCadena().equalsIgnoreCase("s");

	     listaAlumnos.add(new Alumno(nif, nombre, fechaNacimiento, ciclo, rep));
	     System.out.println("Alumno añadido.");
	 }
	 public static void listar(ArrayList<Alumno> listaAlumnos) {
	        if (listaAlumnos.isEmpty()) {
	            System.out.println("No hay alumnos.");
	            return;
	        }
	        for (Alumno a : listaAlumnos)
	            System.out.println(a);
	    }
	   public static void buscar(ArrayList<Alumno> listaAlumnos) {
	        if (listaAlumnos.isEmpty()) {
	            System.out.println("No hay alumnos.");
	            return;
	        }

	        System.out.print("NIF: ");
	        String nif = Util.introducirCadena();

	        boolean encontrado = false;

	        for (Alumno a : listaAlumnos) {
	            if (a.getNif().equals(nif)) {
	                System.out.println(a);
	                encontrado = true;
	            }
	        }

	        if (!encontrado)
	            System.out.println("No existe.");
	    }
	   public static void modificar(ArrayList<Alumno> listaAlumnos) {
	        if (listaAlumnos.isEmpty()) {
	            System.out.println("No hay alumnos.");
	            return;
	        }
	        System.out.print("NIF: ");
	        String nif = Util.introducirCadena();

	        boolean ok = false;

	        for (Alumno a : listaAlumnos) {
	            if (a.getNif().equals(nif)) {
	                ok = true;

	                System.out.print("Nuevo nombre: ");
	                a.nombre = Util.introducirCadena();

	                System.out.print("Nueva Fecha de Nacimiento: ");
	                a.fechaNacimiento = Util.introducirCadena();

	                System.out.print("¿Repetidor? (s/n): ");
	                a.repetidor = Util.introducirCadena().equalsIgnoreCase("s");

	                System.out.println("Modificado.");
	            }
	        }

	        if (!ok)
	            System.out.println("No existe.");
	    }
	}