package modelo;
import java.time.YearMonth;

public class Socio {
    private String dni;
    private String nombreCompleto;
    private YearMonth fechaAlta;
    private int librosPermitidos;

    public Socio(String dni, String nombreCompleto, int mes, int año, int librosPermitidos) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.fechaAlta = YearMonth.of(año, mes);
        this.librosPermitidos = librosPermitidos;
    }

    public String getDni() {
        return dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public YearMonth getFechaAlta() {
        return fechaAlta;
    }

    public int getLibrosPermitidos() {
        return librosPermitidos;
    }

    public int getAñosEnBiblioteca() {
        return YearMonth.now().getYear() - fechaAlta.getYear();
    }

    public double getCuotaFinal() {
        final double CUOTA_BASE = 12.0;
        final int LIBROS_BASE = 3;
        final double INCREMENTO_POR_LIBRO = 1.0;
        final double DESCUENTO_ANTIGUEDAD = 2.0;
        final int AÑOS_DESCUENTO = 8;

        double cuota = CUOTA_BASE;

        if (librosPermitidos > LIBROS_BASE) {
            cuota += (librosPermitidos - LIBROS_BASE) * INCREMENTO_POR_LIBRO;
        }

        if (getAñosEnBiblioteca() >= AÑOS_DESCUENTO) {
            cuota -= DESCUENTO_ANTIGUEDAD;
        }

        return cuota;
    }

    public boolean esBibliotecario() {
        return false;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + " | Nombre: " + nombreCompleto + " | Alta: " + 
               fechaAlta.getMonthValue() + "/" + fechaAlta.getYear() + 
               " | Libros permitidos: " + librosPermitidos + 
               " | Cuota final: " + String.format("%.2f€", getCuotaFinal());
    }
}
