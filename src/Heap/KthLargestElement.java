package Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElement {
    public int findKthLargestSimp(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums, k);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                swap(nums, i, 0);
                minHeapify(nums, 0, k);
            }
        }
        return nums[0];
    }

    private void minHeapify(int[] nums, int index, int heapSize) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;

        if (left < heapSize && nums[left] < nums[smallest]) {
            smallest = left;
        }
        if (right < heapSize && nums[right] < nums[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(nums, smallest, index);
            minHeapify(nums, smallest, heapSize);
        }
    }

    private void buildHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            minHeapify(nums, i, heapSize);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public int findKthLargestQuick(int[] nums, int k){
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivotIdx = partition(nums, left, right);
        int target = nums.length - k;
        if (pivotIdx == target) {
            return nums[pivotIdx];
        }
        if (pivotIdx < target) {
            return quickSelect(nums, pivotIdx + 1, right, k);
        } else {
            return quickSelect(nums, left, pivotIdx - 1, k);
        }

    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left, j = right + 1;
        while (i < j) {
            while (++i < right && nums[i] < pivot) {
                ;
            }
            while (--j > left && nums[j] > pivot) {
                ;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, left, j);

        return j;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        sc.close();
        int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        KthLargestElement solution = new KthLargestElement();
        System.out.println("堆排序：" + solution.findKthLargest(nums, k));
        System.out.println("快速排序：" + solution.findKthLargestQuick(nums, k));
    }
}
