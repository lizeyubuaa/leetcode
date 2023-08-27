package Chapter12;

import java.util.ArrayList;
import java.util.List;

public class Count696 {
    public int countBinarySubstrings(String s) {
        List<Integer> value = new ArrayList<>();
        int same = 1;
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) same += 1;
            else {
                value.add(same);
                same = 1;
            }
        }
        value.add(same);
        for (int i = 1; i < value.size(); i++) {
            result += Math.min(value.get(i), value.get(i - 1));
        }
        return result;
    }
}
