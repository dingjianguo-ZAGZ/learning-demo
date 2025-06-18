package stack;

import java.util.PriorityQueue;

public class E33findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = queue.poll();
        }
        return res;
    }
}
