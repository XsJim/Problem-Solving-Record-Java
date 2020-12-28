import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        System.out.println(os.insert(3,"ccccc"));
        System.out.println(os.insert(1,"aaaaa"));
        System.out.println(os.insert(2,"bbbbb"));
        System.out.println(os.insert(5,"eeeee"));
        System.out.println(os.insert(4,"ddddd"));
    }
}

// 由题意模拟过程
class OrderedStream {
    private int ptr;
    private String[] map;
    public OrderedStream(int n) {
        ptr = 1;
        map = new String[n+1];
    }
    
    public List<String> insert(int id, String value) {
        map[id] = value;
        List<String> list = new ArrayList<>();
        if (id == ptr) {
            while (id < map.length && map[id] != null) {
                list.add(map[id]);
                id++;
            }
            ptr = id;
        }

        return list;
    }
}