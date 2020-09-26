public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'a'));
        System.out.println(new Solution().nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'c'));
        System.out.println(new Solution().nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'd'));
        System.out.println(new Solution().nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'g'));
        System.out.println(new Solution().nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'j'));
        System.out.println(new Solution().nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'k'));
    }
}

class Solution {
    // 首先，检查数组最后一个字符是否大于给定字符
    // 如果大于，那么第一个比给定字符大的字符在这最后一个字符前或者就是这最后一个字符，这时需要从数组第一位开始检测
    // -如果遇到比给定字符大的字符，就返回
    // 如果小于或等于，那么比给定字符大的字符按照题目规则应该是字符数组的第一个字符，返回即可
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length-1] <= target) return letters[0];
        for (char c : letters) {
            if (c > target) return c;
        }
        return '*';
    }
}