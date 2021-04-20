package mx.edu.j2se.Guerrero.tasks.tests;

import mx.edu.j2se.Guerrero.tasks.ArrayTaskList;
import mx.edu.j2se.Guerrero.tasks.LinkedTaskList;
import mx.edu.j2se.Guerrero.tasks.Task;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Iterator;

public class LinkedTaskListTest {

    @Test
    public void linkedTest() {
        Task objeto1 = new Task("correr", LocalDateTime.of(1996,1,10,13,30));
        objeto1.setActive(true);
        Task objeto2 = new Task("correr",LocalDateTime.of(1996,1,10,13,30),LocalDateTime.of(1996,11,8,13,30),LocalDateTime.of(0,1,2,0,0));
        objeto2.setActive(true);

        LinkedTaskList objeto3 = new LinkedTaskList();
        objeto3.add(objeto1);
        objeto3.add(objeto2);
        Assert.assertEquals(2,objeto3.size());
        System.out.println(objeto3);
        objeto3.remove(objeto2);
        System.out.println(LinkedTaskList.count);
        objeto3.add(objeto2);
        objeto3.add(objeto2);
        objeto3.add(objeto2);
        Assert.assertEquals(4,objeto3.size());
        objeto3.remove(objeto2);
        System.out.println(objeto3.getTask(0));
        objeto3.add(objeto2);
        Iterator<Task> i = objeto3.iterator();
        Assert.assertTrue(i.hasNext());
        Assert.assertEquals(i.next(),objeto1);
    }
}
