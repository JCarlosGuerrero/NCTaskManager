package mx.edu.j2se.Guerrero.tasks.tests;

import mx.edu.j2se.Guerrero.tasks.Task;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class TaskTest {

    @Test
    public void nonRepetitiveConstructorTest() throws Exception{
        Task objeto1 = new Task("correr", LocalDateTime.of(1996,1,10,13,30));
        Assert.assertFalse(objeto1.isActive());
        objeto1.setActive(true);
        Assert.assertTrue(objeto1.isActive());
        Assert.assertEquals("correr",objeto1.getTitle());
        objeto1.setTitle("nadar");
        Assert.assertEquals("nadar",objeto1.getTitle());
        Assert.assertFalse(objeto1.isRepeated());
        Assert.assertEquals(LocalDateTime.of(1996,1,10,13,30),objeto1.getTime());
        objeto1.setTime(LocalDateTime.of(1996,11,8,13,30));
        Assert.assertNotEquals(LocalDateTime.of(1996,1,10,13,30),objeto1.getTime());
        Assert.assertEquals(objeto1.getTime(),objeto1.nextTimeAfter(LocalDateTime.of(1996,1,5,13,30)));

        System.out.println(objeto1.copy());
    }

    @Test
    public void RepetitiveConstrutorTest() throws Exception{
        Task objeto2 = new Task("correr",LocalDateTime.of(1996,1,10,13,30),LocalDateTime.of(1996,11,8,13,30),LocalDateTime.of(0,1,2,0,0));
        Assert.assertFalse(objeto2.isActive());
        objeto2.setActive(true);
        Assert.assertTrue(objeto2.isActive());
        Assert.assertEquals("correr",objeto2.getTitle());
        objeto2.setTitle("nadar");
        Assert.assertEquals("nadar",objeto2.getTitle());
        Assert.assertTrue(objeto2.isRepeated());
        Assert.assertEquals(LocalDateTime.of(1996,1,10,13,30),objeto2.getStartTime());
        Assert.assertEquals(LocalDateTime.of(1996,11,8,13,30),objeto2.getEndTime());
        Assert.assertEquals(LocalDateTime.of(0,1,2,0,0),objeto2.getRepeatInterval());
        Assert.assertEquals(LocalDateTime.of(1996,5,3,13,30),objeto2.nextTimeAfter(LocalDateTime.of(1996,5,2,0,0)));

        System.out.println(objeto2.copy());
    }

}
