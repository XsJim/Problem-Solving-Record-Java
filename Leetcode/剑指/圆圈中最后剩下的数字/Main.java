import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().lastRemaining(5, 3));
        System.out.println(new Solution().lastRemaining(10, 17));
        System.out.println(new Solution().lastRemaining(100000, 1000000));
    }
}

class Solution {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        m -= 1;
        int i = m % n;
        while (arrayList.size() > 1) {
            arrayList.remove(i);
            i = (i + m) % arrayList.size();
        }
        return arrayList.get(0);
    }
}