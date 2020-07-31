public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(new Solution().sumRootToLeaf(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        int[] ans = new int[1];
        talgo(root, 0, ans, (int)10e9+7);
        return ans[0];
    }

    private static void talgo(TreeNode node, int num, int[] ans, int M) {
        if (node == null) return;
        num &= 0x3fffffff;
        num <<= 1;
        num |= node.val;
        if (node.left == null && node.right == null) {
            ans[0] += num;
            ans[0] %= M;
            return;
        }
        talgo(node.left, num, ans, M);
        talgo(node.right, num, ans, M);
    }
}