package Chapter2;

import java.util.Arrays;

public class Assign455 {
    public static int findContentChildren(int[] children, int[] cookie) {
        Arrays.sort(children);
        Arrays.sort(cookie);
        int childPoint = 0;
        int cookiePoint = 0;
        while (childPoint < children.length && cookiePoint < cookie.length) {
            if (children[childPoint] <= cookie[cookiePoint]) {
                childPoint++;
            }
            cookiePoint++;
        }
        return childPoint;
    }
}