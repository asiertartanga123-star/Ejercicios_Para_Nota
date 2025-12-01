Package clases;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Entrenamiento {
private LocalDate fecha;
    private String ejercicio;
    private int repeticiones;

    public Entrenamiento(LocalDate fecha, String ejercicio, int repeticiones) {
        this.fecha = fecha;
        this.ejercicio = ejercicio;
        this.repeticiones = repeticiones;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate nuevaFecha) {
        this.fecha = nuevaFecha;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Ejercicio: " + ejercicio + ", Reps: " + repeticiones;
    }
}