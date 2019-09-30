package practica;

import java.io.File;

public class Ej3 {
	public static void main(String[] args) {

		new File("MyFiles").mkdirs();
		File fichero1 = null;
		File fichero2 = null;
		try {

			fichero1 = new File("MyFiles\\fichero1.txt");
			fichero2 = new File("MyFiles\\fichero2.txt");

			// Creando ficheros
			if (fichero1.createNewFile() && fichero2.createNewFile()) {
				System.out.println("Ficheros creados");
			} else {
				System.out.println("No se han podido crear los ficheros");
			}

			// Renombrar fichero2
			System.out.println();
			File newFichero2 = new File("MyFiles\\ficheroRenombrado.txt");
			if (fichero2.renameTo(newFichero2)) {
				System.out.println("Fichero2 renombrado");
			} else {
				System.out.println("Fichero2 no se ha podido renombrar");
			}

			// Listar ficheros
			System.out.println();
			File f = new File("MyFiles");
			File[] ficheros1 = f.listFiles();
			System.out.println("- MyFiles -");
			for (int i = 0; i < ficheros1.length; i++) {
				System.out.println(ficheros1[i].getName());
			}

			// Eliminar fichero1
			System.out.println();
			if (fichero1.delete()) {
				System.out.println("Fichero1 eliminado");
			} else {
				System.out.println("Fichero1 no se ha podido eliminar");
			}

			// Listar ficheros
			File[] ficheros2 = f.listFiles();
			System.out.println("- MyFiles -");
			for (int i = 0; i < ficheros2.length; i++) {
				System.out.println(ficheros2[i].getName());
			}

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}
}