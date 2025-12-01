
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cliente extends Persona {

    private LocalDate fechaAlta;

    private Map<String, Entrenamiento> entrenamientos;
    private int contadorWOD = 100;

    public Cliente(String dni, String nombre, LocalDate fechaAlta) {
        super(dni, nombre);
        this.fechaAlta = fechaAlta;
        this.entrenamientos = new HashMap<>();
    }

    // Añade un entrenamiento creando el código automático
    public void añadirEntrenamiento(LocalDate fecha, String ejercicio, int repeticiones) {
        String codigo = "WOD-" + contadorWOD++;
        entrenamientos.put(codigo, new Entrenamiento(fecha, ejercicio, repeticiones));
    }

    public Map<String, Entrenamiento> getEntrenamientos() {
        return entrenamientos;
    }

    @Override
    public void visualizar() {
        System.out.println("CLIENTE:");
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Fecha alta: " + fechaAlta);
        System.out.println("ENTRENAMIENTOS:");
        entrenamientos.forEach((k, v) -> System.out.println(k + " → " + v));
    }
}