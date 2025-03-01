package recall;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 */
public class E058combinationSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return res;
    }

    public void dfs(int[] candidates, int startIndex, int target) {
        int len = candidates.length;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (startIndex >= len || candidates[startIndex] > target) {
            //可选列表中最小值大于目标值
            return;
        }
        for (int i = startIndex; i < len; i++) {
            int num = candidates[i];
            list.add(num);
            dfs(candidates, i , target - num);
            list.remove(list.size() - 1);
        }
    }
}
