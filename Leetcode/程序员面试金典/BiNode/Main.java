public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(0);
        root.right.right = new TreeNode(6);
        TreeNode.lev(new Solution().convertBiNode(root));
    }
}


class Solution {
    public TreeNode convertBiNode(TreeNode root) {
        TreeNode head = new TreeNode(-1);
        TreeNode[] ans = new TreeNode[] {head};
        mid(root, ans);
        return head.right;
    }

    private static void mid(TreeNode node, TreeNode[] ans) {
        if (node == null) return;
        mid(node.left, ans);
        ans[0].right = new TreeNode(node.val);
        ans[0] = ans[0].right;
        mid(node.right, ans);
    }
}