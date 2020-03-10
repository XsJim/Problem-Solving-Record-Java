import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right.left = null;
        root.right.right = null;

        root.left.left.left = null;
        root.left.left.right = null;

        root.left.right.left = null;
        root.left.right.right = null;

        Node head = new Solution().treeToDoublyList(root);
        Node current = head;
        for (int i = 0; i < 5; i++) {
            System.out.println(current.val);
            current = current.right;
        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        LinkedList<Node> linkedList = new LinkedList<>();
        mid(root, linkedList);
        Node prev = linkedList.getLast();
        for (int i = 0; i < linkedList.size()-1; i++) {
            Node current = linkedList.get(i);
            current.left = prev;
            current.right = linkedList.get(i+1);
            prev = current;
        }
        Node prev_2 = linkedList.getLast();
        prev_2.left = prev;
        prev_2.right = linkedList.getFirst();
        return linkedList.getFirst();
    }

    private static void mid(Node x, LinkedList<Node> linkedList) {
        if (x == null) return;
        mid(x.left, linkedList);
        linkedList.add(x);
        mid(x.right, linkedList);
    }
}