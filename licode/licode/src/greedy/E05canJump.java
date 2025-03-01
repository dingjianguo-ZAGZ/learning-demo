package greedy;

import java.util.Map;

/**
 * 跳跃游戏
 */
public class E05canJump {
    public boolean canJump(int[] nums) {
        //2 3 1 1 4     3 2 1 0 4
        //不用关心跳几步，只需要关心最大范围是否能覆盖全部
        if(nums.length == 1){
            return true;
        }
        //当前覆盖范围
        int cover = 0;
        //在覆盖范围里更新最大覆盖范围
        for (int i = 0; i <= cover; i++) {
            //每次移动一步，修改覆盖范围的下标
            cover = Math.max(nums[i] + i,cover);
            if(cover >= nums.length-1){
                return true;
            }
        }
        return false;
    }
}
