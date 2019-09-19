package sort;

/**
 * 求无序数组中的第K大元素
 */
public class FindTheKBigData {

    private static final int K_BIG = 4;

    public static void main(String[] args) {
        int array[] = {4, 22, 2, 5, 12, 8, 1, 9, 6};

        int result = findTheKBigData(array, 0, array.length - 1);
        System.out.println("k=" + K_BIG + ",data=" + result);

        printArray(array);
    }

    private static int findTheKBigData(int[] array, int p, int q) {
        if (p > q) {
            return -1;
        }
        int pivot = partition(array, p, q);
        if (pivot + 1 == K_BIG) {
            return array[pivot];
        } else if (pivot + 1 > K_BIG) {
            return findTheKBigData(array, p, pivot - 1);
        } else {
            return findTheKBigData(array, pivot + 1, q);
        }
    }

    // 3,9,5,8
    private static int partition(int[] a, int p, int q) {
        int pivot = a[q];

        int temp;
        int i = p;
        int j = p;
        for (; j < q; j++) {
            if (a[j] < pivot) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }

        temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        return i;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
