package combine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E02combinationSum3 {
    LinkedList<Integer> stack = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1,n);
        return res;
    }
    private void backtracking(int k,int n,int startIndex,int target){
        if(target == 0 && stack.size() == k){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = startIndex;i <= 9;i++){
            if(target<i){
                continue;//剪枝
            }
            if(stack.size() == k){
                continue;
            }
            stack.push(i);
            backtracking(k,n,i+1,target-i);
            //回溯
            stack.pop();
        }
    }
}
