import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(5);
        A.left = new TreeNode(3);
        A.right = new TreeNode(6);
        A.left.left = new TreeNode(2);
        A.left.right = new TreeNode(4);
        A.right.left = null;
        A.right.right = null;

        A.left.left.left = new TreeNode(1);
        A.left.left.right = null;
        A.left.right.left = null;
        A.left.right.right = null;
        A.left.left.left.left = null;
        A.left.left.left.right = null;
        //A.right.left.left = null;
        //A.right.left.right = null;
        //A.right.right.left = null;
        //A.right.right.right = null;
        System.out.println(new Solution().kthLargest(A, 3));
    }
}

class Solution {
    public int kthLargest(TreeNode root, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        pre(root, arrayList);
        return arrayList.get(arrayList.size()-k);
    }

    private static void pre(TreeNode x, ArrayList<Integer> arrayList) {
        if (x == null) return;
        pre(x.left, arrayList);
        arrayList.add(x.val);
        pre(x.right, arrayList);
    }
}