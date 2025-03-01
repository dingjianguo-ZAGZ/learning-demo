package combine;

import java.util.*;

/**
 * 非递减子序列
 */
public class E10findSubsequences {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length == 0){
            res.add(new ArrayList<>(list));
            return res;
        }
        backtracking(nums,0);
        return res;
    }
    private void backtracking(int[] nums,int index){
        if(list.size() > 1){
            res.add(new ArrayList<>(list));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if((!list.isEmpty() && list.get(list.size()-1) > nums[i]) || set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            list.add(nums[i]);
            backtracking(nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
