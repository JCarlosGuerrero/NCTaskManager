package mx.edu.j2se.Guerrero.tasks.tests;

import mx.edu.j2se.Guerrero.tasks.AbstractTaskList;
import mx.edu.j2se.Guerrero.tasks.ArrayTaskList;
import mx.edu.j2se.Guerrero.tasks.LinkedTaskList;
import mx.edu.j2se.Guerrero.tasks.Task;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class AbstractTaskListTest {

    @Test
    public void AbstractTest() {

        Task objeto1 = new Task("correr", LocalDateTime.of(1996,1,10,13,30));
        objeto1.setActive(true);
        Task objeto2 = new Task("correr",LocalDateTime.of(1996,1,10,13,30),LocalDateTime.of(1996,11,8,13,30),LocalDateTime.of(0,1,2,0,0));
        objeto2.setActive(true);

        AbstractTaskList objeto3 = new ArrayTaskList();
        AbstractTaskList objeto4 = new LinkedTaskList();

        objeto3.add(objeto1);
        objeto4.add(objeto1);

        Assert.assertEquals(1,objeto3.size());
        Assert.assertEquals(1,objeto4.size());

        System.out.println(objeto3.getStream());
        System.out.println(objeto4.getStream());
    }
}
