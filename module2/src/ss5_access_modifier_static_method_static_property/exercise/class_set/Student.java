package ss5_access_modifier_static_method_static_property.exercise.class_set;

public class Student {
    private String name = "John";
    private String classes = "C02";

    public void setClasses(String classes) {
        this.classes = classes;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
