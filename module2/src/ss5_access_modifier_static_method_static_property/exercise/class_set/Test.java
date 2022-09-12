package ss5_access_modifier_static_method_static_property.exercise.class_set;

public class Test {
    public static void main(String[] args) {
        Student st1 = new Student();
        Student st2 = new Student();
        Student st3 = new Student();

        st1.setName("Phuong");
        st1.setClasses("C07");
        st2.setName("Tan");
        st2.setClasses("C08");
        System.out.println(st1.toString());
        System.out.println(st2.toString());
        System.out.println(st3.toString());
    }
}
