package Chapter6;

import java.util.*;

// key: 每行每列有且仅有一个queen, 当前解用一维数组表示即可
public class NQueens51 {
    // 以数字形式存放的输出
    private final List<List<Integer>> result = new ArrayList<>();
    // 当前状态：找到的一组解
    private final List<Integer> locations = new ArrayList<>();

    public static void main(String[] args) {
        NQueens51 obj = new NQueens51();

        System.out.println(obj.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        // 第一行第i列
        for (int i = 0; i < n; i++) {
            backTrack(n, 0, i);
        }
//        System.out.println(result);
        // 为了去重
        Set<List<Integer>> result_cleaned = new HashSet<>(result);
        // 以字符串形式存放的最终的输出
        List<List<String>> resultString = new ArrayList<>();
        for (List<Integer> locations : result_cleaned) {
            resultString.add(generateAns(locations));
        }
        return resultString;
    }


    public void backTrack(int n, int a, int b) {
        if (a == n) {
            result.add(new ArrayList<>(locations));
            return;
        }

        if (a >= 0 && b >= 0 && a < n && b < n && check(a, b)) {
            locations.add(b);
            // 遍历所有可能情况
            for (int j = 0; j < n; j++) {
                backTrack(n, a + 1, j);
            }
            // 回溯
            locations.remove(locations.size() - 1);
        }
    }

    // 检查该位置是否能放置棋子
    public boolean check(int a, int b) {

        for (int i = 0; i < locations.size(); i++) {
            int x = i;
            int y = locations.get(i);
            if (x == a || y == b || Math.abs(x - a) == Math.abs(y - b)) return false;
        }
        return true;
    }

    public List<String> generateAns(List<Integer> locations) {
        int n = locations.size();
        List<String> ans = new ArrayList<>();
        StringBuilder sb;
        for (int y : locations) {
            sb = new StringBuilder(".".repeat(n));
            sb.replace(y, y + 1, "Q");
            ans.add(sb.toString());
        }
        return ans;
    }
}
