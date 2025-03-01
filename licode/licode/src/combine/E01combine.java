package combine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class E01combine {
    LinkedList<Integer> stack = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,0);
        return res;
    }
    private void backtracking(int n,int k,int startIndex){
        if(stack.size() == k){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = startIndex+1; i <= n - (k - stack.size()) + 1; i++) {
            // 1-4选择一个
            stack.push(i);
            //剩下的再组合(递归)
            backtracking(n,k,i);
            //回溯
            stack.pop();
        }
    }
}
