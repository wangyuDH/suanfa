package sort;

import java.util.Random;

/**
 * 冒泡排序
 * 选择排序
 * 插入排序
 * 4,2,5,6,1,9,7
 */
public class BubbleSort {

    private static final int SIZE = 20;

    public static void main(String[] args) {
        int array1[] = getRandom();
        int array2[] = array1.clone();
        int array3[] = array1.clone();
        int array4[] = array1.clone();

        printArray(array1);
        System.out.println("======================================================================================");

        bubbleSort(array1);
        printArray(array1);

        System.out.println("======================================================================================");

        //printArray(array2);
        cccSort(array2);
        printArray(array2);

        System.out.println("======================================================================================");

        //printArray(array3);
        selectSort(array3);
        printArray(array3);

        System.out.println("======================================================================================");

        //printArray(array3);
        insertSort(array4);
        printArray(array4);
    }

    private static void bubbleSort(int[] a) {
        long start = System.currentTimeMillis();
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println("bubble sort: " + (System.currentTimeMillis() - start));
    }

    private static void cccSort(int[] a) {
        long start =System.currentTimeMillis();
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i+1; j < a.length ; j++) {
                if (a[i] > a[j]) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        System.out.println("cccSort sort: " + (System.currentTimeMillis() - start));
    }

    private static void selectSort(int[] a) {
        long start =System.currentTimeMillis();
        for (int i = 0; i < a.length - 1; i++) {
            int index = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            if(index != i){
                int temp = a[index];
                a[index] = a[i];
                a[i] = temp;
            }
        }
        System.out.println("selectSort sort: " + (System.currentTimeMillis() - start));
    }

    private static void insertSort(int[] a) {
        long start =System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int j = i - 1;
            for(;j>=0;j--){
                if(temp < a[j]){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = temp;
        }
        System.out.println("insertSort sort: " + (System.currentTimeMillis() - start));
    }

    private static int[] getRandom() {
        int[] array = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(SIZE * 2);
        }
        return array;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
