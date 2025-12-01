Package clases;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Trabajador extends Persona {

    private String usuario;
    private String contraseña;
    private String cargo; // monitor o recepcionista

    public Trabajador(String dni, String nombre, String usuario, String contraseña, String cargo) {
        super(dni, nombre);
        if (!cargo.equals("monitor") && !cargo.equals("recepcionista")) {
            throw new IllegalArgumentException("Cargo no válido");
        }
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.cargo = cargo;
    }

    @Override
    public void visualizar() {
        System.out.println("TRABAJADOR:");
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Usuario: " + usuario);
        System.out.println("Cargo: " + cargo);
    }
}