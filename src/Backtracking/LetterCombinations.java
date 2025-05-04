package Backtracking;

import java.util.*;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return ans;
        }

        Map<Character, String> phone = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtrack(ans, digits, phone, 0, new StringBuffer());
        return ans;
    }

    private void backtrack(List<String> ans, String digits, Map<Character, String> phone, int index, StringBuffer sb) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        String cur = phone.get(digits.charAt(index));
        for (int i = 0; i < cur.length(); i++) {
            sb.append(cur.charAt(i));
            backtrack(ans, digits, phone, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        LetterCombinations soluiton = new LetterCombinations();
        System.out.println(soluiton.letterCombinations(s));
    }
}
