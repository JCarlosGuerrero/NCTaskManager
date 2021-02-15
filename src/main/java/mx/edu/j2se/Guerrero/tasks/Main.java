package mx.edu.j2se.Guerrero.tasks;

public class Main {
	
	public static void main(String[] args) {
		persona estudianteNC = new persona();
		estudianteNC.setEdad(19);
		estudianteNC.setNombre("Eduardo");
		int laEdad = estudianteNC.getEdad();
		String loDejaron = estudianteNC.loDejanEntrarAlBar();
		System.out.println(estudianteNC.getNombre() + loDejaron);

		String elNombre = estudianteNC.getNombre();
		System.out.println(elNombre);
	}


}
