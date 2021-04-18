package mx.edu.j2se.Guerrero.tasks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

public class ArrayTaskList extends AbstractTaskList {

    int n = 1;
    Task[] arrayTask = new Task[n]; //arreglo tipo object

    /**
     * Method to add a task to the array
     * @param task task to be added to the array
     */
    @Override
    public void add(Task task){

        Task arrayTaskTemp[] = new Task[arrayTask.length + 1];
        System.arraycopy(arrayTask,0,arrayTaskTemp,0,arrayTask.length);
        arrayTaskTemp[arrayTask.length] = task;
        this.arrayTask = arrayTaskTemp;
    }

    /**
     * Remove a task from the array and return true
     * if the task was in the array
     * @param task task to be removed
     * @return true if the task was in the array
     */
    @Override
    public boolean remove(Task task) {

        Task arrayTask2[] = new Task[arrayTask.length];
        boolean taskInList = false;
        int k = 0;
        for (int i = 0, j = 0; i < arrayTask.length; i++) {
            if(task.title == arrayTask[i].title
            && (task.time == arrayTask[i].time || task.start == arrayTask[i].start)) {
                taskInList = true;
                k++;
                continue;
            }
             arrayTask2[j++] = arrayTask[i];
        }
        this.arrayTask = Arrays.copyOf(arrayTask2,arrayTask.length - k);
        return taskInList;
    }

    /**
     * Method that tell the number of the tasks in the array
     * @return the number of the tasks
     */
    @Override
    public int size() {

        return arrayTask.length;
    }

    /**
     * Method that returns the specified task from the array
     * @param index Element to be returned from the array
     * @return The object in the specified index
     */
    @Override
    public Task getTask(int index) {

        if(index < arrayTask.length && index >= 0){
            return arrayTask[index];
        }
        throw new IndexOutOfBoundsException("Index out of range");
    }

    /**
     * Iterator for each element of the Array
     * @return true if the specified element is in the array
     */
    @Override
    public Iterator<Task> iterator() {
        return new iterator();
    }

    public class iterator implements Iterator<Task> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public Task next() {
            cursor++;
            return getTask(cursor - 1);
        }
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
        ArrayTaskList integers = (ArrayTaskList) o;
        return n == integers.n && Arrays.equals(arrayTask, integers.arrayTask);
    }

    /**
     * Method that returns the hash code of the array
     * @return The hash code
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(n);
        result = 31 * result + Arrays.hashCode(arrayTask);
        return result;
    }

    /**
     * Method that writes in console the array of tasks
     * @return The String of Arrays
     */
    @Override
    public String toString() {
        return "ArrayTaskList{" +
                "n=" + n +
                ", arrayTask=" + Arrays.toString(arrayTask) +
                '}';
    }

    /**
     * Method that creates a copy of the current Array
      */
    public void copy() {
        Task[] copy = Arrays.copyOf(arrayTask,arrayTask.length);
    }
}