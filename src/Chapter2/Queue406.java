package Chapter2;

import java.util.ArrayList;
import java.util.Arrays;

public class Queue406 {
    public int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> result = new ArrayList<>();
//        Arrays.sort(people, Comparator.comparingInt((int[] x) -> x[0]).reversed()
//                .thenComparingInt((int[] x) -> x[1]));
        Arrays.sort(people, (s,t)-> s[0]!=t[0]?t[0]-s[0]:s[1]-t[1]);
        for (int[] peo: people) {
            result.add(peo[1], peo);
        }
        return result.toArray(new int[people.length][2]);
    }
}