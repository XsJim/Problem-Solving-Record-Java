import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().sequentialDigits(100, 300));
        System.out.println(new Solution().sequentialDigits(1000, 13000));
        System.out.println(new Solution().sequentialDigits(10, 1000000000));
    }
}

// 首先，可以得到的特殊数字（顺次数）是有限的
// 设定一个方法，方法初始需要设定两个值，初始数数位和起始值
// 该方法将根据初始值，返回一个符合条件的值，下次再调用该方法，则会顺次返回下一个值，如果没有合理值可返回，则返回-1
// 有了该方法之后，便可以首先设定出第一个值（大于等于low），然后不断获取下一个值，如果这个值不为-1（合理），且这个值小于等于high（合法），就可以将其加入答案链表
// 设定第一个值，首先需要得到low的数位，得到数位后，设定起始值为1，并将其首次提交给方法
// 方法返回一个值，这个值应该是该数位的首个顺次数，不断通过方法获取特殊值，直到获取到的值大于或者等于low，或者等于-1（说明已经不存在比low大或者等于它的顺次数了）
// 然后，便可进行上述的区间内枚举，得到所有符合条件的答案
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int[] w = new int[] {0};
        for (int l = low; l != 0; l /= 10) {
            w[0]++;
        }
        int[] begin = new int[] {1};

        int x = nextX(w, begin);

        while (x != -1 && x < low) {
            x = nextX(w, begin);
        } 
        List<Integer> ans = new ArrayList<>();
        while (x != -1 && x <= high) {
            ans.add(x);
            x = nextX(w, begin);
        }

        return ans;
    }

    private int nextX(int[] w, int[] begin) {
        if (begin[0] == 10 || 10 - begin[0] < w[0]) {
            w[0]++;
            if (w[0] == 10) return -1;
            begin[0] = 1;
        }

        int x = begin[0];

        for (int i = w[0] - 1, j = begin[0] + 1; i != 0; i--, j++) {
            x *= 10;
            x += j;
        }
        begin[0]++;

        return x;
    }
}