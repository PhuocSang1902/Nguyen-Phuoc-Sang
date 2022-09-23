package ss10_java_collection_framework.exercise.exercise_extra_1.model;

public class Student extends Person implements Comparable<Student> {
    private String nameClass;
    private double point;

    public Student() {
    }

    public Student(String nameClass, double point) {
        this.nameClass = nameClass;
        this.point = point;
    }

    public Student(String code, String name, Boolean gender, String nameClass, double point) {
        super(code, name, gender);
        this.nameClass = nameClass;
        this.point = point;
    }

    public String getNameClass() {
        return this.nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public double getPoint() {
        return this.point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return super.toString() + ", name class is " + this.nameClass + ", point is " + this.point;
    }


    @Override
    public int compareTo(Student o) {
        if (this.getName().compareTo(o.getName()) != 0) {
            return this.getName().compareTo(o.getName());
        }

            return this.getCode().compareTo(o.getCode());

    }
}
