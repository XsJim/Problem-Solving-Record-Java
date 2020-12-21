public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reformatNumber("1-23-45 6"));
        System.out.println(new Solution().reformatNumber("123 4-567"));
        System.out.println(new Solution().reformatNumber("123 4-5678"));
        System.out.println(new Solution().reformatNumber("12"));
        System.out.println(new Solution().reformatNumber("--17-5 229 35-39475 "));
    }
}

// 从前至后遍历给定字符串，遇到数字就将其加入答案字符串，如果加入字符前，计数器已经为3，就先添加一个'-'
// 当全部字符遍历完毕后，判断计数器的值，只有计数器的值为1时，才需要对答案字符串做变动，因为此时答案字符串的最后部分一定是3+1形式的
// 这不符合要求，所以对其做出改变，然后返回答案字符串即可，其他情况不需要考虑
class Solution {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            char x = number.charAt(i);
            if (x >= '0' && x <= '9') {
                if (count == 3) {
                    sb.append('-');
                    count = 0;
                }
                sb.append(x);
                count++;
            }
        }

        if (count == 1) {
            sb = sb.deleteCharAt(sb.length()-2);
            sb.insert(sb.length()-2, '-');
        }

        return sb.toString();
    }
}