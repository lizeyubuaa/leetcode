package Chapter7;

public class Stair70 {
    public static void main(String[] args) {
        Stair70 obj = new Stair70();
        System.out.println(obj.climbStairsRec(4));
    }
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int pre = 2;
        int pre2 = 1;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = pre + pre2;
            pre2 = pre;
            pre = cur;
        }
        return cur;
    }

    public int climbStairsRec(int n) {
        if(n <= 2) return n;
        return climbStairsRec(n-1) + climbStairsRec(n-2);
    }
}
