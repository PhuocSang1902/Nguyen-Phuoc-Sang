package model;

public class Teacher extends Person {
    private String speciality;

    public Teacher() {
    }

    public Teacher(String code, String name, String birthday, String gender) {
        super(code, name, birthday, gender);
    }

    public Teacher(String code, String name, String birthday, String gender, String speciality) {
        super(code, name, birthday, gender);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                super.toString() +
                ", speciality='" + speciality + '\'' +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s", super.getCode(), super.getName(), super.getBirthday(), super.getGender(), this.speciality);
    }
}
