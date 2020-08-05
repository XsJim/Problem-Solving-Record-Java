public class Main {
    public static void main(String[] args) {
        MagicDictionary md = new MagicDictionary();
        md.buildDict(new String[] {"hello", "hallo", "leetcode"});
        System.out.println(md.search("hello"));
        System.out.println(md.search("hallo"));
        System.out.println(md.search("hell"));
        System.out.println(md.search("leetcoded"));
    }
}

// 维护一棵树
// 树的结点含有一个字符串 s ，和 26 个子结点
// 其中 s 表示由树根到达此结点的路径上的所有字母按序组成的字符串
// 每个结点所表示的字母都由他在父亲结点中存放的位置决定，树根没有父结点，所以表示空字符
// 构造树需要若干字符串，构造完成后，每条由树根至树叶的路径均表示一个单词
// 要确定某单词是否在树中，只需从树根开始逐个字符对比，若对比完成时，监测点位于一个树叶，且树叶的 s 和被检查单词相同，则说明单词存在
// 在本题中，有一次修改字符的机会，由于每个位置都可能被修改，所以在对比时，要给予每个位置修改的机会

class MagicDictionary {
    private static int R = 26;

    private class Node {
        String s;
        Node[] map;
        Node() {
            s = null;
            map = new Node[R];
        }
    }

    private Node root;

    public MagicDictionary() {
        root = null;
    }
    
    public void buildDict(String[] dict) {
        root = new Node();
        for (String str : dict) {
            put(str);
        }
    }

    private void put(String str) {
        put(root, str, 0);
    }

    private void put(Node n, String str, int i) {
        if (i == str.length()) {
            n.s = str;
            return;
        }
        int x = str.charAt(i)-'a';
        if (n.map[x] == null) n.map[x] = new Node();
        put(n.map[x], str, i+1);
    }
    
    public boolean search(String word) {
        if (root == null) return false;
        return find(word);
    }

    private boolean find(String word) {
        return find(root, word, 0, 1);
    }

    private boolean find(Node n, String word, int i, int count) {
        if (n == null) return false;
        if (i == word.length()) {
            if (n.s == null || count != 0) return false;
            return true;
        }

        int x = word.charAt(i)-'a';
        if (find(n.map[x], word, i+1, count)) return true;

        if (count == 0) return false;
        for (int j = 0; j < R; j++) {
            if (j != x && find(n.map[j], word, i+1, count-1)) {
                return true;
            }
        }

        return false;
    }
}