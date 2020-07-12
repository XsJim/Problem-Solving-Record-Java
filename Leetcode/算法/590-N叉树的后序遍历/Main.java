import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(3);
        Node b = new Node(2);
        Node c = new Node(4);
        List<Node> list = new ArrayList<>();
        list.add(a); list.add(b); list.add(c);
        root.children = list;
        Node d = new Node(5);
        Node e = new Node(6);
        list = new ArrayList<>();
        list.add(d); list.add(e);
        a.children = list;

        System.out.println(new Solution().postorder(root));
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
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) talgo(list, root);
        return list;
    }

    private static void talgo(List<Integer> list, Node curr) {
        if (curr.children != null) {
            for (Node n : curr.children) {
                talgo(list, n);
            }
        }
        list.add(curr.val);
    }
}