public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root = new Solution().pruneTree(root);
        System.out.println(root);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        TreeNode nRoot = new TreeNode(-1);
        nRoot.left = root;
        talgo(nRoot);
        return nRoot.left;
    }

    private static boolean talgo(TreeNode node) {
        if (node == null) return true;

        boolean l = talgo(node.left);
        boolean r = talgo(node.right);
        if (l) node.left = null;
        if (r) node.right = null;

        if (node.val == 1) return false;
        return (l && r);
    }
}