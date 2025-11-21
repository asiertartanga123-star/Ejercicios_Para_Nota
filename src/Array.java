package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> alumnos = new ArrayList<>();
		alumnos.add("Ana");
		alumnos.add("Luis");
		alumnos.add("Marta");
		alumnos.add("Juan");
		alumnos.add("Pedro");
		
		Iterator<String> it = alumnos.iterator();
			while(it.hasNext()) {
			String alumno = it.next();
			if(alumno.length() < 4) {
				it.remove();
			}
		}
		System.out.println("Lista actualizada: " + alumnos);
		
		ListIterator<String> listIt =  alumnos.listIterator();
		while(listIt.hasNext()) {
			int index = listIt.nextIndex();
			String alumno = listIt.next();
			System.out.println("Forward index " + index + ": " + alumno);
			if(alumno.startsWith("P")) {
				listIt.set(alumno.toUpperCase());
			}
			else if(alumno.startsWith("M")) {
				listIt.add("Marcos");
			}
		}
		System.out.println("Lista después de ListIterator: " + alumnos );
		
		System.out.println("Recorrido inverso:");
		ListIterator<String> revIt = alumnos.listIterator(alumnos.size());
		while(revIt.hasPrevious()) {
			int index = revIt.previousIndex();
			String nombre = revIt.previous();
			System.out.println("Reverse index " + index + ": " + nombre);
		}
	}
}
	
	
