package mx.edu.j2se.Guerrero.tasks;

import mx.edu.j2se.Guerrero.evaluation.Circle;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Task objeto1 = new Task("correr",5);
		objeto1.setActive(true);

		System.out.println(objeto1.nextTimeAfter(3));
		System.out.println();

		Task objeto2 = new Task("nadar",1,10,1);
		objeto2.setActive(true);

		objeto1.setTime(1,10,2);
		objeto2.setTime(5);

		System.out.println(objeto2.title + " "+ objeto2.start + " " + objeto2.end + " " + objeto2.interval);
		System.out.println(objeto2.nextTimeAfter(3));

		ArrayTaskList objeto3 = new ArrayTaskList();

		objeto3.arrayTask[0] = new Task("correr",2);
		objeto3.arrayTask[0].setActive(true);
		objeto3.arrayTask[1] = new Task("nadar", 6,10,2);
		objeto3.arrayTask[1].setActive(true);

		objeto3.add(new Task("volar",6));
		objeto3.add(new Task("teletransportar",1,2,3));
		objeto3.add(new Task("volar",2,10,2));
		objeto3.add(new Task(null,0));

		objeto3.remove(new Task("volar",6));

		System.out.println("objeto3.size() = " + objeto3.size());

		System.out.println(objeto3.getTask(2));

		objeto3.Incoming(2,5);

		LinkedTaskList objeto4 = new LinkedTaskList();

		objeto4.add(new Task("comer",10));
		objeto4.add(new Task("jugar",2,9,1));
		objeto4.add(new Task("comer",5));
		objeto4.add(new Task("bailar",4,6,1));


		objeto4.remove(new Task("bailar",4,6,1));

		Circle objeto5 = new Circle();
		Circle objeto6 = new Circle(10);

		objeto5.getRadius();
		objeto6.getRadius();

		objeto5.setRadius(2);
		objeto6.setRadius(3);

		System.out.println(objeto5.getArea());
		System.out.println(objeto6.getArea());


		Circle array[] = new Circle[3];
		array[0] = new Circle(3);
		array[1] = new Circle(6);
		array[2] = new Circle(9);
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
