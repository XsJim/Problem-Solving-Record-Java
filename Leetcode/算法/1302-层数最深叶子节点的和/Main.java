public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.left = new TreeNode(7);

        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        System.out.println(new Solution().deepestLeavesSum(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int[] max = new int[1];
        int[] sum = new int[1];
        talgo(root, 1, max, sum);
        return sum[0];
    }

    private static void talgo(TreeNode node, int d, int[] max, int[] sum) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            if (d > max[0]) {
                max[0] = d;
                sum[0] = node.val;
            }
            else if (d == max[0]) {
                sum[0] += node.val;
            }
            return;
        }
        talgo(node.left, d+1, max, sum);
        talgo(node.right, d+1, max, sum);
    }
}