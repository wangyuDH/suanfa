package tree;

import java.util.Arrays;

/**
 * 堆 - 大顶堆 & 小顶堆
 */
public class Heap {

    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    //数组，从下标1开始存储数据
    private int a[];

    //堆中已经存储的数据个数
    private int count = 0;


    public Heap() {
        a = new int[DEFAULT_INITIAL_CAPACITY];
    }

    public Heap(int capacity) {
        a = new int[capacity + 1];
    }

    public void insert(int data) {
        a[++count] = data;
        //自下往上堆化
        if (count > 1) {
            siftUp(count);
        }
    }

    /**
     * 自下往上堆化
     *
     * @param i
     */
    private void siftUp(int i) {
        if (a[i] <= a[i / 2]) {
            return;
        }

        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(i, i / 2);
            i = i / 2;
        }

    }

    public void removeMax() {
        if (count == 0) {
            return;
        }
        System.out.println("remove Max: " + a[1]);
        //最后一个元素赋予根节点
        a[1] = a[count];
        a[count] = 0;
        count--;
        //自上往下堆化
        siftDown(1,count);
    }

    public void sort(){
        int c = count;
        while (c > 1){
            swap(1,c);
            c--;
            siftDown(1,c);
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * 自上往下堆化
     *
     * @param i
     * @param n
     */
    private void siftDown(int i,int n) {
        while (true) {
            int maxPos = i;
            if (2 * i <= n && a[i] < a[2 * i]) {
                maxPos = 2 * i;
            }
            if ((2 * i + 1 <= n) && a[i] < a[2 * i + 1]) {
                maxPos = 2 * i + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(i, maxPos);
            i = maxPos;
        }

    }

    private void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    @Override
    public String toString() {
        return "Heap{" +
                "a=" + Arrays.toString(a) +
                '}';
    }
}
