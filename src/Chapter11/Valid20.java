package Chapter11;

import java.util.ArrayDeque;
import java.util.Deque;

public class Valid20 {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;

        Deque<Character> characters = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '[' || current == '{' || current == '(') characters.push(current);
            else {
                // 检查是否为空
                if(characters.peek() == null) return false;
                switch (current) {
                    case ')' -> {
                        if (characters.peek() != '(') return false;
                    }
                    case ']' -> {
                        if (characters.peek() != '[') return false;
                    }
                    case '}' -> {
                        if (characters.peek() != '{') return false;
                    }
                }
                characters.pop();
            }
        }
        // 返回是否为空
        return characters.isEmpty();
    }
}