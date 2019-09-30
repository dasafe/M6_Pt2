package practica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ej4 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		String ruta = "MyFiles\\ficheroRenombrado.txt";
		File f = new File(ruta);

		// Comprobamos la ruta
		if (f.isFile()) {

			// Imprime contenido del txt
			System.out.println("- Contenido Archivo -");
			try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			}

			// Comprobamos si es un directorio
		} else if (f.isDirectory()) {
			System.out.println("La ruta es un directorio");

		} else {
			System.out.println("La ruta no existe");
		}
	}
}
