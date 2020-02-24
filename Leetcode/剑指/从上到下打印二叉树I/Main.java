import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(9);
        A.right = new TreeNode(20);
        A.left.left = null;
        A.left.right = null;
        A.right.left = new TreeNode(15);
        A.right.right = new TreeNode(7);

        //A.left.left.left = null;
        //A.left.left.right = null;
        //A.left.right.left = null;
        //A.left.right.right = null;
        A.right.left.left = null;
        A.right.left.right = null;
        A.right.right.left = null;
        A.right.right.right = null;
        System.out.println(Arrays.toString(new Solution().levelOrder(A)));
    }
}

class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            arrayList.add(current.val);
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
            current = queue.pollFirst();
        }
        int reLength = arrayList.size();
        int[] re = new int[reLength];
        for (int i = 0; i < reLength; i++) {
            re[i] = arrayList.get(i);
        }
        return re;
    }
}