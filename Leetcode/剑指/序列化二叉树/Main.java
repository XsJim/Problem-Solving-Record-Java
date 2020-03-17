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

        Codec codec = new Codec();
        // System.out.println(codec.serialize(A));
        TreeNode.pre(codec.deserialize(codec.serialize(A)));
        System.out.println("-------------------------");
        // System.out.println(codec.serialize(null));
        TreeNode.pre(codec.deserialize(codec.serialize(null)));
        System.out.println("-------------------------");
        TreeNode B = new TreeNode(9);
        B.left = null;
        B.right = new TreeNode(11);
        B.right.left = null;
        B.right.right = null;
        // System.out.println(codec.serialize(B));
        TreeNode.pre(codec.deserialize(codec.serialize(B)));
    }
}