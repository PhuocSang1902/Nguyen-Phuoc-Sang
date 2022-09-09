package ss4_class_and_object.exercise.Lesson3Fan;

public class MainFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setSpeech(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setStatus(true);
        fan2.setStatus(false);
        fan2.setSpeech(fan2.MEDIUM);
        System.out.println(fan1);
        System.out.println(fan2);
    }
}
