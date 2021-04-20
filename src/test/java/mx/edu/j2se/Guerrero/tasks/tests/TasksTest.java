package mx.edu.j2se.Guerrero.tasks.tests;

import mx.edu.j2se.Guerrero.tasks.*;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;

public class TasksTest {

    @Test
    public void TasksTesT(){

        Task objeto1 = new Task("correr", LocalDateTime.of(1996,1,10,13,30));
        objeto1.setActive(true);
        Task objeto2 = new Task("nadar",LocalDateTime.of(1996,10,10,13,30),LocalDateTime.of(1996,11,8,13,30),LocalDateTime.of(0,1,2,0,0));
        objeto2.setActive(true);

        AbstractTaskList list = TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        list.add(objeto1);
        list.add(objeto2);

        Iterable<Task> tasks = list;
        LocalDateTime start = LocalDateTime.of(1996,1,1,0,0);
        LocalDateTime end = LocalDateTime.of(1996,12,31,0,0);
        System.out.println(Tasks.incoming(list,start,end));
        LocalDateTime end2 = LocalDateTime.of(1996,5,10,0,0);
        System.out.println(Tasks.incoming(list,start,end2));
        System.out.println(Tasks.calendar(list,start,end));

        SortedMap<LocalDateTime,Set<Task>> sm = Tasks.calendar(list,start,end);

        Set s = sm.entrySet();
        Iterator i = s.iterator();

        while (i.hasNext()) {
            System.out.println(sm);
        }
    }
}
