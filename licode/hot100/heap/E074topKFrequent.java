package heap;

import java.util.*;

public class E074topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        //先统计元素数量
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i],count);
        }
        //维护一个元素个数为 k 的最小堆（方便比较）
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return map.get(o1) - map.get(o2);//结果小于 0，o1排在前面
        });
        for (Integer key : map.keySet()) {
            if(queue.size() < k){
                queue.add(key); //先加入 k 个最小元素
            }else if(map.get(key) > map.get(queue.peek())){
                //移除最小元素，加入当前元素，优先队列会自动将最小元素放在队头
                queue.remove();
                queue.add(key);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()){
            res.add(queue.remove());
        }
        return res.stream().mapToInt(Integer::intValue).toArray();

    }

}
