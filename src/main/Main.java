Package Main;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        Cliente c = new Cliente("12345678A", "Jon", LocalDate.of(2024, 1, 10));
        c.añadirEntrenamiento(LocalDate.of(2024, 1, 15), "Sentadillas", 50);
        c.añadirEntrenamiento(LocalDate.of(2024, 1, 16), "Flexiones", 30);
        c.añadirEntrenamiento(LocalDate.of(2024, 1, 17), "Burpees", 20);


        System.out.println("=== DATOS INICIALES ===");
        c.visualizar();


        System.out.println("\nModificando fechas (+1 día)...\n");

        Iterator<Map.Entry<String, Entrenamiento>> it = c.getEntrenamientos().entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Entrenamiento> entry = it.next();
            Entrenamiento e = entry.getValue();
            e.setFecha(e.getFecha().plusDays(1));
        }

       
        System.out.println("=== DATOS MODIFICADOS ===");
        c.visualizar();
    }
}