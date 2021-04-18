package mx.edu.j2se.Guerrero.tasks;

import java.time.LocalDateTime;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		Task objeto1 = new Task("comer", LocalDateTime.of(2021, 01, 10, 7, 30));
		System.out.println(objeto1);

		LinkedTaskList objeto2 = new LinkedTaskList();
		objeto2.add(new Task("comer", LocalDateTime.of(2021, 01, 10, 7, 30)));
		objeto2.add(new Task("bailar", LocalDateTime.of(2021, 01, 10, 7, 30)));
		objeto2.add(new Task("jugar", LocalDateTime.of(2021, 01, 10, 7, 30)));
		objeto2.add(new Task("dormir", LocalDateTime.of(2021, 01, 10, 7, 30)));
		objeto2.add(new Task("correr", LocalDateTime.of(2021, 01, 10, 7, 30)));
		System.out.println(objeto2.size());
		System.out.println(objeto2.getTask(3));
		objeto2.remove(new Task("bailar", LocalDateTime.of(2021, 01, 10, 7, 30)));
		System.out.println("hola");

	}
}

