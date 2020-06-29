public class Main {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        map.put(1, 2);
        System.out.println(map.get(1));
        map.remove(1);
        System.out.println(map.get(1));
    }
}

class MyHashMap {
    private int[] map;

    public MyHashMap() {
        int R = 1000001;
        map = new int[R];
        for (int i = 0; i < R; i++) map[i] = -1;
    }
    
    public void put(int key, int value) {
        map[key] = value;
    }
    
    public int get(int key) {
        return map[key];
    }
    
    public void remove(int key) {
        map[key] = -1;
    }
}