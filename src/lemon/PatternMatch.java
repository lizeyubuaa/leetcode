package lemon;

import java.util.HashMap;

public class PatternMatch {
    public boolean patternMatch(String s1, String s2){
        String[] s3 = s2.split(" ");
        HashMap<Character, String> cache = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if(cache.containsKey(s1.charAt(i))){
                if(!cache.get(s1.charAt(i)).equals(s3[i])) return false;
            }
            else cache.put(s1.charAt(i), s3[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PatternMatch().patternMatch("effe", "good bad bad not"));
    }
}
