package mx.edu.j2se.Guerrero.tasks;

/**
 * Practical work No. 1 Project Structure
 * @version 1 17 02 2021
 * @author JoséCarlos
 */
public class Task {

    String  title;
    int     time;
    int     start;
    int     end;
    int     interval;
    boolean active;

    // Constructors
    public Task(String title, int time) {
        this.title = title;
        this.time = time;
    }
    public Task(String title, int start, int end, int interval) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    //Methods for reading and setting the task name
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //Methods for reading and setting the task status
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    //Methods for reading and changing execution time for non-repetitive tasks
    public int getTime() {
        if (isRepeated()) {
            return start;
        } else {
            return time;
        }
    }

    public void setTime(int time) {
        if (isRepeated()) {
            this.start = time;
            this.end = time;
            this.interval = 0;
        } else {
            this.time = time;
        }
    }

    //Methods for reading and changing execution time for repetitive tasks
    public int getStartTime() {
        if (isRepeated()) {
            return start;
        } else {
            return time;
        }
    }

    public int getEndTime() {
        if (isRepeated()) {
            return end;
        } else {
            return time;
        }
    }

    public int getRepeatInterval() {
        if (isRepeated()) {
            return interval;
        } else {
            return 0;
        }
    }

    public void setTime(int start, int end, int interval) {
        if (!isRepeated()) {
            this.time = 0;
        } else {
            this.start = start;
            this.end = end;
            this.interval = interval;
        }
    }

    public boolean isRepeated() {
        return interval > 0;
    }

    public int nextTimeAfter(int current) {
        if(isActive()) {
            if(isRepeated() && current <= start) {
                return start;
            } else if(isRepeated() && current <= end && current > start) {
                return start = start + interval;
            } else if(!isRepeated() && current <= time) {
                return time;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}