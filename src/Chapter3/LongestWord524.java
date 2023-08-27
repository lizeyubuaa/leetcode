package Chapter3;

import java.util.List;

public class LongestWord524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String t : dictionary) {
            if (check(s, t)) {
                if (res.length() < t.length()) res = t;
                else if (res.length() == t.length() && res.compareTo(t) > 0) res = t;
            }
        }
        return res;
    }

    public boolean check(String s, String t) {
        if (s.length() < t.length()) return false;
        else if (s.length() == t.length()) return s.equals(t);
        else {
            int ps = 0;
            int pt = 0;
            while (ps < s.length() && pt < t.length()) {
                if (s.charAt(ps) == t.charAt(pt)) pt++;
                ps++;
            }
            return pt == t.length();
        }
    }
}
