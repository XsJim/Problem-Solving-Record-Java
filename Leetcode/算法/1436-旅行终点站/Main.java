import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> paths = new LinkedList<>();
        List<String> list1 = new LinkedList<>();
        list1.add("London"); list1.add("New York");
        paths.add(list1);
        List<String> list2 = new LinkedList<>();
        list2.add("New York"); list2.add("Lima");
        paths.add(list2);
        List<String> list3 = new LinkedList<>();
        list3.add("Lima"); list3.add("Sao Paulo");
        paths.add(list3);
        System.out.println(new Solution().destCity(paths));
    }
}

class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (List<String> list : paths) {
            map.put(list.get(0), true);
        }
        for (List<String> list : paths) {
            for (String s : list) {
                if (map.get(s) == null) return s;
            }
        }
        return null;
    }
}