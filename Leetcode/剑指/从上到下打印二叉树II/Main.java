import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

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
        System.out.println(new Solution().levelOrder(A));
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> queue_2 = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList_2 = new ArrayList<>();
        TreeNode current = root;
        int x = 1;
        while (current != null) {
            arrayList.add(current.val);
            arrayList_2.add(x);
            if (current.left != null) {
                queue.add(current.left);
                queue_2.add(x+1);
            }
            if (current.right != null) {
                queue.add(current.right);
                queue_2.add(x+1);
            }
            current = queue.pollFirst();
            if (queue_2.size() > 0) x = queue_2.poll();
        }
        int reLength = arrayList.size();
        List<List<Integer>> re = new LinkedList<>();
        int j = 0;
        for (int i = 1; i <= arrayList_2.get(reLength-1); i++) {
            re.add(new LinkedList<>());
            while (j < reLength && arrayList_2.get(j) == i) {
                re.get(i-1).add(arrayList.get(j));
                j++;
            }
        }
        return re;
    }
}