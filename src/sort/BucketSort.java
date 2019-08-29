package sort;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 桶排序
 * 计数排序
 * 基数排序
 */
public class BucketSort {

    public static void main(String[] args) {
        int array1[] = {5, 9, 5, 1, 6, 4, 8, 8, 3, 4, 6, 9};
        int array2[] = {5, 18, 27, 33, 42, 66, 90, 8, 81, 47, 13, 67, 9, 36, 62, 22};
        int array3[] = {25, 19, 35, 31, 56, 74, 68, 38, 23, 22, 55, 77, 99, 45, 70};

        System.out.println("======================================================================================");

        countingSort(array1);
        printArray(array1);

        System.out.println("======================================================================================");

        bucketSort(array2);
        printArray(array2);

        System.out.println("======================================================================================");

        radixSort(array3);
        printArray(array3);

    }

    private static void countingSort(int[] a) {
        long start = System.currentTimeMillis();
        int bucket[] = new int[11];
        //将分数相同的放入一个桶中
        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                a[index++] = i;
                bucket[i]--;
            }
        }

        System.out.println("counting sort: " + (System.currentTimeMillis() - start));
    }

    private static void bucketSort(int[] a) {
        long start = System.currentTimeMillis();
        //计算桶的个数
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;


        List<LinkedList<Integer>> bucket = new ArrayList<>();
        //将元素放个桶中
        for(int i=0;i<a.length;i++){
            int index = getBucketIndex(a[i]);
            bucket.get(index).add(a[i]);
        }
        //排序每个桶中的数据


        System.out.println("bucket sort: " + (System.currentTimeMillis() - start));
    }

    /**
     * 获取元素在哪个桶
     * @param data
     * @return index
     */
    private static int getBucketIndex(int data) {
        int index = 0;

        return index;
    }

    private static void radixSort(int[] a) {
        long start = System.currentTimeMillis();

        System.out.println("radix sort: " + (System.currentTimeMillis() - start));
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
