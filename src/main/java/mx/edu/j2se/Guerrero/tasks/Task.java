package mx.edu.j2se.Guerrero.tasks;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * Practical work No. 1 Project Structure
 * @version 1 17 02 2021
 * @author JoséCarlos
 */

public class Task implements Cloneable {

    String          title;
    LocalDateTime   time;
    LocalDateTime   start;
    LocalDateTime   end;
    LocalDateTime   interval;
    boolean active;

    /**
     * Constructs an inactive task to run at a specified time
     * @param title Name of the Task
     * @param time  Specified time to run
     */
    public Task(String title, LocalDateTime time) {
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
    public Task(String title, LocalDateTime start, LocalDateTime end, LocalDateTime interval) {
        if(end.isBefore(start)) {
            throw new IllegalArgumentException("End time cannot be smaller than start time");
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
    public LocalDateTime getTime() {
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
    public void setTime(LocalDateTime time) {
        if (isRepeated()) {
            this.time = time;
            this.start = null;
            this.end = null;
            this.interval = null;
        } else {
            this.time = time;
        }
    }

    /**
     * Method to get the start time of a repetitive task
     * If non-repetitive: return the time of the task
     * @return the time of the task
     */
    public LocalDateTime getStartTime() {
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
    public LocalDateTime getEndTime() {
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
    public LocalDateTime getRepeatInterval() {
        if (isRepeated()) {
            return interval;
        } else {
            return null;
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
    public void setTime(LocalDateTime start, LocalDateTime end, LocalDateTime interval) {
        if(end.isBefore(start)) {
            throw new IllegalArgumentException("End time cannot be smaller than start time");
        }
        if (isRepeated()) {
            this.start = start;
            this.end = end;
            this.interval = interval;
        } else {
            this.time = null;
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
        return !interval.isEqual( null);
    }

    /**
     * Check the next task time execution,
     * if it's active and repeatability
     * @param current current moment for
     *                the next task time execution
     * @return
     */
    public LocalDateTime nextTimeAfter(LocalDateTime current) {
        if(isActive()) {
            if(isRepeated() && current.isBefore(start)) {
                return start;
            } else if(isRepeated() && current.isBefore(end) && current.isAfter(start)) {
                LocalDateTime intervalos = start;
                while (intervalos.isBefore(current)) {
                    intervalos.plusHours(interval.getHour());
                }
                return (intervalos.isAfter(end)) ? end : intervalos;
            } else if(!isRepeated() && current.isBefore(time)) {
                return time;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Method that returns true if two objects are the same
     * @param o Object Task to compare
     * @return True if the Tasks are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return time == task.time && start == task.start && end == task.end && interval == task.interval && active == task.active && Objects.equals(title, task.title);
    }

    /**
     * Method that returns the hash code of the Task
     * @return The hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, time, start, end, interval, active);
    }

    /**
     * Method that writes in console the Tasks
     * @return The String of tasks
     */
    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", time=" + time +
                ", start=" + start +
                ", end=" + end +
                ", interval=" + interval +
                ", active=" + active +
                '}';
    }

    /**
     * Method to copy a Task
     * @return The copy of the Task
     * @throws CloneNotSupportedException
     */
    public Object copy() throws CloneNotSupportedException {
        return super.clone();
    }
}