package Chapter10;

public class Reverse190 {
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n)).reverse();
        if(sb.length() < 32) sb.append("0".repeat(32 - sb.length()));
        System.out.println(sb.toString());
        return Integer.parseInt(sb.toString(), 2);
    }
}
