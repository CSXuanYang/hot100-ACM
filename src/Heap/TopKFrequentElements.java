package Heap;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        // 哈希表存储频次
        Map<Integer, Integer> hash = new HashMap<>();
        int maxCnt = 0;
        for (int i = 0; i < n; i++) {
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
            maxCnt = Math.max(hash.get(nums[i]), maxCnt);
        }

        // 桶排序
        List<Integer>[] bucket = new List[maxCnt + 1];
        Arrays.setAll(bucket, i -> new ArrayList<>());
        for (int key : hash.keySet()) {
            int i = hash.get(key);
            bucket[i].add(key);
        }

        // 返回结果
        int[] ans = new int[k];
        int idx = 0;
        for (int i = maxCnt; i >= 0 && idx < k; i--) {
            for (int num : bucket[i]) {
                ans[idx++] = num;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        sc.close();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] ans = solution.topKFrequent(nums, k);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
