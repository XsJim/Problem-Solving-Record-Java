import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(new Solution().binaryTreePaths(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root != null) talgo(root, "", list);
        return list;
    }

    private static void talgo(TreeNode node, String s, List<String> list) {
        if (!s.equals("")) s += "->";
        s += node.val;
        if (node.left == null && node.right == null) {
            list.add(s);
            return;
        }
        if (node.left != null) talgo(node.left, s, list);
        if (node.right != null) talgo(node.right, s, list);
    }
}