package digui;

/**
 * 有n个台阶，每次你可以跨1个台阶或者2个台阶，请问走这n个台阶有多少种走法？
 *  f(n) = f(n-1) + f(n-2)
 *   1 2 3 5 8 13
 */
public class Test {
    public static void main(String[] args) {
        int n = 6;

        int count1 = calc1(n);
        System.out.println("递归calc1："+count1);

        int count2 = calc2(n);
        System.out.println("非递归calc2："+count2);
    }

    private static int calc1(int n) {
        if(n == 1){
            return  1;
        }
        if(n == 2){
            return 2;
        }
        return calc1(n-1) + calc1(n-2);
    }

    private static int calc2(int n) {
        if(n == 1){
            return  1;
        }
        if(n == 2){
            return 2;
        }
        int c1 = 1,c2 = 2;
        int c3 = 0;
        for(int i=3;i<=n;i++){
            c3 = c1 + c2;
            c1 = c2;
            c2 = c3;
        }
        return c3;
    }
}
