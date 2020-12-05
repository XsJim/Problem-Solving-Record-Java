import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(7);

        System.out.println(new Solution().isEvenOddTree(root));
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

// 层序遍历二叉树，分情况检查每一层的每一个结点是否满足条件
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int flag = 0;
        Deque<TreeNode> queueN = new ArrayDeque<>();
        int l = 0;
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            int x = (flag & 1);
            if (x == (node.val & 1)) return false;
            if (x == 0 && node.val <= l) return false;
            if (x == 1 && node.val >= l) return false;
            l = node.val;
            if (node.left != null) queueN.add(node.left);
            if (node.right != null) queueN.add(node.right);
            if (queue.size() == 0) {
                queue = queueN;
                queueN = new ArrayDeque<>();
                flag++;
                if ((flag & 1) == 0) l = 0;
                else l = 10000000;
            }
        }

        return true;
    }
}