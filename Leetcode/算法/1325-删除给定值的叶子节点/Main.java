public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);

        TreeNode nRoot = new Solution().removeLeafNodes(root, 2);

        TreeNode.pre(nRoot);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void pre(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        pre(node.left);
        pre(node.right);
    }
}

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode prev = new TreeNode(-1);
        prev.left = root;
        talgo(root, prev, target, false);
        return prev.left;
    }

    private static void talgo(TreeNode node, TreeNode prev, int target, boolean flag) {
        if (node == null) return;
        if (check(node, prev, target, flag)) return;

        talgo(node.left, node, target, false);
        talgo(node.right, node, target, true);

        check(node, prev, target, flag);
    }

    private static boolean check(TreeNode node, TreeNode prev, int target, boolean flag) {
        if (node.left == null && node.right == null) {
            if (node.val == target) {
                if (flag) {
                    prev.right = null;
                } else {
                    prev.left = null;
                }
            }
            return true;
        }
        return false;
    }
}