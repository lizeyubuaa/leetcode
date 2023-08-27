package Chapter6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FriendCircle547 {
    private int[] visited;

    public static void main(String[] args) {
        FriendCircle547 obj = new FriendCircle547();
        int[][] test = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(obj.findCircleNum(test));
    }

    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        visited = new int[isConnected.length];
        for (int i = 0; i < visited.length; i++) {
            res += circle(isConnected, i);
        }
        return res;
    }

    public int circle(int[][] isConnected, int person) {
        if (visited[person] == 1) return 0;
        else {
            LinkedList<Integer> toBeVisited = new LinkedList<>();
            // 广度优先搜索
            toBeVisited.add(person);
            while (toBeVisited.size() != 0) {
                int current = toBeVisited.remove();
                visited[current] = 1;
                // 遍历当前人的所有朋友，要求当前人没有访问过、符合朋友的定义、不是当前人
                for (int i = 0; i < isConnected[current].length; i++) {
                    if (visited[i] == 0 && i != current && isConnected[current][i] == 1) toBeVisited.add(i);
                }
            }
            return 1;
        }
    }
}
