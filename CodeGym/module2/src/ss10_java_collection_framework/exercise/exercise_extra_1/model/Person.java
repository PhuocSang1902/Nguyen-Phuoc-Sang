package ss10_java_collection_framework.exercise.exercise_extra_1.model;

public abstract class Person {
    private String code;
    private String name;
    private Boolean gender;

    public Person() {
    }

    public Person(String code, String name, Boolean gender) {
        this.code = code;
        this.name = name;
        this.gender = gender;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender(Boolean gender) {
        return this.gender = gender;
    }

    public void setGender(String gender) {
        if (gender.equals("male")){
            this.gender = true;
        }else if (gender.equals("female")){
            this.gender = false;
        }else if (gender.equals("other")){
            this.gender = null;
        }
    }

    @Override

    public String toString() {
        if (this.gender == null) {
            return "Name is " + this.name + ", code is " + this.code + ", gender is other";
        }else if (this.gender){
            return "Name is " + this.name + ", code is " + this.code + ", gender is male";
        }
        return "Name is " + this.name + ", code is " + this.code + ", gender is female";
    }

    public String info() {
        if (this.gender) {
            return this.code + "," + this.name + ",male";
        }
        if (!this.gender) {
            return this.code + "," + this.name + ",female";
        }
        return this.code + "," + this.name + ",other";
    }
}
