import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}

class LRUCache {
    private HashMap<Integer, Integer> map;
    private LinkedList<Integer> list;
    private int max_size;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new LinkedList<>();
        max_size = capacity;
    }
    
    public int get(int key) {
        Integer value = map.get(key);
        if (value == null) return -1;
        list.remove((Integer)key);
        list.add(key);
        return value;
    }
    
    public void put(int key, int value) {
        if (map.get(key) != null) {
            list.remove((Integer)key);
        }
        else if (list.size() == max_size) {
            map.remove(list.removeFirst());
        }
        map.put(key, value);
        list.add(key);
    }
}