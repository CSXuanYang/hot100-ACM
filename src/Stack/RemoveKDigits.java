package Stack;

import java.util.*;

/**
 * 从只包含数字的字符串中删除k个字符，使得剩下的数字最小。
 * 1. 从左到右遍历字符串；
 * 2. 如果当前数字比栈顶数字小，并且我们还有删除次数 k > 0，就把栈顶弹出（意味着删除这个更大的数字）；
 * 3. 否则就把当前数字压入栈；
 * 4. 最后如果还剩下 k 没删除完，就从栈顶继续弹出；
 * 5. 最后把栈转成字符串，并去掉前导 0。
 */
/

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.pollLast(); // 删除较大的数字
                k--;
            }
            stack.offerLast(digit);
        }

        // 如果还有多余的k，继续从后面删除
        while (k-- > 0) {
            stack.pollLast();
        }

        // 构建结果字符串，同时去除前导0
        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            result.append(digit);
        }

        // 如果结果为空，就返回"0"
        return result.length() == 0 ? "0" : result.toString();
    }

    // 示例测试
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k)); // 输出 "1219"

        num = "10200";
        k = 1;
        System.out.println(removeKdigits(num, k)); // 输出 "200"

        num = "10";
        k = 2;
        System.out.println(removeKdigits(num, k)); // 输出 "0"
    }
}

