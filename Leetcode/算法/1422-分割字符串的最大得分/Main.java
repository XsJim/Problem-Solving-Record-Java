public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxScore("011101"));
        System.out.println(new Solution().maxScore("00111"));
        System.out.println(new Solution().maxScore("1111"));
    }
}

class Solution {
    // 问将只含 0, 1 的字符串分隔为两个非空的字符串，求左字符串含 0 的数量加右字符串含 1 的数量的和的最大值
    // 要得到最大值，就要知道所有可能的值
    // 最简单的方法，列举每一个可能的分割点，计算这个和
    // 每次计算，首先统计左字符串 0 的个数，再统计右字符串 1 的数量
    // 每次分割点向右移动一个单位，左字符串 0 的个数只是加上了新加入的一个单元的 0 的数量
    // 同样，右字符串只是减掉了这个刚去掉的单元的 1 的数量
    // 所以，可以在找最大值之前，就计算出分割点在每个位置时，分割点左边 0 和右边 1 的数量
    // 再通过一次遍历得到最大值
    public int maxScore(String s) {
        int[] l = new int[s.length()];
        if (s.charAt(0) == '0') l[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            l[i] = l[i-1] + (s.charAt(i) == '0' ? 1 : 0);
        }

        int[] r = new int[s.length()];
        for (int i = s.length() - 2; i >= 0; i--) {
            r[i] = r[i+1] + (s.charAt(i+1) == '1' ? 1 : 0);
        }

        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int x = l[i] + r[i];
            if (x > max) max = x;
        }

        return max;
    }
}