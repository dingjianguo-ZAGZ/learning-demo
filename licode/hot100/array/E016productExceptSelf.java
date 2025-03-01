package array;

/**
 * 除自身以外数组的乘积
 */
public class E016productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        //第一个数字的前缀之积 = 1
        answer[0] = 1;
        //计算前缀之积
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }
        //计算后缀之积
        //最后一个数字的前缀 * 后缀之积为 前缀之积
        //定义一个变量用来保存后缀之积
        int num = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            num = num * nums[j+1];
            //最终结果 = 前缀 * 后缀
            answer[j] = answer[j] * num;
        }
        return answer;
    }
}
