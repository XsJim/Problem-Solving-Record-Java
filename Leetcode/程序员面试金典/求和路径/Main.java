public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);
        
        System.out.println(new Solution().pathSum(root, 4));
    }
}

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int[] ans = new int[] {0};
        talgo_begin(root, sum, ans);
        return ans[0];
    }

    private static void talgo(TreeNode node, int sum, int nowSum, int[] ans) {
        if (node == null) return;
        if ((nowSum + node.val) == sum) ans[0]++;
        talgo(node.left, sum, nowSum+node.val, ans);
        talgo(node.right, sum, nowSum+node.val, ans);
    }

    private static void talgo_begin(TreeNode node, int sum, int[] ans) {
        if (node == null) return;
        talgo(node, sum, 0, ans);
        talgo_begin(node.left, sum, ans);
        talgo_begin(node.right, sum, ans);
    }
}