package Hash;

import java.util.*;

public class GroupAnagrams {
    // 排序
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if (!hash.containsKey(sortedStr)) {
                hash.put(sortedStr, new ArrayList<String>());
            }
            hash.get(sortedStr).add(str);
        }
        return new ArrayList<>(hash.values());
    }

    // 计数
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();
        for (String str : strs) {
            int[] cnt = new int[26];
            for (int i = 0; i < str.length(); i++) {
                cnt[str.charAt(i) - 'a']++;
            }

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                sb.append(cnt[i]);
                sb.append("#");
            }

            String key = sb.toString();
            if (!hash.containsKey(key)) {
                hash.put(key, new ArrayList<String>());
            }
            hash.get(key).add(str);
        }

        return new ArrayList<>(hash.values());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(",");
        System.out.println("排序：" + groupAnagrams(strs));
        System.out.println("计数：" + groupAnagrams(strs));
    }
}
