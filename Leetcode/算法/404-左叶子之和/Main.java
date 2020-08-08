public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new Solution().sumOfLeftLeaves(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // 要求的是所有左叶子的和
    // 所以当满足两个条件时：
    // 1. 叶子
    // 2. 是其父节点的左孩子
    // 可以将该结点的值加入答案
    // 递归块内包含的是当前结点，这个结点的值该不该加，要考虑上面的两个因素
    // 所以在递归块内，要判断当前结点是否为叶子，且是否为父结点的左孩子
    // 第一个条件由当前结点便可推出，看看它是否有孩子
    // 第二个条件涉及到了父结点，必须由参数给出，即由它的上层递归给出，所以参数中要包含一个标记当前结点是否为左孩子的值
    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum = new int[] {0};
        talgo(root, sum, false);

        return sum[0];
    }

    private static void talgo(TreeNode node, int[] sum, boolean flag) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            if (flag) sum[0] += node.val;
            return;
        }
        talgo(node.left, sum, true);
        talgo(node.right, sum, false);
    }
}