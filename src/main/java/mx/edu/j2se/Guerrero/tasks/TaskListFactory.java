package mx.edu.j2se.Guerrero.tasks;

    public class TaskListFactory {

        /**
         * Static method that creates an array or a list of the specified enum type
         * @param type array or linked list
         * @return Array or List
         */
        public static AbstractTaskList createTaskList(ListTypes.types type) {

            for (ListTypes.types types : ListTypes.types.values()) {
                switch (types) {
                    case ARRAY:
                        AbstractTaskList array = new ArrayTaskList();
                        return array;

                    case LINKED:
                        AbstractTaskList list = new LinkedTaskList();
                        return list;

                    default: return null;
                }
            } return null;
        }
    }