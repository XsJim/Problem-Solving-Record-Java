import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        rooms.add(list);

        list = new ArrayList<>();
        list.add(2);
        rooms.add(list);

        list = new ArrayList<>();
        list.add(3);
        rooms.add(list);

        list = new ArrayList<>();
        rooms.add(list);
        System.out.println(new Solution().canVisitAllRooms(rooms));

        rooms = new ArrayList<>();
        list = new ArrayList<>();
        list.add(1); list.add(3);
        rooms.add(list);

        list = new ArrayList<>();
        list.add(3); list.add(0); list.add(1);
        rooms.add(list);

        list = new ArrayList<>();
        list.add(2);
        rooms.add(list);

        list = new ArrayList<>();
        list.add(0);
        rooms.add(list);

        System.out.println(new Solution().canVisitAllRooms(rooms));
    }
}

class Solution {
    // 创建一个队列，首先将 0 加入
    // 代表目前可以打开但是还没打开过的房间号
    // 遍历这个队列当其不为空的时候，弹出一个房间号，得到他可以打开的房间列表
    // 遍历这个列表，当出现未曾打开过的房间号时，将其推入队列，标记未打开过的数组改标记为打开过，未打开房间计数器减去一
    // 当循环结束后，所有可以打开的房间都已标记，且未打开房间计数器储存着当前还未打开的房间的数量
    // 返回这个值是否为 0 便可
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] map = new int[1005];
        int count = rooms.size() - 1;

        Deque<Integer> queue = new ArrayDeque<>();
        int i = 0;
        map[0] = 1;
        queue.add(0);
        while (queue.size() > 0) {
            List<Integer> list = rooms.get(queue.poll());
            for (int x : list) {
                if (map[x] == 0) {
                    map[x] = 1;
                    queue.add(x);
                    count--;
                }
            }
        }

        return count == 0;
    }
}