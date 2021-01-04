import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        
        root.right = new TreeNode(2);

        root.right.left = new TreeNode(3);

        System.out.println(new Solution().inorderTraversal(root));
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

// 递归
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        talgo(root, list);
        return list;
    }

    private static void talgo(TreeNode node, List<Integer> list) {
        if (node == null) return;
        talgo(node.left, list);
        list.add(node.val);
        talgo(node.right, list);
    }
}