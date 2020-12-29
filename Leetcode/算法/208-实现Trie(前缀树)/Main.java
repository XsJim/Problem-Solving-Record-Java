public class Main {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.search("apple"));
        System.out.println(t.search("app"));
        System.out.println(t.startsWith("app"));
        t.insert("app");
        System.out.println(t.search("app"));
    }
}

// 实现前缀字典树
class Trie {
    private Node root;
    class Node {
        boolean isWord;
        Node[] child;
        Node() {
            isWord = false;
            child = new Node[26];
        }
    }

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        insert_x(word, 0, root);
    }

    private void insert_x(String word, int index, Node map) {
        if (index == word.length()) {
            map.isWord = true;
            return;
        }
        int x = word.charAt(index) - 'a';
        Node map_x = map.child[x];
        if (map_x == null) map.child[x] = new Node();
        insert_x(word, index+1, map.child[x]);

    }

    public boolean search(String word) {
        return search_x(word, 0, root);
    }

    private boolean search_x(String word, int index, Node map) {
        if (index == word.length()) return map.isWord;
        int x = word.charAt(index) - 'a';
        Node map_x = map.child[x];
        if (map_x == null) return false;
        return search_x(word, index+1, map.child[x]);
    }

    public boolean startsWith(String prefix) {
        return startsWith_x(prefix, 0, root);
    }

    private boolean startsWith_x(String word, int index, Node map) {
        if (index == word.length()) return true;
        int x = word.charAt(index) - 'a';
        Node map_x = map.child[x];
        if (map_x == null) return false;
        return startsWith_x(word, index+1, map.child[x]);
    }
}