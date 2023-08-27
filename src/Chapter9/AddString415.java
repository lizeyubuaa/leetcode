package Chapter9;

public class AddString415 {
    public String addStrings(String num1, String num2) {
        return String.valueOf(Long.sum(Long.parseLong(num1), Long.parseLong(num2)));
    }
}
