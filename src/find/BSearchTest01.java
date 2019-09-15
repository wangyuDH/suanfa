package find;

/**
 * 折半查找-基础版
 *   注意点：
 *    1 退出条件
 *    2 mid的取值
 *    3 low和hign的更新
 */
public class BSearchTest01 {
    public static final int key = 10;

    public static void main(String[] args) {
        int array[] = {2, 5, 7, 8, 10, 33, 57};

        int index1 = findKey(array, key);
        System.out.println("index1: " + index1);

        int low = 0;
        int hign = array.length - 1;
        int index2 = diguiFindKey(array, low, hign, key);
        System.out.println("index2: " + index2);
    }

    private static int diguiFindKey(int[] a, int low, int hign, int key) {
        if(low > hign){
            return -1;
        }

        int mid = low + (hign - low) / 2;
        if (a[mid] == key) {
            return mid;
        } else if (a[mid] > key) {
            return diguiFindKey(a, low, mid - 1, key);
        } else {
            return diguiFindKey(a, mid + 1, hign, key);
        }
    }

    private static int findKey(int[] a, int key) {
        int low = 0;
        int hign = a.length - 1;

        while (hign >= low) {
            int mid = low + (hign - low) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] > key) {
                hign = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
