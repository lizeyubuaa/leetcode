package Chapter9;

public class Happy202 {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        while (fast != 1) {
            fast = Transform(Transform(fast));
            slow = Transform(slow);
            if (fast == slow && fast != 1) return false;
        }
        return true;
    }

    public int Transform(int n) {
        int temp = 0;
        while (n != 0) {
            temp += (n % 10) * (n % 10);
            n /= 10;
        }
        return temp;
    }
}

