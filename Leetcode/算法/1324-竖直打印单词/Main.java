import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().printVertically("HOW ARE YOU"));
        System.out.println(new Solution().printVertically("TO BE OR NOT TO BE"));
        System.out.println(new Solution().printVertically("CONTEST IS COMING"));
    }
}

class Solution {
    // 首先切割字符串，以空格为切割单位，得到字符串数组，每个元素都是一个单词且按顺序排列
    // 遍历字符串数组，得到最大字符串长度，这个值便是答案中的字符串个数
    // 建立循环，依次创建每一行的字符串
    // 由于数组中字符串的长度不同，所以可能出现位于前方的某些单词已经拼写完成，而位于后方的还需要继续拼写
    // 对于拼写完成的，需要在该位置上添加空格，所以需要得到每行中最后一个大于或等于该行行数的单词位置（即列数）
    // 位于这个列数之后的单词，均以拼写完成，所以在当前位置添加字符后，便得到这一行的答案
    public List<String> printVertically(String s) {
        String[] strs = s.split(" ");
        int maxLen = 0;
        for (int i = 0; i < strs.length; i++) {
            maxLen = Math.max(strs[i].length(), maxLen);
        }
        List<String> ans = new ArrayList<>(maxLen);
        for (int i = 1; i <= maxLen; i++) {
            int j = strs.length - 1;
            while (strs[j].length() < i) j--;
            int z = 0;
            StringBuilder sb = new StringBuilder();
            while (z <= j) {
                sb.append(strs[z].length() < i ? " " : strs[z].charAt(i-1));
                z++;
            }
            ans.add(sb.toString());
        }

        return ans;
    }
}