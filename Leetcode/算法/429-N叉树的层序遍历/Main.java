import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        List<Node> list = new ArrayList<>();
        list.add(n1); list.add(n2); list.add(n3);
        root.children = list;
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        list = new ArrayList<>();
        list.add(n4); list.add(n5);
        n1.children = list;
        System.out.println(new Solution().levelOrder(root));
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
    public List<List<Integer>> levelOrder_dq(Node root) {
        Deque<Node> queue_1 = new ArrayDeque<>();
        Deque<Node> queue_2 = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        queue_1.add(root);

        while (queue_1.size() > 0) {
            List<Integer> list = new ArrayList<>();
            while (queue_1.size() > 0) {
                Node n = queue_1.poll();
                list.add(n.val);
                if (n.children != null) for (Node nd : n.children) queue_2.add(nd);
            }
            Deque<Node> temp = queue_1;
            queue_1 = queue_2;
            queue_2 = temp;
            ans.add(list);
        }

        return ans;
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        talgo(root, ans, 0);
        return ans;
    }

    private static void talgo(Node n, List<List<Integer>> ans, int h) {
        if (ans.size() == h) {
            ans.add(new ArrayList<Integer>());
        }
        ans.get(h).add(n.val);
        if (n.children != null) {
            for (Node nd : n.children) {
                talgo(nd, ans, h+1);
            }
        }
    }
}