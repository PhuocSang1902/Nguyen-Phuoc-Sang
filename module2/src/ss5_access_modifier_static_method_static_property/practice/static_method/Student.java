package ss5_access_modifier_static_method_static_property.practice.static_method;

public class Student {
    private final int rollno;
    private final String name;
    private static String collage = "BBDIT";

    Student (int r, String name){
        this.rollno = r;
        this.name = name;
    }
    static void change(){
        collage = "CODEGYM";
    }
    void display(){
        System.out.println(rollno + " "+ name + " " + collage);
    }
}
