import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().longestWord(new String[] {"w","wo","wor","worl", "world"}));
        System.out.println(new Solution().longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
}

class Solution {
    private class Node {
        Node[] map;
        boolean flag;
        Node() {
            flag = true;
            map = new Node[26];
        }
    }

    // 建立字典树，将给定的单词数组排序
    // 排序规则是：首先按照长度从小到大进行排序，如果长度相同，则按照字典序倒序排序
    // 遍历排序后的单词数组，按序添加到字典序中
    // 添加规则是：如果当前字符不存在且该字符是字符串的最后一个字符，就将其添加，否则不添加
    // 最后倒序遍历单词数组，并在字典树中查找，如果找到，立即返回答案
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() == b.length()) return b.compareTo(a);
            return Integer.compare(a.length(), b.length());
        });

        Node[] root = new Node[26];
        for (String s : words) {
            put(s, root, 0);
        }

        for (int i = words.length - 1; i >= 0; i--) {
            if (find(words[i], root, 0)) return words[i];
        }

        return "";
    }

    private boolean put(String s, Node[] node, int i) {
        if (i == s.length()) return true;
        int index = s.charAt(i) - 'a';
        if (node[index] == null) {
            if (i != s.length() - 1) return false;
            node[index] = new Node();
            return put(s, node[index].map, i+1);
        }
        return put(s, node[index].map, i+1);
    }

    private boolean find(String s, Node[] node, int i) {
        if (i == s.length()) return true;
        int index = s.charAt(i) - 'a';
        return node[index] != null && find(s, node[index].map, i+1);
    }
}