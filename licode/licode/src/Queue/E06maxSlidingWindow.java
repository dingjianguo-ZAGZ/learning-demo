package Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class E06maxSlidingWindow {
    //单调递减队列
    static class MonotonicStack{
        //创建双端队列
        private final LinkedList<Integer> duque = new LinkedList<>();
        //查看队列第一个元素
        public int peek(){
            return duque.peekFirst();
        }
        //移除并查看队列第一个元素
        public int poll(){
            return duque.pollFirst();
        }
        //向队尾添加一个元素
        public void offer(int x){
            while (!duque.isEmpty() && duque.peekLast() < x){
                duque.pollLast();
            }
            duque.offerLast(x);
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        //创建单调递减队列
        MonotonicStack queue = new MonotonicStack();
        //创建结果集对象
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(i >= k && queue.peek() == nums[i-k]){
                queue.poll();
            }
            queue.offer(num);
            //向结果集中添加元素
            if(i >= k-1 ){
                res.add(queue.peek());
            }
        }
        return res.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }
}
