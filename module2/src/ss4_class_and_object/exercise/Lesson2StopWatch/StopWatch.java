package ss4_class_and_object.exercise.Lesson2StopWatch;

public class StopWatch {
    long startTime;
    long endTime;
    StopWatch(){
    }
    public void start(){
        this.startTime = System.currentTimeMillis();
    }
    public void stop(){
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return this.endTime - this.startTime;
    }
}
