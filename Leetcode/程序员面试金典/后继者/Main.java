import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode t = new Solution().inorderSuccessor(root, root.left);
        if (t != null) System.out.println(t.val);
        else System.out.println("null");
    }
}

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return talgo(root, p);
    }

    private static TreeNode talgo(TreeNode node, TreeNode p) {
        if (node == null) return null;
        if (node.val <= p.val) {
            return talgo(node.right, p);
        } else {
            TreeNode left = talgo(node.left, p);
            return left != null ? left : node;
        }
    }
}
