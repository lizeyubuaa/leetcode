package Chapter8;

import java.util.ArrayList;
import java.util.List;

public class Add241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (ch) {
                            case '+' -> result.add(l + r);
                            case '-' -> result.add(l - r);
                            case '*' -> result.add(l * r);
                        }
                    }
                }
            }
        }
        if(result.size() == 0) result.add(Integer.valueOf(expression));
        return result;
    }
}
