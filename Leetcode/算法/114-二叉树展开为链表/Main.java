import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        new Solution().flatten(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
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
    // 前序遍历加入链表，遍历链表改变结点结构
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        talgo(root, list);
        TreeNode prev = null;
        for (TreeNode current : list) {
            current.left = null;
            if (prev != null) {
                prev.right = current;
                prev = current;
            } else prev = current;
        }
    }

    private static void talgo(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        list.add(node);
        talgo(node.left, list);
        talgo(node.right, list);
    }
}