package principal;

import modelo.Objetos;

public class Ejercicio4 {

	public static void main(String[] args) {
		Objetos[] inventario = { 
				new Objetos("Manzana", 1.2, 5), 
				new Objetos("Pera", 1.5, 4),
				new Objetos("Naranja", 2.0, 3), 
				new Objetos("Melón", 3.0, null),
				new Objetos("Sandía", 4.5, 2) };
			double total = 0;
			Objetos productoMasCaro = null;

			for (int i = 0; i < inventario.length; i++) {
				if (inventario[i].getStock() != null) {
					if (inventario[i].getStock() % 2 != 0) {
						total += inventario[i].getPrecio();
					}

					if (inventario[i].getStock() > 5) {
						if (productoMasCaro == null || inventario[i].getPrecio() > productoMasCaro.getPrecio()) {
							productoMasCaro = inventario[i];
						}
					}
				}
			}

			System.out.println("La suma de precios con stock null es: " + total);
			if (productoMasCaro != null) {
				System.out.println("El producto más caro con stock mayor que 5 es: " + productoMasCaro.getProducto());
			} else {
				System.out.println("No hay productos con stock mayor que 5.");
			}

			Objetos[] inventarioOrdenado = new Objetos[inventario.length];
			int index = 0;

			for (Objetos obj : inventario) {
				if (obj.getStock() != null) {
					inventarioOrdenado[index++] = obj;
				}
			}

			for (Objetos obj : inventario) {
				if (obj.getStock() == null) {
					inventarioOrdenado[index++] = obj;
				}
			}

			System.out.println("Inventario ordenado:");
			for (Objetos obj : inventarioOrdenado) {
				System.out.println(obj.getProducto() + " - Stock: " + obj.getStock());
			}
			
			Objetos productoMasCaroGlobal = null;
			Objetos productoMasBaratoGlobal = null;
			int indiceMasCaro = -1;
			int indiceMasBarato = -1;

			for (int i = 0; i < inventario.length; i++) {
				if (inventario[i].getStock() != null) {
					if (productoMasCaroGlobal == null || inventario[i].getPrecio() > productoMasCaroGlobal.getPrecio()) {
						productoMasCaroGlobal = inventario[i];
						indiceMasCaro = i;
					}
					if (productoMasBaratoGlobal == null || inventario[i].getPrecio() < productoMasBaratoGlobal.getPrecio()) {
						productoMasBaratoGlobal = inventario[i];
						indiceMasBarato = i;
					}
				}
			}

			if (indiceMasCaro != -1 && indiceMasBarato != -1) {
				Objetos temp = inventario[indiceMasCaro];
				inventario[indiceMasCaro] = inventario[indiceMasBarato];
				inventario[indiceMasBarato] = temp;
			}

			System.out.println("Inventario después del intercambio:");
			for (Objetos obj : inventario) {
				System.out.println(obj.getProducto() + " - Precio: " + obj.getPrecio() + ", Stock: " + obj.getStock());
			}
		}
	}