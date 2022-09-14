package test;

public class Main {
    public static boolean solution(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            int check = arr[i];
            int total1 = 0;
            int total2 = 0;
            for (int j = 0; j < check; j++) {
                total1 += arr[j];
            }
            for (int j = check + 1; j < arr.length; j++) {
                total2 += arr[j];
            }
            if(total1 == total2){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,3}));
    }
}
