import java.util.List;
import java.util.ArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findOcurrences("alice is a good girl she is a good student", "a", "good")));
        System.out.println(Arrays.toString(new Solution().findOcurrences("we will we will rock you", "we", "will")));
    }
}

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] texts = text.split(" ");
        int brake = texts.length - 2;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < brake; i++) {
            if (texts[i].equals(first) && texts[i+1].equals(second)) list.add(texts[i+2]);
        }
        return list.toArray(new String[list.size()]);
    }
}