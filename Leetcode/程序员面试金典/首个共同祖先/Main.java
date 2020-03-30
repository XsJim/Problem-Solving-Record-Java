public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(new Solution().lowestCommonAncestor(root, root.left, root.right).val);
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return talgo(root, p, q);
    }

    private static TreeNode talgo(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || p == node || q == node) return node;
        TreeNode left = talgo(node.left, p, q);
        TreeNode right = talgo(node.right, p, q);
        if (left != null && right != null) return node;
        return left != null ? left : right;
    }
}