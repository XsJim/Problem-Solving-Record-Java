public class Main {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }
}

// 创建字典树
// 正常添加单词
// 查询由给定前缀组成的所有单词时，首先在字典树中找到前缀的最后一个字母的结点
// 然后以这一点为根结点，求这颗子树上的所有存在单词的结点的权值的和
class MapSum {
    private Node[] root;
    class Node {
        Node[] son = new Node[26];
        boolean haveWord;
        int wordInt;

        Node(boolean haveWord) {
            this.haveWord = haveWord;
        }

        Node(boolean haveWord, int wordInt) {
            this.haveWord = haveWord;
            this.wordInt = wordInt;
        }

        private void isHaveWord() {
            haveWord = true;
        }

        private void setWordInt(int val) {
            this.wordInt = val;
        }
    }

    public void put(Node[] root, String key, int val) {
        if (key.length() == 0) return;
        putWord(root, key, val, 0);
    }

    private void putWord(Node[] map, String key, int val, int x) {
        int xx = key.charAt(x) - 'a';
        if (x == key.length() - 1) {
            if (map[xx] == null) {
                map[xx] = new Node(true, val);
            } else {
                map[xx].isHaveWord();
                map[xx].setWordInt(val);
            }
            return;
        }
        if (map[xx] == null) {
            map[xx] = new Node(false);
        }
        putWord(map[xx].son, key, val, x+1);
    }

    public static int get(Node[] root, String prefix) {
        if (prefix.length() == 0) return 0;
        return getSum(root, prefix, 0);
    }

    private static int getSum(Node[] map, String prefix, int x) {
        int xx = prefix.charAt(x) - 'a';
        if (x == prefix.length() - 1) {
            return add(map[xx]);
        }
        if (map[xx] == null) return 0;
        return getSum(map[xx].son, prefix, x+1);
    }

    private static int add(Node map) {
        if (map == null) return 0;
        int sum = map.haveWord ? map.wordInt : 0;
        for (int i = 0; i < 26; i++) {
            sum += add(map.son[i]);
        }
        return sum;
    }

    public MapSum() {
        root = new Node[26];
    }
    
    public void insert(String key, int val) {
        put(root, key, val);
    }
    
    public int sum(String prefix) {
        return get(root, prefix);
    }
}