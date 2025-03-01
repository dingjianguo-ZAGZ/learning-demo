package greedy;

import java.util.Arrays;

public class E07largestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int res = 0;//返回结果
        //按照绝对值大小从大到小排序
        nums = Arrays.stream(nums)//获取流
                .boxed()//将基本数据类型转换成包装类
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        //遇到负数，翻转变成正数
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0 && k > 0){
                nums[i] = -nums[i];
                k--;
            }
        }
        //判断 k 是否用完
        //k 没有用完，此时数组中都是正数，反复翻转最小的正数，消耗完 k
        //组中都是正数，翻转偶数次正数，结果不变
        //所以 k =奇数,翻转，（翻转奇数次 和 翻转一次 结果相同） k = 偶数，不操作
        if(k % 2 == 1) nums[nums.length-1] = -nums[nums.length-1];//翻转一次
        return Arrays.stream(nums).sum();
    }
}
