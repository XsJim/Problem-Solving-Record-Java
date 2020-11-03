public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().slowestKey(new int[] {9,29,49,50}, "cbcd"));
        System.out.println(new Solution().slowestKey(new int[] {12,23,36,46,62}, "spuda"));
    }
}

// 遍历按键起始时间数组，每次计算出当前按键的持续时间后，与原最大持续时间作比较，如果新的时间比较大，就更新这个值
// 最后，遍历时间记录数组，得到答案
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] count = new int[26];
        int prev = 0;
        for (int i = 0; i < releaseTimes.length; i++) {
            int index = keysPressed.charAt(i)-'a';
            int time = releaseTimes[i] - prev;
            if (count[index] < time) count[index] = time;
            prev = releaseTimes[i];
        }
        int max = -1;
        char ans = '*';
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= max) {
                max = count[i];
                ans = (char)(i+'a');
            }
        }

        return ans;
    }
}