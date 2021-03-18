package mx.edu.j2se.Guerrero.tasks;

import java.util.LinkedList;
import java.util.Objects;

public class LinkedTaskList extends AbstractTaskList {

    LinkedList<Task> list = new LinkedList<Task>(); //Linked list de objects

    /**
     * Method to add a task to the LinkedList
     * @param task task to be added
     */
    @Override
    public void add(Task task){

        list.add(task);
    }

    /**
     * Method to remove a task to the LinkedList and returns true
     * if the task was in the list
     * @param task task to be removed
     * @return true if the task was in the list
     */
    @Override
    public boolean remove(Task task) {

        boolean taskInList = false;
        int kLimit = list.size();
        outer: for(int k = 0; k < kLimit; k++) {
        int j = 0;
        for (Task temptask : list ) {
            if(temptask.title == task.title && (temptask.time == task.time || temptask.start == task.start)) {
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
    @Override
    public int size() {

        return list.size();
    }

    /**
     * Method that returns the specified task from the list
     * @param index Element to be returned from the list
     * @return The object in the specified index
     */
    @Override
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
    @Override
    public LinkedTaskList incoming(int from, int to) {

        LinkedTaskList temp = new LinkedTaskList();

        int j = 0;
        for (Task temptask : list) {
            if(temptask.isActive()) {
                if(temptask.start >= from && temptask.end <= to
                || temptask.time >= from && temptask.time <= to) {
                    temp.add(temptask);
                }
            }
        }
        return temp;
    }

    /**
     * Method that returns true if two objects are the same
     * @param o Object Task to compare
     * @return True if the Tasks are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedTaskList integers = (LinkedTaskList) o;
        return Objects.equals(list, integers.list);
    }

    /**
     * Method that returns the hash code of the list
     * @return The hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    /**
     * Method that writes in console the List
     * @return The String of Lists
     */
    @Override
    public String toString() {
        return "LinkedTaskList{" +
                "list=" + list +
                '}';
    }

    /**
     * Method that creates a copy of the current List
     */
    public void copy() {
        LinkedTaskList copy = (LinkedTaskList) list.clone();
    }
}
