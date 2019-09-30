package practica;

import java.io.File;
import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fichero = new File("src\\practica\\Ej1.java");
		Scanner s = null;
		try {
			s = new Scanner(fichero);

			while (s.hasNextLine()) {
				String linea = s.nextLine();
				System.out.println(linea);
			}

		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
	}

}
