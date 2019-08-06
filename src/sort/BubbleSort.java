package sort;

import java.util.Random;

/**
 * 冒泡排序
 *   4,2,5,6,1,9,7
 */
public class BubbleSort {

    private static final int SIZE = 6;

    public static void main(String[] args) {
        int array[] = getRandom();
        printArray(array);

        bubbleSort(array);
        printArray(array);
    }

    private static void bubbleSort(int[] a) {
        int temp;
        for(int i=0;i<a.length - 1;i++){
            boolean flag = true;
            for(int j=0;j< a.length - 1 - i ;j++){
                if(a[j] > a[j+1]){
                    temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }

    private static int[] getRandom() {
        int[] array = new int[SIZE];
        Random random = new Random();
        for(int i=0;i<SIZE;i++){
            array[i] = random.nextInt(20);
        }
        return array;
    }

    private static void printArray(int[] array) {
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
