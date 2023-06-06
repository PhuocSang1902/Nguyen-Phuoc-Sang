package test;

public class Main {
    public static void main(String[] args) {

    }
    public static int[] countCharInString(String str) {
        String[] temp = str.split("");
        int[] result = new int[temp.length];
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            count = 0;
            for (int j = 0; j < temp.length; j++) {
                if (temp[i].equals(temp[j])){
                    count += 1;
                }
            }
            result[i] = count;
        }
        return result;
    }
    public static void findFibonacci(int maxNumber){
        int a = 0;
        int b = 1;
        int c = 0;
        System.out.println(a);
        System.out.println(b);
        while (c < maxNumber){
            c = a + b;
            System.out.println(c);
            a = b;
            b = c;
        }
    }
}
