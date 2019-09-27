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
			
			//Renombrar fichero2
			File newFichero2 = new File("ficheroRenombrado");
			if(fichero2.renameTo(newFichero2)){
				System.out.println("Fichero2 renombrado");
			}else{
				System.out.println("Fichero2 no se ha podido renombrar");
			}
			
						//Listar ficheros
			File f = new File("MyFiles");
			File[] ficheros = f.listFiles();
			System.out.println("- MyFiles -");
			for (int i=0; i < ficheros.length;x++){
 				System.out.println(ficheros[x].getName());
			}
			
			//Eliminar fichero1
			if(f1.delete()){
				System.out.println("Fichero1 eliminado");
			}else{
				System.out.println("Fichero1 no se ha podido eliminar");
			}
			
			//Listar ficheros
			File f = new File("MyFiles");
			File[] ficheros = f.listFiles();
			System.out.println("- MyFiles -");
			for (int i=0; i < ficheros.length;x++){
 				System.out.println(ficheros[x].getName());
			}
			
			fichero1.close();
			fichero2.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}
}
