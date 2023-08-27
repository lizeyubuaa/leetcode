package Chapter5;

import java.util.*;

public class SortCharacters451 {
    public String frequencySort(String s) {
        char ch;
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> characterFrequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            characterFrequency.put(ch, characterFrequency.getOrDefault(ch, 0) + 1);
        }
        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(characterFrequency.entrySet());
        entries.sort((S, T) -> -S.getValue() + T.getValue());

        for (Map.Entry<Character, Integer> entry : entries) {
            sb.append(entry.getKey().toString().repeat(entry.getValue()));
        }
        return sb.toString();
    }
}
