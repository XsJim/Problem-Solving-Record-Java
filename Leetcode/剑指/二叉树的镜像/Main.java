public class Main {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(4);
        A.left = new TreeNode(2);
        A.right = new TreeNode(7);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(3);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(9);

        A.left.left.left = null;
        A.left.left.right = null;
        A.left.right.left = null;
        A.left.right.right = null;
        A.right.left.left = null;
        A.right.left.right = null;
        A.right.right.left = null;
        A.right.right.right = null;
        TreeNode.pre(A);
        System.out.println("__________");
        A = new Solution().mirrorTree(A);

        TreeNode.pre(A);
    }
}

class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        return talgo(root);
    }

    private static TreeNode talgo(TreeNode a) {
        if (a == null) return null;
        TreeNode temp = a.left;
        a.left = talgo(a.right);
        a.right = talgo(temp);
        return a;
    }
}