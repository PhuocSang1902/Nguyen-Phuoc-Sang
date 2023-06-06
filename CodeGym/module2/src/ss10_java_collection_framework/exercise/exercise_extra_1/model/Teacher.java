package ss10_java_collection_framework.exercise.exercise_extra_1.model;

public class Teacher extends Person implements Comparable<Teacher> {
    private String speciality;

    public Teacher() {
    }

    public Teacher(String speciality) {
        this.speciality = speciality;
    }

    public Teacher(String code, String name, Boolean gender, String speciality) {
        super(code, name, gender);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return super.toString() + ", speciality is " + this.speciality;
    }

    public String info() {
        return super.info() + "," + this.speciality;
    }

    @Override
    public int compareTo(Teacher o) {
        if (this.getName().compareTo(o.getName()) != 0) {
            return this.getName().compareTo(o.getName());
        }

        return this.getCode().compareTo(o.getCode());

    }
}
