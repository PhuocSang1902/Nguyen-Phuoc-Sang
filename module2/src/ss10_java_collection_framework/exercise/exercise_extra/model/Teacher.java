package ss10_java_collection_framework.exercise.exercise_extra.model;

public class Teacher extends Person {
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
}
