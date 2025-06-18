package stack;

import java.util.*;

public class E31maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Mystack queue = new Mystack();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            queue.offer(num);
            if (i >= k && queue.peek() == nums[i - k]) {
                //需要移除当前最大值
                queue.poll();
            }
            if(i >= k-1){
                //添加元素
                res.add(queue.peek());
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Mystack {
        private final LinkedList<Integer> deque = new LinkedList<>();

        public int peek() {
            return deque.peekFirst();
        }

        public int poll() {
            return deque.pollFirst();
        }

        public void offer(int m) {
            while (!deque.isEmpty() && deque.peekLast() < m) {
                deque.pollLast();
            }
            deque.offerLast(m);
        }
    }
}
