package modelo;
public class Bibliotecario extends Socio {
    private String seccion;

    public Bibliotecario(String dni, String nombreCompleto, int mes, int año, 
                        int librosPermitidos, String seccion) {
        super(dni, nombreCompleto, mes, año, librosPermitidos);
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

    @Override
    public double getCuotaFinal() {
        final double PLUS_BIBLIOTECARIO = 30.0;
        return super.getCuotaFinal() + PLUS_BIBLIOTECARIO;
    }

    @Override
    public boolean esBibliotecario() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " | Sección: " + seccion + " | BIBLIOTECARIO";
    }
}
