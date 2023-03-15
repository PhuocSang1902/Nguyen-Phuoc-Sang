package ss2_loops.exercise;

import java.util.ArrayList;
import java.util.Collections;

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
    public boolean isPrime(int num){
        if(num == 0){
            return false;
        }
        for (int i = 2; i < num; i++) {
            int isDivisibleByI = num % i;
            if (isDivisibleByI == 0){
                return false;
            }
        }
        return true;
    }
    public ArrayList<Integer> convertBase10ToBaseB(int number, int B){
        ArrayList<Integer> result = new ArrayList<>();
        while (number != 0){
            result.add(number%B);
            number = number/B;
        }
        Collections.reverse(result);
        return result;
    }
}
