public class E09moveZeroes {
    public void moveZeroes(int[] nums) {
        int s = 0;
        for (int f = 0; f < nums.length; f++) {
            //寻找第一个非零
            if(nums[f] != 0){
                int num = nums[f];
                nums[f] = 0;
                nums[s] = num;
                s++;
            }
        }
    }
}
