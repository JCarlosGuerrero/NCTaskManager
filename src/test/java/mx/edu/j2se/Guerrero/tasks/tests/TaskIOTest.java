package mx.edu.j2se.Guerrero.tasks.tests;

import mx.edu.j2se.Guerrero.tasks.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class TaskIOTest {

    @Test
    public void IOTest() throws IOException {
        Task objeto1 = new Task("correr", LocalDateTime.of(1996,1,10,13,30));
        objeto1.setActive(true);
        Task objeto2 = new Task("nadar",LocalDateTime.of(1996,10,10,13,30),LocalDateTime.of(1996,11,8,13,30),LocalDateTime.of(0,1,2,0,0));
        objeto2.setActive(true);

        AbstractTaskList list = TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        list.add(objeto1);
        list.add(objeto2);

        AbstractTaskList anotherList = TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        File file = new File("C:\\NCTaskManager\\prueba.txt");
        TaskIO.writeBinary(list,file);
        TaskIO.readBinary(anotherList,file);    //LocalDateTime parse no funciona adecuadamente, tratar de usar epoch
    }

}
