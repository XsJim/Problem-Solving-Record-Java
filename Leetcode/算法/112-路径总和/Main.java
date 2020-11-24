public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.right = new TreeNode(1);

        System.out.println(new Solution().hasPathSum(root, 22));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// 递归每条可能路径，到达叶子时判断整条路径的和是否为所求数
// 在某条路径满足要求后，其他路径的判断应该取消
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean[] flag = new boolean[1];
        talgo(root, sum, 0, flag);
        return flag[0];
    }

    private static void talgo(TreeNode node, int sum, int curSum, boolean[] flag) {
        if (node == null || flag[0]) return;
        curSum += node.val;
        if (node.left == null && node.right == null) {
            if (curSum == sum) flag[0] = true;
            return;
        }
        talgo(node.left, sum, curSum, flag);
        talgo(node.right, sum, curSum, flag);
    }
}