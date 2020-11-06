public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(new Solution().kthSmallest(root, 3));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// 中序遍历得到的是顺序序列
// 在每次向序列添加元素时，记录当前元素个数，如果达到 k ，则说明这个值应当被返回，将它记录到答案数组
// 为了优化查找速度，所以在得到这个值后，后续的遍历就可以取消，在每次向下搜索之前，首先判断元素个数是否已经达到条件
// 如果答案已经被记录下来，就停止
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[1];
        talgo(root, ans, new int[1], k);
        return ans[0];
    }

    private static void talgo(TreeNode node, int[] ans, int[] count, int k) {
        if (count[0] == k) return;
        if (node == null) return;
        talgo(node.left, ans, count, k);
        count[0]++;
        if (count[0] == k) ans[0] = node.val;
        talgo(node.right, ans, count, k);
    }
}