package recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class E055permute {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    boolean[] used;//保存元素是否被使用过
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        dfs(nums);
        return res;
    }
    public void dfs(int[] nums){
        int len = nums.length;
        //定义递归头
        if(len == list.size()){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            //只有元素没有被使用过，才进行操作
            if(!used[i]){
                //标记使用过
                used[i] = true;
                //先加入这一轮的值
                list.add(nums[i]);
                dfs(nums);
                //移除标记
                used[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
