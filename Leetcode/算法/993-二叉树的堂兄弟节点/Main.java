public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new Solution().isCousins(root, 5, 4));
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

class Solution {
    // 首先遍历二叉树找第一个结点，要保存两个有用的信息，结点所在的高度和结点的父结点
    // 判断第一个结点是否找到，如果没找到，那么就返回 false
    // 然后找第二个结点，二次遍历过程中，遍历的范围是小于等于结点一的高度
    // 如果找到第二个结点，就比较两结点的父结点是否相同，如果父结点不同，就说明两结点是堂兄弟
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] max = new int[] {Integer.MAX_VALUE};

        int[] xH = new int[] {-1};
        TreeNode xP = talgo(null, root, x, 0, xH, max);
        if (xP == null) return false;
        max[0] = xH[0];
        int[] yH = new int[] {-1};
        TreeNode yP = talgo(null, root, y, 0, yH, max);
        if (yP == null || xP == yP || xH[0] != yH[0]) return false;
        return true;
    }

    private static TreeNode talgo(TreeNode prev, TreeNode node, int a, int current_h, int[] h, int[] max) {
        if (node == null || current_h > max[0]) return null;
        if (node.val == a) {
            h[0] = current_h;
            return prev;
        }
        TreeNode l = talgo(node, node.left, a, current_h+1, h, max);
        if (l != null) return l;
        TreeNode r = talgo(node, node.right, a, current_h+1, h, max);
        return r;
    }
}