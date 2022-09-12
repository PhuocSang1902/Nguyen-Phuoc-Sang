package ss5_access_modifier_static_method_static_property.practice.static_method;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();
        Student s1 = new Student(1, "phuong");
        Student s2 = new Student(2, "dat");
        Student s3 = new Student(3, "tan");
        s1.display();
        s2.display();
        s3.display();
    }
}
