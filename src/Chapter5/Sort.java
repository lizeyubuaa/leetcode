package Chapter5;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] in = new int[]{4, 3, 5, 2, 1};
//        System.out.println(Arrays.toString(Heap(in)));
        System.out.println(Arrays.toString(Quick(in, 0, in.length - 1)));
//        System.out.println(Arrays.toString(Bubble(in)));
//        System.out.println(Arrays.toString(BinaryInsert(in)));
    }

    public static int[] BinaryInsert(int[] in) {
        // 链表便于插入元素
        ArrayList<Integer> result = new ArrayList<>();
        // 运算安全，便于边界运算，插入最大最小值
        result.add(Integer.MIN_VALUE);
        result.add(in[0]);
        result.add(Integer.MAX_VALUE);
        int l;
        int r;
        int mid;

        // 每个循环插入一个元素
        for (int i = 1; i < in.length; i++) {
            // 确认左右指针
            l = 0;
            r = result.size() - 1;
            int ans = in.length - 1;
            // 二分确认插入区间
            // 查找比target大的第一个元素
            while (l <= r) {
                mid = l + (r - l) / 2;
                if (result.get(mid) > in[i]) {
                    r = mid - 1;
                    ans = mid;
                }
                else l = mid + 1;
            }
            // 插入元素
            result.add(ans, in[i]);
        }


        Integer[] out = new Integer[in.length];
        result.toArray(out);

        // Integer[] map为 int[]
        return Arrays.stream(out).mapToInt(Integer::valueOf).toArray();
    }


    public static int[] Bubble(int[] in) {
        int temp;
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < in.length - 1; i++) {
                if (in[i + 1] < in[i]) {
                    temp = in[i + 1];
                    in[i + 1] = in[i];
                    in[i] = temp;
                    flag = true;
                }
            }
        }
        while (flag);
        return in;
    }

    // 对原数组进行修改
    public static int[] Quick(int[] in, int left, int right) {
        // 需要记录子数组的长度，递归的时候要用
        int l = left;
        int r = right;
        if (l >= r) return in;
        // 需要多次交换，只声明一次，节省空间
        int temp;

        // 注意l始终要小于r
        while (l < r) {
            // 先动右指针，再动左指针
            while (in[left] <= in[r] && l < r) r--;
            while (in[left] >= in[l] && l < r) l++;
            // 注意l始终要小于r
            if (l < r) {
                temp = in[l];
                in[l] = in[r];
                in[r] = temp;
                l++;
                r--;
            }
        }
        // 交换右指针和哨兵
        temp = in[r];
        in[r] = in[left];
        in[left] = temp;

        in = Quick(in, left, r - 1);
        in = Quick(in, r + 1, right);

        return in;
    }

    public static int[] Heap(int[] in) {
        int n = in.length;
        int temp;
        // 关键1：调整序列为初始堆积，要从正中间的元素开始，直到0号元素
        for (int i = (n - 1) / 2; i >= 0; i--) {
            Adjust(in, i, n);
        }
        // 该堆积已经能作为优先队列的一部分
        // 关键2：经过调整后，第一个元素是最大元素，接下来把最大元素放在最后，重复这个过程n-1次
        for (int i = n - 1; i >= 1; i--) {
            temp = in[0];
            in[0] = in[i];
            in[i] = temp;
            Adjust(in, 0, i);
        }
        return in;
    }

    // 原地排序，n会改变，作为参数传入
    public static void Adjust(int[] in, int i, int n) {
        int child;
        int temp;
        // 注意i不能越界
        while (i < n) {
            child = 2 * i + 1;
            if (child + 1 < n && in[child + 1] > in[child]) {
                child += 1;
            }
            if (child < n && in[child] > in[i]) {
                temp = in[i];
                in[i] = in[child];
                in[child] = temp;
                i = child;
            }
            else {
                break;
            }
        }
    }
}
