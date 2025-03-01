package Queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class E08findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        //使用小顶堆 ， 只用维护k 个元素有序
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //先把k个元素加入
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        //将队顶元素删除，加入新元素
        for (int i = k; i < nums.length; i++) {
            if(nums[i] > queue.peek()){
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        //第 k 大，也就是小顶堆中最小的（队顶）
        return queue.peek();


    }

    public static void main(String[] args) {

    }
}
