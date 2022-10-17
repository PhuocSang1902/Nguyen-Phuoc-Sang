package model;

public class Student extends Person {
    private String className;
    private double point;

    public Student() {
    }

    public Student(String code, String name, String birthday, String gender) {
        super(code, name, birthday, gender);
    }

    public Student(String code, String name, String birthday, String gender, String className, double point) {
        super(code, name, birthday, gender);
        this.className = className;
        this.point = point;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                ", className='" + className + '\'' +
                ", point=" + point +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s", super.getCode(), super.getName(), super.getBirthday(), super.getGender(), this.getClassName(), this.getPoint());
    }
}
