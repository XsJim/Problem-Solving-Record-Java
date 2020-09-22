public class Main {
    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("pad"));
        System.out.println(wd.search("bad"));
        System.out.println(wd.search(".ad"));
        System.out.println(wd.search("b.."));
    }
}
// 建立字典树
// 添加单词既向字典树中添加新的路径
// 查找单词按照路径检查即可
// 遇到 '.' 时，要循环匹配这一层的所有位置，每一种可通过的路径都要检查，在某次检查找到正确路径时，立即返回答案
class WordDictionary {
    class Node {
        boolean flag;
        Node[] map;
        Node() {
            map = new Node[26];
            flag = false;
        }
    }
    private Node[] root;
    private static final int R = 26;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node[R];
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        add(word, 0, root);
    }

    private void add(String s, int index, Node[] map) {
        int c = s.charAt(index) - 'a';
        if (map[c] == null) {
            map[c] = new Node();
        }
        if (index + 1 == s.length()) {
            map[c].flag = true;
            return;
        }
        add(s, index+1, map[c].map);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return check(word, 0, root);
    }

    private boolean check(String s, int index, Node[] map) {
        int c = s.charAt(index) - 'a';
        if (c >= 0 && c < R) {
            if (map[c] != null) {
                if (index + 1 == s.length()) return map[c].flag;
                return check(s, index+1, map[c].map);
            }
            return false;
        } else {
            boolean flag_i = false;
            for (int i = 0; i < R; i++) {
                if (map[i] != null) {
                    if (index + 1 == s.length()) {
                        flag_i = map[i].flag;
                    } else {
                        flag_i = check(s, index+1, map[i].map);
                    }
                    if (flag_i) return true;
                }
            }
        }
        return false;
    }
}