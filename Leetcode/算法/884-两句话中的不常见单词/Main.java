import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().uncommonFromSentences("this apple is sweet", "this apple is sour")));
        System.out.println(Arrays.toString(new Solution().uncommonFromSentences("apple apple", "banana")));
    }
}

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> mapA = new HashMap<>();
        for (String s : A.split(" ")) {
            mapA.put(s, mapA.getOrDefault(s, 0) + 1);
        }
        for (String s : B.split(" ")) {
            mapA.put(s, mapA.getOrDefault(s, 0) + 1);
        }

        List<String> list = new ArrayList<>();

        for (String s : mapA.keySet()) {
            if (mapA.get(s) == 1) list.add(s);
        }

        return list.toArray(new String[list.size()]);
    }
}