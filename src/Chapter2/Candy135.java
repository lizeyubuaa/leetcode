package Chapter2;

public class Candy135 {
    public static int candy(int[] children) {
        int[] candies = new int[children.length];
        for (int i = 0; i < children.length - 1; i++) {
            if (children[i + 1] > children[i]) {
                candies[i + 1] = candies[i] + 1;
            }
        }
        for (int i = children.length - 1; i > 0; i--) {
            if (children[i-1] > children[i]) {
                candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
            }
        }
        int count = children.length;
        for (int candy : candies) {
            count += candy;
        }
        return count;
    }
}
