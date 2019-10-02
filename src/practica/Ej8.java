package practica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ej8 {
	static int opcion;
	static String nombre;
	static Scanner reader = new Scanner(System.in);
	static String cod_tienda;
	static Map tienda = new TreeMap();
	static String ruta = "catalogo.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tienda.put("DOOM", 29.99);
		tienda.put("Cyberpunk_2077", 60);
		tienda.put("Death_Stranding", 60);
		tienda.put("Hollow_Knight", 15.95);
		do {
			menu();
			System.out.println();
		} while (opcion != 7);

	}

	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println(
				"*MENU*\n1. Introducir\n2. Modificar\n3. Eliminar\n4. Mostrar\n5. Actualizar fichero\n6. Mostrar desde fichero\n7. Terminar");
		System.out.println("Elegir opcion: ");
		opcion = validacion();
		switch (opcion) {
		case 1:
			introducir();
			break;
		case 2:
			modificar();
			break;
		case 3:
			eliminar();
			break;
		case 4:
			mostrar();
			break;
		case 5:
			try {
				actualizar();
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 6:
			try {
				mostrarFichero();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 7:
			System.out.println("\nBye!");
			break;

		default:
			System.out.println("\nOpcion invalida");
			break;
		}
	}

	private static void actualizar() throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
			System.out.println();
			// Creando archivo
			PrintWriter writer = new PrintWriter(ruta, "UTF-8");

			// Escribiendo en el archivo
			Iterator it = tienda.keySet().iterator();
			while (it.hasNext()) {
				cod_tienda = (String) it.next();
				writer.println(cod_tienda + " - " + tienda.get(cod_tienda));
			}
			System.out.println("Fichero actualizado");
			writer.close();
	}

	private static void mostrarFichero() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println();
		// Imprimir contenido
		System.out.println("- Catalogo -");
		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}

	private static void mostrar() {
		// TODO Auto-generated method stub
		System.out.println();
		Iterator it = tienda.keySet().iterator();
		while (it.hasNext()) {
			cod_tienda = (String) it.next();
			System.out.println(cod_tienda + " - " + tienda.get(cod_tienda) + "€");
		}
	}

	private static void eliminar() {
		// TODO Auto-generated method stub
		System.out.println("Introduce el juego:");
		nombre = nombreNotNull();
		Iterator it = tienda.keySet().iterator();
		while (it.hasNext()) {
			cod_tienda = (String) it.next();
			if (cod_tienda.equalsIgnoreCase(nombre)) {
				tienda.remove(nombre);
				System.out.println("\nRegistro eliminado");
				break;
			}
		}
	}

	private static void modificar() {
		// TODO Auto-generated method stub
		System.out.println("Introduce el juego:");
		boolean existe = false;
		nombre = nombreNotNull();
		Iterator it = tienda.keySet().iterator();
		while (it.hasNext()) {
			cod_tienda = (String) it.next();
			if (cod_tienda.equalsIgnoreCase(nombre)) {
				existe = true;
				System.out.println("Introduce el nuevo precio:");
				float precio = validacionFloat();
				tienda.put(nombre, precio);
				break;
			}
		}
		if (!existe) {
			System.out.println("\nEste juego ya está registrado");
		}
	}

	private static void introducir() {
		// TODO Auto-generated method stub
		System.out.println("Introduce el juego:");
		boolean existe = false;
		nombre = nombreNotNull();
		Iterator it = tienda.keySet().iterator();
		while (it.hasNext()) {
			cod_tienda = (String) it.next();
			if (cod_tienda.equalsIgnoreCase(nombre)) {
				existe = true;
				System.out.println("\nEste juego ya está registrado");
				break;
			}
		}
		if (!existe) {
			System.out.println("Introduce el precio:");
			float precio = validacionFloat();
			tienda.put(nombre, precio);
		}

	}

	private static float validacionFloat() {
		while (!reader.hasNextFloat()) {
			reader.next();
			System.out.println("Precio invalido");
		}
		float numero = reader.nextFloat();
		return numero;
	}

	private static int validacion() {
		while (!reader.hasNextInt()) {
			reader.next();
			System.out.println("No valido");
		}
		int numero = reader.nextInt();
		return numero;
	}

	private static String nombreNotNull() {
		reader.nextLine();
		nombre = reader.nextLine();
		while (nombre.equalsIgnoreCase("")) {
			System.out.println("Nombre vacio, introduce un nombre valido:");
			nombre = reader.nextLine();
		}
		return nombre;
	}
}
