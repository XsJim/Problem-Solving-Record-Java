import java.util.ArrayDeque;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static void lev(TreeNode head) {
        if (head == null) return;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            System.out.println(current.val);
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }
}