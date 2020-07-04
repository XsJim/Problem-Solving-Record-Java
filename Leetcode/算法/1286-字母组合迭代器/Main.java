import java.util.Queue;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        CombinationIterator ci = new CombinationIterator("abc", 2);
        System.out.println(ci.next());
        System.out.println(ci.hasNext());
        System.out.println(ci.next());
        System.out.println(ci.hasNext());
        System.out.println(ci.next());
        System.out.println(ci.hasNext());
    }
}

class CombinationIterator {
    Queue<String> queue;
    public CombinationIterator(String characters, int combinationLength) {
        queue = new ArrayDeque<>();
        fill(characters.toCharArray(), 0, new char[combinationLength], 0, queue);
    }
    
    public String next() {
        return queue.remove();
    }
    
    public boolean hasNext() {
        return queue.size() != 0;
    }

    private static void fill(char[] sArr, int i, char[] a, int j, Queue<String> queue) {
        if (a.length - j > sArr.length - i) return;
        if (j == a.length) {
            queue.add(new String(a));
            return;
        }

        while (i < sArr.length) {
            a[j] = sArr[i++];
            fill(sArr, i, a, j+1, queue);
        }
    }
}

