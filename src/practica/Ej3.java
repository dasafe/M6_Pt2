package practica;

import java.io.File;
import java.io.FileWriter;

public class Ej3 {
	public static void main(String[] args) {

		String[] lineas = { "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "..." };

		new File("MyFiles").mkdirs();
		FileWriter fichero1 = null;
		FileWriter fichero2 = null;
		try {

			fichero1 = new FileWriter("MyFiles\\fichero1.txt");
			fichero2 = new FileWriter("MyFiles\\fichero2.txt");

//			for (String linea : lineas) {
//				fichero1.write(linea + "\n");
//			}
			File newFichero2 = new File("ficheroRenombrado");
			
			fichero1.close();
			fichero2.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}
}
