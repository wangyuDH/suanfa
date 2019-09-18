package find;

/**
 * 何编程实现“求一个数的平方根”？要求精确到小数点后6位
 */
public class SqrtTest {
    private static final int key = 5;

    private static final double offset = 0.000001;

    public static void main(String[] args) {
        double low = 0;
        double high = key;
        double result = calc(key, low, high);
        System.out.println(result);

        System.out.println(Math.sqrt(key));
    }

    /**
     * 5/2=2.5                     low=0,high=5,mid=2.5          2.5*2.5>5
     * 2.5/2=1.25                  low=0,high=2.5,mid=1.25       1.25*1.25=1.5625<5
     * 1.25+(2.5-1.25)/2=1.875     low=1.25,high=2.5,mid=1.875   1.875*1.875=3.515625<5
     */
    private static double calc(double key, double low, double high) {
        double mid = low + (high - low)/2.0;
        if (Math.abs(mid * mid - key) <= offset) {
            return mid;
        }
        if(mid * mid > key){
            return calc(key,low,mid);
        }else {
            return calc(key,mid,high);
        }
    }
}
