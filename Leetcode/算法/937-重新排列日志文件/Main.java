import java.util.PriorityQueue;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().reorderLogFiles(new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"})));
        System.out.println(Arrays.toString(new Solution().reorderLogFiles(new String[] {"j mo", "5 m w", "g 07", "o 2 0", "t q h"})));
    }
}

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        class Node {
            int index;
            String a;
            String b;

            Node(int index, String a, String b) {
                this.index = index;
                this.a = a;
                this.b = b;
            }
        }

        String[] ans = new String[logs.length];
        int i = logs.length - 1;

        PriorityQueue<Node> pq = new PriorityQueue<>((l, r) -> {
            if (l.b.equals(r.b)) return l.a.compareTo(r.a);
            return l.b.compareTo(r.b);
        });

        for (int j = i; j >= 0; j--) {
            String[] cur = logs[j].split(" ");
            char x = cur[1].charAt(0);
            if (x >= '0' && x <= '9') ans[i--] = logs[j];
            else {
                StringBuilder sb = new StringBuilder();
                for (int z = 1; z < cur.length; z++) {
                    sb.append(cur[z]);
                    sb.append(" ");
                }
                pq.add(new Node(j, cur[0], sb.toString()));
            }
        }
        i = 0;
        while (pq.size() > 0) {
            ans[i++] = logs[pq.poll().index];
        }

        return ans;
    }
}