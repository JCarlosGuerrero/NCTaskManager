package mx.edu.j2se.Guerrero.tasks;

import java.util.Arrays;

public class ArrayTaskList {

    int n = 2;  //XXX Como iniciar n
    Task arrayTask[] = new Task[n]; //arreglo tipo object

    /**
     * Method to add a task to the array
     * @param task task to be added to the array
     */
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
    public boolean remove(Task task) {

        Task arrayTask2[] = new Task[arrayTask.length];
        boolean taskInList = false;
        int k = 0;
        for (int i = 0, j = 0; i < arrayTask.length; i++) {
            if(task.title.equals(arrayTask[i].title)
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
    public int size() {

        return arrayTask.length;
    }

    /**
     * Method that returns the specified task from the array
     * @param index Element to be returned from the array
     * @return The object in the specified index
     */
    public Task getTask(int index) {

        if(index < arrayTask.length && index >= 0){
            return arrayTask[index];
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
    public ArrayTaskList incoming(int from, int to) {

        ArrayTaskList selection = new ArrayTaskList();
        for (int i = 0;i < arrayTask.length; i++) {
            if(arrayTask[i].active) {
                if(arrayTask[i].start >= from && arrayTask[i].end <= to
                || arrayTask[i].time >= from && arrayTask[i].time <= to) {
                    selection.add(arrayTask[i]);
                }
            }
        }
        Task arrayTask2[] = new Task[arrayTask.length];
        int k = 0;
        for (int i = 0, j = 0;i < selection.arrayTask.length; i++) {
            if(selection.arrayTask[i] != null){
                arrayTask2[j++] = selection.arrayTask[i];
                k++;
            }
        }
        selection.arrayTask = Arrays.copyOf(arrayTask2, k);
        return selection;
    }
}