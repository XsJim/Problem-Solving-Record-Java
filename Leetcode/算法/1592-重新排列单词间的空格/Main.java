import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reorderSpaces("  this   is  a sentence "));
        System.out.println(new Solution().reorderSpaces(" practice   makes   perfect"));
        System.out.println(new Solution().reorderSpaces("hello   world"));
        System.out.println(new Solution().reorderSpaces("  walks  udp package   into  bar a"));
        System.out.println(new Solution().reorderSpaces("a"));
    }
}

// 首先统计字符串中空格数量，并将单个单词加入一个队列
// 得到单词数量和空格数量后，可以计算出每两个单词之间的空格数量以及字符串末尾应添加的空格数量
// 之后按照之前的计算结果建立答案字符串并返回
class Solution {
    public String reorderSpaces(String text) {
        Deque<String> queue = new ArrayDeque<>();
        int sum = 0;
        int i = 0;
        char[] sArr = text.toCharArray();
        while (i < sArr.length) {
            if (sArr[i] == ' ') {
                sum++;
                i++;
            }
            else {
                int j = i + 1;
                while (j < sArr.length && sArr[j] != ' ') j++;
                queue.add(new String(sArr, i, j - i));
                i = j;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(queue.poll());
        int x = sum;
        if (queue.size() != 0) {
            int len = sum / queue.size();
            x = sum - len * queue.size();
            StringBuilder sp = new StringBuilder();
            for (int j = 0; j < len; j++) sp.append(' ');
            
            while (queue.size() > 0) {
                sb.append(sp);
                sb.append(queue.poll());
            }
        }

        for (int j = 0; j < x; j++) sb.append(' ');
        

        return sb.toString();
    }
}