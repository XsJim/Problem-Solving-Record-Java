public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().maxDepth(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int maxDepth(TreeNode root) {
        int[] max = new int[] {0};
        talgo(root, max, 0);
        return max[0];
    }

    private static void talgo(TreeNode nd, int[] max, int n) {
        if (nd == null) return;
        n++;
        if (n > max[0]) max[0] = n;
        talgo(nd.left, max, n);
        talgo(nd.right, max, n);
    }
}