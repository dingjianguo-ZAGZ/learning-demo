package combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class E12permuteUnique {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtracking(nums);
        return res;
    }
    private void backtracking(int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //同一层不能元素重复
            if(!used[i]){
                if(i > 0 && nums[i] == nums[i-1] &&!used[i-1]){
                    continue;
                }else {
                    list.push(nums[i]);
                    used[i] =true;
                    backtracking(nums);
                    list.pop();
                    used[i] = false;
                }
            }

        }
    }
}
