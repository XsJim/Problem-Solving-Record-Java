public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("hello"));
        System.out.println(new Solution().reverseVowels("leetcode"));
    }
}

class Solution {

    // 程序要做的是将字符串中所有的元音字母按序取出（大小写），然后将取出的序列逆序，再放回到原字符串中，实现反转字符串中的元音字母
    // 为了达到较优的时间复杂度并且尽量节省空间，采用双指针算法
    // 设定两个指针，初始值分别为 0 和 length-1
    // 算法的思路是，首先由第一个指针开始，向后查找，遇到元音字母时停下
    // 然后第二个指针向前查找，也是遇到元音字母时停下
    // 最后交换这两个位置的元音字母，并且后移第一个指针，前移第二个指针
    // 这所有的过程都要满足一个条件，即第一个指针要小于第二个指针，一旦相等，就表示字符串已经扫描完毕
    // 即使让这两个指针可以相等，并且指向的是一个元音字母，这个字母也不需要移动，所以唯一的条件就是第一个指针小于第二个
    // 为了加快判断字母是否为元音字母，使用散列表
    // 这里直接使用字符作为下标，在事先准备好的标记数组中给这五个特定的元音字母做标记
    // 最终得到的字符数组，转换为字符串，就是所求答案

    public String reverseVowels(String s) {
        char[] sArr = s.toCharArray();
        
        boolean[] map = new boolean[256];
        char[] flag = new char[] {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < flag.length; i++) {
            map[flag[i]] = true;
            map[flag[i]-'a'+'A'] = true;
        }

        int l = 0, r = sArr.length - 1;
        while (l < r) {
            while (l < r && !map[sArr[l]]) l++;
            while (l < r && !map[sArr[r]]) r--;
            if (l < r) {
                char temp = sArr[l];
                sArr[l] = sArr[r];
                sArr[r] = temp;
                l++; r--;
            }
        }
        
        return new String(sArr);
    }
}