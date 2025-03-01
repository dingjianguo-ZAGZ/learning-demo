package combine;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * 组合总和2
 */
public class E05combinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList stack = new LinkedList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] valid = new boolean[candidates.length];
        backtracking(candidates,target,0,valid);
        return res;
    }
    private void backtracking(int[] candidates, int target,int index,boolean[] valid){
        if(target == 0){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            if(num > target){
                continue;
            }
            if(i > 0 && candidates[i-1] == num && !valid[i-1]){
                continue;
            }
            //同一个组合中的元素可以重复出现，组合不能相同
            valid[i] = true;
            stack.push(num);
            backtracking(candidates,target-num,i+1,valid);
            //回溯
            stack.pop();
            //设置为false不影响下一轮的判断
            valid[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
