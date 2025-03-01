package recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E056subsets {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0){
            res.add(new ArrayList<>(list));
            return res;
        }
        used = new boolean[nums.length];
        //对数组进行排序，方便去重
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int startIndex) {
        int len = nums.length;
        res.add(new ArrayList<>(list));
        //定义递归头
        //到达叶子节点，此时startINDEX 超出数组边界
        if (startIndex == len) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                //注意used[i - 1] == true，表示相同的值是在同一个树枝出现，所以可以重复
                continue; //相反情况，表示相同值在上一轮已经遍历过，跳过
            }
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}
