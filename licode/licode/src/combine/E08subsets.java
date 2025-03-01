package combine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E08subsets {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return res;
    }
    private void backtracking(int[] nums,int index){
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.push(nums[i]);
            backtracking(nums,i+1);
            list.pop();
        }
    }
}
