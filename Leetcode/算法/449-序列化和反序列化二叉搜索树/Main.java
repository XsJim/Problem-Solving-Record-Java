public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        Codec c = new Codec();
        String data = c.serialize(root);
        System.out.println(data);
        root = c.deserialize(data);
        while (root != null) {
            System.out.println(root.val);
            root = root.left;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {
    // 树的序列化和反序列化
    // 均使用递归实现
    // 序列化步骤中，每个结点对应的序列由一或两部分组成
    // 1. 如果结点非空，则该结点序列由 1 开头，后接它所含的数字
    // 2. 如果结点为空，则该结点序列由 0 开头，后面什么都没有
    // 整体过程按照先左后右，遇空返回的规则，这样也保证了反序列化可以正确进行
    // 反序列化过程中，首先解析当前遇到的是结点还是空结点
    // 1. 如果该结点序列由 1 开头，说明结点非空，首先创立该结点，然后从序列中读取它所包含的数字（数字的结尾是一个特殊符号）
    //    再按照规则，读取它的左子树、右子树
    // 2. 如果该结点序列由 0 开头，说明遇到空结点，则直接返回 null ，不需要再向下构造
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        s(root, sb);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        return d(data, new int[] {0});
    }

    private static void s(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(0);
            return;
        }
        sb.append(1);
        sb.append(node.val);
        sb.append('*');
        s(node.left, sb);
        s(node.right, sb);
    }

    private static TreeNode d(String str, int[] i) {
        if (i[0] >= str.length()) return null;
        if (str.charAt(i[0]++) == '0') return null;
        TreeNode node = new TreeNode(getInteger(str, i));
        node.left = d(str, i);
        node.right = d(str, i);
        return node;
    }

    private static int getInteger(String str, int[] i) {
        char x = str.charAt(i[0]++);
        int ans = 0;
        while (x != '*') {
            ans *= 10;
            ans += (x - '0');
            x = str.charAt(i[0]++);
        }
        return ans;
    }
}