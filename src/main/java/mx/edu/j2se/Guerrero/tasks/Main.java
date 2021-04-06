package mx.edu.j2se.Guerrero.tasks;

import java.time.LocalDateTime;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		Task objeto1 = new Task("comer", LocalDateTime.of(2021,01,10,7,30));
		System.out.println(objeto1);

		TaskListFactory.createTaskList(ListTypes.types.ARRAY);
		System.out.println("Hola");
	}
}
