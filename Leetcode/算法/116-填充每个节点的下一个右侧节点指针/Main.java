public class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
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

// 建立一个递归函数，函数的参数中，包括一个当前结点，当前结点的父结点，以及标记当前结点是其父结点的左右结点的标记变量
// 假设调用此递归函数时，参数中父结点的next值已经设定，若next存在则为父结点的相邻结点，否则为null
// 递归函数的目的是设定当前结点的next值，并对它的子元素进行相同的操作
// 当前结点的next值根据它在父结点中的位置决定
// 若其为父结点的左孩子，那么它的next值指向父结点的右孩子
// 若其为父结点的右孩子，那么它的next值指向父结点的next值的左孩子
// 由上可知，若要设定一个结点的next值，只需知道它的父结点（它为左结点）或者父结点的next值（它为右结点）即可
// 那么对于当前结点的左右两个孩子结点来说，也可以设定它们的next值了（对于它们来说已经得到父结点的next值了）
// 所以继续调用递归函数即可
// 在递归函数的入口，需要设定root结点的next值，这时可以创建一个假的父结点值，不论将其设置为这个假父结点的左孩子还是右孩子，只要保证在对应得赋值语句中不出现对null的引用即可
class Solution {
    public Node connect(Node root) {
        talgo(new Node(), root, 0);
        return root;
    }

    private static void talgo(Node prev, Node node, int flag) {
        if (node == null) return;
        if (flag == 0) {
            node.next = prev.right;
        } else {
            if (prev.next != null) node.next = prev.next.left;
        }
        talgo(node, node.left, 0);
        talgo(node, node.right, 1);
    }
}