package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class E075MedianFinder {

}
class MedianFinder{
    PriorityQueue<Integer> minQue; //降序队列，保存小于等于中位数的值
    PriorityQueue<Integer> maxQue; //升序队列，保存大于中位数的值

    public MedianFinder() {
        minQue = new PriorityQueue<>((a,b)-> (b-a)); //降序
        maxQue = new PriorityQueue<>((a,b)-> (a-b)); //升序
    }

    public void addNum(int num) {
        if(minQue.isEmpty() || num <= minQue.peek()){
            //队列为空 或 要加入的元素 小于等于中位数
            minQue.offer(num);
            //此时，中位数 <= 原来的中位数
            if(maxQue.size() + 1 < minQue.size()){
                //两个队列元素个数相差大于1，表示需要重新计算中位数
                maxQue.offer(minQue.poll()); //将降序队列的最大值加入到升队列
            }
        }else {
            //加入到升序队列
            maxQue.offer(num);
            if(maxQue.size() > minQue.size()){
                //升序队列 元素个数不能大于降序队列
                minQue.offer(maxQue.poll());
            }
        }
    }

    public double findMedian() {
        //如果降序队列 元素个数和 升序队列元素个数不相等，那么，降序队列的最大值就是中位数
        if(minQue.size() > maxQue.size()){
            return minQue.peek();
        }else {
            //两个队列元素个数相等，取出队头元素求中位数
            return (minQue.peek() + maxQue.peek()) / 2.0;
        }
    }
}