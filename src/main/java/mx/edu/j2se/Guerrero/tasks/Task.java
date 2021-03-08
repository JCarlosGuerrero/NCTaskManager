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

    /**
     * Constructs an inactive task to run at a specified time
     * @param title Name of the Task
     * @param time  Specified time to run
     */
    public Task(String title, int time) {
        if(time < 0) {
            throw new IllegalArgumentException("Time cannot be negative");
        }
        this.title = title;
        this.time = time;
    }

    /** Constructor
     * Constructs an inactive task to run at a specific time
     * range with repetition interval
     * @param title Name of the task
     * @param start Start time of the task
     * @param end End time of the task
     * @param interval number of repetitions
     */
    public Task(String title, int start, int end, int interval) {
        if(end < start || interval < 1) {
            throw new IllegalArgumentException("End time cannot be smaller than " +
                    "start time, interval must be positive");
        }
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
    }


    /**
     * Get the title of the task
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the task
     * @param title new name for the task
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Check the status of the task
     * @return If the task is active or not
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Set the status of the task
     * @param active Set if you want to activate or not the task
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Method to check the time of a non-repetitive task
     * If repetitive: return start time
     * @return the time of the task
     */
    public int getTime() {
        if (isRepeated()) {
            return start;
        } else {
            return time;
        }
    }

    /**
     * Method for setting the time of a non-repetitive task
     * If repetitive: It should become non-repetitive
     * @param time the new time for the task
     */
    public void setTime(int time) {
        if(time < 0) {
            throw new IllegalArgumentException("Time cannot be negative");
        }
        if (isRepeated()) {
            this.time = time;
            this.start = 0;
            this.end = 0;
            this.interval = 0;
        } else {
            this.time = time;
        }
    }

    /**
     * Method to get the start time of a repetitive task
     * If non-repetitive: return the time of the task
     * @return the time of the task
     */
    public int getStartTime() {
        if (isRepeated()) {
            return start;
        } else {
            return time;
        }
    }

    /**
     * Method to get the end time of a repetitive task
     * If non-repetitive: return the time of the task
     * @return the time of the task
     */
    public int getEndTime() {
        if (isRepeated()) {
            return end;
        } else {
            return time;
        }
    }

    /**
     * Method to get the repetition interval of a
     * repetitive task.
     * If non-repetitive: return 0
     * @return the repetition interval
     */
    public int getRepeatInterval() {
        if (isRepeated()) {
            return interval;
        } else {
            return 0;
        }
    }

    /**
     * Method to set the interval, start and end
     * time of a repetitive task.
     * If non-repetitive: It should become repetitive
     * @param start start time of the task
     * @param end end time of the task
     * @param interval repetition interval of the task
     */
    public void setTime(int start, int end, int interval) {
        if(end < start || interval < 1) {
            throw new IllegalArgumentException("End time cannot be smaller than" +
                    "start time, interval must be positive");
        }
        if (isRepeated()) {
            this.start = start;
            this.end = end;
            this.interval = interval;
        } else {
            this.time = 0;
            this.start = start;
            this.end = end;
            this.interval = interval;
        }
    }

    /**
     * Check the task repeatability
     * @return if is a repetitive task
     */
    public boolean isRepeated() {
        return interval > 0;
    }

    /**
     * Check the next task time execution,
     * if it's active and repeatability
     * @param current current moment for
     *                the next task time execution
     * @return
     */
    public int nextTimeAfter(int current) {
        if(isActive()) {
            if(isRepeated() && current <= start) {
                return start;
            } else if(isRepeated() && current <= end && current > start) {
                return (end - start) / interval;
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