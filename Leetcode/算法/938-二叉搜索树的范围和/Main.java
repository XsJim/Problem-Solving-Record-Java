public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(new Solution().rangeSumBST(root, 7, 15));
    }
}

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int[] sum = new int[] {0};
        talgo(root, sum, L, R);
        return sum[0];
    }

    private static void talgo(TreeNode node, int[] sum, int L, int R) {
        if (node == null) return;
        if (node.val < L) {
            talgo(node.right, sum, L, R);
            return;
        }
        if (node.val > R) {
            talgo(node.left, sum, L, R);
            return;
        }
        talgo(node.left, sum, L, R);
        sum[0] += node.val;
        talgo(node.right, sum, L, R);
    }
}