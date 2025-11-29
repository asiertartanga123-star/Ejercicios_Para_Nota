package principal;
import java.util.ArrayList;
import java.util.List;

import modelo.Bibliotecario;
import modelo.Socio;
public class BibliotecaApp {
    public static void main(String[] args) {
        int opcion;
        ArrayList<Socio> lista = new ArrayList<>();
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = Util.leerInt();

            switch (opcion) {
                case 0:
                    introducirSocio(lista);
                    break;
                case 1:
                    visualizarTodosSocios(lista);
                    break;
                case 2:
                    visualizarBibliotecarios(lista);
                    break;
                case 3:
                    visualizarBibliotecariosPorSeccion(lista);
                    break;
                case 4:
                    buscarPorNombre(lista);
                    break;
                case 5:
                    buscarPorCuota(lista);
                    break;
                case 6:
                    buscarBibliotecariosPorAños(lista);
                    break;
                case 7:
                    darDeBaja(lista);
                    break;
                case 8:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 8);
        
    }

    private static void mostrarMenu() {
        System.out.println("\n===== " + "LECTURA VIVA" + " =====");
        System.out.println("0. Introducir datos de socio/bibliotecario");
        System.out.println("1. Visualizar todos los socios");
        System.out.println("2. Visualizar solo bibliotecarios");
        System.out.println("3. Visualizar bibliotecarios de una sección");
        System.out.println("4. Buscar socio por nombre");
        System.out.println("5. Buscar socios por cuota mínima");
        System.out.println("6. Buscar bibliotecarios por años de antigüedad");
        System.out.println("7. Dar de baja un socio");
        System.out.println("8. Salir");
        System.out.println("=====================================");
    }

    private static void introducirSocio(ArrayList<Socio> lista) {
        System.out.print("Introduzca DNI: ");
        String dni = Util.introducirCadena();

        if (existeSocio(dni, lista)) {
            System.out.println("ERROR: La persona con DNI " + dni + " ya existe en el sistema.");
            return;
        }

        System.out.print("Nombre completo: ");
        String nombre = Util.introducirCadena();

        System.out.print("Mes de alta (1-12): ");
        int mes = Util.leerInt();
        System.out.print("Año de alta: ");
        int año = Util.leerInt();
        System.out.print("Número de libros que puede solicitar: ");
        int libros = Util.leerInt();
       

        System.out.print("¿Es bibliotecario? (s/n): ");
        String esBibliotecario =Util.introducirCadena().toLowerCase();

        if (esBibliotecario.equals("s")) {
            System.out.print("Nombre de la sección: ");
            String seccion =Util.introducirCadena();
            lista.add(new Bibliotecario(dni, nombre, mes, año, libros, seccion));
        } else {
            lista.add(new Socio(dni, nombre, mes, año, libros));
        }

        System.out.println("Socio/Bibliotecario agregado exitosamente.");
    }

    private static void visualizarTodosSocios(ArrayList<Socio> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay socios registrados.");
            return;
        }

        System.out.println("\n===== TODOS LOS SOCIOS DE " + "LECTURA VIVA" + " =====");
        for (Socio socio : lista) {
            System.out.println(socio);
        }
    }

    private static void visualizarBibliotecarios(ArrayList<Socio> lista) {
        List<Socio> bibliotecarios = lista.stream()
                .filter(Socio::esBibliotecario)
                .toList();

        if (bibliotecarios.isEmpty()) {
            System.out.println("No hay bibliotecarios registrados.");
            return;
        }

        System.out.println("\n===== BIBLIOTECARIOS =====");
        for (Socio socio : bibliotecarios) {
            System.out.println(socio);
        }
    }

    private static void visualizarBibliotecariosPorSeccion(ArrayList<Socio> lista) {
    	 System.out.print("Introduzca la sección: ");
    	    String seccion = Util.introducirCadena();

    	    boolean encontrado = false;

    	    for (Socio s : lista) {
    	        if (s.esBibliotecario()) {
    	            Bibliotecario b = (Bibliotecario) s;
    	            if (b.getSeccion().equalsIgnoreCase(seccion)) {
    	                System.out.println(b.getNombreCompleto());
    	                encontrado = true;
    	            }
    	        }
    	    }

    	    if (!encontrado) {
    	        System.out.println("No hay bibliotecarios en esa sección.");
    	    }
    	}
    private static void buscarPorNombre(ArrayList<Socio> lista) {
        System.out.print("Introduzca nombre o parte del nombre: ");
        String nombre = Util.introducirCadena().toLowerCase();

        List<Socio> resultados = lista.stream()
                .filter(s -> s.getNombreCompleto().toLowerCase().contains(nombre))
                .toList();

        if (resultados.isEmpty()) {
            System.out.println("ERROR: No se encontraron coincidencias.");
            return;
        }

        System.out.println("\n===== RESULTADOS DE BÚSQUEDA =====");
        for (Socio socio : resultados) {
            String tipo = socio.esBibliotecario() ? "Sí (Bibliotecario)" : "No";
            System.out.println("DNI: " + socio.getDni() + " | Años en biblioteca: " + 
                             socio.getAñosEnBiblioteca() + " | ¿Bibliotecario?: " + tipo);
        }
    }

    private static void buscarPorCuota(ArrayList<Socio> lista) {
        System.out.print("Introduzca cuota mínima: ");
        double cuotaMinima = Util.leerDouble();
        

        List<Socio> resultados = lista.stream()
                .filter(s -> s.getCuotaFinal() >= cuotaMinima)
                .toList();

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron socios con cuota final >= " + cuotaMinima + "€");
            return;
        }

        System.out.println("\n===== SOCIOS CON CUOTA >= " + cuotaMinima + "€ =====");
        for (Socio socio : resultados) {
            String tipo = socio.esBibliotecario() ? " (BIBLIOTECARIO)" : "";
            System.out.println(socio.getNombreCompleto() + " - Cuota final: " + 
                             String.format("%.2f€", socio.getCuotaFinal()) + tipo);
        }
    }

    private static void buscarBibliotecariosPorAños(ArrayList<Socio> lista) {
        System.out.print("Introduzca número de años: ");
        int años = Util.leerInt();
       

        List<Socio> resultados = lista.stream()
                .filter(Socio::esBibliotecario)
                .filter(s -> s.getAñosEnBiblioteca() >= años)
                .toList();

        if (resultados.isEmpty()) {
            System.out.println("No hay bibliotecarios con " + años + " años o más de antigüedad.");
            return;
        }

        System.out.println("\n===== BIBLIOTECARIOS CON " + años + "+ AÑOS =====");
        for (Socio socio : resultados) {
            System.out.println(socio.getNombreCompleto() + " - Años: " + socio.getAñosEnBiblioteca());
        }
    }

    private static void darDeBaja(ArrayList<Socio> lista) {
        System.out.print("Introduzca DNI del socio a dar de baja: ");
        String dni = Util.introducirCadena();

        Socio socio = obtenerSocioPorDni(dni,lista);
        if (socio == null) {
            System.out.println("ERROR: No existe socio con DNI " + dni);
            return;
        }

        lista.remove(socio);
        System.out.println("Socio " + socio.getNombreCompleto() + " dado de baja correctamente.");
    }

    private static boolean existeSocio(String dni, ArrayList<Socio> lista) {
        return lista.stream().anyMatch(s -> s.getDni().equals(dni));
    }

    private static Socio obtenerSocioPorDni(String dni, ArrayList<Socio> lista) {
        return lista.stream().filter(s -> s.getDni().equals(dni)).findFirst().orElse(null);
    }
}
