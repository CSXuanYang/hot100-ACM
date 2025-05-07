package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecodeString {
    public String decodeString(String s) {
        Deque<Integer> numStk = new ArrayDeque<>();
        Deque<String> strStk = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        int multi = 0;

        for (Character c : s.toCharArray()) {
            if (c == '[') {
                numStk.push(multi);
                strStk.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                int cur = numStk.pop();
                for (int i = 0; i < cur; i++) {
                    sb.append(res);
                }
                res = new StringBuilder(strStk.pop() + sb);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        DecodeString solution = new DecodeString();
        System.out.println(solution.decodeString(s));
    }
}
