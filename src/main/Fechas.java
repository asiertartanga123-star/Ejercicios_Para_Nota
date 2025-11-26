package main;

	import java.time.*;
	import java.time.format.DateTimeFormatter;
	import java.time.temporal.ChronoUnit;
	import java.util.Locale;
	import java.util.Scanner;

	public class Fechas {
	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        // 1. Pedir fecha
	        System.out.print("Introduce tu fecha de nacimiento (dd/MM/yyyy): ");
	        String fechaStr = sc.nextLine();

	        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate fechaNac = LocalDate.parse(fechaStr, formatoEntrada);

	        // 3. Mostrar en distintos formatos
	        System.out.println("\n--- FORMATOS ---");
	        System.out.println("1) Formato ISO: " + fechaNac);
	        System.out.println("2) d-M-yy: " + fechaNac.format(DateTimeFormatter.ofPattern("d-M-yy")));
	        System.out.println("3) dd-MMM-yyyy: " + fechaNac.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.forLanguageTag("es-ES"))));
	        System.out.println("4) yyyy-MMMM-dd: " + fechaNac.format(DateTimeFormatter.ofPattern("yyyy-MMMM-dd", Locale.forLanguageTag("es-ES"))));

	        // 4. Calcular edad
	        LocalDate hoy = LocalDate.now();
	        Period edad = Period.between(fechaNac, hoy);
	        long diasTotales = ChronoUnit.DAYS.between(fechaNac, hoy);

	        System.out.println("\n--- EDAD ---");
	        System.out.println("Tienes " + edad.getYears() + " años, "
	                + edad.getMonths() + " meses y "
	                + edad.getDays() + " días.");
	        System.out.println("Han pasado " + diasTotales + " días desde que naciste.");

	        // 5. Pedir hora
	        System.out.print("\nIntroduce una hora (HH:mm): ");
	        String horaStr = sc.nextLine();

	        LocalTime hora = LocalTime.parse(horaStr, DateTimeFormatter.ofPattern("HH:mm"));
	        LocalTime horaMas3 = hora.plusHours(3);
	        long diferenciaMinutos = ChronoUnit.MINUTES.between(hora, LocalTime.now());

	        System.out.println("\n--- HORAS ---");
	        System.out.println("Hora introducida: " + hora);
	        System.out.println("Dentro de 3 horas: " + horaMas3);
	        System.out.println("Minutos entre esa hora y ahora: " + diferenciaMinutos);

	        // 6. LocalDateTime combinado
	        LocalDateTime fechaHora = LocalDateTime.of(fechaNac, hora);

	        System.out.println("\n--- FECHA Y HORA (LocalDateTime) ---");
	        System.out.println("Fecha y hora combinadas: " + fechaHora);

	        LocalDateTime modificada = fechaHora.plusYears(1).plusMonths(2).plusDays(10);
	        System.out.println("Fecha modificada (+1 año, +2 meses, +10 días): " + modificada);

	        DateTimeFormatter formateadorCompleto =
	                DateTimeFormatter.ofPattern("EEEE dd 'de' MMMM yyyy HH:mm", new Locale("es", "ES"));

	        System.out.println("Formateado bonito: " + fechaHora.format(formateadorCompleto));
	    }
	}

