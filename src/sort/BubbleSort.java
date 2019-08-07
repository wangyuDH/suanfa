package sort;

import java.util.Random;

/**
 * 冒泡排序
 * 4,2,5,6,1,9,7
 */
public class BubbleSort {

    private static final int SIZE = 20;

    public static void main(String[] args) {
        int array1[] = getRandom();
        int array2[] = array1.clone();

        printArray(array1);
        bubbleSort(array1);
        printArray(array1);

        System.out.println("======================================================================================");

        printArray(array2);
        cccSort(array2);
        printArray(array2);
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
            for (int j = i+1; j < a.length - 1; j++) {
                if (a[i] > a[j]) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        System.out.println("cccSort sort: " + (System.currentTimeMillis() - start));
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
