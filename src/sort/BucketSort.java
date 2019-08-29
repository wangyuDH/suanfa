package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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

        //radixSort(array3);
        //printArray(array3);

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
        //计算数组中的最大最小值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }
        System.out.println("array size: " + a.length + ",min: " + min + ",max: " + max);
        //计算桶的个数
        int bucketSize = (max - min) / a.length + 1;
        //初始化桶
        List<List<Integer>> bucket = new ArrayList<>(bucketSize);
        for (int i = 0; i < bucketSize; i++) {
            bucket.add(new ArrayList<>());
        }
        //将元素放个桶中
        List<Integer> list = null;
        for (int i = 0; i < a.length; i++) {
            int index = getBucketIndex(a[i], min, a.length);
            bucket.get(index).add(a[i]);
        }
        //排序每个桶中的数据
        for (int i = 0; i < bucketSize; i++) {
            Collections.sort(bucket.get(i));
            System.out.println("bucket i:" + i + ": " + bucket.get(i));
        }

        int index = 0;
        for (int i = 0; i < bucketSize; i++) {
            list = bucket.get(i);
            if (list == null || list.size() == 0) {
                continue;
            }
            for (int j = 0; j < list.size(); j++) {
                a[index++] = list.get(j);
            }
        }
        System.out.println("bucket sort: " + (System.currentTimeMillis() - start));
    }

    /**
     * 获取元素在哪个桶
     *
     * @param data
     * @return index
     */
    private static int getBucketIndex(int data, int min, int arraySize) {
        return (data - min) / arraySize;
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
