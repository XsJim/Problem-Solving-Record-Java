import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        root = new Solution().connect(root);
        Node.pr(root);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static void pr(Node node) {
        if (node == null) return;
        System.out.println(node.val+" "+(node.next == null ? "#" : node.next.val));
        pr(node.left);
        pr(node.right);
    }
}

// 不是最优解
// 按层次得到每个结点的next值

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Deque<Node> queueN = new ArrayDeque<>();
        while (queue.size() > 0) {
            Node node = queue.poll();
            Node leftc = node.left;
            Node rightc = node.right;
            if (leftc != null) {
                queueN.add(leftc);
                if (rightc != null) leftc.next = rightc;
                else {
                    Node cur = node.next;
                    while (cur != null) {
                        if (cur.left != null) {
                            leftc.next = cur.left;
                            break;
                        }
                        if (cur.right != null) {
                            leftc.next = cur.right;
                            break;
                        }
                        cur = cur.next;
                    }
                }
            }

            if (rightc != null) {
                queueN.add(rightc);
                Node cur = node.next;
                while (cur != null) {
                    if (cur.left != null) {
                        rightc.next = cur.left;
                        break;
                    }
                    if (cur.right != null) {
                        rightc.next = cur.right;
                        break;
                    }
                    cur = cur.next;
                }
            }
            if (queue.size() == 0) {
                queue = queueN;
                queueN = new ArrayDeque<>();
            }
        }
        return root;
    }
}