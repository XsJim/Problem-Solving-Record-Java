public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().isBalanced(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // 对于任何一个结点，如果左右子树的高度差大于 1 ，整棵树就视为不平衡
    // 所以对于每一个结点，都求出其左右子树的高度，然后确定其是否平衡
    // 使用递归实现
    // 递归方法接收一个结点，返回它的高度，当前结点的高度是其左右子树较高的那个加上 1
    // 所以如果当前结点为空，那么它的高度就是 0
    // 首先求左子树的高度，调用递归后，左子树的根节点又去调用递归计算自己的左右子树的高度
    // 右子树也相同
    // 当左右子树的高度都计算完毕，就判断它们的高度差，如果不满足条件，就将全局变量做标记
    // 然后返回当前子树的高度
    // 一次计算高度就是一次递归，任何位置都可能改变标记的值，所以在一次递归调用完毕后，就及时判断标记的状态
    // 如果标记已经改变，就不再进行接下来的步骤，因为已经判断完毕，完成了程序任务
    public boolean isBalanced(TreeNode root) {
        boolean[] ans = new boolean[] {true};
        talgo(root, ans);
        return ans[0];
    }

    private static int talgo(TreeNode node, boolean[] ans) {
        if (node == null) return 0;
        int l = talgo(node.left, ans);
        if (!ans[0]) return l;
        int r = talgo(node.right, ans);
        if (!ans[0]) return r;
        if (Math.abs(l-r) > 1) ans[0] = false;
        return Math.max(l, r)+1;
    }
}