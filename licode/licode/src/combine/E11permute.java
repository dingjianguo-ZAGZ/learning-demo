package combine;

import java.util.*;
import java.util.concurrent.CountDownLatch;

public class E11permute {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums);
        return res;
    }
    private void backtracking(int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!list.isEmpty() && list.contains(nums[i])){
                continue;
            }
            list.push(nums[i]);
            backtracking(nums);
            list.pop();
        }
    }
}
