package practica;

public class Ej4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner (System.in);
		String ruta = reader.nextLine();
		File f = new File("ruta");
		
		//Comprobamos la ruta
		if(f.isFile()){
			//Imprime contenido del txt
			try (BufferedReader br = new BufferedReader(new FileReader("foo.txt"))) {
				String line = null;
				while ((line = br.readLine()) != null) {
		 			System.out.println(line);
				}
			}
		}else if(f.isDirectory()){
			System.out.println("La ruta es un directorio");
		}else{
			System.out.println("La ruta no existe");
		}
	}

}
