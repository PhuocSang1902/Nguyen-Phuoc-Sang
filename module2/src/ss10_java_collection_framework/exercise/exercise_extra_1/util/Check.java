package ss10_java_collection_framework.exercise.exercise_extra_1.util;

public class Check {
    public static void checkName(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 32 || str.charAt(i) > 32 && str.charAt(i) < 65 || str.charAt(i) > 90 && str.charAt(i) < 97 || str.charAt(i) > 122) {
                throw new IncorrectFormatException("Name Is Out Of Format Exception!");
            }
            if (str.charAt(0) == 32){
                throw new IncorrectFormatException("Name Is Out Of Format Exception!");
            }
        }
    }

    public static void checkPoint(double point){
        if (point < 0 || point > 10){
            throw new IncorrectFormatException("Number Is Out Of Format Exception!");
        }
    }


}
