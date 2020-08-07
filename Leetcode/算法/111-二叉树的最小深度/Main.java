public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().minDepth(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // 递归每一个结点，从 root 开始，它位于第一层，它的左右子树分别比它多一层
    // 如果当前节点的左右两个子树都为空，那么当前节点就是一个叶子节点，判断当前层数是否小于最小值，如果是，则改变这个最小值
    // 当 root 为 null 时，无法完成判断（是否为树叶），所以对这种情况需要特判
    public int minDepth(TreeNode root) {
        int[] min = new int[1];
        if (root == null) return min[0];

        min[0] = Integer.MAX_VALUE;
        talgo(root, 1, min);

        return min[0];
    }

    private static void talgo(TreeNode node, int d, int[] min) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            if (d < min[0]) min[0] = d;
            return;
        }
        talgo(node.left, d+1, min);
        talgo(node.right, d+1, min);
    }
}