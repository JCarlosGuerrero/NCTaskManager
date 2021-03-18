package mx.edu.j2se.Guerrero.tasks;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		Task objeto1 = new Task("correr",2);
		objeto1.setActive(true);

		System.out.println(objeto1.nextTimeAfter(3));
		System.out.println();

		System.out.println(objeto1.toString());

		Task objeto2 = new Task("nadar",3,5,1);
		objeto2.setActive(true);

		objeto1.setTime(2,4,2);
		objeto2.setTime(5);

		System.out.println(objeto2.title + " "+ objeto2.start + " " + objeto2.end + " " + objeto2.interval);
		System.out.println(objeto2.nextTimeAfter(3));

		ArrayTaskList objeto3 = new ArrayTaskList();

		objeto3.arrayTask[0] = new Task("correr",2);
		objeto3.arrayTask[0].setActive(true);

		objeto3.add(new Task("volar",6));
		objeto3.add(new Task("teletransportar",1,2,3));
		objeto3.add(new Task("volar",2,10,2));

		System.out.println(objeto3.toString());

		objeto3.remove(new Task("volar",6));

		System.out.println("objeto3.size() = " + objeto3.size());

		System.out.println(objeto3.getTask(2));

		objeto3.incoming(2,5);

		LinkedTaskList objeto4 = new LinkedTaskList();

		objeto4.add(new Task("comer",10));
		objeto4.add(new Task("jugar",2,5,1));
		objeto4.add(new Task("comer",2,9,2));
		objeto4.add(new Task("votar",5));
		objeto4.add(new Task("comer",10));

		System.out.println(objeto4.toString());
		objeto4.list.get(0).setActive(true);
		objeto4.list.get(1).setActive(true);
		objeto4.list.get(2).setActive(true);
		objeto4.list.get(3).setActive(true);
		objeto4.list.get(4).setActive(true);

		objeto4.remove(new Task("comer",10));

		System.out.println(objeto4.size());

		System.out.println(objeto4.getTask(1));

		objeto4.incoming(1,5);

		AbstractTaskList objeto5 = new ArrayTaskList();
		AbstractTaskList objeto6 = new LinkedTaskList();

		objeto5.add(new Task("ver tele",3));
		objeto6.add(new Task("jugar con la pelota",2,10,2));

	}
}
