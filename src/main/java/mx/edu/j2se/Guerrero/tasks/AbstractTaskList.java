package mx.edu.j2se.Guerrero.tasks;

import java.util.Iterator;

    abstract class AbstractTaskList implements Iterable<Task> {

        /**
         * Abstract method that adds a Task to an array or list
         * @param task Task to be added
         */
        abstract void add(Task task);

        /**
         * Abstract method that removes a Task of an array or list
         * @param task Task to be removed
         * @return True if the task was in the array or list
         */
        abstract boolean remove(Task task);

        /**
         * Abstract method that tells the number of tasks in the array or list
         * @return The number of tasks
         */
        abstract int size();

        /**
         * Abstract method that returns the specified task in the array or list
         * @param index Number of the element to be returned
         * @return The specified task
         */
        abstract Task getTask(int index);

        /**
         * Abstract method that tells you if there are tasks in the specified interval
         * @param from Start of the interval
         * @param to End of the interval
         * @return An array or a list of the tasks in the interval
         */
        abstract AbstractTaskList incoming(int from, int to);

        /*
        public Iterator<AbstractTaskList> iterator(){
            return this.iterator();
        }
        */

        /**
         * Iterator for each element of the lists or Arrays
         * @return true if the specified element is in the list or array
         */
        @Override
        public Iterator<Task> iterator() {
            //posibles variables
            Iterator<Task> i = new Iterator<Task>() {
                @Override
                public boolean hasNext() {
                    return false; //if sentence
                }

                @Override
                public Task next() {
                    return null; //posible adicion ++
                }
            };
            return i;
        }
    }

    class ListTypes {

        public enum types { ARRAY, LINKED }

    }

    class TaskListFactory {

        /**
         * Static method that creates an array or a list of the specified enum type
         * @param type array or linked list
         * @return Array or List
         */
        static AbstractTaskList createTaskList(ListTypes.types type) {

            AbstractTaskList array = new ArrayTaskList();
            AbstractTaskList list = new ArrayTaskList();

            for (ListTypes.types types : ListTypes.types.values()) {
                switch (types) {
                    case ARRAY: return array;

                    case LINKED: return list;

                    default: return null;
                }
            } return null;
        }
    }