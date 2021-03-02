package mx.edu.j2se.Guerrero.tasks;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Task objeto1 = new Task("correr",5);
		objeto1.setActive(true);

		System.out.println(objeto1.nextTimeAfter(3));
		System.out.println();

		Task objeto2 = new Task("nadar",1,10,1);
		objeto2.setActive(true);

		System.out.println(objeto2.title + " "+ objeto2.start + " " + objeto2.end + " " + objeto2.interval);
		System.out.println(objeto2.nextTimeAfter(3));

		ArrayTaskList objeto3 = new ArrayTaskList();

		objeto3.arrayTask[0] = new Task("correr",5);
		objeto3.arrayTask[1] = new Task("nadar", 4,5,0);

		objeto3.add(new Task("volar",6));
		objeto3.add(new Task("teletransportar",1,2,3));
		objeto3.add(new Task("volar",6));

		objeto3.remove(new Task("volar",6));

		System.out.println("objeto3.size() = " + objeto3.size());

		System.out.println(objeto3.getTask(3));
		/*persona estudianteNC = new persona();
		estudianteNC.setEdad(19);
		estudianteNC.setNombre("Eduardo");
		int laEdad = estudianteNC.getEdad();
		String loDejaron = estudianteNC.loDejanEntrarAlBar();
		System.out.println(estudianteNC.getNombre() + loDejaron);

		String elNombre = estudianteNC.getNombre();
		System.out.println(elNombre);
		*/
	}
}
