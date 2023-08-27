package Chapter3;

public class Square633 {
    public boolean judgeSquareSum(int c) {
        long l = 0;
        long r = (long) Math.sqrt(c);
        while (l <= r) {
            if (l * l + r * r > c) r--;
            else if (l * l + r * r < c) l++;
            else return true;
        }
        return false;
    }

    public boolean judgeSquareSum_1(int c) {
        for (long i = 0; i * i <= c; i++) {
            if (check(c - i * i)) return true;
        }
        return false;
    }

    // 检查一个数是不是完全平方数
    public boolean check(long num) {
        double a;
        try {
            a = Math.sqrt(num);
        }
        catch (Exception e) {
            return false;
        }
        int b = (int) a;
        return a - b == 0;
    }
}