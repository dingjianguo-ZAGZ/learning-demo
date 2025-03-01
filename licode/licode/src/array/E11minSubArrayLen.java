package array;

import java.beans.IntrospectionException;
import java.time.chrono.MinguoChronology;

public class E11minSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        int r = 0;
        int l = 0;
        int count = Integer.MAX_VALUE;
        int sum = nums[l];
        for (; r < nums.length; r++) {
            sum+=nums[r];
            while(sum >= target){
                int length = r-l+1;
                count = Math.min(count,length);
                //开始移动左指针
                sum -= nums[l++];
            }
        }
        return count == Integer.MAX_VALUE?0:count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int t = 7;
        int i = minSubArrayLen(t,nums);
        System.out.println(i);
    }
}
