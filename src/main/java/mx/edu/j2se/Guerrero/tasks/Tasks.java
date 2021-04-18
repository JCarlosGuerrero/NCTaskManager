package mx.edu.j2se.Guerrero.tasks;

import java.time.LocalDateTime;
import java.util.*;

public class Tasks {

    /**
     * Method that tells you if there are tasks in the specified interval
     * @param tasks Tasks to be added
     * @param start Start of the interval
     * @param end End of the interval
     * @return The tasks that are in the interval
     */
    public static final Iterable<Task> incoming(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end) {


        AbstractTaskList taskList = TaskListFactory.createTaskList(tasks instanceof LinkedTaskList ? ListTypes.types.LINKED : ListTypes.types.ARRAY);

        tasks.forEach(task-> {
            if (task.nextTimeAfter(start).isBefore(end)) {
                taskList.add(task);
            }
        }); return taskList;
    }

    /**
     * Method that orders the tasks
     * @param tasks tasks to be ordered
     * @param start parameter that functions as key to order
     * @param end parameter that functions also as key to order
     * @return The tasks ordered by start time
     */
    public static SortedMap<LocalDateTime, Set<Task>> calendar(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end) {

        SortedMap<LocalDateTime, Set<Task>> sm = new TreeMap<LocalDateTime,Set<Task>>();

        LocalDateTime finalStart = start;
        tasks.forEach(task -> {
            if (task.nextTimeAfter(finalStart).isBefore(end)) {
                Set<Task> setTask = new HashSet<>();
                setTask.add(task);
                sm.put(finalStart, setTask);
            }
        });
        return sm;
    }
}