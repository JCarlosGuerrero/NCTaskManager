package mx.edu.j2se.Guerrero.tasks;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedTaskList {

    LinkedList<Task> list = new LinkedList<Task>(); //Linked list de objects

    /**
     * Method to add a task to the LinkedList
     * @param task task to be added
     */
    public void add(Task task){

        list.add(task);
    }

    /**
     * Method to remove a task to the LinkedList and returns true
     * if the task was in the list
     * @param task task to be removed
     * @return true if the task was in the list
     */
    public boolean remove(Task task) {

        boolean taskInList = false;
        int kLimit = list.size();
        outer: for(int k = 0; k < kLimit; k++) {
        int j = 0;
        for (Iterator<Task> i = list.iterator();i.hasNext();) {
            Task data = i.next();
            if(data.title.equals(task.title) && data.time == task.time) {
                list.remove(j);
                taskInList = true;
                continue outer;
            }
            j++;
        }
        } return taskInList;
    }

    /**
     * Method to see the number of elements in the LinkedList
     * @return the number of the elements in the list
     */
    public int size() {

        return list.size();
    }

    /**
     * Method that returns the specified task from the list
     * @param index Element to be returned from the list
     * @return The object in the specified index
     */
    public Task getTask(int index) {

        if(index < list.size() && index >= 0){
            return list.get(index);
        }
        throw new IndexOutOfBoundsException("Index out of range");
    }

    /**
     * Method that tells you if there are tasks in the specified
     * interval
     * @param from start of the interval
     * @param to end of the interval
     * @return A list of the tasks in the interval
     */

    public LinkedTaskList Incoming(int from, int to) {

        LinkedTaskList temp = new LinkedTaskList();

        int j = 0;
        for (Iterator<Task> i = list.iterator();i.hasNext();) {
            Task data = i.next();
            if(data.isActive()) {
                if(data.start >= from && data.end <= to
                || data.time >= from && data.time <= to) {
                    temp.add(data);
                }
            }
        }
        return temp;
    }
}
