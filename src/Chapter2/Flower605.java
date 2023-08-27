package Chapter2;

import java.util.Arrays;

public class Flower605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int[] extended_flowerbed = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, extended_flowerbed, 1, flowerbed.length);
        for (int i = 1; i <= flowerbed.length; i++) {
            if (extended_flowerbed[i] == 0 && extended_flowerbed[i - 1] == 0 && extended_flowerbed[i + 1] == 0) {
                count += 1;
                extended_flowerbed[i] = 1;
            }
            if (count >= n) return true;
        }
        return false;
    }


    public boolean canPlaceFlowers_ori(int[] flowerbed, int n) {
        int count = 0;
        if (Arrays.equals(flowerbed, new int[]{0})) return 1 >= n;
        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                if (i == 0) {
                    flowerbed[0] = 1;
                    count++;
                }
                else if (flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
                else if (i == flowerbed.length - 2) {
                    flowerbed[i + 1] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
}

