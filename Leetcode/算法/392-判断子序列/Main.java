import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
        System.out.println(new Solution().isSubsequence("axc", "ahbgdc"));
    }
}

// 建立一种结点，结点包含一个下标，和一个整数链表
// 然后构建一个散列数组，和 256 个字符一一对应
// 首先遍历 t 字符串，如果散列数组中当前字符的位置已经初始化，则将该字符出现的下标接入链表的末尾
// 否则，初始化结点，下标设为 0 ，并将该下标接入链表末尾
// 之后，遍历 s 字符串，通过方法 get 得到该字符在 t 字符串中，出现的下标大于上一个字符下标的下标值或者得到 -1
//   在 get 方法中，首先确定字符对应散列数组位置是否为 null ，如果为 null ，则返回 -1
//   接着，从该字符当前最新下标开始，向后查找，直到到达链表末尾，或者找到比当前要求位置大的下标，对于这两种情况，分别返回 -1 或者较大下标
// 在循环中，得到一个下标值，按照规定，这个数是 -1 或者比当前最新下标大的值，如果是 -1 ，说明无法组成该字符串，返回 false
// 否则，当前这个字符有满足条件的字符与之对应，接着循环判断之后的字符
class Solution {
    public boolean isSubsequence(String s, String t) {
        Node[] map = new Node[256];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map[c] == null) map[c] = new Node();
            map[c].list.add(i);
        }

        for (int i = 0, j = -1; i < s.length(); i++) {
            char c = s.charAt(i);
            int x = get(c, map, j);
            if (x > j) {
                j = x;
            } else return false;
        }

        return true;
    }

    class Node {
        int index;
        List<Integer> list;
        Node() {
            index = 0;
            list = new ArrayList<>();
        }
    }

    private static int get(char c, Node[] map, int j) {
        if (map[c] == null) return -1;
        
        while (map[c].index < map[c].list.size()) {
            int now = map[c].list.get(map[c].index++);
            if (now > j) return now;
        }
        return -1;
    }
}