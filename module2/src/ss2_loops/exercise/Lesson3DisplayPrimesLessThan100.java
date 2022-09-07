package ss2_loops.exercise;

public class Lesson3DisplayPrimesLessThan100 {
    public static void main(String[] args) {
        int number = 2;
        while (number < 100){
            boolean check = true;
            for (int i = 2; i < number; i++) {
                int isDivisibleByI = number % i;
                if (isDivisibleByI == 0){
                    check = false;
                    break;
                }
            }
            if (check){
                System.out.print(number + "\t");
            }
            number ++;

        }
    }
}
