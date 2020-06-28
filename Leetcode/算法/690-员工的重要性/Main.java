import java.util.Map;
import java.util.HashMap;
import java.util.List;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        List<Employee> list = new LinkedList<>();
        List<Integer> listSub = new LinkedList<>();
        listSub.add(2); listSub.add(3);
        list.add(new Employee(1, 5, listSub));
        listSub = new LinkedList<>();
        list.add(new Employee(2, 3, listSub));
        listSub = new LinkedList<>();
        list.add(new Employee(3, 3, listSub));
        System.out.println(new Solution().getImportance(list, 1));
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
}

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        int[] ans = new int[1];
        talgo(map, ans, id);
        return ans[0];
    }

    private static void talgo(Map<Integer, Employee> map, int[] ans, int i) {
        Employee e = map.get(i);
        ans[0] += e.importance;
        for (int x : e.subordinates) {
            talgo(map, ans, x);
        }
    }
}