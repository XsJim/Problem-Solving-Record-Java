import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));
    }
}

class Solution {
    // 统计给定字符串中，每个单词的出现次数
    // 再遍历每个出现的单词，如果它不在禁用单词列表里且它的出现次数比上一个符合条件的单词多，那么将它作为当前出现次数最多的单词
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < banned.length; i++) map.put(banned[i], -1);

        char[] paragraphArr = paragraph.toCharArray();
        for (int i = 0; i < paragraphArr.length; i++) {
            if (paragraphArr[i] >= 'A' && paragraphArr[i] <= 'Z') {
                paragraphArr[i] = (char)(paragraphArr[i] - 'A' + 'a');
            }
        }

        int offset = -1;
        int index = 0;
        int count = 0;

        String ans = null;
        int max = 0;

        while (index <= paragraphArr.length) {
            if (index < paragraphArr.length && paragraphArr[index] >= 'a' && paragraphArr[index] <= 'z') {
                if (offset == -1) offset = index;
                count++;
            } else {
                if (offset != -1) {
                    String current = new String(paragraphArr, offset, count);
                    Integer x = map.get(current);
                    if (x == null) {
                        map.put(current, 1);
                        x = 1;
                    } else {
                        if (x != -1) {
                            map.put(current, x+1);
                            x = x + 1;
                        }
                    }
                    if (x > max) {
                        ans = current;
                        max = x;
                    }
                    offset = -1;
                }
                count = 0;
            }
            index++;
        }

        return ans;
    }
}