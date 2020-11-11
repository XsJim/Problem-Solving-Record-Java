import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        TreeNode root2= new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(8);
        root2.right.right.right = new TreeNode(9);
        System.out.println(new Solution().leafSimilar(root1, root2));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// 首先通过递归分别得到两颗树的叶子序列
// 然后对比长度，如果序列长度不同，返回 false
// 否则，按顺序对比每个元素，如果全部相同，则说明两个数是叶子相似的树
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        talgo(root1, list1);
        talgo(root2, list2);
        if (list1.size() != list2.size()) return false;
        Iterator<Integer> it1 = list1.iterator(), it2 = list2.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            if (it1.next() != it2.next()) return false;
        }
        return true;
    }

    private static void talgo(TreeNode node, List<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        talgo(node.left, list);
        talgo(node.right, list);
    }
}