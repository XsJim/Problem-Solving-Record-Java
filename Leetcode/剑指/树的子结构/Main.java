public class Main {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(4);
        A.right = new TreeNode(5);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(2);
        A.right.left = null;
        A.right.right = null;
        A.left.left.left = null;
        A.left.left.right = null;
        A.left.right.left = null;
        A.left.right.right = null;

        TreeNode B = new TreeNode(2);
        B.left = new TreeNode(1);
        B.right = null;
        B.left.left = null;
        B.left.right = null;

        System.out.println(new Solution().isSubStructure(A, null));
    }
}

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return false;
        return pre(A, B);
    }

    private static boolean pre(TreeNode A, TreeNode B) {
        if (A == null) return false;
        if (A.val == B.val && check(A, B)) return true;
        return pre(A.left, B) || pre(A.right, B);
    }

    private static boolean check(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        return (A.val == B.val) && check(A.left, B.left) && check(A.right, B.right);
    }
}