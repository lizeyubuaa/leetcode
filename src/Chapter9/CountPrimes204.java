package Chapter9;

import java.util.Arrays;

public class CountPrimes204 {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = 0;
                }
            }

        }
        return Arrays.stream(isPrime).sum() - 2;
    }
}