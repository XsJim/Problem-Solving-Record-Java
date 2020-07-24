import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        Node root = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        list.add(n1); list.add(n2); list.add(n3);
        root.children = list;
        list = new ArrayList<>();
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        list.add(n4); list.add(n5);
        n1.children = list;
        System.out.println(new Solution().maxDepth(root));
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    public int maxDepth(Node root) {
        int[] max = new int[1];
        talgo(root, max, 1);

        return max[0];
    }
    
    private static void talgo(Node node, int[] max, int h) {
        if (node == null) return;
        if (h > max[0]) max[0] = h;
        if (node.children == null) return;
        for (Node n : node.children) {
            talgo(n, max, h+1);
        }
    }
}