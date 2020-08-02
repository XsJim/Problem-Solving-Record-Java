import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        System.out.println(new Solution().replaceWords(dict, "the cattle was rattled by the battery"));
    }
}

class Solution {
    private class Node {
        public Node[] child;
        public String s;
        public Node() {
            child = new Node[26];
            s = null;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        Node root = new Node();
        for (String str : dict) {
            put(str, 0, root);
        }

        String[] sS = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sS.length; i++) {
            sb.append(find(sS[i], root, 0));
            if (i + 1 < sS.length) sb.append(" ");
        }

        return sb.toString();
    }

    private void put(String str, int i, Node n) {
        int x = str.charAt(i) - 'a';
        if (n.child[x] == null) {
            n.child[x] = new Node();
        }

        if (i + 1 == str.length()) {
            n.child[x].s = str;
            return;
        }

        put(str, i+1, n.child[x]);
    }

    private static String find(String str, Node n, int i) {
        if (i == str.length()) return str;
        int x = str.charAt(i) - 'a';
        if (n.child[x] == null) {
            return str;
        }

        if (n.child[x].s != null) {
            return n.child[x].s;
        }

        return find(str, n.child[x], i+1);
    }
}