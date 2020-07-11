import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isLongPressedName("alex", "aaleex"));
        System.out.println(new Solution().isLongPressedName("saeed", "ssaaedd"));
        System.out.println(new Solution().isLongPressedName("leelee", "lleeelee"));
        System.out.println(new Solution().isLongPressedName("laiden", "laiden"));
    }
}

class Solution {
    class Node {
        char x;
        int count;
        Node(char x, int count) {
            this.x = x;
            this.count = count;
        }
    }
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() == 0 && typed.length() == 0) return true;
        if (name.length() == 0 || typed.length() == 0) return false;

        ArrayList<Node> listN = talgo(name);
        ArrayList<Node> listT = talgo(typed);
        if (listN.size() != listT.size()) return false;
        Iterator<Node> itN = listN.iterator();
        Iterator<Node> itT = listT.iterator();
        while (itN.hasNext() && itT.hasNext()) {
            Node N = itN.next();
            Node T = itT.next();
            if (N.x != T.x || N.count > T.count) return false;
        }
        return true;
    }

    private ArrayList<Node> talgo(String s) {
        ArrayList<Node> list = new ArrayList<>();
        char[] n = s.toCharArray();
        char a = n[0];
        int c = 1;
        for (int i = 1; i < n.length; i++) {
            if (a == n[i]) c++;
            else {
                list.add(new Node(a, c));
                a = n[i]; c = 1;
            }
        }
        list.add(new Node(a, c));
        return list;
    }
}