public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static void print(TreeNode current) {
        if (current == null) {
            System.out.println("*");
            return;
        }
        System.out.println(current.val);
        print(current.left);
        print(current.right);
    }
}