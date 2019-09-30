package practica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Ej6 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String ruta = "escribeLineas.txt";
		try {

			// Creando archivo
			PrintWriter writer = new PrintWriter(ruta, "UTF-8");

			// Escribiendo en el archivo
			writer.println("Probando\nvarias\nmaneras");
			writer.println("de\nsaltar\nde\nlinea");
			writer.println("8\n9\n10");
			writer.close();

			// Imprimir contenido
			System.out.println("- Contenido Archivo -");
			try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			}

		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
