package mx.edu.j2se.Guerrero.tasks;

import java.util.Objects;

public class LinkedTaskList extends AbstractTaskList {

    public Node head;
    public Node last;
    public static int count;

    private static void incrementCount() {
        count++;
    }
    private void decrementCount() {
        count--;
    }

    private static int getCount() {
        return count;
    }

    /**
     * Method to add a task to the LinkedList
     * @param task task to be added
     */
    @Override
    public void add(Task task){

        if (getCount() != 0) {
            Node prev = last;
            last = new Node(task);
            prev.next = last;
        } else {
            last = new Node(task);
            head = last;
        }
        incrementCount();
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
        Node prev = head;
        Node current = head;

        while (current.next != null || current == last) {
            if (current.getTaskNode().equals(task)) {
                if (count == 1) { head = null; last = null;}
                else if (current.equals(head)) { head = head.next;}
                else if (current.equals(last)) { last = prev;last.next = null;}
                else {prev.next = current.next;}
                decrementCount();
                taskInList = true;
                break;
            }
            prev = current;
            current = prev.next;
        }
        return taskInList;
    }

    /**
     * Method to see the number of elements in the LinkedList
     * @return the number of the elements in the list
     */
    @Override
    public int size() {
        return getCount();
    }

    /**
     * Method that returns the specified task from the list
     * @param index Element to be returned from the list
     * @return The object in the specified index
     */
    @Override
    public Task getTask(int index) {
        if (index < 0) return null;

        Node current = null;
        if (head != null) {
            current = head;
            for (int i = 0;i < index; i++) {
                if (current.getNext() == null) return null;
                current = current.getNext();
            }
            return current.getTaskNode();
        }
        return current.getTaskNode();
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
        LinkedTaskList tasks = (LinkedTaskList) o;
        return Objects.equals(head, tasks.head) && Objects.equals(last, tasks.last);
    }


    /**
     * Method that returns the hash code of the list
     * @return The hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(head, last);
    }

    /**
     * Method that writes in console the List
     * @return The String of Lists
     */
    @Override
    public String toString() {
        return "LinkedTaskList{" +
                "head=" + head +
                ", last=" + last +
                '}';
    }

    /**
     * Method that creates a copy of the current List
     */
    public Object clone() throws CloneNotSupportedException {
        LinkedTaskList copy = (LinkedTaskList) super.clone();
        return copy;
    }
}

class Node {
    Node next;
    Task task;

    public Node(Task task) {
        next = null;
        this.task = task;
    }

    public Task getTaskNode() {
        return task;
    }

    public Node getNext(){
        return next;
    }
}
