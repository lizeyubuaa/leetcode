package Chapter3;

public class ValidPalindrome680 {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        if(s.length() <= 1) return true;
        else if(s.charAt(0) == s.charAt(s.length() - 1) && validPalindrome1(s.substring(1, s.length() - 1))) return true;
        else return validPalindrome1(s.substring(1)) || validPalindrome1(s.substring(0, s.length() - 1));
    }
    public boolean validPalindrome1(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            else return (valid(s, l + 1, r) || valid(s, l, r - 1));
        }
        return true;
    }

    public boolean valid(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            else return false;
        }
        return true;
    }
}
