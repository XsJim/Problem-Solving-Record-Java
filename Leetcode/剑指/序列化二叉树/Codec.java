import java.util.LinkedList;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (linkedList.size() > 0) {
            TreeNode current = linkedList.remove();
            if (current == null) {
                sb.append(",null");
            } else {
                sb.append("," + current.val);
                linkedList.add(current.left);
                linkedList.add(current.right);
            }
        }
        if (sb.length() > 0) {
            return sb.substring(1);
        } else return "";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        if (strings[0].equals("null")) return null;

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        linkedList.add(root);
        int i = 1;
        while (linkedList.size() > 0) {
            TreeNode current = linkedList.remove();
            if (strings[i].equals("null")) current.left = null;
            else {
                current.left = new TreeNode(Integer.parseInt(strings[i]));
                linkedList.add(current.left);
            }
            i++;
            if (strings[i].equals("null")) current.right = null;
            else {
                current.right = new TreeNode(Integer.parseInt(strings[i]));
                linkedList.add(current.right);
            }
            i++;
        }
        return root;
    }
}