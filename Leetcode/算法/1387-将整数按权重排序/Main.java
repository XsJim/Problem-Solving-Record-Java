import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().getKth(12, 15, 2));
        System.out.println(new Solution().getKth(1, 1, 1));
        System.out.println(new Solution().getKth(7, 11, 4));
        System.out.println(new Solution().getKth(10, 20, 5));
        System.out.println(new Solution().getKth(1, 1000, 777));
    }
}

// 求一个数的权值只能通过函数按步骤进行，做一个小优化，将每个计算过的值存起来，当后续计算遇到已经计算过的值，就可以直接使用
// 得到每个数的权值后，排序返回答案即可
class Solution {
    private static int get(int x, Map<Integer, Integer> map) {
        if (x == 1) {
            return 0;
        }
        Integer a = map.get(x);
        if (a == null) {
            if ((x & 1) == 0) a = get(x / 2, map);
            else a = get(3 * x + 1, map);
            a++;
            map.put(x, a);
        }

        return a;
    }
    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        class Node {
            int num;
            int kk;
            Node(int num, int kk) {
                this.num = num;
                this.kk = kk;
            }
        }
        Node[] nodes = new Node[hi-lo+1];
        
        for (int i = lo, j = 0; i <= hi; i++, j++) {
            nodes[j] = new Node(i, get(i, map));
        }
        Arrays.sort(nodes, (a, b) -> {
            if (a.kk == b.kk) return Integer.compare(a.num, b.num);
            return Integer.compare(a.kk, b.kk);
        });
        return nodes[k-1].num;
    }
}