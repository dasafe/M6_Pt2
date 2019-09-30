package practica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Ej7 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		System.out.println("Primer parametro");
		String ruta1 = reader.nextLine();
		System.err.println("Segundo parametro");
		String ruta2 = reader.nextLine();
		File f1 = new File(ruta1);
		File f2 = new File(ruta2);

		// Creando ficheros
		try {
			if (f1.createNewFile()) {
				System.out.println("Fichero creado");
			} else {
				System.out.println("No se han podido crear el fichero");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Comprobamos si es un directorio
		if (f2.isDirectory()) {
			ruta2 = ruta2 + "\\" + ruta1.substring(ruta1.lastIndexOf("\\") + 1);
			copia(ruta1, ruta2);
			System.out.println("Copia creada en nueva ruta");
		} else {
			copia(ruta1, ruta2);
			System.out.println("Copia creada");
		}

	}

	private static void copia(String ruta1, String ruta2) throws IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter writer = new PrintWriter(ruta2, "UTF-8");
			try (BufferedReader br = new BufferedReader(new FileReader(ruta1))) {
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
					writer.println(line);
				}
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
