import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-1);

        FindElements fe = new FindElements(root);
        System.out.println(fe.find(1));
        System.out.println(fe.find(3));
        System.out.println(fe.find(5));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// 递归的构造树，并把每个结点的值都加入散列表，以便后续检测
class FindElements {
    Map<Integer, Integer> map;
    public FindElements(TreeNode root) {
        map = new HashMap<>();
        root.val = 0;
        talgo(root, map);
    }

    private static void talgo(TreeNode node, Map<Integer, Integer> map) {
        map.put(node.val, 1);
        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
            talgo(node.left, map);
        }
        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
            talgo(node.right, map);
        }
    }
    
    public boolean find(int target) {
        return map.get(target) != null;
    }
}