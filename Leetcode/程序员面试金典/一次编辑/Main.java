public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().oneEditAway("pale", "ple"));
        System.out.println(new Solution().oneEditAway("pales", "pal"));
    } 
}

class Solution {
    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        if (Math.abs(first.length()-second.length()) > 1) return false;
        char[] fir = first.toCharArray();
        char[] sec = second.toCharArray();
        if (fir.length < sec.length) {
            char[] temp = fir;
            fir = sec;
            sec = temp;
        }
        boolean flag = false;
        if (fir.length == sec.length) flag = true;
        int i = 0, j = 0;
        int count = 0;
        while (i < fir.length && j < sec.length) {
            if (fir[i] != sec[j]) {
                count++;
                if (count == 2) return false;
                i++;
                if (flag) j++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
}