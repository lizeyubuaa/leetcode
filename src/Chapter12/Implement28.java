package Chapter12;

import java.util.Arrays;

public class Implement28 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.startsWith(needle, i)) return i;
        }
        return -1;
    }

    // 理论讲解：https://www.bilibili.com/video/BV1jb411V78H/?spm_id_from=333.337.search-card.all.click&vd_source=850083f56afd64451d5f47b5759e038d
    // 求next数组：https://www.bilibili.com/video/BV1M5411j7Xx/?spm_id_from=333.337.search-card.all.click&vd_source=850083f56afd64451d5f47b5759e038d
    public int strStr_kmp(String haystack, String needle) {
        int[] next = new int[needle.length()];
        // 计算next数组
        getNext(next, needle);
        // 1.初始化j，查找串（比较串）的查找指针
        int j = 0;
        // i是主串的查找指针，随着循环，不回溯
        for (int i = 0; i < haystack.length(); i++) {
            // 2.对应位置不相等
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            // 3.对应位置相等，比较串的指针向右移动
            // 3.主串的指针在外循环里也在移动
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            // 4.匹配成功,比较串的指针到达了比较串的末尾+1
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public void getNext(int[] next, String needle) {
        // next数组含义：当查找指针在比较串和主串不一致时，查找串的比较指针回退到比较指针前一位在next数组中对应值所处的位置
        // 1.初始化
        next[0] = 0;
        // j表示前缀末尾
        int j = 0;
        // 0位置已经初始化(规定), i从1开始
        // i表示后缀末尾
        for (int i = 1; i < needle.length(); i++) {
            // 2.前后缀不相等，连续回退j
            // j必须大于0
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                // 记住要看j的前一位的next的数组的值
                j = next[j - 1];
            }
            // 3.前后缀相等
            // 表示的是长度
            if (needle.charAt(j) == needle.charAt(i)) {
                j++;
            }
            // 4.更新next数组
            next[i] = j;
        }
    }
}
