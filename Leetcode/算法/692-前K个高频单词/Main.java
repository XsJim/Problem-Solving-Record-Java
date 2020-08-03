import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(new Solution().topKFrequent(new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}

class Solution {

    // 创建散列表（键为单词，值为单词出现次数），遍历单词数组，记录单词出现次数
    // 创建优先队列（元素为 Node ，是一个包含字符串和出现次数的结构），若出现次数相同，则按字典序逆序排序，否则按出现次数排序
    // 遍历散列表，将当前项添加到队列中后，检查队列总元素数是否大于 K ，若大于，则将队首元素出队
    // 创建答案链表，将队列元素依次出队，并插入链表首部，这保证了出现次数多的单词排在前面

    public List<String> topKFrequent(String[] words, int k) {
        class Node {
            String s;
            int count;
            Node(String s, int count) {
                this.s = s;
                this.count = count;
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (b.count == a.count) return b.s.compareTo(a.s);
            return Integer.compare(a.count, b.count);
        });
        for (String s : map.keySet()) {
            pq.add(new Node(s, map.get(s)));
            if (pq.size() > k) pq.poll();
        }

        List<String> ans = new LinkedList<>();
        while (pq.size() > 0) {
            ans.add(0, pq.poll().s);
        }

        return ans;
    }
}