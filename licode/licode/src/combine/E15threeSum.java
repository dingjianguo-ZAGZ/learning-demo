package combine;

import java.util.*;

public class E15threeSum {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        dfs(nums,0,0);
        return res;
    }
    private void dfs(int[] nums,int target,int index){
        if(list.size() == 3){
            if(target == 0){
                res.add(new ArrayList<>(list));
                return;
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(list.size() == 0 && (target - nums[i] > nums[nums.length-1] + nums[nums.length-2])){
                continue;
            }
            if(list.size() == 0 && nums[i] > 0){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            used[i] = true;
            list.push(nums[i]);
            dfs(nums,target-nums[i],i+1);
            list.pop();
            used[i] = false;
        }
    }
}
