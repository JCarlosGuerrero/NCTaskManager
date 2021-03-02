package mx.edu.j2se.Guerrero.tasks;

import java.util.Arrays;

public class ArrayTaskList {

    int n = 2;  //XXX Como iniciar n
    Task arrayTask[] = new Task[n]; //arreglo tipo object

    public void add(Task task){

        Task arrayTask2[] = new Task[arrayTask.length + 1];
        int i;
        for(i =0; i < arrayTask.length; i++ ) {
            arrayTask2[i] = arrayTask[i];
        }
        arrayTask2[i] = task;
        this.arrayTask = arrayTask2;
    }

    public boolean remove(Task task) {

        Task arrayTask2[] = new Task[arrayTask.length];
        boolean taskInList = false;
        int k = 0;
        for (int i = 0, j = 0; i < arrayTask.length; i++) {
            if(task.title.equals(arrayTask[i].title)) {
                taskInList = true;
                k++;
                continue;
            }
             arrayTask2[j++] = arrayTask[i];
        }
        this.arrayTask = Arrays.copyOf(arrayTask2,arrayTask.length - k);
        return taskInList;
    }

    public int size() {
        return arrayTask.length;
    }

    public Task getTask(int index) {
        if(index < arrayTask.length && index >= 0){
            return arrayTask[index];
        }
        System.out.println("Out of range");
        return null;
    }
}