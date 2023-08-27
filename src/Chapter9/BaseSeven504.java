package Chapter9;

public class BaseSeven504 {
    public String convertToBase7(int num) {
        boolean negative = false;
        StringBuilder sb = new StringBuilder();
        if (num < 0) {
            num = -num;
            negative = true;
        }
        int a;
        int b;
        do {
            a = num / 7;
            b = num % 7;
            sb.append(b);
            num = a;
        }
        while (num != 0);
        if (negative) sb.append('-');
        return sb.reverse().toString();
    }
}