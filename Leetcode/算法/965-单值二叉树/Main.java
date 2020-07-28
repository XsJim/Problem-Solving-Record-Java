public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        System.out.println(new Solution().isUnivalTree(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return check(root, root.val);
    }

    private static boolean check(TreeNode node, int x) {
        if (node == null) return true;
        return (node.val == x) && check(node.left, x) && check(node.right, x);
    }
}