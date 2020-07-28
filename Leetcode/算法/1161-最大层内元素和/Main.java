public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        System.out.println(new Solution().maxLevelSum(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int maxLevelSum(TreeNode root) {
        int[] sum = new int[10001];
        talgo(sum, 1, root);
        int ans = 1, max = sum[1];
        for (int i = 2; i < 10001; i++) {
            if (sum[i] > max) {
                max = sum[i];
                ans = i;
            }
        }

        return ans;
    }

    private static void talgo(int[] sum, int h, TreeNode node) {
        if (node == null) return;
        sum[h] += node.val;
        talgo(sum, h+1, node.left);
        talgo(sum, h+1, node.right);
    }
}