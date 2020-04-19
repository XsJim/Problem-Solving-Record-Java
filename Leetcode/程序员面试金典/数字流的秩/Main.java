import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        StreamRank obj = new StreamRank();
        System.out.println(obj.getRankOfNumber(1));
        obj.track(0);
        System.out.println(obj.getRankOfNumber(0));
    }
}

class StreamRank {
    private HashMap<Integer, Node> map;
    private LinkedList<Node> list;
    public StreamRank() {
        map = new HashMap<>();
        list = new LinkedList<>();
    }
    
    public void track(int x) {
        Node node = map.get(x);
        if (node == null) {
            node = new Node(x);
            map.put(x, node);
            int i = 0;
            for (Node n : list) {
                if (n.x > x) break;
                i++;
            }
            list.add(i, node);
        } else node.add();
    }
    
    public int getRankOfNumber(int x) {
        int ans = 0;
        for (Node n : list) {
            if (n.x <= x) ans += n.sum;
            else break;
        }
        return ans;
    }

    private class Node {
        int x;
        int sum;
        
        Node(int x) {
            this.x = x;
            sum = 1;
        }

        void add() {
            sum++;
        }
    }
}