public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().checkRecord("PPALLP"));
        System.out.println(new Solution().checkRecord("PPALLL"));
    }
}

class Solution {

    // 遍历字符串
    // 每个位置有三种情况 P 、 L 、 A ，设置两种计数器，分别记录 A 的出现次数， L 的连续出现次数
    // 如果当前位置是 A ，则将 A 的计数器加一并判断值是否为 2 ，若为 2 则此人得不到奖励
    // 如果当前位置是 L ，则将 L 的连续计数器加一并判断值是否为 3 ，若为 3 则此人得不到奖励
    // A 的计数器始终增加， L 的连续计数器在当前位置字符不为 L 时置为 0
    
    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) return false;
        int a = 0, l = 0;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == 'A' && ++a == 2) return false;
            else if (x == 'L') {
                if (++l == 3) return false;
            } else {
                l = 0;
            }
        }

        return true;
    }
}