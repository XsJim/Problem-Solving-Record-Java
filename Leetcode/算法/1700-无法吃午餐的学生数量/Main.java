public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countStudents(new int[] {1,1,0,0}, new int[] {0,1,0,1}));
        System.out.println(new Solution().countStudents(new int[] {1,1,1,0,0,1}, new int[] {1,0,0,0,1,1}));
    }
}
// 首先分别记录学生吃1和0的总数
// 然后从0开始遍历饼栈
// 并将当前栈顶对应的饼分给学生（从对应饼个数中减一）
// 当执行完出饼操作后，检查饼个数是否为-1
// 若为-1，说明这个饼已经没有学生要吃，所以它会阻碍后续出饼
// 所以可知有当前栈中剩余个数的饼对应的学生吃不上午餐（包括刚刚假设分配的饼）
// 可以直接用栈顶元素改变饼个数，是因为不论如何排队，可以吃到该饼的学生总会出现在队头
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < students.length; i++) {
            zeroCount += (students[i]^1);
            oneCount += (students[i]^0);
        }

        int j = 0;
        while (j < sandwiches.length) {
            zeroCount -= (sandwiches[j]^1);
            oneCount -= (sandwiches[j]^0);
            if (zeroCount == -1 || oneCount == -1) {
                break;
            }
            j++;
        }

        return students.length - j;
    }
}