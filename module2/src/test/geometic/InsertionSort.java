package test.geometic;

import java.util.Arrays;

class InsertionSort {
    void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];//key 11,13,5
            int j = i - 1;//j=0,1,2

            while (j >= 0 && arr[j] > key) {//arr[j]=13
                arr[j + 1] = arr[j];//arr[j+1] = 12
                j = j - 1;//j=0
            }

            arr[j + 1] = key;//j = 0, arr[j]=11
//            System.out.println(Arrays.toString(arr));
//            System.out.println(key);
            //{ 12, 11, 13, 5, 6 }
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6 };
        System.out.println(Arrays.toString(arr));

        InsertionSort ob = new InsertionSort();
        ob.sort(arr);

        printArray(arr);
    }
}
