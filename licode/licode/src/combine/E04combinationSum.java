package combine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E04combinationSum {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates,target,0);
        return res;
    }
    private void backtracking(int[] candidates, int target,int startIndex){
        if(target == 0){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            int num = candidates[i];
            if(target < num) {
                continue;
            }
            stack.push(num);
            backtracking(candidates, target - num, i);
            stack.pop();

        }
    }
}
