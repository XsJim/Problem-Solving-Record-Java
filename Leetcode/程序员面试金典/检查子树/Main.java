import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        TreeNode t2 = new TreeNode(2);

        System.out.println(new Solution().checkSubTree(t1, t2));
    }
}

class Solution {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) return true; 
        LinkedList<TreeNode> list = new LinkedList<>();
        pre(t1, t2, list);

        for (TreeNode node : list) {
            if (talgo(node, t2)) return true;
        }
        return false;
    }

    private static void pre(TreeNode t1, TreeNode t2, LinkedList<TreeNode> list) {
        if (t1 == null) return;
        if (t1.val == t2.val) list.add(t1);
        if (t1.left != null) pre(t1.left, t2, list);
        if (t1.right != null) pre(t1.right, t2, list);
    }

    private static boolean talgo(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null) return false;
        if (t2 == null) return true;
        if (t1.val == t2.val) return talgo(t1.left, t2.left) && talgo(t1.right, t2.right);
        return false;  
    }
}