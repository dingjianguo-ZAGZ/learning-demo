package array;

import java.util.LinkedList;

public class E015rotate {
    public void rotate(int[] nums, int k) {
        //翻转数组
        k %= nums.length;
        //先翻转所有
        reverse(nums,0,nums.length-1);
        //将 前 k 位和 后 n-k 位分别翻转
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }
    public void reverse(int[] nums,int start,int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }

    }
}
