package ss4_class_and_object.exercise.Lesson3Fan;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private double radius = 5;
    private int speech = SLOW;
    private boolean status = false;
    private String color = "blue";

    Fan() {

    }

    @Override
    public String toString() {
        if (this.status) {
            return "Fan{" +
                    ", radius=" + radius +
                    ", speech=" + speech +
                    ", color='" + color + '\'' +
                    ", Status is on}";
        }
        return "Fan{" +
                ", radius=" + radius +
                ", speech=" + speech +
                ", color='" + color + '\'' +
                ", Status is off}";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getSpeech() {
        return speech;
    }

    public void setSpeech(int speech) {
        this.speech = speech;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
