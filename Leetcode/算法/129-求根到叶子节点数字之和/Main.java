public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Solution().sumNumbers(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int sumNumbers(TreeNode root) {
        int[] ans = new int[1];
        talgo(root, ans, 0);
        return ans[0];
    }

    private static void talgo(TreeNode node, int[] ans, int current_num) {
        if (node == null) return;
        current_num *= 10;
        current_num += node.val;
        if (node.left == null && node.right == null) {
            ans[0] += current_num;
            return;
        }
        talgo(node.left, ans, current_num);
        talgo(node.right, ans, current_num);
    }
}