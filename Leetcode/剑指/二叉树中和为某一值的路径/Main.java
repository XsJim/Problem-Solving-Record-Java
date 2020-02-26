import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(5);
        A.left = new TreeNode(4);
        A.right = new TreeNode(8);
        A.left.left =new TreeNode(11);
        A.left.right = null;
        A.right.left = new TreeNode(13);
        A.right.right = new TreeNode(4);

        A.left.left.left = new TreeNode(7);
        A.left.left.right = new TreeNode(2);
        //A.left.right.left = null;
        //A.left.right.right = null;
        A.right.left.left = null;
        A.right.left.right = null;
        A.right.right.left = new TreeNode(5);
        A.right.right.left.left = null;
        A.right.right.left.right = null;
        A.right.right.right = new TreeNode(1);
        A.right.right.right.left = null;
        A.right.right.right.right = null;
        System.out.println(new Solution().pathSum(A, 22));
    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> re = new LinkedList<>();
        if (root != null) {
            LinkedList<Integer> linked = new LinkedList<>();
            talgo(root, sum, re, linked, 0);
        }
        return re;
    }

    private static void talgo(TreeNode A, int sum, List<List<Integer>> list, LinkedList<Integer> linked, int tsum) {
        if (A.left == null && A.right == null && A.val + tsum == sum) {
            List<Integer> current = new LinkedList<>();
            for (int i = 0; i < linked.size(); i++) {
                current.add(linked.get(i));
            }
            current.add(A.val);
            list.add(current);
            return;
        }
        linked.add(A.val);
        if (A.left != null) talgo(A.left, sum, list, linked, tsum+A.val);
        if (A.right != null) talgo(A.right, sum, list, linked, tsum+A.val);
        linked.pollLast();
    }
}