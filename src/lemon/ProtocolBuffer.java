package lemon;

import java.util.Arrays;
import java.util.Collections;

public class ProtocolBuffer {
    public String[] protocolBuffer(String[] input) {
        return new String[]{encode(input[0]), decode(input[1])};
    }

    private String encode(String s) {
        StringBuilder sb = new StringBuilder();
        s = Integer.toBinaryString(Integer.parseInt(s));
        while (s.length() > 7) {
            sb.append("0X").append(Integer.toHexString(Integer.parseInt("1" + s.substring(s.length() - 7), 2)));
            s = s.substring(0, s.length() - 7);
        }
        String last = Integer.toHexString(Integer.parseInt(String.join("", Collections.nCopies(8 - s.length(), "0")) + s, 2));
        sb.append("0X").append(last.length() == 1 ? "0" + last : last);

        return sb.toString().toUpperCase();
    }

    private String decode(String s) {
        StringBuilder sb = new StringBuilder();
        while (s.length() > 4) {
            sb.insert(0, Integer.toBinaryString(Integer.parseInt(s.substring(2, 4), 16)).substring(1));
            System.out.println(sb);
            s = s.substring(4);
        }
        String last = Integer.toBinaryString(Integer.parseInt(s.substring(s.length() - 2), 16));
        sb.insert(0, String.join("", Collections.nCopies(8 - last.length(), "0")) + last);
        return String.valueOf(Integer.parseInt(sb.toString(), 2));
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProtocolBuffer().protocolBuffer(new String[]{"999", "0XE70X07"})));
    }
}
