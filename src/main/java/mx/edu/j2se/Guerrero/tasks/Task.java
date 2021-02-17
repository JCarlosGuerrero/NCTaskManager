package mx.edu.j2se.Guerrero.tasks;

public class Task {

        String title;
        int time;
        int start;
        int end;
        int interval;
        boolean active;
        int current;

        //Constructors
        public Task(String title, int time){

        }
        public Task(String title, int start, int end, int interval) {

        }

        //Methods for reading and setting the task name
        public String getTitle(){
            return title;    
        }
        public void setTitle(String title) {
            this.title = title;
        }

        //Methods for reading and setting the task status
        public boolean isActive() {
        if (active) {
            System.out.println("Esta activado");
        } else {
            System.out.println("No esta activado");
        } return active;
        }
        public void setActive(boolean active) {
            this.active = active;
        }

        //Methods for reading and changing execution time for non-repetitive tasks
        public int getTime() {
            if (isRepeated()){
                return start;
            }else {
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
            if (isRepeated()){
                return start;
            } else {
                this.time = start;
                return time;
            }
        }
        public int getEndTime() {
            if (isRepeated()){
                return end;
            } else {
                this.time = end;
                return time;
            }
        }
        public int getRepeatInterval() {
            if (isRepeated()){
                return interval;
            } else {
                return 0;
            }
        }
        public void setTime(int start, int end, int interval) {
            if(isRepeated()){
                this.start = start;
                this.end = end;
                this.interval = interval;
            } else {
                this.time = 0;
                this.start=start;
                this.end = end;
                this.interval = interval;
            }
        }
        public boolean isRepeated() {
            if(interval != 0) {
                return true;
            } else {
                return false;
            }
        }
        public int nextTimeAfter(int current) {
         if(current > this.end){
             return start;
         } else {
             return -1;
         }
        }
    }