public class E018productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        //记录前缀积 和 后缀积
        int[] left = new int[nums.length]; //前缀积 （不包含当前值），第一个前缀积是1
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            right[j] = right[j - 1] * nums[j - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

}
