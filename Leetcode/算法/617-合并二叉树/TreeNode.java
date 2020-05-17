public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static void pre(TreeNode a) {
        if (a == null) System.out.println("null");
        else {
            System.out.println(a.val);
            pre(a.left);
            pre(a.right);
        }
    }
}