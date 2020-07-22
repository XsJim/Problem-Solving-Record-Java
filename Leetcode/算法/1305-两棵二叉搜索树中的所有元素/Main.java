import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);

        System.out.println(new Solution().getAllElements(root1, root2));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        mid(root1, list1);
        List<Integer> list2 = new ArrayList<>();
        mid(root2, list2);
        if (list1.size() == 0) return list2;
        if (list2.size() == 0) return list1;

        List<Integer> ans = new ArrayList<>(list1.size()+list2.size());

        Iterator<Integer> it1 = list1.iterator();
        Iterator<Integer> it2 = list2.iterator();
        it1.hasNext(); it2.hasNext();
        int r1 = it1.next();
        int r2 = it2.next();
        w: while (true) {
            while (r1 <= r2) {
                ans.add(r1);
                if (it1.hasNext()) r1 = it1.next();
                else {
                    ans.add(r2);
                    break w;
                }
            }
            while (r2 <= r1) {
                ans.add(r2);
                if (it2.hasNext()) r2 = it2.next();
                else {
                    ans.add(r1);
                    break w;
                }
            }
        }

        while (it1.hasNext()) ans.add(it1.next());
        while (it2.hasNext()) ans.add(it2.next());

        return ans;
    }

    private static void mid(TreeNode node, List<Integer> list) {
        if (node == null) return;
        mid(node.left, list);
        list.add(node.val);
        mid(node.right, list);
    }
}