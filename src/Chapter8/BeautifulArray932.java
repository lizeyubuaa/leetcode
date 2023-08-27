package Chapter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BeautifulArray932 {
    public int[] beautifulArray(int n) {
        if(n == 1) return new int[]{1};
        else{
            List<Integer> res = new ArrayList<>();
            int[] odds = beautifulArray((n + 1) / 2);
            for (int odd : odds) {
                res.add(odd * 2 - 1);
            }
            int[] evens = beautifulArray(n / 2);
            for (int even : evens) {
                res.add(even * 2);
            }
            return res.stream().mapToInt(Integer::valueOf).toArray();
        }
    }
}
