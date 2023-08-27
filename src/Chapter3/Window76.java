package Chapter3;

import java.util.HashMap;
import java.util.Set;

public class Window76 {
    HashMap<Character, Integer> target = new HashMap<>();
    HashMap<Character, Integer> temp = new HashMap<>();

    public String minWindow(String s, String t) {
        boolean flag = false;
        int l = 0;
        int r = 0;
        int resL = 0;
        int resR = 0;
        int resLength = s.length();

        // 初始化
        for (int i = 0; i < t.length(); i++) {
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }
        // r指针先动
        while (r < s.length()) {
            temp.put(s.charAt(r), temp.getOrDefault(s.charAt(r), 0) + 1);

            while (check()) {
                // 找到可行解
                flag = true;
                // 检查状态，对比最优状态
                if (r - l < resLength) {
                    //更新最优状态
                    resL = l;
                    resR = r;
                    resLength = r - l;
                }
                // 更新左指针
                temp.put(s.charAt(l), temp.get(s.charAt(l)) - 1);
                l++;
            }
            r++;
        }

        return flag ? s.substring(resL, resR + 1) : "";
    }

    public boolean check() {
        Set<Character> characters = target.keySet();
        for (Character next : characters) {
            if (target.get(next) > temp.getOrDefault(next, 0)) return false;
        }
        return true;
    }
}