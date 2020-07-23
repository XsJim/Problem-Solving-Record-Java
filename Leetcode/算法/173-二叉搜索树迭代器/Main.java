import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode current = stack.pop();
        int re = current.val;
        current = current.right;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        return re;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }
}