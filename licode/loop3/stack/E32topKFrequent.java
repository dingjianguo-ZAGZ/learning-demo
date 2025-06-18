package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class E32topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //统计出现的次数
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((o1,o2)->
            o2.getValue() - o1.getValue()//降序排序，大顶堆
        );
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}
