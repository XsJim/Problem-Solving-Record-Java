public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Solution().findTilt(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // 对于每一个结点，都有相同的需求，求左子树和、右子树和，求差的绝对值，加入最终答案
    // 对于当前的结点，它也是父结点的一个子结点，当有了当前结点左右子树的和之后，再加上自己的值，就是以他为根的子树的和，也是它的父结点所需要的一个值
    // 程序通过递归实现
    // 首先判断当前结点是否为空，若为空，则不需要计算它的左右子树的差的绝对值，也不需要返回它和它的左右子树的和，当前的空子树的和为 0
    // 如果不为空，就递归的计算左子树的和，右子树的和
    // 将它们的差的绝对值加入最终答案
    // 然后返回左右子树和加上当前结点的值的和
    public int findTilt(TreeNode root) {
        int[] sum = new int[] {0};
        talgo(root, sum);
        return sum[0];
    }

    private static int talgo(TreeNode node, int[] sum) {
        if (node == null) return 0;
        int l = talgo(node.left, sum);
        int r = talgo(node.right, sum);
        sum[0] += Math.abs(l-r);
        return l + r + node.val;
    }
}