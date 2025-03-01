package string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 滑动窗口中的最大值
 */
public class E011maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        MonotonicStack queue = new MonotonicStack();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(i >= k && nums[i - k] == queue.peek()){
                //滑动窗口移动 排除出去的元素 == 滑动前窗口中的最大值
                //需要将该值从队列中移除
                queue.poll();
            }
            //向队列中添加移动滑动窗口后，新出现的值
            queue.offer(num);
            //从下标 i >= k - 1 开始，将最大值加入结果集
            //只有下边 >= k-1，此时滑动窗口完全打开，此时的最大值才是有效的
            if(i >= k - 1){
                res.add(queue.peek());
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    static class MonotonicStack {
        //双端队列，从队头获取最大值，从队尾添加元素
        private final LinkedList<Integer> deque = new LinkedList();
        //查看递减队列第一个元素
        public Integer peek(){
            return deque.peekFirst();
        }
        //返回并移除队列第一个元素
        public Integer poll(){
            return deque.pollFirst();
        }
        //向队列添加元素
        public void offer(int x){
            while (!deque.isEmpty() && deque.peekLast() < x){
                //如果队尾元素小于要加入的值，则移除
                //队列中只要有滑动窗口中的最大值就行，每次移动窗口，都会先向队列中添加元素，所以不用担心队列为空
                deque.pollLast();
            }
            //向队尾添加元素
            deque.offerLast(x);
        }
    }
}
