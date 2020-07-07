import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("ab#c", "ad#c"));
        System.out.println(new Solution().backspaceCompare("ab##", "c#d#"));
        System.out.println(new Solution().backspaceCompare("a##c", "#a#c"));
        System.out.println(new Solution().backspaceCompare("a#c", "b"));
    }
}

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        for (char x : S.toCharArray()) {
            if (x == '#') {
                if (!s.empty()) s.pop();
            } else s.push(x);
        }

        for (char x : T.toCharArray()) {
            if (x == '#') {
                if (!t.empty()) t.pop();
            } else t.push(x);
        }

        while (!s.empty() && !t.empty()) {
            if (s.pop() != t.pop()) return false;
        }
        if (!s.empty() || !t.empty()) return false;
        return true;
    }
}