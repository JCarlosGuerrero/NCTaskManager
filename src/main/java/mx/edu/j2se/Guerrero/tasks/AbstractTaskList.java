package mx.edu.j2se.Guerrero.tasks;

import java.util.Iterator;
import java.util.stream.Stream;

abstract class AbstractTaskList implements Iterable<Task> {

    /**
         * Abstract method that adds a Task to an array or list
         * @param task Task to be added
         */
        public abstract void add(Task task);

        /**
         * Abstract method that removes a Task of an array or list
         * @param task Task to be removed
         * @return True if the task was in the array or list
         */
        public abstract boolean remove(Task task);

        /**
         * Abstract method that tells the number of tasks in the array or list
         * @return The number of tasks
         */
        public abstract int size();

        /**
         * Abstract method that returns the specified task in the array or list
         * @param index Number of the element to be returned
         * @return The specified task
         */
        public abstract Task getTask(int index);

        /**
         * Abstract method  that allows to work with collections as with the streams
         * @return the stream
         */

        /**
         * Iterator for each element of the lists or Arrays
         * @return true if the specified element is in the list or array
         */
        public abstract Iterator<Task> iterator();
    }