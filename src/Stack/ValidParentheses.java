package Stack;

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> hash = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!hash.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || !stack.pop().equals(hash.get(c))) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.isValid(s));
    }
}
