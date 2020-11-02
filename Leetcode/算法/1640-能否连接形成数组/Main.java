public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().canFormArray(new int[] {85}, new int[][] {{85}}));
        System.out.println(new Solution().canFormArray(new int[] {15,88}, new int[][] {{88},{15}}));
        System.out.println(new Solution().canFormArray(new int[] {49,18,16}, new int[][] {{16,18,49}}));
        System.out.println(new Solution().canFormArray(new int[] {91,4,64,78}, new int[][] {{78},{4, 64},{91}}));
        System.out.println(new Solution().canFormArray(new int[] {1,3,5,7}, new int[][] {{2,4,6,8}}));
    }
}

// 首先记录‘零件 pieces ’中每个零件开头的数和它在零件列表中位置的对应关系
// 然后遍历目标拼接数组 arr ，当当前位置的数没有在零件列表的某个零件的开头出现，则说明这个数组无法拼接完成
// 否则，逐个检测元素，如果零件的每一个数都按照目标数组的顺序出现，则说明这个零件可用，接下来继续向后检测，直到整个目标数组拼接完毕
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] map = new int[101];
        for (int i = 0; i < 101; i++) map[i] = -1;
        for (int i = 0; i < pieces.length; i++) {
            map[pieces[i][0]] = i;
        }
        int x = 0;
        while (x < arr.length) {
            if (map[arr[x]] != -1) {
                int index = map[arr[x]];
                if (pieces[index].length > arr.length - x) return false;
                int i = 0;
                while (i < pieces[index].length) {
                    if (pieces[index][i] != arr[x]) return false;
                    i++; x++;
                }
            } else return false;
        }

        return true;
    }
}