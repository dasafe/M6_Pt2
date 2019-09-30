package practica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Ej5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String ruta = "frasesMatrix.txt";
		try {

			// Creando archivo
			PrintWriter writer = new PrintWriter(ruta, "UTF-8");

			// Escribiendo en el archivo
			writer.println(
					"Yo sólo puedo mostrarte la puerta, tú eres quien la tiene que atravesar. Si ejecutas el programa dos veces, ¿Qué ocurre? ¿Cómo lo solucionamos?");
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
