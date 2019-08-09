package sort;

import java.util.Random;

/**
 * 归并排序 VS 快速排序
 * 4,2,5,6,1,9,7
 */
public class MergeSort {

    private static final int SIZE = 5000;

    public static void main(String[] args) {
        int array1[] = getRandom();
        int array2[] = array1.clone();

        printArray(array1);
        System.out.println("======================================================================================");

        long start1 = System.currentTimeMillis();
        mergeSort(array1, 0, array1.length - 1);
        System.out.println("merge sort: " + (System.currentTimeMillis() - start1));
        printArray(array1);

        System.out.println("======================================================================================");

        quickSort(array2);
        printArray(array2);
    }

    private static void mergeSort(int[] a, int p, int q) {
        if (p >= q) {
            return;
        }
        int r = (p + q) / 2;

        mergeSort(a, p, r);
        mergeSort(a, r + 1, q);
        merge(a, p, r, q);
    }

    private static void merge(int[] a, int p, int r, int q) {
        int tmpArray[] = new int[q - p + 1];
        int i = p;
        int j = r + 1;
        int index = 0;
        while (i <= r && j <= q) {
            if (a[i] < a[j]) {
                tmpArray[index++] = a[i++];
            } else {
                tmpArray[index++] = a[j++];
            }
        }

        while (i <= r) {
            tmpArray[index++] = a[i++];
        }

        while (j <= q) {
            tmpArray[index++] = a[j++];
        }

        for (int k = 0; k <q - p + 1; k++) {
            a[p + k] = tmpArray[k];
        }

    }

    private static void quickSort(int[] a) {
        long start = System.currentTimeMillis();

        System.out.println("quick sort: " + (System.currentTimeMillis() - start));
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
