import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().rankTeams(new String[] {"ABC","ACB","ABC","ACB","ACB"}));
        System.out.println(new Solution().rankTeams(new String[] {"WXYZ","XYZW"}));
        System.out.println(new Solution().rankTeams(new String[] {"ZMNAGUEDSJYLBOPHRQICWFXTVK"}));
        System.out.println(new Solution().rankTeams(new String[] {"BCA","CAB","CBA","ABC","ACB","BAC"}));
        System.out.println(new Solution().rankTeams(new String[] {"M","M","M","M"}));
    }
}

class Solution {
    // 每个投票者，都可以按照自己的想法，给选举人们排出一个队列
    // 最终得到的投票结果，是某个选举人，在某某位置有多少票
    // 然后是排序，排序就如一个选择名次的过程，第一名应该如何选出呢？
    // 如果所有投票者的想法都是让某人当这个第一名，那么这个第一名就必定是这一位
    // 所以选法是观察当前所有选举人中，高位上的票数，高位上票数多者，得到当前选举位
    // 如果当前有两人票数相同（如，有三人选 A 为第一，又三人选 B 为第一），此时就应该顺次向后观察，观察分别有多少人选它们当第二名，依然票多者胜
    // 如果最终都无法抉择（每个期望位置的票都一样多），就应该按照名称的字母序排，字母序小的考靠前，即先被选出
    // 每选完一人，这个人就应该退出选举
    // 下一轮选举，还是应该按照从高位到低位的顺序，依次对比票数
    // 这样使得那些原本在上一轮中参与了最终竞选却没被选上的人，在这一轮中被优先选出
    public String rankTeams(String[] votes) {
        int n = 26;
        class Node {
            int[] count;
            Node() {
                count = new int[27];
            }
        }
        Node[] counts = new Node[n];
        for (int i = 0; i < n; i++) {
            counts[i] = new Node();
        }

        for (String s : votes) {
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i)-'A';
                counts[index].count[i]++;
                counts[index].count[n] = n - index;
            }
        }

        Arrays.sort(counts, (a, b) -> {
            for (int i = 0; i <= 26; i++) {
                if (a.count[i] != b.count[i]) return Integer.compare(b.count[i], a.count[i]);
            }
            return 0;
        });

        char[] ans = new char[n];
        int i = 0;
        while (i < n && counts[i].count[n] != 0) {
            ans[i] = (char)(n - counts[i].count[n] + 'A');
            i++;
        }

        return new String(ans, 0, i);
    }
}