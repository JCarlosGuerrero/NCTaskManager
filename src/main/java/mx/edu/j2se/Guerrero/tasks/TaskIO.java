package mx.edu.j2se.Guerrero.tasks;

import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TaskIO {

    /**
     * Write the tasks from the list to the stream in a binary format
     * @param tasks list of tasks
     * @param out where tasks are written
     * @throws IOException
     */
    public static void write(AbstractTaskList tasks, OutputStream out) throws IOException {

        DataOutput data = new DataOutputStream(out);
        data.write(tasks.size());
        tasks.forEach(task -> {
            try {
                data.write(task.getTitle().length());
                data.writeChars(task.getTitle());
                data.writeBoolean(task.isActive());
                data.writeBoolean(task.isRepeated());

                if (task.isRepeated()) {
                    data.writeInt(Integer.parseInt(task.getRepeatInterval().toString()));
                    data.writeInt(Integer.parseInt(task.getStartTime().toString()));
                    data.writeInt(Integer.parseInt(task.getEndTime().toString()));
                } else {
                    data.writeInt(Integer.parseInt(task.getTime().toString()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        out.close();
    }

    /**
     * Read tasks from the stream to the current task list
     * @param tasks list of tasks
     * @param in where tasks are read
     */
    public static void read(AbstractTaskList tasks, InputStream in) throws IOException {

        DataInput data = new DataInputStream(in);

        int size = data.readInt();
        for (int i = 0; i < size; i++) {
            int length = data.readInt();
            String title = null;
            for (int j = 0; j < length; j++) {
                title = String.valueOf(data.readChar());
            }
            boolean isActive = data.readBoolean();
            boolean isRepeated = data.readBoolean();
            Task newTask;
            if (isRepeated) {
                String intervalTemp = String.valueOf(data.readInt());
                String startTemp = String.valueOf(data.readInt());
                String endTemp = String.valueOf(data.readInt());
                LocalDateTime interval = LocalDateTime.parse(intervalTemp);
                LocalDateTime start = LocalDateTime.parse(startTemp);
                LocalDateTime end = LocalDateTime.parse(endTemp);
                newTask = new Task(title,start,end,interval);
            } else {
                String timeTemp = String.valueOf(data.readInt());
                LocalDateTime time = LocalDateTime.parse(timeTemp);
                newTask = new Task(title,time);
            }
            newTask.setActive(isActive);
            tasks.add(newTask);
        }
        in.close();
    }

    /**
     * writes tasks from the list to the file
     * @param tasks tasks to be written in the file
     * @param file where the tasks are written
     */
    public static void writeBinary(AbstractTaskList tasks, File file) throws IOException {

        OutputStreamWriter outputStream = new FileWriter(file);
        outputStream.write(tasks.size());
        tasks.forEach(task -> {
            try {
                outputStream.write(task.getTitle().length());
                outputStream.write(task.getTitle());
                outputStream.write(task.isActive() ? 1 : 0);
                outputStream.write(task.isRepeated() ? 1 : 0);
                if (task.isRepeated()) {
                    outputStream.write(task.getRepeatInterval().toString());
                    outputStream.write(task.getStartTime().toString());
                    outputStream.write(task.getEndTime().toString());
                } else {
                    outputStream.write(task.getTime().toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        outputStream.close();
    }

    /**
     * reads tasks from the file to the task list
     * @param tasks tasks to be read from the file
     * @param file where the tasks are saved
     */
    public static void readBinary(AbstractTaskList tasks, File file) throws IOException {

        InputStreamReader inputStream = new FileReader(file);
        int size = inputStream.read();
        for (int i = 0; i < size; i++) {
            int length = inputStream.read();
            String title = null;
            for (int j = 0; j < length; j++) {
                title = String.valueOf(inputStream.read());
            }
            boolean isActive = inputStream.read() == 1;
            boolean isRepeated = inputStream.read() == 1;
            Task newTask;
            if (isRepeated) {
                String intervalTemp = String.valueOf(inputStream.read());
                String startTemp = String.valueOf(inputStream.read());
                String endTemp = String.valueOf(inputStream.read());
                LocalDateTime interval = LocalDateTime.parse(intervalTemp);
                LocalDateTime start = LocalDateTime.parse(startTemp);
                LocalDateTime end = LocalDateTime.parse(endTemp);
                newTask = new Task(title,start,end,interval);
            } else {
                String timeTemp = String.valueOf(inputStream.read());
                LocalDateTime time = LocalDateTime.parse(timeTemp);
                newTask = new Task(title,time);
            }
            newTask.setActive(isActive);
            tasks.add(newTask);
        }
        inputStream.close();
    }

    /**
     * Writes tasks from the list to the stream in the JSON format
     * @param tasks list of tasks
     * @param out stream writing of tasks
     */
    public static void write(AbstractTaskList tasks, Writer out) throws IOException {
        Gson gson = new Gson();

        String representationJson = null ;
        for (int i = 0; i < tasks.size(); i++) {
            representationJson = gson.toJson(tasks.getTask(i));
        }
        out.write(representationJson);
        out.close();
    }

    /**
     * Reads tasks from the stream to the list
     * @param tasks list of the tasks
     * @param in stream reading of tasks
     */
    public static void read(AbstractTaskList tasks, Reader in) throws IOException {

        try {
            Gson gson = new Gson();
            for (int i = 0; i < tasks.size(); i++) {
                Task x = gson.fromJson(in,Task.class);
                tasks.add(x);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes tasks to the file in JSON format
     * @param tasks tasks to be written
     * @param file where the tasks are gonna be written
     * @throws IOException
     */
    public static void writeText(AbstractTaskList tasks, File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        Gson gson = new Gson();
        for (int i = 0; i < tasks.size(); i++) {
            String aux = gson.toJson(tasks.getTask(i));
            fileWriter.write(aux);
        }
        fileWriter.close();
    }

    /**
     * Reads tasks from the file
     * @param tasks tasks that are in the file
     * @param file where the tasks are stored
     */
    public static void readText(AbstractTaskList tasks, File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        try {
            Gson gson = new Gson();
            for (int i = 0; i < tasks.size(); i++) {
                Task x = gson.fromJson(fileReader, Task.class);
                tasks.add(x);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        fileReader.close();
    }
}