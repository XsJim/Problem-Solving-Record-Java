import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }
}

class RecentCounter {
    private int[] queue;
    private int left;
    private int right;
    public RecentCounter() {
        queue = new int[10000];
        left = 0;
        right = -1;
    }
    
    public int ping(int t) {
        int x = t - 3000;
        int l = left, r = right;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (queue[mid] < x) {
                l = mid + 1;
                left = l;
            }
            else if (queue[mid] > x) {
                r = mid - 1;
                left = mid;
            }
            else {
                left = mid;
                break;
            }
        }
        queue[++right] = t;
        return right - left + 1;
    }
}