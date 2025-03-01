package combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class E09subsetsWithDup {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length == 0){
            res.add(list);
            return res;
        }
        //保证相同元素相邻
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtracking(nums,0);
        return res;
    }
    private void backtracking(int[] nums,int index){
        res.add(new ArrayList<>(list));
        if(index >= nums.length){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            list.push(nums[i]);
            used[i] = true;
            backtracking(nums,i+1);
            list.pop();
            used[i] = false;
        }
    }
}
