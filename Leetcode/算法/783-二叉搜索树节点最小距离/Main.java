public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(new Solution().minDiffInBST(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // 求两结点的差的最小值，这两结点一定是树中数字排序后相邻的两个，（把数字映射到数轴上，距离最小的两个数，相应的差也最小）
    // 二叉搜索树的中序遍历，遍历结果就是整个树最终的排序结果
    // 遍历添加时的顺序是这样的，先左子树，添加当前值，再右子树
    // 既然添加的值就是最终顺序，那么添加当前值时，也可以算出与上一个值的差，再判断是否是最小差即可
    // 需要注意的是，添加第一个值时，它前面是没有值的，所以这个地方要特判
    public int minDiffInBST(TreeNode root) {
        int[] min = new int[] {Integer.MAX_VALUE};
        talgo(root, new int[1], min, new boolean[1]);
        return min[0];
    }

    private static void talgo(TreeNode node, int[] i, int[] min, boolean[] flag) {
        if (node == null) return;
        talgo(node.left, i, min, flag);
        if (flag[0]) {
            int x = node.val - i[0];
            if (x < min[0]) min[0] = x;
        } else {
            flag[0] = true;
        }
        i[0] = node.val;
        talgo(node.right, i, min, flag);
    }
}