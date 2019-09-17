package find;

import java.io.Serializable;

/**
 * 折半查找-进阶版
 * 1 查找第一个等于给定值的元素
 * 2 查找最后一个等于给定值的元素
 * <p>
 * 3 查找第一个大于等于给定值的元素
 * 4 查找最后一个小于等于给定值的元素
 */
public class BSearchTest02 {
    public static final int key = 9;
    public static final int array[] = {2, 5, 7, 8, 10, 33, 57};

    public static void main(String[] args) {
        int low = 0;
        int high = array.length - 1;

        int index1 = findKey1(array, low, high, key);
        System.out.println("index1: " + index1);

        System.out.println("=============================================================");
        int index2 = findKey2(array, low, high, key);
        System.out.println("index2: " + index2);

        System.out.println("=============================================================");
        int index3 = findKey3(array, low, high, key);
        System.out.println("index3: " + index3);

        System.out.println("=============================================================");
        int index4 = findKey4(array, low, high, key);
        System.out.println("index4: " + index4);
    }

    /**
     * 查找第一个等于给定值的元素
     */
    private static int findKey1(int[] a, int low, int high, int key) {
        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (a[mid] == key) {
                if (mid == 0 || a[mid - 1] != key) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (a[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个等于给定值的元素
     */
    private static int findKey2(int[] a, int low, int high, int key) {
        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (a[mid] == key) {
                if (mid == a.length - 1 || a[mid + 1] != key) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (a[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     */
    private static int findKey3(int[] a, int low, int high, int key) {
        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (a[mid] >= key) {
                if (mid == 0 || a[mid - 1] < key) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     */
    private static int findKey4(int[] a, int low, int high, int key) {
        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (a[mid] <= key) {
                if (mid == a.length - 1 || a[mid + 1] > key) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
